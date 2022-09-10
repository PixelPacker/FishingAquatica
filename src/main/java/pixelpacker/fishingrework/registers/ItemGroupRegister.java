package pixelpacker.fishingrework.registers;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ItemGroupRegister {
    public static final ItemGroup FISHING_GROUP = FabricItemGroupBuilder.build(
            new Identifier("fishingrework", "general"),
            () -> new ItemStack(BlockRegister.BASIC_CRATE));

            public void main(){

            }
}
