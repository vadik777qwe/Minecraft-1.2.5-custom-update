package net.minecraft.src;

import net.minecraft.block.Block;

import org.lwjgl.opengl.GL11;

public class RenderTNTPrimed extends Render {
	private RenderBlocks blockRenderer;

	public RenderTNTPrimed() {
		blockRenderer = new RenderBlocks();
		shadowSize = 0.5F;
	}

	public void func_153_a(EntityTNTPrimed par1EntityTNTPrimed, double par2,
			double par4, double par6, float par8, float par9) {
		GL11.glPushMatrix();
		GL11.glTranslatef((float) par2, (float) par4, (float) par6);

		if (((float) par1EntityTNTPrimed.fuse - par9) + 1.0F < 10F) {
			float f = 1.0F - (((float) par1EntityTNTPrimed.fuse - par9) + 1.0F) / 10F;

			if (f < 0.0F) {
				f = 0.0F;
			}

			if (f > 1.0F) {
				f = 1.0F;
			}

			f *= f;
			f *= f;
			float f2 = 1.0F + f * 0.3F;
			GL11.glScalef(f2, f2, f2);
		}

		float f1 = (1.0F - (((float) par1EntityTNTPrimed.fuse - par9) + 1.0F) / 100F) * 0.8F;
		loadTexture("/terrain.png");
		blockRenderer.renderBlockAsItem(Block.tnt, 0,
				par1EntityTNTPrimed.getBrightness(par9));

		if ((par1EntityTNTPrimed.fuse / 5) % 2 == 0) {
			GL11.glDisable(GL11.GL_TEXTURE_2D);
			GL11.glDisable(GL11.GL_LIGHTING);
			GL11.glEnable(GL11.GL_BLEND);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_DST_ALPHA);
			GL11.glColor4f(1.0F, 1.0F, 1.0F, f1);
			blockRenderer.renderBlockAsItem(Block.tnt, 0, 1.0F);
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			GL11.glDisable(GL11.GL_BLEND);
			GL11.glEnable(GL11.GL_LIGHTING);
			GL11.glEnable(GL11.GL_TEXTURE_2D);
		}

		GL11.glPopMatrix();
	}

	/**
	 * Actually renders the given argument. This is a synthetic bridge method,
	 * always casting down its argument and then handing it off to a worker
	 * function which does the actual work. In all probabilty, the class Render
	 * is generic (Render<T extends Entity) and this method has signature public
	 * void doRender(T entity, double d, double d1, double d2, float f, float
	 * f1). But JAD is pre 1.5 so doesn't do that.
	 */
	public void doRender(Entity par1Entity, double par2, double par4,
			double par6, float par8, float par9) {
		func_153_a((EntityTNTPrimed) par1Entity, par2, par4, par6, par8, par9);
	}
}
