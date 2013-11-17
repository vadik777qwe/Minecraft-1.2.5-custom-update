package net.minecraft.world.map;

import net.minecraft.structures.StructureStart;
import net.minecraft.structures.StructureNetherBridgeStart;
import java.util.*;
import net.minecraft.src.SpawnListEntry;

public class MapGenNetherBridge extends MapGenStructure {
	private List spawnList;

	public MapGenNetherBridge() {
		spawnList = new ArrayList();
		spawnList.add(new SpawnListEntry(net.minecraft.entity.EntityBlaze.class,
				10, 2, 3));
		spawnList.add(new SpawnListEntry(
				net.minecraft.entity.EntityPigZombie.class, 10, 4, 4));
		spawnList.add(new SpawnListEntry(
				net.minecraft.entity.EntityMagmaCube.class, 3, 4, 4));
	}

	public List getSpawnList() {
		return spawnList;
	}

        @Override
	protected boolean canSpawnStructureAtCoords(int par1, int par2) {
		int i = par1 >> 4;
		int j = par2 >> 4;
		rand.setSeed((long) (i ^ j << 4) ^ worldObj.getSeed());
		rand.nextInt();

		if (rand.nextInt(3) != 0) {
			return false;
		}

		if (par1 != (i << 4) + 4 + rand.nextInt(8)) {
			return false;
		}

		return par2 == (j << 4) + 4 + rand.nextInt(8);
	}

        @Override
	protected StructureStart getStructureStart(int par1, int par2) {
		return new StructureNetherBridgeStart(worldObj, rand, par1, par2);
	}
}
