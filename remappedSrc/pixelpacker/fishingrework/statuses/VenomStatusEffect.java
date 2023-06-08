package pixelpacker.fishingrework.statuses;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.boss.WitherEntity;
import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.entity.damage.*;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.mob.WardenEntity;


public class VenomStatusEffect extends StatusEffect {
    public VenomStatusEffect(StatusEffectCategory statusEffectCategory, int color) {
        super(statusEffectCategory, color);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        int i = 25 >> amplifier;
        if (i > 0) {
            return duration % i == 0;
        } else {
            return true;
        }
    }

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier){
        if(!(entity instanceof EnderDragonEntity || entity instanceof WitherEntity || entity instanceof WardenEntity)){
            float damage = .5f;
            entity.damage(entity.getDamageSources().magic(), damage);
        }
    }
}
