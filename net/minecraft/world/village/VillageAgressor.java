package net.minecraft.world.village;

import net.minecraft.entity.EntityLiving;

class VillageAgressor {
	public EntityLiving agressor;
	public int agressionTime;
	final Village villageObj;

	VillageAgressor(Village par1Village, EntityLiving par2EntityLiving, int par3) {
		villageObj = par1Village;
		agressor = par2EntityLiving;
		agressionTime = par3;
	}
}
