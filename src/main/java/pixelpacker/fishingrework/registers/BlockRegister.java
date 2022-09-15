package pixelpacker.fishingrework.registers;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import pixelpacker.fishingrework.FishingRework;
import pixelpacker.fishingrework.blocks.crates.BasicCrateBlockClass;

public class BlockRegister {
    public static final Block BASIC_CRATE = new BasicCrateBlockClass(FabricBlockSettings.of(Material.WOOD).sounds(BlockSoundGroup.WOOD).hardness(2.0f));
    public static final Block FISH_OIL_PLANKS = new Block(FabricBlockSettings.of(Material.WOOD).hardness(2.0f).sounds(BlockSoundGroup.WOOD).sounds(BlockSoundGroup.WOOD));
    public static final Block FISH_OIL_STAIRS = new StairsBlock(FISH_OIL_PLANKS.getDefaultState(), AbstractBlock.Settings.copy(FISH_OIL_PLANKS));
    public static final Block FISH_OIL_FENCE = new FenceBlock(FabricBlockSettings.of(Material.WOOD).strength(2.0f, 3.0f).sounds(BlockSoundGroup.WOOD));
    public static final Block FISH_OIL_FENCE_GATE = new FenceGateBlock(FabricBlockSettings.of(Material.WOOD).strength(2.0f, 3.0f).sounds(BlockSoundGroup.WOOD));
    public static final Block FISH_OIL_SLAB = new SlabBlock(FabricBlockSettings.of(Material.WOOD).strength(2.0f, 3.0f).sounds(BlockSoundGroup.WOOD));

    public void registerBlocks(){
        register("basic_crate", BASIC_CRATE);
        register("fish_oil_planks", FISH_OIL_PLANKS);
        register("fish_oil_stairs", FISH_OIL_STAIRS);
        register("fish_oil_fence", FISH_OIL_FENCE);
        register("fish_oil_slab", FISH_OIL_SLAB);
        register("fish_oil_fence_gate", FISH_OIL_FENCE_GATE);
    }

    public void register(String blockName, Block block){
        Registry.register(Registry.BLOCK, new Identifier(FishingRework.MODID, blockName), block);
        Registry.register(Registry.ITEM, new Identifier(FishingRework.MODID, blockName), new BlockItem(block, new FabricItemSettings().group(ItemGroupRegister.FISHING_GROUP)));
    }
}
