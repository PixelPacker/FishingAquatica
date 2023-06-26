package pixelpacker.fishingrework.registers;

import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import pixelpacker.fishingrework.FishingRework;
import pixelpacker.fishingrework.items.fish.FishOilBottleItem;
import pixelpacker.fishingrework.items.fish.FishToolMaterial;
import pixelpacker.fishingrework.items.fish.SwordFishItem;
import pixelpacker.fishingrework.items.rod.DiamondFishingRodItem;
import pixelpacker.fishingrework.items.rod.GoldFishingRodItem;
import pixelpacker.fishingrework.items.rod.IronFishingRodItem;
import pixelpacker.fishingrework.items.rod.NetheriteFishingRod;

public class ItemRegister {
    private static final RegistryKey<ItemGroup> fishing_group = ItemGroupRegister.FISHING_GROUP;
    //Normal Items
    public static Item FISH_OIL_BOTTLE = new FishOilBottleItem(new Item.Settings().maxCount(16));

    //Tools
    /**
     * Tool Speeds:
     * <p>
     * Sword: -2.4f
     * Shovel: -3.0f
     * Pickaxe: -2.8f
     * Axe: -3.0f
     * </p>
     */
    public static ToolItem SWORD_FISH = new SwordFishItem(FishToolMaterial.INSTANCE,4, -2.4f, new Item.Settings());

    //Fishing Rods
    public static FishingRodItem GOLD_FISHING_ROD = new GoldFishingRodItem(new Item.Settings().maxDamage(32));
    public static FishingRodItem IRON_FISHING_ROD = new IronFishingRodItem(new Item.Settings().maxDamage(128));
    public static FishingRodItem DIAMOND_FISHING_ROD = new DiamondFishingRodItem(new Item.Settings().maxDamage(256));
    public static FishingRodItem NETHERITE_FISHING_ROD = new NetheriteFishingRod(new Item.Settings().maxDamage(512));

    public void registerItems(){
        //Normal Items
        register("fish_oil_bottle", FISH_OIL_BOTTLE, fishing_group);
        //Tools
        register("sword_fish", SWORD_FISH, fishing_group);
        //Fishing Rods
        register("gold_fishing_rod", GOLD_FISHING_ROD, fishing_group);
        register("iron_fishing_rod", IRON_FISHING_ROD, fishing_group);
        register("diamond_fishing_rod", DIAMOND_FISHING_ROD, fishing_group);
        register("netherite_fishing_rod", NETHERITE_FISHING_ROD, fishing_group);
    }

    public void register(String itemName, Item item, RegistryKey group){
        Registry.register(Registries.ITEM, new Identifier(FishingRework.MODID, itemName), item);
        ItemGroupRegister.addItemToGroup(item, group);
    }
}
