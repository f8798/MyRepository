package com.tank.objects.common;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import com.tank.constants.Config;
import com.tank.constants.TankImageEnum;
import com.tank.utils.ResourceContainer;

public class CommonObject {
	protected volatile int x;
	protected volatile int y;
	protected volatile int width;
	protected volatile int height;
	protected volatile boolean isTransparent;
	private volatile Image objectImage;
	
	protected ResourceContainer resourceContainer;
	public CommonObject(){
		resourceContainer = ResourceContainer.getInstance();
	}
	
	public void printInfo(){
		System.out.println("x:"+x+" ,y:"+y+", width:"+width+" ,height:"+height);
		
	}
	
	public CommonObject(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public void draw(Graphics g){
		g.drawImage(objectImage, x, y, null);
	}
	
	public boolean hit(CommonObject object){
		return this.getRectangle().intersects(object.getRectangle());
	}

	public boolean willHit(int x, int y,CommonObject object){
		return getRectangle(x,y).intersects(object.getRectangle());
	}
	public void setImage(Image objectImage){
		this.objectImage = objectImage;
		this.width = objectImage.getWidth(null);
		this.height = objectImage.getHeight(null);
	} 
	
	public Rectangle getRectangle(){
		return new Rectangle(x,y,width,height);
	}
	
	public Rectangle getRectangle(int x, int y){
		return new Rectangle(x,y,width,height);
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public boolean isTransparent() {
		return isTransparent;
	}

	public void setTransparent(boolean isTransparent) {
		this.isTransparent = isTransparent;
	}
	
	public boolean conflictCheck(int x,int y){

		if(hitWallCheck(x,y)){
			return true;
		}
		for(int i=0;i<resourceContainer.getObjectList().size();i++){
			CommonObject object = resourceContainer.getObjectList().get(i);
			if(this != object){
				if(!object.isTransparent&&this.willHit(x, y, object)){
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean hitWallCheck(int x, int y){
		return x<0||y<0||(x+this.getWidth())>Config.windowWidth||(y+this.getHeight())>Config.windowHeight;
	}
	
	public void moveUp(){
		y--;
	}
	
	public void moveDown(){
		y++;
	}
	
	public void moveLeft(){
		x--;
	}
	
	public void moveRight(){
		x++;
	}
	

}
