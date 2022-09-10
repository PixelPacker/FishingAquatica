package pixelpacker.fishingrework;

import net.fabricmc.api.ModInitializer;
import pixelpacker.fishingrework.registers.BlockRegister;
import pixelpacker.fishingrework.registers.ItemRegister;

public class FishingRework implements ModInitializer {
    public static final String MODID = "fishingrework";
    private BlockRegister blockReg;
    private ItemRegister itemReg;

    @Override
    public void onInitialize() {
        blockReg = new BlockRegister();
        itemReg = new ItemRegister();

        blockReg.registerBlocks();
    }
}
