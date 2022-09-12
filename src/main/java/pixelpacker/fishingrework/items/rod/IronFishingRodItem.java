package pixelpacker.fishingrework.items.rod;

import net.minecraft.item.FishingRodItem;
import net.minecraft.item.Vanishable;

public class IronFishingRodItem extends FishingRodItem implements Vanishable{
    public IronFishingRodItem(Settings settings) {
        super(settings);
    }

    @Override
    public int getEnchantability() {
        return 14;
    }
}
