package com.tank.gamepanel;

import java.awt.Graphics;
import java.util.List;

import javax.swing.JPanel;

import com.tank.objects.common.CommonObject;

public class GamePanel extends JPanel {
	
	private List objectsList;
	public GamePanel(List objectsList){
		this.objectsList = objectsList;
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		for(int i=0;i<objectsList.size();i++){
			((CommonObject)objectsList.get(i)).draw(g);
		}
		

	}

}
