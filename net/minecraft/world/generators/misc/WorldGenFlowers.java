package net.minecraft.world.generators.misc;

import net.minecraft.world.World;
import net.minecraft.world.WorldGenerator;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;

public class WorldGenFlowers extends WorldGenerator {
	/** The ID of the plant block used in this plant generator. */
	private int plantBlockId;

	public WorldGenFlowers(int par1) {
		plantBlockId = par1;
	}

        @Override
	public boolean generate(World par1World, Random par2Random, int par3,
			int par4, int par5) {
		for (int i = 0; i < 64; i++) {
			int j = (par3 + par2Random.nextInt(8)) - par2Random.nextInt(8);
			int k = (par4 + par2Random.nextInt(4)) - par2Random.nextInt(4);
			int l = (par5 + par2Random.nextInt(8)) - par2Random.nextInt(8);

			if (par1World.isAirBlock(j, k, l)
					&& ((BlockFlower) Block.blocksList[plantBlockId])
							.canBlockStay(par1World, j, k, l)) {
				par1World.setBlock(j, k, l, plantBlockId);
			}
		}

		return true;
	}
}
