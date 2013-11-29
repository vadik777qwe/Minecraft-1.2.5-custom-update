package net.minecraft.biome;

import net.minecraft.src.SpawnListEntry;

public class BiomeGenHell extends BiomeGenBase {
	public BiomeGenHell(int par1) {
		super(par1);
		spawnableMonsterList.clear();
		spawnableCreatureList.clear();
		spawnableWaterCreatureList.clear();
		spawnableMonsterList.add(new SpawnListEntry(
				net.minecraft.entity.EntityGhast.class, 50, 4, 4));
		spawnableMonsterList.add(new SpawnListEntry(
				net.minecraft.entity.EntityPigZombie.class, 100, 4, 4));
		spawnableMonsterList.add(new SpawnListEntry(
				net.minecraft.entity.EntityMagmaCube.class, 1, 4, 4));
	}
}
