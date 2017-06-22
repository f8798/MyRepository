package com.tank.utils;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;

import com.tank.constants.TankImageEnum;
import com.tank.objects.common.CommonObject;

public class ResourceContainer {
	private static ResourceContainer resourceContainer;
	private Map<TankImageEnum, Image> resourceMap;
	private List<CommonObject> objectList;
	
	public List<CommonObject> getObjectList() {
		return objectList;
	}
	private ResourceContainer(){
		resourceMap = new HashMap<TankImageEnum, Image>();
		objectList = new LinkedList<CommonObject>();
		objectList = Collections.synchronizedList(objectList);
		try {
			for(TankImageEnum tankEnum:TankImageEnum.values()){
				resourceMap.put(tankEnum,ImageIO.read(new File(tankEnum.getFileAddress())));
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}
	public static ResourceContainer getInstance(){
		synchronized(ResourceContainer.class){
			if(resourceContainer==null){
				resourceContainer =  new ResourceContainer();
			}
		}
		return resourceContainer;
	}
	public Image getImageResource(TankImageEnum tankEnum){
		return resourceMap.get(tankEnum);
	}
	
	public void addObject(CommonObject object){
		objectList.add(object);
	}
	
	public void addAllObject(List<? extends CommonObject> list){
		objectList.addAll(list);
	}
	
	public void remove(){
		
	}
}
