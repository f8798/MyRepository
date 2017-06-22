package com.tank.objects;

import com.tank.constants.Config;
import com.tank.constants.DirectionEnum;
import com.tank.constants.TankImageEnum;
import com.tank.objects.common.CommonObject;
import com.tank.objects.common.Tank;

public class Bullet extends CommonObject implements Runnable{
	private boolean isPlayerBullet;
	private volatile DirectionEnum direction;
	
	public Bullet(Tank tank){
		if(tank instanceof TankPlayer){
			isPlayerBullet = true;
		}else{
			isPlayerBullet = false;
		}
		this.direction = tank.getDirection();
		
		switch(this.direction){
		case Up:
			this.setImage(this.resourceContainer.getImageResource(TankImageEnum.Bullet_U));
			this.setX(tank.getX() + tank.getWidth()/2);
			this.setY(tank.getY() - this.getHeight() - 1);
			break;
		case Down:
			this.setImage(this.resourceContainer.getImageResource(TankImageEnum.Bullet_D));
			this.setX(tank.getX() + tank.getWidth()/2);
			this.setY(tank.getY() + tank.getHeight() + 1);
			break;
		case Left:
			this.setImage(this.resourceContainer.getImageResource(TankImageEnum.Bullet_L));
			this.setX(tank.getX() - this.getWidth() - 1);
			this.setY(tank.getY() + tank.getHeight()/2);
			break;
		case Right:
			this.setImage(this.resourceContainer.getImageResource(TankImageEnum.Bullet_R));
			this.setX(tank.getX() + tank.getWidth() + 1);
			this.setY(tank.getY() + tank.getHeight()/2);
			break;
		}
	}

	@Override
	public void run() {
		while(true){
			switch(this.direction){
			case Up:
				this.moveUp();
				break;
			case Down:
				this.moveDown();
				break;
			case Left:
				this.moveLeft();
				break;
			case Right:
				this.moveRight();
				break;
			}
			if(conflictCheck(x,y))
				break;
			try {
				Thread.sleep(Config.bulletSpeed);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public boolean conflictCheck(int x,int y){

		if(hitWallCheck(x,y)){
			this.destroy();
			return true;
		}
		for(int i=0;i<resourceContainer.getObjectList().size();i++){
			CommonObject object = resourceContainer.getObjectList().get(i);
			if(this != object){
				if(!object.isTransparent()&&this.willHit(x, y, object)){
					this.destroy();
					if(object instanceof Wall){
						Wall wall = (Wall)object;
						wall.destory();
					}else{
						if(this.isPlayerBullet){
							if(object instanceof TankEnemy){
								TankEnemy tank = (TankEnemy)object;
								tank.destroy();
							}
						}else{
							if(object instanceof TankPlayer){
								TankPlayer tank = (TankPlayer)object;
								tank.destroy();
							}
						}
						
					}

					return true;
				}
			}
		}
		return false;
	}
	
	public void destroy(){
		this.setTransparent(true);

		this.resourceContainer.getObjectList().remove(this);
	}
	
	public static void main(String args[]){
	}
}
