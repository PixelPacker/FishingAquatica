package pixelpacker.fishingrework.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.context.LootContext;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import pixelpacker.fishingrework.util.LootTableGenerator;

import java.util.Arrays;
import java.util.List;

public class CrateBlockClass extends Block {
    public CrateBlockClass(Settings settings){
        super(settings.hardness(1.9f));
    }

    @Override
    public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        List<Item> items = Arrays.asList(
            Items.GRASS_BLOCK,
            Items.ACACIA_BOAT,
            Items.ACACIA_BUTTON
        );
        if (player.getServer() == null) return;
        ServerWorld serverWorld =player.getServer().getWorld(player.getWorld().getRegistryKey());
        LootContext ctx = new LootContext.Builder(player.getServer().getWorld(player.getWorld().getRegistryKey())).random(Random.create()).build(LootContextTypes.EMPTY);

        LootTable table = LootTableGenerator.generateLootTable(items);
        table.generateLoot(ctx, itemStack -> {
            World w = player.getEntityWorld();
            Block.dropStack(player.getWorld(), pos, itemStack);
        });
    }
}
