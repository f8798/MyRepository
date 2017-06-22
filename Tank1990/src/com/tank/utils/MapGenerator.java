package com.tank.utils;

import com.tank.constants.Config;
import com.tank.objects.TankEnemy;
import com.tank.objects.TankPlayer;
import com.tank.objects.Wall;

public class MapGenerator {
	public static void generateMap(){
		ResourceContainer rc = ResourceContainer.getInstance();
		TankPlayer tankPlayer = new TankPlayer(Config.windowWidth/2-15,Config.windowHeight-70);
		TankEnemy tankEnemy1 = new TankEnemy(0,0);
		TankEnemy tankEnemy2 = new TankEnemy(Config.windowWidth/2-15,0);
		TankEnemy tankEnemy3 = new TankEnemy(Config.windowWidth-60,0);
		
		rc.addObject(tankPlayer);
		rc.addObject(tankEnemy1);
		rc.addObject(tankEnemy2);
		rc.addObject(tankEnemy3);
		
		int rows = Config.windowHeight/15;
		int lines = Config.windowWidth/15;
		
		for(int i=2;i<Config.windowHeight/15-3;i++){
			rc.addObject(new Wall(i*15,100));
		}
		for(int i=2;i<Config.windowHeight/15-3;i++){
			rc.addObject(new Wall(i*15,115));
		}
		for(int i=2;i<Config.windowHeight/15-3;i++){
			rc.addObject(new Wall(i*15,130));
		}
		for(int i=2;i<Config.windowHeight/15-3;i++){
			rc.addObject(new Wall(i*15,145));
		}
		for(int i=2;i<Config.windowHeight/15-3;i++){
			rc.addObject(new Wall(i*15,160));
		}
		for(int i=2;i<Config.windowHeight/15-3;i++){
			rc.addObject(new Wall(i*15,175));
		}
		for(int i=2;i<Config.windowHeight/15-3;i++){
			rc.addObject(new Wall(i*15,190));
		}
		for(int i=2;i<Config.windowHeight/15-3;i++){
			rc.addObject(new Wall(i*15,205));
		}
	}
	
}
