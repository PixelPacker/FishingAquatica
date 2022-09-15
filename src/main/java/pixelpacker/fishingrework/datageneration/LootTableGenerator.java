package pixelpacker.fishingrework.datageneration;

import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.data.server.BlockLootTableGenerator;
import pixelpacker.fishingrework.registers.BlockRegister;

class LootTableGenerator extends FabricBlockLootTableProvider {
    LootTableGenerator(FabricDataGenerator generator){
        super(generator);
    }

    @Override
    public void generateBlockLootTables() {

    }
}
