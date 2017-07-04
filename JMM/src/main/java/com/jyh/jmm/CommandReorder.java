package com.jyh.jmm;

public class CommandReorder {
	public static int a = 0;
	public static volatile int b = 0;
	public static void main(String[] args) throws InterruptedException {
		int i = 0;
		while(i++ <10000000){
			a = 0;
			b = 0;
			Thread t1 = new Thread(new Runnable() {
				public void run() {
					a = 1;
					b = 2;
				}
			});
			
			Thread t2 = new Thread(new Runnable() {
				public void run() {
					if(b==2&&a==0){
						//volatile should be added on variable b to pretend instruction reorder;
						//
						System.out.println("aaaa");
					}
//					}
						
					
				}
			});
			
			t1.start();
			t2.start();
			t1.join();
			t2.join();
		}

	}

}
