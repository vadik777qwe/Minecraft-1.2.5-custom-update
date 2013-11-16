package net.minecraft.biome;

import java.util.List;

import net.minecraft.src.EntityGhast;
import net.minecraft.src.EntityMagmaCube;
import net.minecraft.src.EntityPigZombie;
import net.minecraft.src.SpawnListEntry;

public class BiomeGenHell extends BiomeGenBase {
	public BiomeGenHell(int par1) {
		super(par1);
		spawnableMonsterList.clear();
		spawnableCreatureList.clear();
		spawnableWaterCreatureList.clear();
		spawnableMonsterList.add(new SpawnListEntry(
				net.minecraft.src.EntityGhast.class, 50, 4, 4));
		spawnableMonsterList.add(new SpawnListEntry(
				net.minecraft.src.EntityPigZombie.class, 100, 4, 4));
		spawnableMonsterList.add(new SpawnListEntry(
				net.minecraft.src.EntityMagmaCube.class, 1, 4, 4));
	}
}
