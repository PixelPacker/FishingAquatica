package pixelpacker.fishingrework;

import net.fabricmc.api.ModInitializer;
import pixelpacker.fishingrework.registers.BlockRegister;
import pixelpacker.fishingrework.registers.ItemGroupRegister;
import pixelpacker.fishingrework.registers.ItemRegister;
import pixelpacker.fishingrework.registers.ModelPredicateRegister;

public class FishingRework implements ModInitializer {
    public static final String MODID = "fishingrework";

    @Override
    public void onInitialize() {
        BlockRegister blockReg = new BlockRegister();
        ItemRegister itemReg = new ItemRegister();
        ItemGroupRegister itemGroupReg = new ItemGroupRegister();
        ModelPredicateRegister predicateRegister = new ModelPredicateRegister();

        blockReg.registerBlocks();
        itemReg.registerItems();
        predicateRegister.register();
        itemGroupReg.main();
    }
}
