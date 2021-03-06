package net.minecraft.gui;

import java.util.*;
import net.minecraft.stats.SorterStatsBlock;
import net.minecraft.stats.StatCrafting;
import net.minecraft.stats.StatList;
import net.minecraft.src.Tessellator;

public class GuiSlotStatsBlock extends GuiSlotStats {
	public final GuiStats field_27274_a;

	public GuiSlotStatsBlock(GuiStats par1GuiStats) {
		super(par1GuiStats);
		field_27274_a = par1GuiStats;
		field_27273_c = new ArrayList();
		Iterator iterator = StatList.objectMineStats.iterator();

		do {
			if (!iterator.hasNext()) {
				break;
			}

			StatCrafting statcrafting = (StatCrafting) iterator.next();
			boolean flag = false;
			int i = statcrafting.getItemID();

			if (GuiStats.getStatsFileWriter(par1GuiStats).writeStat(
					statcrafting) > 0) {
				flag = true;
			} else if (StatList.objectUseStats[i] != null
					&& GuiStats.getStatsFileWriter(par1GuiStats).writeStat(
							StatList.objectUseStats[i]) > 0) {
				flag = true;
			} else if (StatList.objectCraftStats[i] != null
					&& GuiStats.getStatsFileWriter(par1GuiStats).writeStat(
							StatList.objectCraftStats[i]) > 0) {
				flag = true;
			}

			if (flag) {
				field_27273_c.add(statcrafting);
			}
		} while (true);

		field_27272_d = new SorterStatsBlock(this, par1GuiStats);
	}

        @Override
	protected void func_27260_a(int par1, int par2, Tessellator par3Tessellator) {
		super.func_27260_a(par1, par2, par3Tessellator);

		if (field_27268_b == 0) {
			GuiStats.drawSprite(field_27274_a, ((par1 + 115) - 18) + 1,
					par2 + 1 + 1, 18, 18);
		} else {
			GuiStats.drawSprite(field_27274_a, (par1 + 115) - 18, par2 + 1, 18,
					18);
		}

		if (field_27268_b == 1) {
			GuiStats.drawSprite(field_27274_a, ((par1 + 165) - 18) + 1,
					par2 + 1 + 1, 36, 18);
		} else {
			GuiStats.drawSprite(field_27274_a, (par1 + 165) - 18, par2 + 1, 36,
					18);
		}

		if (field_27268_b == 2) {
			GuiStats.drawSprite(field_27274_a, ((par1 + 215) - 18) + 1,
					par2 + 1 + 1, 54, 18);
		} else {
			GuiStats.drawSprite(field_27274_a, (par1 + 215) - 18, par2 + 1, 54,
					18);
		}
	}

        @Override
	protected void drawSlot(int par1, int par2, int par3, int par4,
			Tessellator par5Tessellator) {
		StatCrafting statcrafting = func_27264_b(par1);
		int i = statcrafting.getItemID();
		GuiStats.drawItemSprite(field_27274_a, par2 + 40, par3, i);
		func_27265_a((StatCrafting) StatList.objectCraftStats[i], par2 + 115,
				par3, par1 % 2 == 0);
		func_27265_a((StatCrafting) StatList.objectUseStats[i], par2 + 165,
				par3, par1 % 2 == 0);
		func_27265_a(statcrafting, par2 + 215, par3, par1 % 2 == 0);
	}

        @Override
	protected String func_27263_a(int par1) {
		if (par1 == 0) {
			return "stat.crafted";
		}

		if (par1 == 1) {
			return "stat.used";
		} else {
			return "stat.mined";
		}
	}
}
