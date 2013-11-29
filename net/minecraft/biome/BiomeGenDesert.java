package net.minecraft.biome;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.generators.misc.WorldGenDesertWells;

public class BiomeGenDesert extends BiomeGenBase {
	public BiomeGenDesert(int par1) {
		super(par1);
		spawnableCreatureList.clear();
		topBlock = (byte) Block.sand.blockID;
		fillerBlock = (byte) Block.sand.blockID;
		biomeDecorator.treesPerChunk = -999;
		biomeDecorator.deadBushPerChunk = 2;
		biomeDecorator.reedsPerChunk = 50;
		biomeDecorator.cactiPerChunk = 10;
	}

        @Override
	public void decorate(World par1World, Random par2Random, int par3, int par4) {
		super.decorate(par1World, par2Random, par3, par4);

		if (par2Random.nextInt(1000) == 0) {
			int i = par3 + par2Random.nextInt(16) + 8;
			int j = par4 + par2Random.nextInt(16) + 8;
			WorldGenDesertWells worldgendesertwells = new WorldGenDesertWells();
			worldgendesertwells.generate(par1World, par2Random, i,
					par1World.getHeightValue(i, j) + 1, j);
		}
	}
}
