package net.minecraft.entity;

import net.minecraft.src.DamageSource;

public class EntityDamageSource extends DamageSource {
	protected Entity damageSourceEntity;

	public EntityDamageSource(String par1Str, Entity par2Entity) {
		super(par1Str);
		damageSourceEntity = par2Entity;
	}

	public Entity getEntity() {
		return damageSourceEntity;
	}
}
