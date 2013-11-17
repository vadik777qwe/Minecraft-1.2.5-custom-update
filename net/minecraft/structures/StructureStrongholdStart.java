package net.minecraft.structures;

import net.minecraft.components.ComponentStrongholdStairs2;
import java.util.*;
import net.minecraft.world.World;

public class StructureStrongholdStart extends StructureStart {
	public StructureStrongholdStart(World par1World, Random par2Random,
			int par3, int par4) {
		StructureStrongholdPieces.prepareStructurePieces();
		ComponentStrongholdStairs2 componentstrongholdstairs2 = new ComponentStrongholdStairs2(
				0, par2Random, (par3 << 4) + 2, (par4 << 4) + 2);
		components.add(componentstrongholdstairs2);
		componentstrongholdstairs2.buildComponent(componentstrongholdstairs2,
				components, par2Random);
		StructureComponent structurecomponent;

		for (ArrayList arraylist = componentstrongholdstairs2.field_35037_b; !arraylist
				.isEmpty(); structurecomponent.buildComponent(
				componentstrongholdstairs2, components, par2Random)) {
			int i = par2Random.nextInt(arraylist.size());
			structurecomponent = (StructureComponent) arraylist.remove(i);
		}

		updateBoundingBox();
		markAvailableHeight(par1World, par2Random, 10);
	}
}
