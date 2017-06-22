package com.tank.objects;

import java.sql.Timestamp;
import java.util.Date;

import com.tank.constants.Config;
import com.tank.constants.TankImageEnum;
import com.tank.objects.common.Tank;

public class TankPlayer extends Tank{
	
	//Tank player status, moving of stop.
	private boolean stop = true;
	
	public TankPlayer() {
		this.setImage(resourceContainer.getImageResource(TankImageEnum.Tank_Player_U));
	}
	public TankPlayer(int x, int y) {
		this.x=x;
		this.y=y;
		this.setImage(resourceContainer.getImageResource(TankImageEnum.Tank_Player_U));
	}
	public void run(){
		while(true){
			if(stop==false){
				changeTankDirectionImage();
				switch(this.getDirection()){
				case Up:
					if(this.conflictCheck(x, y-1)){
						stop = true;
						break;
					}
					this.moveUp();
					break;
				case Down:
					if(this.conflictCheck(x, y+1)){
						stop = true;
						break;
					}
					this.moveDown();
					break;
				case Left:
					if(this.conflictCheck(x-1, y)){
						stop = true;
						break;
					}
					this.moveLeft();
					break;
				case Right:
					if(this.conflictCheck(x+1, y)){
						stop = true;
						break;
					}
					this.moveRight();
					break;
				}
			}

			//pause for a while to slow down
			try {
				Thread.sleep(Config.playerSpeed);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public boolean isStop() {
		return stop;
	}

	public void setStop(boolean stop) {
		this.stop = stop;
	}

	public void changeTankDirectionImage(){
		if(!(this.getDirection()==this.getOriginalDirection())){
			switch(this.getDirection()){
			case Up:
				this.setImage(resourceContainer.getImageResource(TankImageEnum.Tank_Player_U));
				break;
			case Down:
				this.setImage(resourceContainer.getImageResource(TankImageEnum.Tank_Player_D));
				break;
			case Left:
				this.setImage(resourceContainer.getImageResource(TankImageEnum.Tank_Player_L));
				break;
			case Right:
				this.setImage(resourceContainer.getImageResource(TankImageEnum.Tank_Player_R));
				break;
			}
		}

	}
	

	
}
