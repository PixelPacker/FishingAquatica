package pixelpacker.fishingrework.registers;

import net.minecraft.item.Item;
import net.minecraft.item.ToolItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import pixelpacker.fishingrework.FishingRework;
import pixelpacker.fishingrework.items.fish.FishToolMaterial;
import pixelpacker.fishingrework.items.fish.SwordFishItem;


public class ItemRegister {
    //Normal Items

    //Tools
    /**
     * TOOL SPEEDS >
     * Sword: -2.4f
     * Shovel: -3.0f
     * Pickaxe: -2.8f
     * Axe: -3.0f
     */
    public static ToolItem SWORD_FISH = new SwordFishItem(FishToolMaterial.INSTANCE,4, -2.4f, new Item.Settings().group(ItemGroupRegister.FISHING_GROUP));
    public void registerItems(){
        register("sword_fish", SWORD_FISH);
    }

    public void register(String itemName, Item item){
        Registry.register(Registry.ITEM, new Identifier(FishingRework.MODID, itemName), item);
    }

}
