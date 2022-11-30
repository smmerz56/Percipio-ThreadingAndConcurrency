package com.skillsoft.concurrency;

//------------------------------------------------------------------------------
/*
Notes:
 		Thread firstThread = new Thread(new MyThread(), "1st Thread");
		Thread secondThread = new Thread(new MyThread());
		
		secondThread.setName("2nd thread");
		
		firstThread.start();// calling start() will run the defined threads on separate new threads
		secondThread.start();
		
		firstThread.run();//calling run() will invoke the run method of the corresponding run instance in the current
					 thread... the thread that executes the main method.
		
		//This will run synchronously
		firstThread.run();
		secondThread.run();
 */
//------------------------------------------------------------------------------

public class MyThread implements Runnable{

	@Override
	public void run() {
		for(int i = 1; i < 5; i++) {
			try {
				Thread.sleep(3000);
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
			String threadName = Thread.currentThread().getName();
			System.out.println(threadName + " says: "+ i);
		}
	}
	
//	public static void main(String[] args) {
//		
//		Thread firstThread = new Thread(new MyThread(), "1st Thread");
//		Thread secondThread = new Thread(new MyThread());
//		
//		secondThread.setName("2nd thread");
//		
//		firstThread.start();// calling start() will run the defined threads on separate new threads
//		secondThread.start();
//		
//		
////		firstThread.run();//calling run() will invoke the run method of the corresponding run instance in the current
////							 thread... the thread that executes the main method.
//		
////		//This will run synchronously
////		firstThread.run();
////		secondThread.run();
//	}
}
