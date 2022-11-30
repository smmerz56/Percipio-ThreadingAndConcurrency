package com.skillsoft.concurrency;

/*
 NOTES:
 	//------------------------------------------------------------------------------
		public static class Walk implements Runnable{
			
			@Override
			public void run() {
				for(int i = 1; i < 5; i++) {
					try {
						Thread.sleep(3000);
					}catch(InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("Im walking");
				}
			}
		}
		//------------------------------------------------------------------------------
		public static class ChewGum implements Runnable{
			
			@Override
			public void run() {
				for(int i = 1; i < 5; i++) {
					try {
						Thread.sleep(3000);
					}catch(InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("Im chewing gum...");
				}
			}
			
		}
		//------------------------------------------------------------------------------
		public static void main(String[] args) {
			
			Thread walkThread = new Thread(new Walk());
			Thread chewThread = new Thread(new ChewGum());
			
			chewThread.setDaemon(true);//Will not wait for it to complete if it is the only one that is currently running i.e. Daemons back ground runners...
			
			System.out.println("\nwalkThread's daemon status: "+walkThread.isDaemon());
			System.out.println("chewThread daemon status: "+chewThread.isDaemon());
			System.out.println("main threads daemon status: "+Thread.currentThread().isDaemon());
			
			System.out.println("\n\n");
			
			try {
				walkThread.start();
				walkThread.join(5000);
				chewThread.start();
			}catch(InterruptedException e) {
				e.printStackTrace();
			}

		}
 */

public class ThreadMethods {
	//------------------------------------------------------------------------------
	public static class Walk implements Runnable{
		
		@Override
		public void run() {
			for(int i = 1; i < 5; i++) {
				try {
					Thread.sleep(3000);
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
				String threadGroup = Thread.currentThread().getThreadGroup().getName();
				int activeThreads = Thread.activeCount();
				
				System.out.println(
						"Im walking..."+" My group "+threadGroup
						+ " has an activeCount of "+activeThreads);
			}
		}
	}
	//------------------------------------------------------------------------------
	public static class ChewGum implements Runnable{
		
		@Override
		public void run() {
			for(int i = 1; i < 5; i++) {
				try {
					Thread.sleep(3000);
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
				String threadGroup = Thread.currentThread().getThreadGroup().getName();
				int activeThreads = Thread.activeCount();
				
				System.out.println(
						"Im chewing..."+" My group "+threadGroup
						+ " has an activeCount of "+activeThreads);
			}
		}
		
	}
	//------------------------------------------------------------------------------
//	public static void main(String[] args) {
//		ThreadGroup groupOne = new ThreadGroup("GroupOne");
//		ThreadGroup groupTwo = new ThreadGroup("GroupTwo");
//		
//		Thread walkThreadOne = new Thread(groupOne, new Walk());
//		Thread walkThreadTwo = new Thread(groupTwo, new Walk());
//		Thread walkThreadThree = new Thread(groupTwo, new Walk());
//		
//		Thread chewThreadOne = new Thread(groupOne, new ChewGum());
//		Thread chewThreadTwo = new Thread(groupTwo, new ChewGum());
//		
//		walkThreadOne.start();
//		walkThreadTwo.start();
//		walkThreadThree.start();
//		chewThreadOne.start();
//		chewThreadTwo.start();
//		
//		System.out.println("#Active threads for main: "+Thread.activeCount());
//		System.out.println("#Active threads for GroupOne: "+groupOne.activeCount());
//		System.out.println("#Active threads for GroupTwo: "+groupTwo.activeCount());
//
//	}
}
