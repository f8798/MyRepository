package com.jyh.jmm;

public class CommandReorder {
	public static int a = 0;
	public static int b = 0;
	public static void main(String[] args) throws InterruptedException {
		int i = 0;
		while(i++ <1000000){
			a = b = 0;
			Thread t1 = new Thread(new Runnable() {
				public void run() {
					a = 1;
					b = 2;
				}
			});
			
			Thread t2 = new Thread(new Runnable() {
				public void run() {
					if(a == 0 && b == 2){
						System.out.println("reorder happened!");
					}else if(a == 0 && b == 0){
						
						System.out.println("reorder happened!");
					}else{
						System.out.println(a +  " " + b);
					}
						
					
				}
			});
			
			t1.start();
			t2.start();
			t1.join();
			t2.join();
		}

	}

}
