package pixelpacker.fishingrework;

import net.fabricmc.api.ModInitializer;
import pixelpacker.fishingrework.registers.*;

public class FishingRework implements ModInitializer {
    public static final String MODID = "fishingrework";
    private static final ConfigRegister configReg = new ConfigRegister();
    private static final BlockRegister blockReg = new BlockRegister();
    private static final ItemRegister itemReg = new ItemRegister();
    private static final ItemGroupRegister itemGroupReg = new ItemGroupRegister();
    private static final EffectsRegister effectsReg = new EffectsRegister();

    @Override
    public void onInitialize() {
        blockReg.registerBlocks();
        itemReg.registerItems();
        itemGroupReg.registerGroups();
        effectsReg.registerEffects();
        configReg.load();
    }

    public static ConfigRegister getConfigRegister(){
        return configReg;
    }

    public static BlockRegister getBlockRegister(){
        return blockReg;
    }

    public static ItemRegister getItemRegister(){
        return itemReg;
    }

    public static ItemGroupRegister getItemGroupRegister(){
        return itemGroupReg;
    }

    public static EffectsRegister getEffectsRegister(){
        return effectsReg;
    }
}
