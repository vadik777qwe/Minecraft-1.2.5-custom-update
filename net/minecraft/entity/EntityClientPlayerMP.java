package net.minecraft.entity;

import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.packet.packets.Packet101CloseWindow;
import net.minecraft.packet.packets.Packet10Flying;
import net.minecraft.packet.packets.Packet11PlayerPosition;
import net.minecraft.packet.packets.Packet12PlayerLook;
import net.minecraft.packet.packets.Packet13PlayerLookMove;
import net.minecraft.packet.packets.Packet14BlockDig;
import net.minecraft.packet.packets.Packet18Animation;
import net.minecraft.packet.packets.Packet19EntityAction;
import net.minecraft.packet.packets.Packet202PlayerAbilities;
import net.minecraft.packet.packets.Packet3Chat;
import net.minecraft.packet.packets.Packet9Respawn;
import net.minecraft.src.DamageSource;
import net.minecraft.src.MathHelper;
import net.minecraft.network.NetClientHandler;
import net.minecraft.src.Session;
import net.minecraft.stats.StatBase;
import net.minecraft.world.World;

public class EntityClientPlayerMP extends EntityPlayerSP {
	public NetClientHandler sendQueue;

	/**
	 * Tick counter that resets every 20 ticks, used for sending inventory
	 * updates
	 */
	private int inventoryUpdateTickCounter;
	private double oldPosX;

	/** Old Minimum Y of the bounding box */
	private double oldMinY;
	private double oldPosY;
	private double oldPosZ;
	private float oldRotationYaw;
	private float oldRotationPitch;

	/** Check if was on ground last update */
	private boolean wasOnGround;

	/** should the player stop sneaking? */
	private boolean shouldStopSneaking;
	private boolean wasSneaking;

	/** The time since the client player moved */
	private int timeSinceMoved;

	/** has the client player's health been set? */
	private boolean hasSetHealth;

	public EntityClientPlayerMP(Minecraft par1Minecraft, World par2World,
			Session par3Session, NetClientHandler par4NetClientHandler) {
		super(par1Minecraft, par2World, par3Session, 0);
		inventoryUpdateTickCounter = 0;
		wasOnGround = false;
		shouldStopSneaking = false;
		wasSneaking = false;
		timeSinceMoved = 0;
		hasSetHealth = false;
		sendQueue = par4NetClientHandler;
	}

	/**
	 * Called when the entity is attacked.
	 */
        @Override
	public boolean attackEntityFrom(DamageSource par1DamageSource, int par2) {
		return false;
	}

	/**
	 * Heal living entity (param: amount of half-hearts)
	 */
        @Override
	public void heal(int i) {
	}

	/**
	 * Called to update the entity's position/logic.
	 */
        @Override
	public void onUpdate() {
		if (!worldObj.blockExists(MathHelper.floor_double(posX), 0,
				MathHelper.floor_double(posZ))) {
			return;
		} else {
			super.onUpdate();
			sendMotionUpdates();
			return;
		}
	}

	/**
	 * Send updated motion and position information to the server
	 */
	public void sendMotionUpdates() {
		if (inventoryUpdateTickCounter++ == 20) {
			inventoryUpdateTickCounter = 0;
		}

		boolean flag = isSprinting();

		if (flag != wasSneaking) {
			if (flag) {
				sendQueue.addToSendQueue(new Packet19EntityAction(this, 4));
			} else {
				sendQueue.addToSendQueue(new Packet19EntityAction(this, 5));
			}

			wasSneaking = flag;
		}

		boolean flag1 = isSneaking();

		if (flag1 != shouldStopSneaking) {
			if (flag1) {
				sendQueue.addToSendQueue(new Packet19EntityAction(this, 1));
			} else {
				sendQueue.addToSendQueue(new Packet19EntityAction(this, 2));
			}

			shouldStopSneaking = flag1;
		}

		double d = posX - oldPosX;
		double d1 = boundingBox.minY - oldMinY;
		double d2 = posY - oldPosY;
		double d3 = posZ - oldPosZ;
		double d4 = rotationYaw - oldRotationYaw;
		double d5 = rotationPitch - oldRotationPitch;
		boolean flag2 = d1 != 0.0D || d2 != 0.0D || d != 0.0D || d3 != 0.0D;
		boolean flag3 = d4 != 0.0D || d5 != 0.0D;

		if (ridingEntity != null) {
			if (flag3) {
				sendQueue.addToSendQueue(new Packet11PlayerPosition(motionX,
						-999D, -999D, motionZ, onGround));
			} else {
				sendQueue.addToSendQueue(new Packet13PlayerLookMove(motionX,
						-999D, -999D, motionZ, rotationYaw, rotationPitch,
						onGround));
			}

			flag2 = false;
		} else if (flag2 && flag3) {
			sendQueue.addToSendQueue(new Packet13PlayerLookMove(posX,
					boundingBox.minY, posY, posZ, rotationYaw, rotationPitch,
					onGround));
			timeSinceMoved = 0;
		} else if (flag2) {
			sendQueue.addToSendQueue(new Packet11PlayerPosition(posX,
					boundingBox.minY, posY, posZ, onGround));
			timeSinceMoved = 0;
		} else if (flag3) {
			sendQueue.addToSendQueue(new Packet12PlayerLook(rotationYaw,
					rotationPitch, onGround));
			timeSinceMoved = 0;
		} else {
			sendQueue.addToSendQueue(new Packet10Flying(onGround));

			if (wasOnGround != onGround || timeSinceMoved > 200) {
				timeSinceMoved = 0;
			} else {
				timeSinceMoved++;
			}
		}

		wasOnGround = onGround;

		if (flag2) {
			oldPosX = posX;
			oldMinY = boundingBox.minY;
			oldPosY = posY;
			oldPosZ = posZ;
		}

		if (flag3) {
			oldRotationYaw = rotationYaw;
			oldRotationPitch = rotationPitch;
		}
	}

	/**
	 * Called when player presses the drop item key
	 */
        @Override
	public EntityItem dropOneItem() {
		sendQueue.addToSendQueue(new Packet14BlockDig(4, 0, 0, 0, 0));
		return null;
	}

	/**
	 * Joins the passed in entity item with the world. Args: entityItem
	 */
        @Override
	protected void joinEntityItemWithWorld(EntityItem entityitem) {
	}

	/**
	 * Sends a chat message from the player. Args: chatMessage
	 */
        @Override
	public void sendChatMessage(String par1Str) {
		if (mc.ingameGUI.func_50013_c().size() == 0
				|| !((String) mc.ingameGUI.func_50013_c().get(
						mc.ingameGUI.func_50013_c().size() - 1))
						.equals(par1Str)) {
			mc.ingameGUI.func_50013_c().add(par1Str);
		}

		sendQueue.addToSendQueue(new Packet3Chat(par1Str));
	}

	/**
	 * Swings the item the player is holding.
	 */
        @Override
	public void swingItem() {
		super.swingItem();
		sendQueue.addToSendQueue(new Packet18Animation(this, 1));
	}

        @Override
	public void respawnPlayer() {
		sendQueue.addToSendQueue(new Packet9Respawn(dimension,
				(byte) worldObj.difficultySetting, worldObj.getWorldInfo()
						.getTerrainType(), worldObj.getHeight(), 0));
	}

	/**
	 * Deals damage to the entity. If its a EntityPlayer then will take damage
	 * from the armor first and then health second with the reduced value. Args:
	 * damageAmount
	 */
        @Override
	protected void damageEntity(DamageSource par1DamageSource, int par2) {
		setEntityHealth(getHealth() - par2);
	}

	/**
	 * sets current screen to null (used on escape buttons of GUIs)
	 */
        @Override
	public void closeScreen() {
		sendQueue.addToSendQueue(new Packet101CloseWindow(
				craftingInventory.windowId));
		inventory.setItemStack(null);
		super.closeScreen();
	}

	/**
	 * Updates health locally.
	 */
        @Override
	public void setHealth(int par1) {
		if (hasSetHealth) {
			super.setHealth(par1);
		} else {
			setEntityHealth(par1);
			hasSetHealth = true;
		}
	}

	/**
	 * Adds a value to a statistic field.
	 */
        @Override
	public void addStat(StatBase par1StatBase, int par2) {
		if (par1StatBase == null) {
			return;
		}

		if (par1StatBase.isIndependent) {
			super.addStat(par1StatBase, par2);
		}
	}

	/**
	 * Used by NetClientHandler.handleStatistic
	 */
	public void incrementStat(StatBase par1StatBase, int par2) {
		if (par1StatBase == null) {
			return;
		}

		if (!par1StatBase.isIndependent) {
			super.addStat(par1StatBase, par2);
		}
	}

        @Override
	public void func_50009_aI() {
		sendQueue.addToSendQueue(new Packet202PlayerAbilities(capabilities));
	}
}
