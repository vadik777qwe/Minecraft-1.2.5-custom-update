package net.minecraft.entity;

import net.minecraft.item.potion.Potion;
import net.minecraft.item.potion.PotionEffect;
import net.minecraft.world.World;

public class EntityCaveSpider extends EntitySpider {
	public EntityCaveSpider(World par1World) {
		super(par1World);
		texture = "/mob/cavespider.png";
		setSize(0.7F, 0.5F);
	}

        @Override
	public int getMaxHealth() {
		return 12;
	}

	/**
	 * How large the spider should be scaled.
	 */
        @Override
	public float spiderScaleAmount() {
		return 0.7F;
	}

        @Override
	public boolean attackEntityAsMob(Entity par1Entity) {
		if (super.attackEntityAsMob(par1Entity)) {
			if (par1Entity instanceof EntityLiving) {
				byte byte0 = 0;

				if (worldObj.difficultySetting > 1) {
					if (worldObj.difficultySetting == 2) {
						byte0 = 7;
					} else if (worldObj.difficultySetting == 3) {
						byte0 = 15;
					}
				}

				if (byte0 > 0) {
					((EntityLiving) par1Entity)
							.addPotionEffect(new PotionEffect(Potion.poison.id,
									byte0 * 20, 0));
				}
			}

			return true;
		} else {
			return false;
		}
	}
}
