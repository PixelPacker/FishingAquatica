package pixelpacker.fishingrework.registers;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.impl.itemgroup.FabricItemGroupBuilderImpl;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ItemGroupRegister {
    public static final ItemGroup FISHING_GROUP = FabricItemGroup.builder(new Identifier("fishingrework", "general"))
            .icon(() -> new ItemStack(BlockRegister.BASIC_CRATE))
            .build();

    public void main(){};

    public static void addItemToGroup(Item item, ItemGroup itemGroup){
        ItemGroupEvents.modifyEntriesEvent(itemGroup).register(content -> {
            content.add(item);
        });
    }
}
