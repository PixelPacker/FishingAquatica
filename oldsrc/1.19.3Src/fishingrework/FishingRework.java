package pixelpacker.fishingrework;

import net.fabricmc.api.ModInitializer;
import pixelpacker.fishingrework.registers.*;

public class FishingRework implements ModInitializer {
    public static final String MODID = "fishingrework";

    @Override
    public void onInitialize() {
        BlockRegister blockReg = new BlockRegister();
        ItemRegister itemReg = new ItemRegister();
        ItemGroupRegister itemGroupReg = new ItemGroupRegister();
        EffectsRegister effectsRegister = new EffectsRegister();

        itemGroupReg.main();
        blockReg.registerBlocks();
        itemReg.registerItems();

        effectsRegister.registerEffects();
    }
}
