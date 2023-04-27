package pixelpacker.fishingrework.items.rod;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.FishingRodItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.Vanishable;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.World;

import java.util.List;

public class IronFishingRodItem extends FishingRodItem implements Vanishable{
    public IronFishingRodItem(Settings settings) {
        super(settings);
    }

    @Override
    public int getEnchantability() {
        return 14;
    }

    @Override
    public void appendTooltip(ItemStack stack, World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("item.fishingrework.iron_fishing_rod.tooltip").formatted(Formatting.YELLOW));
    }

    public boolean canRepair(ItemStack stack, ItemStack ingredient) {
        return ingredient.getItem() == Items.IRON_INGOT;
    }
}
