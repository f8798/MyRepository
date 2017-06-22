package com.tank.objects;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.tank.constants.Config;
import com.tank.constants.DirectionEnum;
import com.tank.constants.TankImageEnum;
import com.tank.objects.common.Tank;

public class TankEnemy extends Tank {
	private Random random;
	
	public TankEnemy() {
		random = new Random();
		this.setImage(resourceContainer.getImageResource(TankImageEnum.Tank_Enemy_U));
	}
	public TankEnemy(int x, int y) {
		this.x = x;
		this.y = y;
		random = new Random();
		this.setImage(resourceContainer.getImageResource(TankImageEnum.Tank_Enemy_U));
	}
	public void run(){
		move();
	}
	
	private void move(){
		while(true){

			//The distance the enemy is going to move
			int distance = random.nextInt(Config.maxEnemyTraveledDistance);
			this.setOriginalDirection(this.getDirection());
			this.setDirection(DirectionEnum.nextDirection()) ;
			this.changeTankDirectionImage();
			
			while(distance-->0){
				if(!this.isLive()){
					return;
				}
				fire();
				boolean outWhile = false;
				switch(this.getDirection()){
				case Up:
					if(this.conflictCheck(x, y-1)){
						outWhile = true;
						break;
					}
					this.moveUp();
					break;
				case Down:
					if(this.conflictCheck(x, y+1)){
						outWhile = true;
						break;
					}
					this.moveDown();
					break;
				case Left:
					if(this.conflictCheck(x-1, y)){
						outWhile = true;
						break;
					}
					this.moveLeft();
					break;
				case Right:
					if(this.conflictCheck(x+1, y)){
						outWhile = true;
						break;
					}
					this.moveRight();
					break;
				}
				Thread.yield();
				if(outWhile){
					break;
				}
				
				//pause for a while to slow down
				try {
					Thread.sleep(Config.enemySpeed);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			

		}
	}
	
	
	public static List generateEnemyTanks(){
		List list = new ArrayList();
		for(int i = 1;i <5;i++){
			list.add(new TankEnemy(i*30,0));
		}
		return list;
	}
	
	public static void main(String args[]){
		int i=90;
		while(i-->0){
			System.out.println(DirectionEnum.nextDirection().name());
		}
	}
	
	public void changeTankDirectionImage(){
		if(!(this.getDirection()==this.getOriginalDirection())){
			switch(this.getDirection()){
			case Up:
				this.setImage(resourceContainer.getImageResource(TankImageEnum.Tank_Enemy_U));
				break;
			case Down:
				this.setImage(resourceContainer.getImageResource(TankImageEnum.Tank_Enemy_D));
				break;
			case Left:
				this.setImage(resourceContainer.getImageResource(TankImageEnum.Tank_Enemy_L));
				break;
			case Right:
				this.setImage(resourceContainer.getImageResource(TankImageEnum.Tank_Enemy_R));
				break;
			}
		}
	}
}
