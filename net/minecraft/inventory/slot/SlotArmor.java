package net.minecraft.inventory.slot;

import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.containers.ContainerPlayer;
import net.minecraft.block.Block;
import net.minecraft.src.IInventory;

public class SlotArmor extends Slot {
	/**
	 * The armor type that can be placed on that slot, it uses the same values
	 * of armorType field on ItemArmor.
	 */
	final int armorType;

	/**
	 * The parent class of this clot, ContainerPlayer, SlotArmor is a Anon inner
	 * class.
	 */
	final ContainerPlayer parent;

	public SlotArmor(ContainerPlayer par1ContainerPlayer, IInventory par2IInventory,
			int par3, int par4, int par5, int par6) {
		super(par2IInventory, par3, par4, par5);
		parent = par1ContainerPlayer;
		armorType = par6;
	}

	/**
	 * Returns the maximum stack size for a given slot (usually the same as
	 * getInventoryStackLimit(), but 1 in the case of armor slots)
	 */
        @Override
	public int getSlotStackLimit() {
		return 1;
	}

	/**
	 * Check if the stack is a valid item for this slot. Always true beside for
	 * the armor slots.
	 */
        @Override
	public boolean isItemValid(ItemStack par1ItemStack) {
		if (par1ItemStack.getItem() instanceof ItemArmor) {
			return ((ItemArmor) par1ItemStack.getItem()).armorType == armorType;
		}

		if (par1ItemStack.getItem().shiftedIndex == Block.pumpkin.blockID) {
			return armorType == 0;
		} else {
			return false;
		}
	}

	/**
	 * Returns the icon index on items.png that is used as background image of
	 * the slot.
	 */
        @Override
	public int getBackgroundIconIndex() {
		return 15 + armorType * 16;
	}
}
