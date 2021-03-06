package net.minecraft.render;

import net.minecraft.entity.EntityGiantZombie;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.models.ModelBase;
import org.lwjgl.opengl.GL11;

public class RenderGiantZombie extends RenderLiving {
	/** Scale of the model to use */
	private float scale;

	public RenderGiantZombie(ModelBase par1ModelBase, float par2, float par3) {
		super(par1ModelBase, par2 * par3);
		scale = par3;
	}

	/**
	 * Applies the scale to the transform matrix
	 */
	protected void preRenderScale(EntityGiantZombie par1EntityGiantZombie,
			float par2) {
		GL11.glScalef(scale, scale, scale);
	}

	/**
	 * Allows the render to do any OpenGL state modifications necessary before
	 * the model is rendered. Args: entityLiving, partialTickTime
	 */
	protected void preRenderCallback(EntityLiving par1EntityLiving, float par2) {
		preRenderScale((EntityGiantZombie) par1EntityLiving, par2);
	}
}
