package pixelpacker.fishingrework.registers;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.impl.itemgroup.FabricItemGroupBuilderImpl;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import pixelpacker.fishingrework.FishingRework;

public class ItemGroupRegister {
    /**
    public static final ItemGroup FISHING_GROUP = FabricItemGroup.builder(new Identifier("fishingrework", "general"))
            .icon(() -> new ItemStack(BlockRegister.BASIC_CRATE))
            .build();
    **/

    public static final RegistryKey<ItemGroup> FISHING_GROUP = RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier(FishingRework.MODID, "general"));
    public void registerGroups(){
        Registry.register(Registries.ITEM_GROUP, FISHING_GROUP, FabricItemGroup.builder()
                .icon(() -> new ItemStack(BlockRegister.BASIC_CRATE.asItem()))
                .displayName(Text.translatable("fishing_rework.group.general"))
                .build());
    }



    public static void addItemToGroup(Item item, RegistryKey<ItemGroup> itemGroup){
        ItemGroupEvents.modifyEntriesEvent(itemGroup).register(content -> {
            content.add(item);
        });
    }
}
