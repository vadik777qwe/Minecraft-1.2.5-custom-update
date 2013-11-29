package net.minecraft.render;

import net.minecraft.world.World;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import java.util.*;

import net.minecraft.block.Block;
import net.minecraft.src.GameSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemRenderer;
import net.minecraft.src.MathHelper;
import net.minecraft.entity.models.ModelBiped;
import net.minecraft.entity.models.ModelChicken;
import net.minecraft.entity.models.ModelCow;
import net.minecraft.entity.models.ModelOcelot;
import net.minecraft.entity.models.ModelPig;
import net.minecraft.entity.models.ModelSheep1;
import net.minecraft.entity.models.ModelSheep2;
import net.minecraft.entity.models.ModelSkeleton;
import net.minecraft.entity.models.ModelSlime;
import net.minecraft.entity.models.ModelSquid;
import net.minecraft.entity.models.ModelWolf;
import net.minecraft.entity.models.ModelZombie;
import net.minecraft.src.OpenGlHelper;

import org.lwjgl.opengl.GL11;

public class RenderManager {
	/** A map of entity classes and the associated renderer. */
	private Map entityRenderMap;

	/** The static instance of RenderManager. */
	public static RenderManager instance = new RenderManager();

	/** Renders fonts */
	private FontRenderer fontRenderer;
	public static double renderPosX;
	public static double renderPosY;
	public static double renderPosZ;
	public RenderEngine renderEngine;
	public ItemRenderer itemRenderer;

	/** Reference to the World object. */
	public World worldObj;

	/** Rendermanager's variable for the player */
	public EntityLiving livingPlayer;
	public float playerViewY;
	public float playerViewX;

	/** Reference to the GameSettings object. */
	public GameSettings options;
	public double field_1222_l;
	public double field_1221_m;
	public double field_1220_n;

	private RenderManager() {
		entityRenderMap = new HashMap();
		entityRenderMap.put(net.minecraft.entity.EntitySpider.class,
				new RenderSpider());
		entityRenderMap.put(net.minecraft.entity.EntityCaveSpider.class,
				new RenderSpider());
		entityRenderMap.put(net.minecraft.entity.EntityPig.class, new RenderPig(
				new ModelPig(), new ModelPig(0.5F), 0.7F));
		entityRenderMap.put(net.minecraft.entity.EntitySheep.class,
				new RenderSheep(new ModelSheep2(), new ModelSheep1(), 0.7F));
		entityRenderMap.put(net.minecraft.entity.EntityCow.class, new RenderCow(
				new ModelCow(), 0.7F));
		entityRenderMap.put(net.minecraft.entity.EntityMooshroom.class,
				new RenderMooshroom(new ModelCow(), 0.7F));
		entityRenderMap.put(net.minecraft.entity.EntityWolf.class, new RenderWolf(
				new ModelWolf(), 0.5F));
		entityRenderMap.put(net.minecraft.entity.EntityChicken.class,
				new RenderChicken(new ModelChicken(), 0.3F));
		entityRenderMap.put(net.minecraft.entity.EntityOcelot.class,
				new RenderOcelot(new ModelOcelot(), 0.4F));
		entityRenderMap.put(net.minecraft.entity.EntitySilverfish.class,
				new RenderSilverfish());
		entityRenderMap.put(net.minecraft.entity.EntityCreeper.class,
				new RenderCreeper());
		entityRenderMap.put(net.minecraft.entity.EntityEnderman.class,
				new RenderEnderman());
		entityRenderMap.put(net.minecraft.entity.EntitySnowman.class,
				new RenderSnowMan());
		entityRenderMap.put(net.minecraft.entity.EntitySkeleton.class,
				new RenderBiped(new ModelSkeleton(), 0.5F));
		entityRenderMap.put(net.minecraft.entity.EntityBlaze.class,
				new RenderBlaze());
		entityRenderMap.put(net.minecraft.entity.EntityZombie.class,
				new RenderBiped(new ModelZombie(), 0.5F));
		entityRenderMap.put(net.minecraft.entity.EntitySlime.class,
				new RenderSlime(new ModelSlime(16), new ModelSlime(0), 0.25F));
		entityRenderMap.put(net.minecraft.entity.EntityMagmaCube.class,
				new RenderMagmaCube());
		entityRenderMap.put(net.minecraft.entity.EntityPlayer.class,
				new RenderPlayer());
		entityRenderMap.put(net.minecraft.entity.EntityGiantZombie.class,
				new RenderGiantZombie(new ModelZombie(), 0.5F, 6F));
		entityRenderMap.put(net.minecraft.entity.EntityGhast.class,
				new RenderGhast());
		entityRenderMap.put(net.minecraft.entity.EntitySquid.class,
				new RenderSquid(new ModelSquid(), 0.7F));
		entityRenderMap.put(net.minecraft.entity.EntityVillager.class,
				new RenderVillager());
		entityRenderMap.put(net.minecraft.entity.EntityIronGolem.class,
				new RenderIronGolem());
		entityRenderMap.put(net.minecraft.entity.EntityLiving.class,
				new RenderLiving(new ModelBiped(), 0.5F));
		entityRenderMap.put(net.minecraft.entity.EntityDragon.class,
				new RenderDragon());
		entityRenderMap.put(net.minecraft.entity.EntityEnderCrystal.class,
				new RenderEnderCrystal());
		entityRenderMap.put(net.minecraft.entity.Entity.class, new RenderEntity());
		entityRenderMap.put(net.minecraft.entity.EntityPainting.class,
				new RenderPainting());
		entityRenderMap.put(net.minecraft.entity.EntityArrow.class,
				new RenderArrow());
		entityRenderMap.put(net.minecraft.entity.EntitySnowball.class,
				new RenderSnowball(Item.snowball.getIconFromDamage(0)));
		entityRenderMap.put(net.minecraft.entity.EntityEnderPearl.class,
				new RenderSnowball(Item.enderPearl.getIconFromDamage(0)));
		entityRenderMap.put(net.minecraft.entity.EntityEnderEye.class,
				new RenderSnowball(Item.eyeOfEnder.getIconFromDamage(0)));
		entityRenderMap.put(net.minecraft.entity.EntityEgg.class,
				new RenderSnowball(Item.egg.getIconFromDamage(0)));
		entityRenderMap.put(net.minecraft.entity.EntityPotion.class,
				new RenderSnowball(154));
		/*entityRenderMap.put(net.minecraft.entity.EntityExpBottle.class,
				new RenderSnowball(Item.expBottle.getIconFromDamage(0)));*/
		entityRenderMap.put(net.minecraft.entity.EntityFireball.class,
				new RenderFireball(2.0F));
		entityRenderMap.put(net.minecraft.entity.EntitySmallFireball.class,
				new RenderFireball(0.5F));
		entityRenderMap.put(net.minecraft.entity.EntityItem.class,
				new RenderItem());
		entityRenderMap.put(net.minecraft.entity.EntityXPOrb.class,
				new RenderXPOrb());
		entityRenderMap.put(net.minecraft.entity.EntityTNTPrimed.class,
				new RenderTNTPrimed());
		entityRenderMap.put(net.minecraft.entity.EntityFallingSand.class,
				new RenderFallingSand());
		entityRenderMap.put(net.minecraft.entity.EntityMinecart.class,
				new RenderMinecart());
		entityRenderMap.put(net.minecraft.entity.EntityBoat.class,
				new RenderBoat());
		entityRenderMap.put(net.minecraft.entity.EntityFishHook.class,
				new RenderFish());
		entityRenderMap.put(net.minecraft.entity.EntityLightningBolt.class,
				new RenderLightningBolt());
		Render render;

		for (Iterator iterator = entityRenderMap.values().iterator(); iterator
				.hasNext(); render.setRenderManager(this)) {
			render = (Render) iterator.next();
		}
	}

	public Render getEntityClassRenderObject(Class par1Class) {
		Render render = (Render) entityRenderMap.get(par1Class);

		if (render == null && par1Class != (net.minecraft.entity.Entity.class)) {
			render = getEntityClassRenderObject(par1Class.getSuperclass());
			entityRenderMap.put(par1Class, render);
		}

		return render;
	}

	public Render getEntityRenderObject(Entity par1Entity) {
		return getEntityClassRenderObject(par1Entity.getClass());
	}

	/**
	 * Caches the current frame's active render info, including the current
	 * World, RenderEngine, GameSettings and FontRenderer settings, as well as
	 * interpolated player position, pitch and yaw.
	 */
	public void cacheActiveRenderInfo(World par1World,
			RenderEngine par2RenderEngine, FontRenderer par3FontRenderer,
			EntityLiving par4EntityLiving, GameSettings par5GameSettings,
			float par6) {
		worldObj = par1World;
		renderEngine = par2RenderEngine;
		options = par5GameSettings;
		livingPlayer = par4EntityLiving;
		fontRenderer = par3FontRenderer;

		if (par4EntityLiving.isPlayerSleeping()) {
			int i = par1World.getBlockId(
					MathHelper.floor_double(par4EntityLiving.posX),
					MathHelper.floor_double(par4EntityLiving.posY),
					MathHelper.floor_double(par4EntityLiving.posZ));

			if (i == Block.bed.blockID) {
				int j = par1World.getBlockMetadata(
						MathHelper.floor_double(par4EntityLiving.posX),
						MathHelper.floor_double(par4EntityLiving.posY),
						MathHelper.floor_double(par4EntityLiving.posZ));
				int k = j & 3;
				playerViewY = k * 90 + 180;
				playerViewX = 0.0F;
			}
		} else {
			playerViewY = par4EntityLiving.prevRotationYaw
					+ (par4EntityLiving.rotationYaw - par4EntityLiving.prevRotationYaw)
					* par6;
			playerViewX = par4EntityLiving.prevRotationPitch
					+ (par4EntityLiving.rotationPitch - par4EntityLiving.prevRotationPitch)
					* par6;
		}

		if (par5GameSettings.thirdPersonView == 2) {
			playerViewY += 180F;
		}

		field_1222_l = par4EntityLiving.lastTickPosX
				+ (par4EntityLiving.posX - par4EntityLiving.lastTickPosX)
				* (double) par6;
		field_1221_m = par4EntityLiving.lastTickPosY
				+ (par4EntityLiving.posY - par4EntityLiving.lastTickPosY)
				* (double) par6;
		field_1220_n = par4EntityLiving.lastTickPosZ
				+ (par4EntityLiving.posZ - par4EntityLiving.lastTickPosZ)
				* (double) par6;
	}

	/**
	 * Will render the specified entity at the specified partial tick time.
	 * Args: entity, partialTickTime
	 */
	public void renderEntity(Entity par1Entity, float par2) {
		double d = par1Entity.lastTickPosX
				+ (par1Entity.posX - par1Entity.lastTickPosX) * (double) par2;
		double d1 = par1Entity.lastTickPosY
				+ (par1Entity.posY - par1Entity.lastTickPosY) * (double) par2;
		double d2 = par1Entity.lastTickPosZ
				+ (par1Entity.posZ - par1Entity.lastTickPosZ) * (double) par2;
		float f = par1Entity.prevRotationYaw
				+ (par1Entity.rotationYaw - par1Entity.prevRotationYaw) * par2;
		int i = par1Entity.getBrightnessForRender(par2);

		if (par1Entity.isBurning()) {
			i = 0xf000f0;
		}

		int j = i % 0x10000;
		int k = i / 0x10000;
		OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit,
				(float) j / 1.0F, (float) k / 1.0F);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		renderEntityWithPosYaw(par1Entity, d - renderPosX, d1 - renderPosY, d2
				- renderPosZ, f, par2);
	}

	/**
	 * Renders the specified entity with the passed in position, yaw, and
	 * partialTickTime. Args: entity, x, y, z, yaw, partialTickTime
	 */
	public void renderEntityWithPosYaw(Entity par1Entity, double par2,
			double par4, double par6, float par8, float par9) {
		Render render = getEntityRenderObject(par1Entity);

		if (render != null) {
			render.doRender(par1Entity, par2, par4, par6, par8, par9);
			render.doRenderShadowAndFire(par1Entity, par2, par4, par6, par8,
					par9);
		}
	}

	/**
	 * World sets this RenderManager's worldObj to the world provided
	 */
	public void set(World par1World) {
		worldObj = par1World;
	}

	public double getDistanceToCamera(double par1, double par3, double par5) {
		double d = par1 - field_1222_l;
		double d1 = par3 - field_1221_m;
		double d2 = par5 - field_1220_n;
		return d * d + d1 * d1 + d2 * d2;
	}

	/**
	 * Returns the font renderer
	 */
	public FontRenderer getFontRenderer() {
		return fontRenderer;
	}
}
