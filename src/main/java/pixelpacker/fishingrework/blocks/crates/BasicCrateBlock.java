package pixelpacker.fishingrework.blocks.crates;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import pixelpacker.fishingrework.util.LootTableGenerator;

import java.util.List;

public class BasicCrateBlock extends Block {
    public BasicCrateBlock(Settings settings){
        super(settings.hardness(1.9f));
    }

    /**public List<Item> getLootCrateTable(){ return CrateLootTables.BASIC_CRATE; }

    public int getTimesToLoot(){
        return 3;
    }
    **/
    @Override
    public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        if (player.getServer() == null) {
            return;
        }

        if(!world.isClient){
            //Randomizes Volume of sound effects
            float minPitch = .95f, maxPitch = 1.05f, volume = .5f;
            float pitch = LootTableGenerator.random.nextFloat((maxPitch - minPitch) + minPitch);

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
        /**
        LootContext ctx = new LootContext.Builder(player.getServer().getWorld(player.getWorld().getRegistryKey())).random(Random.create()).build(LootContextTypes.EMPTY);
        LootTable table = LootTableGenerator.generateLootTable(getLootCrateTable());
        int timesToLoot = LootTableGenerator.random.nextInt(getTimesToLoot()), i = 0;
        while(i <= timesToLoot){
            i++;
            table.generateLoot(ctx, itemStack -> {
                World w = player.getEntityWorld();
                Block.dropStack(player.getWorld(), pos, itemStack);
            });
        }
         **/
    }
    private void playSound(BlockPos pos, SoundEvent soundEvent, float volume, float pitch, ServerWorld world){
        world.playSound(null, pos, soundEvent, SoundCategory.BLOCKS, volume, pitch);
    }

    private void spawnParticle(BlockPos pos, int count, ParticleEffect particleType, ServerWorld world){
        world.spawnParticles(particleType, pos.getX(), pos.getY(), pos.getZ(), count, 0.5f, 0.5f, 0.5f, 0);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable BlockView world, List<Text> tooltip, TooltipContext options) {
        tooltip.add(Text.translatable("block.fishingrework.basic_crate.tooltip_1").formatted(Formatting.YELLOW));
        tooltip.add(Text.translatable("block.fishingrework.basic_crate.tooltip_2").formatted(Formatting.YELLOW));
    }
}