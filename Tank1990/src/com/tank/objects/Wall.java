package com.tank.objects;

import com.tank.constants.TankImageEnum;
import com.tank.objects.common.CommonObject;

public class Wall extends CommonObject {
	public Wall(){
		this.setImage(resourceContainer.getImageResource(TankImageEnum.WallBrick));
	}
	
	public Wall(int x, int y){
		this.x = x;
		this.y = y;
		this.setImage(resourceContainer.getImageResource(TankImageEnum.WallBrick));
	}
	
	public void destory(){
		resourceContainer.getObjectList().remove(this);
	}
}
