package pixelpacker.fishingrework.items.fish;

import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.MilkBucketItem;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.stat.Stats;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import pixelpacker.fishingrework.registers.ItemRegister;
import pixelpacker.fishingrework.util.LootTableGenerator;

import java.util.List;

public class FishOilBottleItem extends MilkBucketItem {
    int nauseaChance = 25;
    public FishOilBottleItem(Settings settings) {
        super(settings);
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        if (user instanceof ServerPlayerEntity serverPlayerEntity) {
            Criteria.CONSUME_ITEM.trigger(serverPlayerEntity, stack);
            serverPlayerEntity.incrementStat(Stats.USED.getOrCreateStat(this));
        }

        if (!world.isClient) {
            user.clearStatusEffects();
        }

        if (user instanceof PlayerEntity && !((PlayerEntity)user).getAbilities().creativeMode) {
            stack.decrement(1);
            int rand = LootTableGenerator.random.nextInt(100);
            if(rand <= nauseaChance){
                user.addStatusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 200, 0));
                world.sendEntityStatus(user, (byte)2);
            }
            ((PlayerEntity) user).getInventory().insertStack(new ItemStack(Items.GLASS_BOTTLE));
        }

        return stack;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("item.fishingrework.fish_oil.tooltip_1").formatted(Formatting.YELLOW));
        tooltip.add(Text.translatable("item.fishingrework.fish_oil.tooltip_2").formatted(Formatting.YELLOW));
    }
}
