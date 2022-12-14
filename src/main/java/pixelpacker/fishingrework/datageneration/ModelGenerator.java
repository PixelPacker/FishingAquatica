package pixelpacker.fishingrework.datageneration;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.ModelIds;
import net.minecraft.data.client.Models;
import pixelpacker.fishingrework.registers.BlockRegister;
import pixelpacker.fishingrework.registers.ItemRegister;

public class ModelGenerator extends FabricModelProvider {
    ModelGenerator(FabricDataGenerator generator) {
        super(generator);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        /**
         * Models.GENERATED for basic items
         * Models.HANDHELD for tools
         */

    }
}
