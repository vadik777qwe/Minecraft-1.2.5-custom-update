package net.minecraft.entity;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.AI.EntityAIArrowAttack;
import net.minecraft.entity.AI.EntityAILookIdle;
import net.minecraft.entity.AI.EntityAINearestAttackableTarget;
import net.minecraft.entity.AI.EntityAIWander;
import net.minecraft.entity.AI.EntityAIWatchClosest;
import net.minecraft.src.DamageSource;
import net.minecraft.item.Item;
import net.minecraft.src.MathHelper;
import net.minecraft.NBT.NBTTagCompound;
import net.minecraft.world.World;

public class EntitySnowman extends EntityGolem {
	public EntitySnowman(World par1World) {
		super(par1World);
		texture = "/mob/snowman.png";
		setSize(0.4F, 1.8F);
		getNavigator().func_48664_a(true);
		tasks.addTask(1, new EntityAIArrowAttack(this, 0.25F, 2, 20));
		tasks.addTask(2, new EntityAIWander(this, 0.2F));
		tasks.addTask(3, new EntityAIWatchClosest(this,
				net.minecraft.entity.EntityPlayer.class, 6F));
		tasks.addTask(4, new EntityAILookIdle(this));
		targetTasks.addTask(1, new EntityAINearestAttackableTarget(this,
				net.minecraft.entity.EntityMob.class, 16F, 0, true));
	}

	/**
	 * Returns true if the newer Entity AI code should be run
	 */
	public boolean isAIEnabled() {
		return true;
	}

	public int getMaxHealth() {
		return 4;
	}

	/**
	 * Called frequently so the entity can update its state every tick as
	 * required. For example, zombies and skeletons use this to react to
	 * sunlight and start to burn.
	 */
	public void onLivingUpdate() {
		super.onLivingUpdate();

		if (isWet()) {
			attackEntityFrom(DamageSource.drown, 1);
		}

		int i = MathHelper.floor_double(posX);
		int k = MathHelper.floor_double(posZ);

		if (worldObj.getBiomeGenForCoords(i, k).getFloatTemperature() > 1.0F) {
			attackEntityFrom(DamageSource.onFire, 1);
		}

		for (int j = 0; j < 4; j++) {
			int l = MathHelper.floor_double(posX
					+ (double) ((float) ((j % 2) * 2 - 1) * 0.25F));
			int i1 = MathHelper.floor_double(posY);
			int j1 = MathHelper.floor_double(posZ
					+ (double) ((float) (((j / 2) % 2) * 2 - 1) * 0.25F));

			if (worldObj.getBlockId(l, i1, j1) == 0
					&& worldObj.getBiomeGenForCoords(l, j1)
							.getFloatTemperature() < 0.8F
					&& Block.snow.canPlaceBlockAt(worldObj, l, i1, j1)) {
				worldObj.setBlockWithNotify(l, i1, j1, Block.snow.blockID);
			}
		}
	}

	/**
	 * (abstract) Protected helper method to write subclass entity data to NBT.
	 */
	public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
		super.writeEntityToNBT(par1NBTTagCompound);
	}

	/**
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
		super.readEntityFromNBT(par1NBTTagCompound);
	}

	/**
	 * Returns the item ID for the item the mob drops on death.
	 */
	protected int getDropItemId() {
		return Item.snowball.shiftedIndex;
	}

	/**
	 * Drop 0-2 items of this living's type
	 */
	protected void dropFewItems(boolean par1, int par2) {
		int i = rand.nextInt(16);

		for (int j = 0; j < i; j++) {
			dropItem(Item.snowball.shiftedIndex, 1);
		}
	}
}
