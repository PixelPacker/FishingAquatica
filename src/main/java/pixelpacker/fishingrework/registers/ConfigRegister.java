package pixelpacker.fishingrework.registers;

import me.lortseam.completeconfig.api.ConfigEntry;
import me.lortseam.completeconfig.data.Config;
import me.lortseam.completeconfig.data.ConfigOptions;
import pixelpacker.fishingrework.FishingRework;

public class ConfigRegister extends Config {
    public ConfigRegister(){
        super(ConfigOptions.mod(FishingRework.MODID));
    }

    @ConfigEntry
    private int lootCrateChance = 10;

    public int getLootCrateChance(){
        return lootCrateChance;
    }
}
