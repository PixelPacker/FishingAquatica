package pixelpacker.fishingrework.registers;

import net.minecraft.item.FishingRodItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ToolItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import pixelpacker.fishingrework.FishingRework;
import pixelpacker.fishingrework.items.fish.FishToolMaterial;
import pixelpacker.fishingrework.items.fish.SwordFishItem;
import pixelpacker.fishingrework.items.rod.DiamondFishingRodItem;
import pixelpacker.fishingrework.items.rod.GoldFishingRodItem;
import pixelpacker.fishingrework.items.rod.IronFishingRodItem;
import pixelpacker.fishingrework.items.rod.NetheriteFishingRod;

import javax.swing.*;


public class ItemRegister {
    //Normal Items

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
    public static ToolItem SWORD_FISH = new SwordFishItem(FishToolMaterial.INSTANCE,4, -2.4f, new Item.Settings().group(ItemGroupRegister.FISHING_GROUP));

    //Fishing Rods
    public static FishingRodItem GOLD_FISHING_ROD = new GoldFishingRodItem(new Item.Settings().maxDamage(32).group(ItemGroupRegister.FISHING_GROUP));
    public static FishingRodItem IRON_FISHING_ROD = new IronFishingRodItem(new Item.Settings().maxDamage(128).group(ItemGroupRegister.FISHING_GROUP));
    public static FishingRodItem DIAMOND_FISHING_ROD = new DiamondFishingRodItem(new Item.Settings().maxDamage(256).group(ItemGroupRegister.FISHING_GROUP));
    public static FishingRodItem NETHERITE_FISHING_ROD = new NetheriteFishingRod(new Item.Settings().maxDamage(512).group(ItemGroupRegister.FISHING_GROUP));

    public void registerItems(){
        register("sword_fish", SWORD_FISH);
        register("gold_fishing_rod", GOLD_FISHING_ROD);
        register("iron_fishing_rod", IRON_FISHING_ROD);
        register("diamond_fishing_rod", DIAMOND_FISHING_ROD);
        register("netherite_fishing_rod", NETHERITE_FISHING_ROD);
    }

    public void register(String itemName, Item item){
        Registry.register(Registry.ITEM, new Identifier(FishingRework.MODID, itemName), item);
    }
}
