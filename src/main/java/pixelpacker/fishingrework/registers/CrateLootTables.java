package pixelpacker.fishingrework.registers;

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
}
