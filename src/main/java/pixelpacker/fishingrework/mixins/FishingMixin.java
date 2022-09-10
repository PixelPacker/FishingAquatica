package pixelpacker.fishingrework.mixins;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FishingBobberEntity;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import pixelpacker.fishingrework.registers.BlockRegister;
import java.util.Random;

@Mixin(FishingBobberEntity.class)
public abstract class FishingMixin {
    private static final Random random = new Random();
    @Shadow @Nullable public abstract PlayerEntity getPlayerOwner();

    @Inject(method = "use", at = @At(value = "HEAD", target = "Lnet/minecraft/entity/player/PlayerEntity;increaseStat(Lnet/minecraft/util/Identifier;I)V"))
    public void use(ItemStack usedItem, CallbackInfoReturnable<Integer> cir) {

        PlayerEntity player = this.getPlayerOwner();
        if (player == null || random.nextInt(100) >= 95) return;
        player.getInventory().insertStack(new ItemStack(BlockRegister.CRATE));
    }
}
