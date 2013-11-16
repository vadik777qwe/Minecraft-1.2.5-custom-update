package net.minecraft.src;

public class ModelEnderman extends ModelBiped {
	/** Is the enderman carrying a block? */
	public boolean isCarrying;

	/** Is the enderman attacking an entity? */
	public boolean isAttacking;
	public ModelRenderer rarms[];
	public ModelRenderer larms[];

	public ModelEnderman() {
		super(0.0F, -14F);
		isCarrying = false;
		isAttacking = false;
		float f = -14F;
		float f1 = 0.0F;
		bipedHeadwear = new ModelRenderer(this, 0, 16);
		bipedHeadwear.addBox(-4F, -8F, -4F, 8, 8, 8, f1 - 0.5F);
		bipedHeadwear.setRotationPoint(0.0F, 0.0F + f, 0.0F);
		bipedBody = new ModelRenderer(this, 32, 16);
		bipedBody.addBox(-4F, 0.0F, -2F, 8, 12, 4, f1);
		bipedBody.setRotationPoint(0.0F, 0.0F + f, 0.0F);
		bipedRightArm = new ModelRenderer(this, 56, 0);
		bipedRightArm.addBox(-1F, -1F, -1F, 2, 2, 2, f1);
		bipedRightArm.setRotationPoint(-3F, 1.0F + f, 0.0F);
		bipedLeftArm = new ModelRenderer(this, 56, 0);
		bipedLeftArm.mirror = true;
		bipedLeftArm.addBox(-1F, -1F, -1F, 2, 2, 2, f1);
		bipedLeftArm.setRotationPoint(5F, 1.0F + f, 0.0F);
		rarms = new ModelRenderer[14];
		larms = new ModelRenderer[14];

		for (int i = 0; i < 14; i++) {
			rarms[i] = new ModelRenderer(this, 56, 2 + i * 2);
			rarms[i].addBox(-1F, 0.0F, -1F, 2, 2, 2, f1);
			larms[i] = new ModelRenderer(this, 56, 2 + i * 2);
			larms[i].mirror = true;
			larms[i].addBox(-1F, 0.0F, -1F, 2, 2, 2, f1);

			if (i == 0) {
				rarms[i].setRotationPoint(0.0F, 1.0F, 0.0F);
				larms[i].setRotationPoint(0.0F, 1.0F, 0.0F);
				bipedRightArm.addChild(rarms[i]);
				bipedLeftArm.addChild(larms[i]);
			} else {
				rarms[i].setRotationPoint(0.0F, 2.0F, 0.0F);
				larms[i].setRotationPoint(0.0F, 2.0F, 0.0F);
				rarms[i - 1].addChild(rarms[i]);
				larms[i - 1].addChild(larms[i]);
			}
		}

		bipedRightLeg = new ModelRenderer(this, 56, 0);
		bipedRightLeg.addBox(-1F, 0.0F, -1F, 2, 30, 2, f1);
		bipedRightLeg.setRotationPoint(-2F, 12F + f, 0.0F);
		bipedLeftLeg = new ModelRenderer(this, 56, 0);
		bipedLeftLeg.mirror = true;
		bipedLeftLeg.addBox(-1F, 0.0F, -1F, 2, 30, 2, f1);
		bipedLeftLeg.setRotationPoint(2.0F, 12F + f, 0.0F);
	}

	/**
	 * Sets the models various rotation angles.
	 */
	public void setRotationAngles(float par1, float par2, float par3,
			float par4, float par5, float par6) {
		super.setRotationAngles(par1, par2, par3, par4, par5, par6);
		bipedHead.showModel = true;
		float f = -14F;
		bipedBody.rotateAngleX = 0.0F;
		bipedBody.rotationPointY = f;
		bipedBody.rotationPointZ = -0F;
		bipedRightLeg.rotateAngleX -= 0.0F;
		bipedLeftLeg.rotateAngleX -= 0.0F;
		bipedRightArm.rotateAngleX = (float) ((double) bipedRightArm.rotateAngleX * 0.5D);
		bipedLeftArm.rotateAngleX = (float) ((double) bipedLeftArm.rotateAngleX * 0.5D);
		bipedRightLeg.rotateAngleX = (float) ((double) bipedRightLeg.rotateAngleX * 0.5D);
		bipedLeftLeg.rotateAngleX = (float) ((double) bipedLeftLeg.rotateAngleX * 0.5D);
		float f1 = 0.4F;

		if (bipedRightArm.rotateAngleX > f1) {
			bipedRightArm.rotateAngleX = f1;
		}

		if (bipedLeftArm.rotateAngleX > f1) {
			bipedLeftArm.rotateAngleX = f1;
		}

		if (bipedRightArm.rotateAngleX < -f1) {
			bipedRightArm.rotateAngleX = -f1;
		}

		if (bipedLeftArm.rotateAngleX < -f1) {
			bipedLeftArm.rotateAngleX = -f1;
		}

		if (bipedRightLeg.rotateAngleX > f1) {
			bipedRightLeg.rotateAngleX = f1;
		}

		if (bipedLeftLeg.rotateAngleX > f1) {
			bipedLeftLeg.rotateAngleX = f1;
		}

		if (bipedRightLeg.rotateAngleX < -f1) {
			bipedRightLeg.rotateAngleX = -f1;
		}

		if (bipedLeftLeg.rotateAngleX < -f1) {
			bipedLeftLeg.rotateAngleX = -f1;
		}

		if (isCarrying) {
			bipedRightArm.rotateAngleX = -0.5F;
			bipedLeftArm.rotateAngleX = -0.5F;
			bipedRightArm.rotateAngleZ = 0.05F;
			bipedLeftArm.rotateAngleZ = -0.05F;
		} else {
			bipedRightArm.rotateAngleZ = 0.0F;
			bipedLeftArm.rotateAngleZ = 0.0F;
		}

		bipedRightArm.rotationPointZ = 0.0F;
		bipedLeftArm.rotationPointZ = 0.0F;
		bipedRightLeg.rotationPointZ = 0.0F;
		bipedLeftLeg.rotationPointZ = 0.0F;
		bipedRightLeg.rotationPointY = 9F + f;
		bipedLeftLeg.rotationPointY = 9F + f;
		bipedHead.rotationPointZ = -0F;
		bipedHead.rotationPointY = f + 1.0F;
		bipedHeadwear.rotationPointX = bipedHead.rotationPointX;
		bipedHeadwear.rotationPointY = bipedHead.rotationPointY;
		bipedHeadwear.rotationPointZ = bipedHead.rotationPointZ;
		bipedHeadwear.rotateAngleX = bipedHead.rotateAngleX;
		bipedHeadwear.rotateAngleY = bipedHead.rotateAngleY;
		bipedHeadwear.rotateAngleZ = bipedHead.rotateAngleZ;

		if (isAttacking) {
			float f2 = 1.0F;
			bipedHead.rotationPointY -= f2 * 5F;
		}

		if (isAttacking && !isCarrying) {
			bipedRightArm.rotateAngleZ = 2.6F;
			bipedLeftArm.rotateAngleZ = -2.6F;
			bipedRightArm.rotateAngleX = 0.0F;
			bipedLeftArm.rotateAngleX = 0.0F;

			for (int i = 0; i < 14; i++) {
				rarms[i].rotateAngleZ = MathHelper.sin(par3 * 0.875F
						+ (float) i * 0.45F)
						* ((float) (i + 8) / 8F) * 0.1F;
				larms[i].rotateAngleZ = -rarms[i].rotateAngleZ;
			}
		} else {
			for (int j = 0; j < 14; j++) {
				rarms[j].rotateAngleZ = 0.0F;
				larms[j].rotateAngleZ = 0.0F;
			}
		}
	}
}