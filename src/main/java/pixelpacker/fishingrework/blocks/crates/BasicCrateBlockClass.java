package pixelpacker.fishingrework.blocks.crates;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.particle.Particle;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.context.LootContext;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleType;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import pixelpacker.fishingrework.loot.crates.CrateLootTables;
import pixelpacker.fishingrework.util.LootTableGenerator;

import java.util.List;

public class BasicCrateBlockClass extends Block {
    public BasicCrateBlockClass(Settings settings){
        super(settings.hardness(1.9f));
    }

    public List<Item> getLootCrateTable(){
        return CrateLootTables.INSTANCE.BASIC_CRATE;
    }

    public int getTimesToLoot(){
        return 3;
    }

    @Override
    public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        java.util.Random rand = new java.util.Random();
        if (player.getServer() == null) {
            return;
        }

        if(!world.isClient){
            //Randomizes Volume of sound effects
            float minPitch = .95f, maxPitch = 1.05f, volume = .5f;
            float pitch = rand.nextFloat((maxPitch - minPitch) + minPitch);

            //IMPORTANT: Type casts the world as a server world, REQUIRES to world to not be client
            ServerWorld sWorld = (ServerWorld)world;

            //Sounds
            playSound(pos, SoundEvents.BLOCK_WOOD_BREAK, volume, pitch, sWorld);
            playSound(pos, SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP, volume, pitch, sWorld);
            playSound(pos, SoundEvents.ENTITY_FIREWORK_ROCKET_TWINKLE, volume, pitch, sWorld);
            playSound(pos, SoundEvents.ENTITY_FIREWORK_ROCKET_BLAST, volume, pitch, sWorld);
            playSound(pos, SoundEvents.ENTITY_FIREWORK_ROCKET_BLAST, volume + 1f, pitch - .5f, sWorld);

            //Particles
            spawnParticle(pos, 10, ParticleTypes.FIREWORK, sWorld);
            spawnParticle(pos, 5, ParticleTypes.POOF, sWorld);
            spawnParticle(pos, 5, ParticleTypes.EXPLOSION, sWorld);
        }

        //Randomizes the amount of times that a crate will drop loot
        LootContext ctx = new LootContext.Builder(player.getServer().getWorld(player.getWorld().getRegistryKey())).random(Random.create()).build(LootContextTypes.EMPTY);
        LootTable table = LootTableGenerator.generateLootTable(getLootCrateTable());
        int timesToLoot = rand.nextInt(getTimesToLoot()), i = 0;
        while(i <= timesToLoot){
            i++;
            table.generateLoot(ctx, itemStack -> {
                World w = player.getEntityWorld();
                Block.dropStack(player.getWorld(), pos, itemStack);
            });
        }
    }
    private void playSound(BlockPos pos, SoundEvent soundEvent, float volume, float pitch, ServerWorld world){
        world.playSound(null, pos, soundEvent, SoundCategory.BLOCKS, volume, pitch);
    }

    private void spawnParticle(BlockPos pos, int count, ParticleEffect particleType, ServerWorld world){
        world.spawnParticles(particleType, pos.getX(), pos.getY(), pos.getZ(), count, 0.5f, 0.5f, 0.5f, 0);
    }
}