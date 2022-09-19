package pixelpacker.fishingrework.blocks.crates;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.world.BlockView;
import org.jetbrains.annotations.Nullable;
import pixelpacker.fishingrework.loot.crates.CrateLootTables;

import java.util.List;

public class RareResourceCrate extends BasicCrateBlock{
    public RareResourceCrate(Settings settings) {
        super(settings);
    }

    @Override
    public List<Item> getLootCrateTable(){ return CrateLootTables.RARE_RESOURCES_CRATE; }
    @Override
    public int getTimesToLoot(){
        return 4;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable BlockView world, List<Text> tooltip, TooltipContext options) {
        tooltip.add(Text.translatable("block.fishingrework.rare_resource_crate.tooltip_1").formatted(Formatting.YELLOW));
        tooltip.add(Text.translatable("block.fishingrework.rare_resource_crate.tooltip_2").formatted(Formatting.YELLOW));
    }
}
