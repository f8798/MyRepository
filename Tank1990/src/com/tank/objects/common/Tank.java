package com.tank.objects.common;

import java.sql.Time;
import java.util.Date;

import com.tank.constants.Config;
import com.tank.constants.DirectionEnum;
import com.tank.constants.TankImageEnum;
import com.tank.objects.Bullet;


public abstract class Tank extends CommonObject implements Runnable{
	
	private volatile boolean isLive = true;
	private volatile DirectionEnum direction = DirectionEnum.Up;
	private volatile DirectionEnum originalDirection = DirectionEnum.Up;
	public volatile long lastFireTime;
	public volatile Bullet lastBullet;
	
	public Tank(){
	}
	
	public boolean isLive() {
		return isLive;
	}

	public void setLive(boolean isLive) {
		this.isLive = isLive;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
	public DirectionEnum getDirection() {
		return direction;
	}

	public void setDirection(DirectionEnum direction) {
		this.direction = direction;
	}

	public DirectionEnum getOriginalDirection() {
		return originalDirection;
	}

	public void setOriginalDirection(DirectionEnum originalDirection) {
		this.originalDirection = originalDirection;
	}
	
	public void destroy(){
		this.setLive(false);
		this.setTransparent(true);
		this.setImage(resourceContainer.getImageResource(TankImageEnum.Tank_Explode));
		try {
			Thread.sleep(Config.dispearTime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.resourceContainer.getObjectList().remove(this);
	}
	
	public void fire(){
		if(!lastBulletExist()){
			Bullet b = new Bullet(this);
			Thread bulletThread = new Thread(b);
			bulletThread.start();
			this.resourceContainer.getObjectList().add(b);
			this.lastBullet = b;
		}
		
	}
	
	public boolean lastBulletExist(){
		return this.resourceContainer.getObjectList().contains(this.lastBullet);
	}
	public boolean checkFireInterval(){
		Date currentDate = new Date();
		if(!((currentDate.getTime()-lastFireTime)>Config.bulletInterval)){
			return false;
		}else{
			lastFireTime = currentDate.getTime();
			return true;
		}
	}
}
