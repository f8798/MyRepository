package com.tank.constants;

public enum TankImageEnum {
	Tank_Player_U("Tank1-up.GIF"),
	Tank_Player_D("Tank1-down.GIF"),
	Tank_Player_L("Tank1-left.GIF"),
	Tank_Player_R("Tank1-right.GIF"),
	Tank_Enemy_U("Tank2-up.GIF"),
	Tank_Enemy_D("Tank2-down.GIF"),
	Tank_Enemy_L("Tank2-left.GIF"),
	Tank_Enemy_R("Tank2-right.GIF"),
	Bullet_U("bullet-up.GIF"),
	Bullet_D("bullet-down.GIF"),
	Bullet_L("bullet-left.GIF"),
	Bullet_R("bullet-right.GIF"),
	Tank_Explode("boom.GIF"),
	WallBrick("wall_brick.GIF");
	
	private String fileAddress;
	private TankImageEnum(){};
	private TankImageEnum(String fileName){
		this.fileAddress = "images/"+fileName;
	}
	
	public String getFileAddress(){
		return fileAddress;
	}
}
