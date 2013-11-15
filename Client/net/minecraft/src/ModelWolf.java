package net.minecraft.src;

import org.lwjgl.opengl.GL11;

public class ModelWolf extends ModelBase
{
    /** main box for the wolf head */
    public ModelRenderer wolfHeadMain;

    /** The wolf's body */
    public ModelRenderer wolfBody;

    /** Wolf'se first leg */
    public ModelRenderer wolfLeg1;

    /** Wolf's second leg */
    public ModelRenderer wolfLeg2;

    /** Wolf's third leg */
    public ModelRenderer wolfLeg3;

    /** Wolf's fourth leg */
    public ModelRenderer wolfLeg4;

    /** The wolf's tail */
    ModelRenderer wolfTail;
    ModelRenderer tails[];

    /** The wolf's mane */
    ModelRenderer wolfMane;
    private float progress;

    public ModelWolf()
    {
        float f = 0.0F;
        float f1 = 13.5F;
        wolfHeadMain = new ModelRenderer(this, 0, 0);
        wolfHeadMain.addBox(-3F, -3F, -2F, 6, 6, 4, f);
        wolfHeadMain.setRotationPoint(-1F, f1, -7F);
        wolfBody = new ModelRenderer(this, 18, 14);
        wolfBody.addBox(-4F, -2F, -3F, 6, 9, 6, f);
        wolfBody.setRotationPoint(0.0F, 14F, 2.0F);
        wolfMane = new ModelRenderer(this, 21, 0);
        wolfMane.addBox(-4F, -3F, -3F, 8, 6, 7, f);
        wolfMane.setRotationPoint(-1F, 14F, 2.0F);
        wolfLeg1 = new ModelRenderer(this, 0, 18);
        wolfLeg1.addBox(-1F, 0.0F, -1F, 2, 8, 2, f);
        wolfLeg1.setRotationPoint(-2.5F, 16F, 7F);
        wolfLeg2 = new ModelRenderer(this, 0, 18);
        wolfLeg2.addBox(-1F, 0.0F, -1F, 2, 8, 2, f);
        wolfLeg2.setRotationPoint(0.5F, 16F, 7F);
        wolfLeg3 = new ModelRenderer(this, 0, 18);
        wolfLeg3.addBox(-1F, 0.0F, -1F, 2, 8, 2, f);
        wolfLeg3.setRotationPoint(-2.5F, 16F, -4F);
        wolfLeg4 = new ModelRenderer(this, 0, 18);
        wolfLeg4.addBox(-1F, 0.0F, -1F, 2, 8, 2, f);
        wolfLeg4.setRotationPoint(0.5F, 16F, -4F);
        wolfTail = new ModelRenderer(this, 9, 18);
        wolfTail.addBox(-1F, 0.0F, -1F, 2, 1, 2, f);
        wolfTail.setRotationPoint(-1F, 12F, 8F);
        tails = new ModelRenderer[7];

        for (int i = 0; i < 7; i++)
        {
            tails[i] = new ModelRenderer(this, 9, Math.min(19 + i, 25));
            float f2 = 0.1F;

            if (i < 4)
            {
                f2 += (float)i * 0.1F;
            }
            else if (i < 6)
            {
                f2 = 0.5F;
            }
            else if (i < 7)
            {
                f2 = 0.4F;
            }
            else
            {
                f2 = 0.15F;
            }

            tails[i].addBox(-1F, 0.0F, -1F, 2, 1, 2, f + f2);
            tails[i].setRotationPoint(0.0F, 1.0F + f2, 0.0F);

            if (i == 0)
            {
                wolfTail.addChild(tails[i]);
            }
            else
            {
                tails[i - 1].addChild(tails[i]);
            }
        }

        wolfHeadMain.setTextureOffset(16, 14).addBox(-3F, -5F, 0.0F, 2, 2, 1, f);
        wolfHeadMain.setTextureOffset(16, 14).addBox(1.0F, -5F, 0.0F, 2, 2, 1, f);
        wolfHeadMain.setTextureOffset(0, 10).addBox(-1.5F, 0.0F, -5F, 3, 3, 4, f);
    }

    /**
     * Sets the models various rotation angles then renders the model.
     */
    public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
    {
        super.render(par1Entity, par2, par3, par4, par5, par6, par7);

        if (par1Entity != null && (par1Entity instanceof EntityLiving))
        {
            EntityLiving entityliving = (EntityLiving)par1Entity;
            progress = (float)entityliving.ticksExisted / 3.978873F;
        }

        setRotationAngles(par2, par3, par4, par5, par6, par7);
        GL11.glPushMatrix();
        EntityWolf entitywolf = (EntityWolf)par1Entity;

        if (entitywolf.isSitting() && !isChild)
        {
            GL11.glTranslatef(0.0F, 1.25F, 0.0F);
            GL11.glRotatef(wolfHeadMain.rotateAngleZ * 180F, 0.0F, 0.0F, 1.0F);
            GL11.glTranslatef(0.0F, -1.25F, 0.0F);
            float f = wolfHeadMain.rotateAngleZ;
            wolfLeg1.rotateAngleX += wolfHeadMain.rotateAngleZ * 1.5F;
            wolfLeg2.rotateAngleX += wolfHeadMain.rotateAngleZ * 1.5F;
            wolfLeg3.rotateAngleX += wolfHeadMain.rotateAngleZ * 1.5F;
            wolfLeg4.rotateAngleX += wolfHeadMain.rotateAngleZ * 1.5F;
            wolfLeg1.rotationPointY -= wolfHeadMain.rotateAngleZ * 1.75F;
            wolfLeg2.rotationPointY -= wolfHeadMain.rotateAngleZ * 1.75F;
            wolfLeg3.rotationPointY -= wolfHeadMain.rotateAngleZ * 1.75F;
            wolfLeg4.rotationPointY -= wolfHeadMain.rotateAngleZ * 1.75F;
            wolfHeadMain.rotateAngleZ = -wolfHeadMain.rotateAngleZ * 1.5F;
        }

        if (isChild)
        {
            float f1 = 2.0F;
            GL11.glPushMatrix();
            GL11.glTranslatef(0.0F, 5F * par7, 2.0F * par7);
            wolfHeadMain.renderWithRotation(par7);
            GL11.glPopMatrix();
            GL11.glPushMatrix();
            GL11.glScalef(1.0F / f1, 1.0F / f1, 1.0F / f1);
            GL11.glTranslatef(0.0F, 24F * par7, 0.0F);
            wolfBody.render(par7);
            wolfLeg1.render(par7);
            wolfLeg2.render(par7);
            wolfLeg3.render(par7);
            wolfLeg4.render(par7);
            wolfTail.render(par7);
            wolfMane.render(par7);
            GL11.glPopMatrix();
        }
        else
        {
            boolean flag = false;
            wolfHeadMain.renderWithRotation(par7);
            wolfBody.render(par7);
            wolfLeg1.render(par7);
            wolfLeg2.render(par7);
            wolfLeg3.render(par7);
            wolfLeg4.render(par7);
            wolfTail.render(par7);
            wolfMane.render(par7);
        }

        GL11.glPopMatrix();
    }

    /**
     * Used for easily adding entity-dependent animations. The second and third float params here are the same second
     * and third as in the setRotationAngles method.
     */
    public void setLivingAnimations(EntityLiving par1EntityLiving, float par2, float par3, float par4)
    {
        EntityWolf entitywolf = (EntityWolf)par1EntityLiving;

        if (entitywolf.isSitting())
        {
            wolfMane.setRotationPoint(-1F, 17.5F, -3F);
            wolfMane.rotateAngleX = ((float)Math.PI / 2F);
            wolfMane.rotateAngleY = 0.0F;
            wolfBody.setRotationPoint(0.0F, 17.5F, 0.0F);
            wolfBody.rotateAngleX = 1.370796F;
            wolfTail.setRotationPoint(-1F, 19F, 6F);
            wolfLeg1.setRotationPoint(-2.5F, 22F, 5.25F);
            wolfLeg1.rotateAngleX = ((float)Math.PI * 3F / 2F);
            wolfLeg1.rotateAngleY = 0.4F;
            wolfLeg2.setRotationPoint(0.5F, 22F, 5.25F);
            wolfLeg2.rotateAngleX = ((float)Math.PI * 3F / 2F);
            wolfLeg2.rotateAngleY = -0.4F;
            wolfLeg3.rotateAngleX = 4.812389F;
            wolfLeg3.setRotationPoint(-2.49F, 21.5F, -2F);
            wolfLeg3.rotateAngleY = 0.15F;
            wolfLeg4.rotateAngleX = 4.812389F;
            wolfLeg4.setRotationPoint(0.51F, 21.5F, -2F);
            wolfLeg4.rotateAngleY = -0.15F;
            wolfHeadMain.rotationPointY = 17F;
        }
        else
        {
            wolfBody.setRotationPoint(0.0F, 14F, 2.0F);
            wolfBody.rotateAngleX = ((float)Math.PI / 2F);
            wolfMane.setRotationPoint(-1F, 14F, -3F);
            wolfMane.rotateAngleX = wolfBody.rotateAngleX;
            wolfTail.setRotationPoint(-1F, 12F, 8F);
            wolfLeg1.setRotationPoint(-2.5F, 16F, 7F);
            wolfLeg2.setRotationPoint(0.5F, 16F, 7F);
            wolfLeg3.setRotationPoint(-2.5F, 16F, -4F);
            wolfLeg4.setRotationPoint(0.5F, 16F, -4F);
            wolfLeg1.rotateAngleX = MathHelper.cos(par2 * 0.6662F) * 1.4F * par3;
            wolfLeg2.rotateAngleX = MathHelper.cos(par2 * 0.6662F + (float)Math.PI) * 1.4F * par3;
            wolfLeg3.rotateAngleX = MathHelper.cos(par2 * 0.6662F + (float)Math.PI) * 1.4F * par3;
            wolfLeg4.rotateAngleX = MathHelper.cos(par2 * 0.6662F) * 1.4F * par3;
            wolfHeadMain.rotationPointY = 13.5F;
            wolfLeg1.rotateAngleY = wolfLeg2.rotateAngleY = wolfLeg3.rotateAngleY = wolfLeg4.rotateAngleY = 0.0F;
        }

        wolfHeadMain.rotateAngleZ = entitywolf.getInterestedAngle(par4) + entitywolf.getShakeAngle(par4, 0.0F);
        wolfMane.rotateAngleZ = entitywolf.getShakeAngle(par4, -0.08F);
        wolfBody.rotateAngleZ = entitywolf.getShakeAngle(par4, -0.16F);
        wolfTail.rotateAngleZ = entitywolf.getShakeAngle(par4, -0.2F);

        if (entitywolf.getWolfShaking())
        {
            float f = entitywolf.getBrightness(par4) * entitywolf.getShadingWhileShaking(par4);
            GL11.glColor3f(f, f, f);
        }

        float f1 = (0.5F + Math.max(par3, entitywolf.getInterestedAngle(par4) * 1.5F)) * 0.25F;
        float f2 = par2 * 0.6662F + progress * 0.6662F;

        if (!entitywolf.isTamed())
        {
            wolfTail.rotateAngleY = 0.0F;
            wolfTail.rotateAngleX += MathHelper.sin(f2) * f1;

            for (int i = 0; i < tails.length; i++)
            {
                tails[i].rotateAngleZ = 0.0F;
                tails[i].rotateAngleX = MathHelper.sin(f2 - (float)(i + 1) * 0.75F) * f1;
            }
        }
        else
        {
            wolfTail.rotateAngleY = MathHelper.sin(f2) * f1;

            for (int j = 0; j < tails.length; j++)
            {
                tails[j].rotateAngleX = 0.0F;
                tails[j].rotateAngleZ = MathHelper.sin(f2 - (float)(j + 1) * 0.75F) * f1;
            }
        }
    }

    /**
     * Sets the models various rotation angles.
     */
    public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6)
    {
        super.setRotationAngles(par1, par2, par3, par4, par5, par6);
        wolfHeadMain.rotateAngleX = par5 / (180F / (float)Math.PI);
        wolfHeadMain.rotateAngleY = par4 / (180F / (float)Math.PI);
        wolfTail.rotateAngleX = par3;
    }
}
