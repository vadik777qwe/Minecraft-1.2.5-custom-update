package net.minecraft.block;

import java.util.Random;

import net.minecraft.src.Material;
import net.minecraft.src.TileEntity;
import net.minecraft.src.TileEntityMobSpawner;

public class BlockMobSpawner extends BlockContainer {
	protected BlockMobSpawner(int par1, int par2) {
		super(par1, par2, Material.rock);
	}

	/**
	 * Returns the TileEntity used by this block.
	 */
	public TileEntity getBlockEntity() {
		return new TileEntityMobSpawner();
	}

	/**
	 * Returns the ID of the items to drop on destruction.
	 */
	public int idDropped(int par1, Random par2Random, int par3) {
		return 0;
	}

	/**
	 * Returns the quantity of items to drop on block destruction.
	 */
	public int quantityDropped(Random par1Random) {
		return 0;
	}

	/**
	 * Is this block (a) opaque and (b) a full 1m cube? This determines whether
	 * or not to render the shared face of two adjacent blocks and also whether
	 * the player can attach torches, redstone wire, etc to this block.
	 */
	public boolean isOpaqueCube() {
		return false;
	}
}
