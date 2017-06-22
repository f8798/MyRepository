package com.tank.listener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.tank.constants.DirectionEnum;
import com.tank.objects.TankPlayer;
import com.tank.utils.ResourceContainer;

public class TankKeyboardListener implements KeyListener {
	
	private TankPlayer tankPlayer;
	private ResourceContainer resourceContainer;
	public TankKeyboardListener(TankPlayer tankPlayer){
		this.tankPlayer = tankPlayer;
		resourceContainer = ResourceContainer.getInstance();
	}
	@Override
	public void keyPressed(KeyEvent event) {
		
		switch (event.getKeyCode()){
		case KeyEvent.VK_UP:
			tankPlayer.setOriginalDirection(tankPlayer.getDirection());
			tankPlayer.setDirection(DirectionEnum.Up);
			tankPlayer.setStop(false);
			break;
		case KeyEvent.VK_DOWN:
			tankPlayer.setOriginalDirection(tankPlayer.getDirection());
			tankPlayer.setDirection(DirectionEnum.Down);
			tankPlayer.setStop(false);
			break;
		case KeyEvent.VK_LEFT:
			tankPlayer.setOriginalDirection(tankPlayer.getDirection());
			tankPlayer.setDirection(DirectionEnum.Left);
			tankPlayer.setStop(false);
			break;
		case KeyEvent.VK_RIGHT:
			tankPlayer.setOriginalDirection(tankPlayer.getDirection());
			tankPlayer.setDirection(DirectionEnum.Right);
			tankPlayer.setStop(false);
			break;
		case KeyEvent.VK_SPACE:
			tankPlayer.fire();
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent event) {
		// TODO Auto-generated method stub
		switch (event.getKeyCode()){
		case KeyEvent.VK_UP:
			tankPlayer.setStop(true);
			break;
		case KeyEvent.VK_DOWN:
			tankPlayer.setStop(true);
			break;
		case KeyEvent.VK_LEFT:
			tankPlayer.setStop(true);
			break;
		case KeyEvent.VK_RIGHT:
			tankPlayer.setStop(true);
			break;
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}
