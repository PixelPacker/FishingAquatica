package pixelpacker.fishingrework.items.rod;

import net.minecraft.item.FishingRodItem;
import net.minecraft.item.Vanishable;

public class DiamondFishingRodItem extends FishingRodItem implements Vanishable {
    public DiamondFishingRodItem(Settings settings) {
        super(settings);
    }

    @Override
    public int getEnchantability() {
        return 10;
    }
}
