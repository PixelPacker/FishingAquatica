package pixelpacker.fishingrework.datageneration;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.ModelIds;
import pixelpacker.fishingrework.registers.BlockRegister;

public class ModelGenerator extends FabricModelProvider {
    ModelGenerator(FabricDataGenerator generator) {
        super(generator);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(BlockRegister.CRATE);
        blockStateModelGenerator.registerParentedItemModel(BlockRegister.CRATE, ModelIds.getBlockModelId(BlockRegister.CRATE));
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        //itemModelGenerator.register(BlockRegister.CRATE.asItem(), Models.CUBE);
    }
}
