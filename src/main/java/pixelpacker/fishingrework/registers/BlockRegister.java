package pixelpacker.fishingrework.registers;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import pixelpacker.fishingrework.FishingRework;
import pixelpacker.fishingrework.blocks.crates.*;

public class BlockRegister {
    public static final RegistryKey<ItemGroup> fishing_group = ItemGroupRegister.FISHING_GROUP;

    //Crates
    public static final Block BASIC_CRATE = new BasicCrateBlock(AbstractBlock.Settings.create().solid().sounds(BlockSoundGroup.WOOD).hardness(2.0f));
    public static final Block RESOURCE_CRATE = new ResourceCrateBlock(AbstractBlock.Settings.create().solid().sounds(BlockSoundGroup.METAL).hardness(2.0f));
    public static final Block PLANTS_CRATE = new PlantsCrateBlock(AbstractBlock.Settings.create().solid().sounds(BlockSoundGroup.AZALEA_LEAVES).hardness(.8f));
    public static final Block MOB_CRATE = new MobCrateBlock(AbstractBlock.Settings.create().solid().sounds(BlockSoundGroup.BONE).hardness(2.0f));
    public static final Block RARE_RESOURCE_CRATE = new RareResourceCrate(AbstractBlock.Settings.create().solid().sounds(BlockSoundGroup.METAL).hardness(2.0f));

    //Fish Oil blocks
    public static final Block FISH_OIL_PLANKS = new Block(AbstractBlock.Settings.create().solid().hardness(2.0f).sounds(BlockSoundGroup.WOOD).sounds(BlockSoundGroup.WOOD));
    public static final Block FISH_OIL_STAIRS = new StairsBlock(FISH_OIL_PLANKS.getDefaultState(), AbstractBlock.Settings.copy(FISH_OIL_PLANKS));
    public static final Block FISH_OIL_FENCE = new FenceBlock(AbstractBlock.Settings.create().solid().strength(2.0f, 3.0f).sounds(BlockSoundGroup.WOOD));
    public static final Block FISH_OIL_FENCE_GATE = new FenceGateBlock(AbstractBlock.Settings.create().solid().strength(2.0f, 3.0f).sounds(BlockSoundGroup.WOOD), WoodType.OAK);
    public static final Block FISH_OIL_SLAB = new SlabBlock(AbstractBlock.Settings.create().solid().strength(2.0f, 3.0f).sounds(BlockSoundGroup.WOOD));

    public void registerBlocks(){
        //Crates
        register("basic_crate", BASIC_CRATE);
        register("resource_crate", RESOURCE_CRATE);
        register("plants_crate", PLANTS_CRATE);
        register("mob_crate", MOB_CRATE);
        register("rare_resource_crate", RARE_RESOURCE_CRATE);
        //Fish Oil Blocks
        register("fish_oil_planks", FISH_OIL_PLANKS);
        register("fish_oil_stairs", FISH_OIL_STAIRS);
        register("fish_oil_fence", FISH_OIL_FENCE);
        register("fish_oil_slab", FISH_OIL_SLAB);
        register("fish_oil_fence_gate", FISH_OIL_FENCE_GATE);
    }

    public void register(String blockName, Block block){
        Registry.register(Registries.BLOCK, new Identifier(FishingRework.MODID, blockName), block);
        Registry.register(Registries.ITEM, new Identifier(FishingRework.MODID, blockName), new BlockItem(block, new FabricItemSettings()));
        ItemGroupRegister.addItemToGroup(block.asItem(), fishing_group);
    }
}
