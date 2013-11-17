package net.minecraft.crafting.recipes;

import java.util.Comparator;
import net.minecraft.crafting.CraftingManager;
import net.minecraft.src.IRecipe;

public class RecipeSorter implements Comparator {
	final CraftingManager craftingManager;

	public RecipeSorter(CraftingManager par1CraftingManager) {
		craftingManager = par1CraftingManager;
	}

	public int compareRecipes(IRecipe par1IRecipe, IRecipe par2IRecipe) {
		if ((par1IRecipe instanceof ShapelessRecipes)
				&& (par2IRecipe instanceof ShapedRecipes)) {
			return 1;
		}

		if ((par2IRecipe instanceof ShapelessRecipes)
				&& (par1IRecipe instanceof ShapedRecipes)) {
			return -1;
		}

		if (par2IRecipe.getRecipeSize() < par1IRecipe.getRecipeSize()) {
			return -1;
		}

		return par2IRecipe.getRecipeSize() <= par1IRecipe.getRecipeSize() ? 0
				: 1;
	}

        @Override
	public int compare(Object par1Obj, Object par2Obj) {
		return compareRecipes((IRecipe) par1Obj, (IRecipe) par2Obj);
	}
}
