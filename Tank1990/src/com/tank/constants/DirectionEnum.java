package com.tank.constants;

import java.util.Random;

public enum DirectionEnum {
	Up, Down, Left, Right;
	
	private static Random random = new Random();
	
	public static DirectionEnum nextDirection(){
		DirectionEnum enums[] = DirectionEnum.values();
		return enums[random.nextInt(enums.length)];
	}
}
