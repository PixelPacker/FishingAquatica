package pixelpacker.fishingrework.items.rod;

import net.minecraft.item.FishingRodItem;
import net.minecraft.item.Vanishable;

public class GoldFishingRodItem extends FishingRodItem implements Vanishable {
    public GoldFishingRodItem(Settings settings) {
        super(settings);
    }

    @Override
    public int getEnchantability() {
        return 22;
    }
}
