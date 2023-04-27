package pixelpacker.fishingrework.registers;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class Tags {
    public static final TagKey<Item> FISHING_RODS = ofItem("fishing_rods");

    public static final TagKey<Item> TIER_1_FISHING_RODS = ofItem("tier_1_fishing_rods");
    public static final TagKey<Item> TIER_2_FISHING_RODS = ofItem("tier_2_fishing_rods");
    public static final TagKey<Item> TIER_3_FISHING_RODS = ofItem("tier_3_fishing_rods");
    public static final TagKey<Item> TIER_4_FISHING_RODS = ofItem("tier_4_fishing_rods");

    private static TagKey<Item> ofItem(String id) {
        return TagKey.of(RegistryKeys.ITEM, new Identifier(id));
    }
}
