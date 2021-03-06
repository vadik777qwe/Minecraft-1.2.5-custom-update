package net.minecraft.components;

import java.util.ArrayList;
import java.util.Random;
import net.minecraft.world.chunk.ChunkPosition;
import net.minecraft.structures.StructureStrongholdPieceWeight;

public class ComponentStrongholdStairs2 extends ComponentStrongholdStairs {
	public StructureStrongholdPieceWeight field_35038_a;
	public ComponentStrongholdPortalRoom portalRoom;
	public ArrayList field_35037_b;

	public ComponentStrongholdStairs2(int par1, Random par2Random, int par3,
			int par4) {
		super(0, par2Random, par3, par4);
		field_35037_b = new ArrayList();
	}

        @Override
	public ChunkPosition getCenter() {
		if (portalRoom != null) {
			return portalRoom.getCenter();
		} else {
			return super.getCenter();
		}
	}
}
