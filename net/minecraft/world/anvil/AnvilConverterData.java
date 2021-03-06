package net.minecraft.world.anvil;

import net.minecraft.NBT.NBTTagList;
import net.minecraft.src.NibbleArrayReader;

public class AnvilConverterData {
	public long lastUpdated;
	public boolean terrainPopulated;
	public byte heightmap[];
	public NibbleArrayReader blockLight;
	public NibbleArrayReader skyLight;
	public NibbleArrayReader data;
	public byte blocks[];
	public NBTTagList entities;
	public NBTTagList tileEntities;
	public NBTTagList tileTicks;
	public final int x;
	public final int z;

	public AnvilConverterData(int par1, int par2) {
		x = par1;
		z = par2;
	}
}
