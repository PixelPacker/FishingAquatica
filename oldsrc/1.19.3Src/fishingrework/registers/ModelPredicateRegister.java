package pixelpacker.fishingrework.registers;

import com.google.common.collect.Maps;
import it.unimi.dsi.fastutil.ints.Int2BooleanOpenCustomHashMap;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.item.ModelPredicateProvider;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.FishingRodItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import pixelpacker.fishingrework.items.rod.DiamondFishingRodItem;
import pixelpacker.fishingrework.items.rod.GoldFishingRodItem;
import pixelpacker.fishingrework.items.rod.IronFishingRodItem;
import pixelpacker.fishingrework.items.rod.NetheriteFishingRod;

import java.util.Map;

@Environment(EnvType.CLIENT)
public class ModelPredicateRegister extends ModelPredicateProviderRegistry {

    public void register(){
        ModelPredicateProviderRegistry.register(ItemRegister.GOLD_FISHING_ROD, new Identifier("gcast"), (stack, world, entity, seed) -> {
            if (entity == null) {
                return 0.0F;
            } else {
                boolean bl = entity.getMainHandStack() == stack;
                boolean bl2 = entity.getOffHandStack() == stack;
                if (entity.getMainHandStack().getItem() instanceof GoldFishingRodItem) {
                    bl2 = false;
                }

                return (bl || bl2) && entity instanceof PlayerEntity && ((PlayerEntity)entity).fishHook != null ? 1.0F : 0.0F;
            }
        });

        ModelPredicateProviderRegistry.register(ItemRegister.IRON_FISHING_ROD, new Identifier("icast"), (stack, world, entity, seed) -> {
            if (entity == null) {
                return 0.0F;
            } else {
                boolean bl = entity.getMainHandStack() == stack;
                boolean bl2 = entity.getOffHandStack() == stack;
                if (entity.getMainHandStack().getItem() instanceof IronFishingRodItem) {
                    bl2 = false;
                }

                return (bl || bl2) && entity instanceof PlayerEntity && ((PlayerEntity)entity).fishHook != null ? 1.0F : 0.0F;
            }
        });

        ModelPredicateProviderRegistry.register(ItemRegister.DIAMOND_FISHING_ROD, new Identifier("dcast"), (stack, world, entity, seed) -> {
            if (entity == null) {
                return 0.0F;
            } else {
                boolean bl = entity.getMainHandStack() == stack;
                boolean bl2 = entity.getOffHandStack() == stack;
                if (entity.getMainHandStack().getItem() instanceof DiamondFishingRodItem) {
                    bl2 = false;
                }

                return (bl || bl2) && entity instanceof PlayerEntity && ((PlayerEntity)entity).fishHook != null ? 1.0F : 0.0F;
            }
        });

        ModelPredicateProviderRegistry.register(ItemRegister.NETHERITE_FISHING_ROD, new Identifier("ncast"), (stack, world, entity, seed) -> {
            if (entity == null) {
                return 0.0F;
            } else {
                boolean bl = entity.getMainHandStack() == stack;
                boolean bl2 = entity.getOffHandStack() == stack;
                if (entity.getMainHandStack().getItem() instanceof NetheriteFishingRod) {
                    bl2 = false;
                }

                return (bl || bl2) && entity instanceof PlayerEntity && ((PlayerEntity)entity).fishHook != null ? 1.0F : 0.0F;
            }
        });
    }
}
