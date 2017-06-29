package com.jyh.jmm;

public class CommandReorder {
	public static void main(String[] args) throws InterruptedException {
		int i = 0;
		while(i++ <1000000){
			TestObject2 to2 = new TestObject2();
			Thread1 t1 = new Thread1(to2);
			Thread2 t2 = new Thread2(to2);
			
			t1.start();
			t2.start();
			t1.join();
			t2.join();
		}

	}
	
	static class TestObject{
		public void invoke(){
//			System.out.println("invoked!");
		}
	}
	
	static class TestObject2{
		public boolean a = false;
		public TestObject b;
	}
	
	static class Thread1 extends Thread{
		TestObject2 to2;
		public Thread1(TestObject2 to2){
			this.to2 = to2;
		}
		public void run() {
			
			if(to2.a==true ){
				
				to2.b.invoke();
			}else{
//				System.out.println(to2.a + "  " + to2.b);
			}
		}
	}
	
	static class Thread2 extends Thread{
		TestObject2 to2;
		public Thread2(TestObject2 to2){
			this.to2 = to2;
		}
		public void run() {
			init();
			to2.a = true;
		}
		
		void init(){
			to2.b = new TestObject();
		}
	}

}


