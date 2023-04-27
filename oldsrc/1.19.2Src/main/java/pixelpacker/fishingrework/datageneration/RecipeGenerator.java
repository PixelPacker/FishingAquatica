package pixelpacker.fishingrework.datageneration;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.RecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;

import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import pixelpacker.fishingrework.registers.BlockRegister;


import java.util.function.Consumer;
import java.util.stream.Stream;

public class RecipeGenerator extends FabricRecipeProvider {
    public RecipeGenerator(FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    protected void generateRecipes(Consumer<RecipeJsonProvider> exporter) {

        RecipeProvider.createFenceGateRecipe(BlockRegister.FISH_OIL_FENCE_GATE, Ingredient.ofItems(BlockRegister.FISH_OIL_PLANKS));
        RecipeProvider.createFenceRecipe(BlockRegister.FISH_OIL_FENCE, Ingredient.ofItems(BlockRegister.FISH_OIL_PLANKS));
        RecipeProvider.createSlabRecipe(BlockRegister.FISH_OIL_SLAB, Ingredient.ofItems(BlockRegister.FISH_OIL_PLANKS));
        RecipeProvider.createStairsRecipe(BlockRegister.FISH_OIL_STAIRS, Ingredient.ofItems(BlockRegister.FISH_OIL_PLANKS));
    }
}
