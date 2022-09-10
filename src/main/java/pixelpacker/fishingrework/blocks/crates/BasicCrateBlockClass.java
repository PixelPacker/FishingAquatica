package pixelpacker.fishingrework.blocks.crates;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.context.LootContext;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import pixelpacker.fishingrework.loot.crates.CrateLootTables;
import pixelpacker.fishingrework.util.LootTableGenerator;

public class BasicCrateBlockClass extends Block {
    public BasicCrateBlockClass(Settings settings){
        super(settings.hardness(1.9f));
    }

    @Override
    public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        java.util.Random rand = new java.util.Random();

        if (player.getServer() == null) {
            return;
        }
        if(!world.isClient){
            //Randomizes Volume of sound effects
            Float minPitch = .95f, maxPitch = 1.05f, volume = .5f;
            Float pitch = rand.nextFloat((maxPitch - minPitch) + minPitch);

            //IMPORTANT: Type casts the world as a server world, REQUIRES to world to not be client
            ServerWorld sWorld = (ServerWorld)world;

            world.playSound(null, pos, SoundEvents.BLOCK_WOOD_BREAK, SoundCategory.BLOCKS, volume, pitch);
            world.playSound(null, pos, SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP, SoundCategory.BLOCKS, volume, pitch);
            world.playSound(null, pos, SoundEvents.ENTITY_GENERIC_EXPLODE, SoundCategory.BLOCKS, volume, pitch);
            sWorld.spawnParticles(ParticleTypes.EXPLOSION, (double) pos.getX(), (double) pos.getY(), (double) pos.getZ(), 5, 0.5f, 0.5f, 0.5f, 0);
        }
        LootContext ctx = new LootContext.Builder(player.getServer().getWorld(player.getWorld().getRegistryKey())).random(Random.create()).build(LootContextTypes.EMPTY);
        LootTable table = LootTableGenerator.generateLootTable(CrateLootTables.INSTANCE.BASIC_CRATE);

        //Randomizes the amount of times that a crate will drop loot
        int timesToLoot = rand.nextInt((3)), i = 0;
        while(i <= timesToLoot){
            i++;
            table.generateLoot(ctx, itemStack -> {
                World w = player.getEntityWorld();
                Block.dropStack(player.getWorld(), pos, itemStack);
            });
        }
    }
}
