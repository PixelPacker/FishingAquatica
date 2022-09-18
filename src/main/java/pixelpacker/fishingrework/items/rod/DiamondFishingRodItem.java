package pixelpacker.fishingrework.items.rod;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.FishingRodItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.Vanishable;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

public class DiamondFishingRodItem extends FishingRodItem implements Vanishable {
    public DiamondFishingRodItem(Settings settings) {
        super(settings);
    }

    @Override
    public int getEnchantability() {
        return 10;
    }

    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("item.fishingrework.diamond_fishing_rod.tooltip").formatted(Formatting.YELLOW));
    }
}
