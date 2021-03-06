package net.minecraft.biome;

import java.util.List;
import java.util.Random;

import net.minecraft.entity.EntityWolf;
import net.minecraft.src.SpawnListEntry;
import net.minecraft.world.WorldGenerator;

public class BiomeGenForest extends BiomeGenBase {
	public BiomeGenForest(int par1) {
		super(par1);
		spawnableCreatureList.add(new SpawnListEntry(
				net.minecraft.entity.EntityWolf.class, 5, 4, 4));
		biomeDecorator.treesPerChunk = 10;
		biomeDecorator.grassPerChunk = 2;
	}

	/**
	 * Gets a WorldGen appropriate for this biome.
	 */
	public WorldGenerator getRandomWorldGenForTrees(Random par1Random) {
		if (par1Random.nextInt(5) == 0) {
			return worldGenForest;
		}

		if (par1Random.nextInt(10) == 0) {
			return worldGenBigTree;
		} else {
			return worldGenTrees;
		}
	}
}
