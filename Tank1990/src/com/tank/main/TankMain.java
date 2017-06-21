package com.tank.main;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.tank.constants.Config;
import com.tank.gamepanel.GamePanel;
import com.tank.listener.TankKeyboardListener;
import com.tank.objects.TankPlayer;
import com.tank.objects.common.Tank;
import com.tank.utils.MapGenerator;
import com.tank.utils.ResourceContainer;

public class TankMain extends JFrame{
	public TankMain(){
		ResourceContainer rc = ResourceContainer.getInstance();
//		TankPlayer tankPlayer = new TankPlayer();
//		rc.addObject(tankPlayer);tankPlayer.printInfo();
//		rc.addAllObject(TankEnemy.generateEnemyTanks());
		MapGenerator.generateMap();
		
		GamePanel panel = new GamePanel(rc.getObjectList());
		panel.setBackground(Color.black);
		this.setSize(300, 300);
		this.add(panel);
		this.addKeyListener(new TankKeyboardListener((TankPlayer)rc.getObjectList().get(0)));
		this.setVisible(true);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		
		Config.windowWidth = panel.getWidth();
		Config.windowHeight = panel.getHeight();
		
		Thread refreshThread = new Thread(new Refresher(panel));
		refreshThread.start();
		
		for(int i = 0;i<rc.getObjectList().size();i++){
			
			if(rc.getObjectList().get(i) instanceof Tank){
				Tank tank = (Tank)rc.getObjectList().get(i);
				Thread tankThread = new Thread((Tank)rc.getObjectList().get(i));
				tankThread.start();
			}
		}
		
		
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		TankMain tankMain = new TankMain();
		//heapOOM();

		
	}
	static class OoMObject{
		 byte[] b = new byte[1024*1024];
	}
	
	public static void heapOOM(){
		List arrayList = new ArrayList();
		while(true){
			arrayList.add(new OoMObject());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	} 
}


class Refresher implements Runnable{
	JPanel gamePanel;
	public Refresher(JPanel gamePanel){
		this.gamePanel = gamePanel;
	}
	public void run(){
		while(true){
			try {
				gamePanel.repaint();
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}