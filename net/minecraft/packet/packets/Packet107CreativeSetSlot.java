package net.minecraft.packet.packets;

import java.io.*;

import net.minecraft.packet.Packet;
import net.minecraft.item.ItemStack;
import net.minecraft.network.NetHandler;

public class Packet107CreativeSetSlot extends Packet {
	public int slot;
	public ItemStack itemStack;

	public Packet107CreativeSetSlot() {
	}

	public Packet107CreativeSetSlot(int par1, ItemStack par2ItemStack) {
		slot = par1;
		itemStack = par2ItemStack;
	}

	/**
	 * Passes this Packet on to the NetHandler for processing.
	 */
	public void processPacket(NetHandler par1NetHandler) {
		par1NetHandler.handleCreativeSetSlot(this);
	}

	/**
	 * Abstract. Reads the raw packet data from the data stream.
	 */
	public void readPacketData(DataInputStream par1DataInputStream)
			throws IOException {
		slot = par1DataInputStream.readShort();
		itemStack = readItemStack(par1DataInputStream);
	}

	/**
	 * Abstract. Writes the raw packet data to the data stream.
	 */
	public void writePacketData(DataOutputStream par1DataOutputStream)
			throws IOException {
		par1DataOutputStream.writeShort(slot);
		writeItemStack(itemStack, par1DataOutputStream);
	}

	/**
	 * Abstract. Return the size of the packet (not counting the header).
	 */
	public int getPacketSize() {
		return 8;
	}
}
