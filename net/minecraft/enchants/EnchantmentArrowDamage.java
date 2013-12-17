package net.minecraft.enchants;

import net.minecraft.enums.EnumEnchantmentType;

public class EnchantmentArrowDamage extends Enchantment {
	public EnchantmentArrowDamage(int par1, int par2) {
		super(par1, par2, EnumEnchantmentType.bow);
		setName("arrowDamage");
	}

	/**
	 * Returns the minimal value of enchantability nedded on the enchantment
	 * level passed.
	 */
	public int getMinEnchantability(int par1) {
		return 1 + (par1 - 1) * 10;
	}

	/**
	 * Returns the maximum value of enchantability nedded on the enchantment
	 * level passed.
	 */
	public int getMaxEnchantability(int par1) {
		return getMinEnchantability(par1) + 15;
	}

	/**
	 * Returns the maximum level that the enchantment can have.
	 */
	public int getMaxLevel() {
		return 5;
	}
}