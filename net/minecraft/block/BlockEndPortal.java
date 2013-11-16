package net.minecraft.block;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.src.AxisAlignedBB;
import net.minecraft.src.Entity;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.IBlockAccess;
import net.minecraft.src.Material;
import net.minecraft.src.TileEntity;
import net.minecraft.src.TileEntityEndPortal;
import net.minecraft.src.World;

public class BlockEndPortal extends BlockContainer {
	/**
	 * true if the enderdragon has been killed - allows end portal blocks to be
	 * created in the end
	 */
	public static boolean bossDefeated = false;

	protected BlockEndPortal(int par1, Material par2Material) {
		super(par1, 0, par2Material);
		setLightValue(1.0F);
	}

	/**
	 * Returns the TileEntity used by this block.
	 */
	public TileEntity getBlockEntity() {
		return new TileEntityEndPortal();
	}

	/**
	 * Updates the blocks bounds based on its current state. Args: world, x, y,
	 * z
	 */
	public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess,
			int par2, int par3, int par4) {
		float f = 0.0625F;
		setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, f, 1.0F);
	}

	/**
	 * Returns true if the given side of this block type should be rendered, if
	 * the adjacent block is at the given coordinates. Args: blockAccess, x, y,
	 * z, side
	 */
	public boolean shouldSideBeRendered(IBlockAccess par1IBlockAccess,
			int par2, int par3, int par4, int par5) {
		if (par5 != 0) {
			return false;
		} else {
			return super.shouldSideBeRendered(par1IBlockAccess, par2, par3,
					par4, par5);
		}
	}

	/**
	 * Adds to the supplied array any colliding bounding boxes with the passed
	 * in bounding box. Args: world, x, y, z, axisAlignedBB, arrayList
	 */
	public void getCollidingBoundingBoxes(World world, int i, int j, int k,
			AxisAlignedBB axisalignedbb, ArrayList arraylist) {
	}

	/**
	 * Is this block (a) opaque and (b) a full 1m cube? This determines whether
	 * or not to render the shared face of two adjacent blocks and also whether
	 * the player can attach torches, redstone wire, etc to this block.
	 */
	public boolean isOpaqueCube() {
		return false;
	}

	/**
	 * If this block doesn't render as an ordinary block it will return False
	 * (examples: signs, buttons, stairs, etc)
	 */
	public boolean renderAsNormalBlock() {
		return false;
	}

	/**
	 * Returns the quantity of items to drop on block destruction.
	 */
	public int quantityDropped(Random par1Random) {
		return 0;
	}

	/**
	 * Triggered whenever an entity collides with this block (enters into the
	 * block). Args: world, x, y, z, entity
	 */
	public void onEntityCollidedWithBlock(World par1World, int par2, int par3,
			int par4, Entity par5Entity) {
		if (par5Entity.ridingEntity == null
				&& par5Entity.riddenByEntity == null
				&& (par5Entity instanceof EntityPlayer) && !par1World.isRemote) {
			((EntityPlayer) par5Entity).travelToTheEnd(1);
		}
	}

	/**
	 * A randomly called display update to be able to add particles or other
	 * items for display
	 */
	public void randomDisplayTick(World par1World, int par2, int par3,
			int par4, Random par5Random) {
		double d = (float) par2 + par5Random.nextFloat();
		double d1 = (float) par3 + 0.8F;
		double d2 = (float) par4 + par5Random.nextFloat();
		double d3 = 0.0D;
		double d4 = 0.0D;
		double d5 = 0.0D;
		par1World.spawnParticle("smoke", d, d1, d2, d3, d4, d5);
	}

	/**
	 * The type of render function that is called for this block
	 */
	public int getRenderType() {
		return -1;
	}

	/**
	 * Called whenever the block is added into the world. Args: world, x, y, z
	 */
	public void onBlockAdded(World par1World, int par2, int par3, int par4) {
		if (bossDefeated) {
			return;
		}

		if (par1World.worldProvider.worldType != 0) {
			par1World.setBlockWithNotify(par2, par3, par4, 0);
			return;
		} else {
			return;
		}
	}
}