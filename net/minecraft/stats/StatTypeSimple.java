package net.minecraft.stats;

import java.text.NumberFormat;
import net.minecraft.src.IStatType;

final class StatTypeSimple implements IStatType {
	StatTypeSimple() {
	}

	/**
	 * Formats a given stat for human consumption.
	 */
	public String format(int par1) {
		return StatBase.getNumberFormat().format(par1);
	}
}
