package com.skillsoft.concurrency;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Arrays;

/*
 	public static void main(String args[]) {
		String[] urls = new String[] {"https://stackoverflow.com/home",
										"https://stackoverflow.com/questions",
										"https://stackoverflow.com/tags",
										"https://stackoverflow.com/users", 
										"https://stackoverflow.com/jobs/companies",
										"https://stackoverflow.co/teams"};
		
		Thread downloaderOne = new Thread(new PageDownloader(
												Arrays.copyOfRange(urls, 0, 3)));
		
		
		Thread downloaderTwo = new Thread(new PageDownloader(
												Arrays.copyOfRange(urls, 3, urls.length)));
		
		try {
			long startTime = System.currentTimeMillis();
			downloaderOne.start();
			downloaderTwo.start();
			
			downloaderOne.join();
			downloaderTwo.join();
			long endTime = System.currentTimeMillis();
			
			System.out.println("Total time taken: "+(endTime-startTime)/1000 + "s");
			
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
 */

public class PageDownloader implements Runnable{
	
	String[] urlsList;
	
	public PageDownloader(String[] urlsList) {
		this.urlsList = urlsList;
	}

	@Override
	public void run() {

		try {
			for(String urlString : urlsList) {
				
				if(Thread.currentThread().isInterrupted()) {
					throw new InterruptedException(Thread.currentThread().getName()+" interrupted");
				}
				
				URL url = new URL(urlString);
				String fileName = urlString.substring(urlString.lastIndexOf("/")+1).trim() + ".html";
				BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
				BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
				
				String line;
				while((line = reader.readLine()) != null) {
					writer.write(line);
				}
				System.out.println("Page downloaded to " + fileName);
				writer.close();
//				Thread.sleep(1000);//This line for practice 
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void main(String args[]) {
		String[] urls = new String[] {"https://stackoverflow.com/home",
										"https://stackoverflow.com/questions",
										"https://stackoverflow.com/tags",
										"https://stackoverflow.com/users", 
										"https://stackoverflow.com/jobs/companies",
										"https://stackoverflow.co/teams"};
		
		Thread downloaderOne = new Thread(new PageDownloader(
												Arrays.copyOfRange(urls, 0, 3)));
		
		
		Thread downloaderTwo = new Thread(new PageDownloader(
												Arrays.copyOfRange(urls, 3, urls.length)));
		
		try {
			long startTime = System.currentTimeMillis();
			downloaderOne.start();
			downloaderTwo.start();
			
			Thread.sleep(5000);
			downloaderOne.interrupt();//Only allow 5 sec to download, then interrupt. 
									//Needs a thread to go to sleep in order to activate .interrupt() 
									//or the whats in the if statement in run()
			
			downloaderTwo.join();//let this thread run as long as it needs to
			long endTime = System.currentTimeMillis();
			
			System.out.println("Total time taken: "+(endTime-startTime)/1000 + "s");
			
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}
	
}
