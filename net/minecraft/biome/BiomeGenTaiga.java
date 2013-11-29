package net.minecraft.biome;

import java.util.Random;

import net.minecraft.src.SpawnListEntry;
import net.minecraft.world.generators.misc.WorldGenTaiga1;
import net.minecraft.world.generators.misc.WorldGenTaiga2;
import net.minecraft.world.WorldGenerator;

public class BiomeGenTaiga extends BiomeGenBase {
	public BiomeGenTaiga(int par1) {
		super(par1);
		spawnableCreatureList.add(new SpawnListEntry(
				net.minecraft.entity.EntityWolf.class, 8, 4, 4));
		biomeDecorator.treesPerChunk = 10;
		biomeDecorator.grassPerChunk = 1;
	}

	/**
	 * Gets a WorldGen appropriate for this biome.
	 */
        @Override
	public WorldGenerator getRandomWorldGenForTrees(Random par1Random) {
		if (par1Random.nextInt(3) == 0) {
			return new WorldGenTaiga1();
		} else {
			return new WorldGenTaiga2(false);
		}
	}
}
