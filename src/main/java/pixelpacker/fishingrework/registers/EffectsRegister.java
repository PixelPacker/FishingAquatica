package pixelpacker.fishingrework.registers;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import pixelpacker.fishingrework.FishingRework;
import pixelpacker.fishingrework.statuses.VenomStatusEffect;

public class EffectsRegister {
    public static final VenomStatusEffect VENOM_STATUS_EFFECT = new VenomStatusEffect(StatusEffectCategory.HARMFUL, 2853401);

    public void registerEffects(){
        register("venom", VENOM_STATUS_EFFECT);
    }

    private void register(String effectName, StatusEffect statusEffect){
        Registry.register(Registries.STATUS_EFFECT, new Identifier(FishingRework.MODID, effectName), statusEffect);
    }
}