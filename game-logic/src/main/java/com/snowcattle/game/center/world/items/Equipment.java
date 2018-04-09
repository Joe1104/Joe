package com.snowcattle.game.center.world.items;


public abstract class Equipment extends BaseItem {
	
	
	private int postion;
	
	public Equipment() {
		super();
		setCanEquip(true);
		setCanSplit(true);
		setCanCombine(true);
	}

	public int getPostion() {
		return postion;
	}

	public void setPostion(int postion) {
		this.postion = postion;
	}
	 
	
}
