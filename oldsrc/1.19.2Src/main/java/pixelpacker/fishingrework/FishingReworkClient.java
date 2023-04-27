package pixelpacker.fishingrework;

import net.fabricmc.api.ClientModInitializer;
import pixelpacker.fishingrework.registers.ModelPredicateRegister;

public class FishingReworkClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModelPredicateRegister predicateRegister = new ModelPredicateRegister();
        predicateRegister.register();
    }
}
