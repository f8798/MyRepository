package common;

import java.util.Date;

public class Timer {
	private Long timeStart;
	
	private Long timeEnd;
	
	public void start(){
		timeStart = System.currentTimeMillis();
		System.out.println(new Date(timeStart).toLocaleString());
	}
	
	public void stop(){
		timeEnd = System.currentTimeMillis();
		System.out.println(new Date(timeEnd).toLocaleString());
		System.out.println((timeEnd - timeStart) + "ms consumed!");
		
	}
}
