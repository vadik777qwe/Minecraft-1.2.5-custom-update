package net.minecraft.entity;

import net.minecraft.src.DamageSource;
import net.minecraft.NBT.NBTTagCompound;

public class EntityDragonPart extends Entity {
	/** The dragon entity this dragon part belongs to */
	public final EntityDragonBase entityDragonObj;

	/** The name of the Dragon Part */
	public final String name;

	public EntityDragonPart(EntityDragonBase par1EntityDragonBase,
			String par2Str, float par3, float par4) {
		super(par1EntityDragonBase.worldObj);
		setSize(par3, par4);
		entityDragonObj = par1EntityDragonBase;
		name = par2Str;
	}

	protected void entityInit() {
	}

	/**
	 * (abstract) Protected helper method to read subclass entity data from NBT.
	 */
	protected void readEntityFromNBT(NBTTagCompound nbttagcompound) {
	}

	/**
	 * (abstract) Protected helper method to write subclass entity data to NBT.
	 */
	protected void writeEntityToNBT(NBTTagCompound nbttagcompound) {
	}

	/**
	 * Returns true if other Entities should be prevented from moving through
	 * this Entity.
	 */
	public boolean canBeCollidedWith() {
		return true;
	}

	/**
	 * Called when the entity is attacked.
	 */
	public boolean attackEntityFrom(DamageSource par1DamageSource, int par2) {
		return entityDragonObj.attackEntityFromPart(this, par1DamageSource,
				par2);
	}

	/**
	 * Returns true if Entity argument is equal to this Entity
	 */
	public boolean isEntityEqual(Entity par1Entity) {
		return this == par1Entity || entityDragonObj == par1Entity;
	}
}
