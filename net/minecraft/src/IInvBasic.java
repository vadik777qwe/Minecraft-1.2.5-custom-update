package net.minecraft.src;

import net.minecraft.inventory.InventoryBasic;

public interface IInvBasic {
	/**
	 * Called by InventoryBasic.onInventoryChanged() on a array that is never
	 * filled.
	 */
	public abstract void onInventoryChanged(InventoryBasic inventorybasic);
}
