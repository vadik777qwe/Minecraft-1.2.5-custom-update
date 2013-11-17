package net.minecraft.packet.packets;

import java.io.*;

import net.minecraft.packet.Packet;
import net.minecraft.network.NetHandler;

public class Packet101CloseWindow extends Packet {
	public int windowId;

	public Packet101CloseWindow() {
	}

	public Packet101CloseWindow(int par1) {
		windowId = par1;
	}

	/**
	 * Passes this Packet on to the NetHandler for processing.
	 */
	public void processPacket(NetHandler par1NetHandler) {
		par1NetHandler.handleCloseWindow(this);
	}

	/**
	 * Abstract. Reads the raw packet data from the data stream.
	 */
	public void readPacketData(DataInputStream par1DataInputStream)
			throws IOException {
		windowId = par1DataInputStream.readByte();
	}

	/**
	 * Abstract. Writes the raw packet data to the data stream.
	 */
	public void writePacketData(DataOutputStream par1DataOutputStream)
			throws IOException {
		par1DataOutputStream.writeByte(windowId);
	}

	/**
	 * Abstract. Return the size of the packet (not counting the header).
	 */
	public int getPacketSize() {
		return 1;
	}
}
