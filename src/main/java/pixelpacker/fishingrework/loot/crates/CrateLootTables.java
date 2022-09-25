package pixelpacker.fishingrework.loot.crates;

import net.minecraft.item.Item;
import net.minecraft.item.Items;
import pixelpacker.fishingrework.registers.BlockRegister;

import java.util.Arrays;
import java.util.List;

public class CrateLootTables {
    /**
     * Create loot tables here to be referenced by different classes.
     * <p>
     * Loot tables are basic and cannot weigh the odds of any individual item
     * so to achieve weighed tables it needs to be diluted with duplicate entries.
     */

    //Register crate loot tiers here
    public static List<Item>TierOneCrates = Arrays.asList(
            BlockRegister.BASIC_CRATE.asItem(),
            BlockRegister.PLANTS_CRATE.asItem()
    );

    public static List<Item>TierTwoCrates = Arrays.asList(
            BlockRegister.BASIC_CRATE.asItem(),
            BlockRegister.PLANTS_CRATE.asItem(),
            BlockRegister.RESOURCE_CRATE.asItem(),
            BlockRegister.MOB_CRATE.asItem()
    );

    public static List<Item>TierThreeCrates = Arrays.asList(
            BlockRegister.RESOURCE_CRATE.asItem(),
            BlockRegister.MOB_CRATE.asItem()
    );

    public static List<Item>TierFourCrates = Arrays.asList(
            BlockRegister.RESOURCE_CRATE.asItem(),
            BlockRegister.MOB_CRATE.asItem(),
            BlockRegister.RARE_RESOURCE_CRATE.asItem()
    );

    //Register crate loot tables here
    public static List<Item> BASIC_CRATE = Arrays.asList(
            Items.IRON_INGOT, Items.IRON_INGOT,
            Items.GOLD_INGOT, Items.GOLD_INGOT,
            Items.COAL, Items.COAL, Items.COAL, Items.COAL, Items.COAL, Items.COAL,
            Items.SALMON, Items.SALMON, Items.SALMON, Items.SALMON, Items.SALMON, Items.SALMON, Items.SALMON, Items.SALMON,
            Items.COD, Items.COD, Items.COD, Items.COD, Items.COD, Items.COD, Items.COD, Items.COD, Items.COD, Items.COD,
            Items.PUFFERFISH, Items.PUFFERFISH, Items.PUFFERFISH,
            Items.TROPICAL_FISH, Items.TROPICAL_FISH, Items.TROPICAL_FISH
    );

    public static List<Item> RESOURCE_CRATE = Arrays.asList(
            Items.IRON_INGOT, Items.IRON_INGOT, Items.IRON_INGOT,
            Items.DIAMOND, Items.DIAMOND,
            Items.GOLD_INGOT, Items.GOLD_INGOT, Items.GOLD_INGOT,
            Items.COAL, Items.COAL, Items.COAL, Items.COAL, Items.COAL,
            Items.COPPER_INGOT, Items.COPPER_INGOT, Items.COPPER_INGOT,
            Items.REDSTONE_BLOCK, Items.REDSTONE, Items.REDSTONE,
            Items.LAPIS_LAZULI, Items.LAPIS_LAZULI,
            Items.CLAY, Items.CLAY, Items.CLAY,
            Items.SAND, Items.SAND
    );

    public static List<Item> MOB_CRATE = Arrays.asList(
            Items.SLIME_BALL, Items.SLIME_BALL,
            Items.ROTTEN_FLESH, Items.ROTTEN_FLESH, Items.ROTTEN_FLESH,
            Items.GUNPOWDER, Items.GUNPOWDER, Items.GUNPOWDER,
            Items.BONE, Items.BONE, Items.BONE, Items.BONE,
            Items.FEATHER, Items.FEATHER, Items.FEATHER,
            Items.STRING, Items.STRING, Items.STRING,
            Items.SPIDER_EYE,
            Items.HONEYCOMB,
            Items.LEATHER, Items.LEATHER
    );

    public static List<Item> PLANT_CRATE = Arrays.asList(
            Items.DANDELION, Items.POPPY, Items.BLUE_ORCHID,
            Items.ALLIUM, Items.AZURE_BLUET, Items.RED_TULIP,
            Items.ORANGE_TULIP, Items.WHITE_TULIP, Items.PINK_TULIP,
            Items.OXEYE_DAISY, Items.CORNFLOWER, Items.LILY_OF_THE_VALLEY,
            Items.SUGAR_CANE, Items.BAMBOO, Items.CACTUS, Items.KELP,
            Items.SUNFLOWER
    );

    public static List<Item> RARE_RESOURCES_CRATE = Arrays.asList(
            Items.EMERALD_BLOCK,
            Items.LAPIS_BLOCK,
            Items.GOLD_BLOCK, Items.GOLD_BLOCK,
            Items.IRON_BLOCK, Items.IRON_BLOCK,
            Items.DIAMOND, Items.DIAMOND, Items.DIAMOND, Items.DIAMOND,
            Items.BLAZE_ROD, Items.BLAZE_ROD,
            Items.ENDER_PEARL, Items.ENDER_PEARL, Items.ENDER_PEARL,
            Items.NAUTILUS_SHELL, Items.NAUTILUS_SHELL,
            Items.HEART_OF_THE_SEA,
            Items.EMERALD, Items.EMERALD, Items.EMERALD, Items.EMERALD, Items.EMERALD, Items.EMERALD,
            Items.EXPERIENCE_BOTTLE, Items.EXPERIENCE_BOTTLE, Items.EXPERIENCE_BOTTLE, Items.EXPERIENCE_BOTTLE
    );
}
