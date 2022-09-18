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

    //REGISTER ALL CRATES HERE
    public static List<Item>BasicCrateTable = Arrays.asList(
            BlockRegister.BASIC_CRATE.asItem()
    );
    public static List<Item> BASIC_CRATE = Arrays.asList(
            Items.IRON_INGOT, Items.IRON_INGOT,
            Items.DIAMOND,
            Items.GOLD_INGOT, Items.GOLD_INGOT,
            Items.LAPIS_LAZULI,
            Items.COAL, Items.COAL, Items.COAL, Items.COAL, Items.COAL, Items.COAL,
            Items.SALMON, Items.SALMON, Items.SALMON, Items.SALMON, Items.SALMON, Items.SALMON, Items.SALMON, Items.SALMON,
            Items.COD, Items.COD, Items.COD, Items.COD, Items.COD, Items.COD, Items.COD, Items.COD, Items.COD, Items.COD,
            Items.PUFFERFISH, Items.PUFFERFISH, Items.PUFFERFISH,
            Items.TROPICAL_FISH, Items.TROPICAL_FISH, Items.TROPICAL_FISH
    );

}
