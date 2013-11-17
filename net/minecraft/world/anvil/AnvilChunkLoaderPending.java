package net.minecraft.world.anvil;

import net.minecraft.world.chunk.ChunkCoordIntPair;
import net.minecraft.NBT.NBTTagCompound;

class AnvilChunkLoaderPending {
	public final ChunkCoordIntPair field_48427_a;
	public final NBTTagCompound field_48426_b;

	public AnvilChunkLoaderPending(ChunkCoordIntPair par1ChunkCoordIntPair,
			NBTTagCompound par2NBTTagCompound) {
		field_48427_a = par1ChunkCoordIntPair;
		field_48426_b = par2NBTTagCompound;
	}
}
