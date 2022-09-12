package pixelpacker.fishingrework.items.rod;

import net.minecraft.item.FishingRodItem;
import net.minecraft.item.Vanishable;

public class NetheriteFishingRod extends FishingRodItem implements Vanishable {

    public NetheriteFishingRod(Settings settings) {
        super(settings);
    }

    @Override
    public int getEnchantability() {
        return 15;
    }
}
