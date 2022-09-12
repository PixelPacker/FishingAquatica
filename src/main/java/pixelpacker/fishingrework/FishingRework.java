package pixelpacker.fishingrework;

import net.fabricmc.api.ModInitializer;
import pixelpacker.fishingrework.registers.BlockRegister;
import pixelpacker.fishingrework.registers.ItemGroupRegister;
import pixelpacker.fishingrework.registers.ItemRegister;
import pixelpacker.fishingrework.registers.ModelPredicateRegister;

public class FishingRework implements ModInitializer {
    public static final String MODID = "fishingrework";
    private BlockRegister blockReg;
    private ItemRegister itemReg;
    private ItemGroupRegister itemGroupReg;
    private ModelPredicateRegister predicateRegister;

    @Override
    public void onInitialize() {
        blockReg = new BlockRegister();
        itemReg = new ItemRegister();
        itemGroupReg = new ItemGroupRegister();
        predicateRegister = new ModelPredicateRegister();


        blockReg.registerBlocks();
        itemReg.registerItems();
        predicateRegister.register();

        itemGroupReg.main();
    }
}
