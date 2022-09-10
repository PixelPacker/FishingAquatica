package pixelpacker.fishingrework.registers;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import pixelpacker.fishingrework.FishingRework;
import pixelpacker.fishingrework.blocks.crates.BasicCrateBlockClass;

public class BlockRegister {
    public static final Block BASIC_CRATE = new BasicCrateBlockClass(FabricBlockSettings.of(Material.WOOD));

    public void registerBlocks(){
        register("basic_crate", BASIC_CRATE);
    }

    public void register(String blockName, Block block){
        Registry.register(Registry.BLOCK, new Identifier(FishingRework.MODID, blockName), block);
        Registry.register(Registry.ITEM, new Identifier(FishingRework.MODID, blockName), new BlockItem(block, new FabricItemSettings().group(ItemGroupRegister.FISHING_GROUP)));
    }
}
