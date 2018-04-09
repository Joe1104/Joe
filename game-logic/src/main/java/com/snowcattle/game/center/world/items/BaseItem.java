package com.snowcattle.game.center.world.items;

import com.snowcattle.game.center.world.BaseWorld;

/**
 * 物品
 * @author Administrator
 *
 */
public abstract class BaseItem extends BaseWorld {

	//可装备
	private Boolean canEquip;  
	
	//可分解
	private Boolean canSplit;
	
	//颜色品质
	private int color;
	
	//可合成
	private Boolean canCombine;
	
	

	public void getaaa() {
 		
	}
	
	public Boolean getCanEquip() {
		return canEquip;
	}

	public void setCanEquip(Boolean canEquip) {
		this.canEquip = canEquip;
	}

	public Boolean getCanSplit() {
		return canSplit;
	}

	public void setCanSplit(Boolean canSplit) {
		this.canSplit = canSplit;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public Boolean getCanCombine() {
		return canCombine;
	}

	public void setCanCombine(Boolean canCombine) {
		this.canCombine = canCombine;
	}
}
