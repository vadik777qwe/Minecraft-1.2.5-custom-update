package net.minecraft.inventory.slot;

import net.minecraft.containers.ContainerEnchantment;
import net.minecraft.inventory.InventoryBasic;

public class SlotEnchantmentTable extends InventoryBasic {
	/** The brewing stand this slot belongs to. */
	final ContainerEnchantment container;

	public SlotEnchantmentTable(ContainerEnchantment par1ContainerEnchantment,
			String par2Str, int par3) {
		super(par2Str, par3);
		container = par1ContainerEnchantment;
	}

	/**
	 * Returns the maximum stack size for a inventory slot. Seems to always be
	 * 64, possibly will be extended. *Isn't this more of a set than a get?*
	 */
        @Override
	public int getInventoryStackLimit() {
		return 1;
	}

	/**
	 * Called when an the contents of an Inventory change, usually
	 */
        @Override
	public void onInventoryChanged() {
		super.onInventoryChanged();
		container.onCraftMatrixChanged(this);
	}
}
