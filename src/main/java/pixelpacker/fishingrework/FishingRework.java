package pixelpacker.fishingrework;

import net.fabricmc.api.ModInitializer;
import pixelpacker.fishingrework.registers.BlockRegister;
import pixelpacker.fishingrework.registers.ItemGroupRegister;
import pixelpacker.fishingrework.registers.ItemRegister;

public class FishingRework implements ModInitializer {
    public static final String MODID = "fishingrework";
    private BlockRegister blockReg;
    private ItemRegister itemReg;
    private ItemGroupRegister itemGroupReg;

    @Override
    public void onInitialize() {
        blockReg = new BlockRegister();
        itemReg = new ItemRegister();
        itemGroupReg = new ItemGroupRegister();

        blockReg.registerBlocks();
        itemReg.registerItems();

        itemGroupReg.main();
    }
}
