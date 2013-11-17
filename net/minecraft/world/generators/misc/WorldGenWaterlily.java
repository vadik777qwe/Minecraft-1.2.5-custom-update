package net.minecraft.world.generators.misc;

import net.minecraft.world.WorldGenerator;
import net.minecraft.world.World;
import java.util.Random;

import net.minecraft.block.Block;

public class WorldGenWaterlily extends WorldGenerator {
	public WorldGenWaterlily() {
	}

	public boolean generate(World par1World, Random par2Random, int par3,
			int par4, int par5) {
		for (int i = 0; i < 10; i++) {
			int j = (par3 + par2Random.nextInt(8)) - par2Random.nextInt(8);
			int k = (par4 + par2Random.nextInt(4)) - par2Random.nextInt(4);
			int l = (par5 + par2Random.nextInt(8)) - par2Random.nextInt(8);

			if (par1World.isAirBlock(j, k, l)
					&& Block.waterlily.canPlaceBlockAt(par1World, j, k, l)) {
				par1World.setBlock(j, k, l, Block.waterlily.blockID);
			}
		}

		return true;
	}
}
