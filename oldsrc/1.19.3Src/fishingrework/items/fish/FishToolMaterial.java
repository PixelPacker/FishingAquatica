package pixelpacker.fishingrework.items.fish;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class FishToolMaterial implements ToolMaterial {

    public static final FishToolMaterial INSTANCE = new FishToolMaterial();

    @Override
    public int getDurability() {
        return 500;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 7.5f;
    }

    @Override
    public float getAttackDamage() {
        return 2.0f;
    }

    @Override
    public int getMiningLevel() {
        return 3;
    }

    @Override
    public int getEnchantability() {
        return 8;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return null;
    }
}
