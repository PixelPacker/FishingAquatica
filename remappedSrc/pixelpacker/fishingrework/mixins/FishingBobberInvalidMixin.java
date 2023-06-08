package pixelpacker.fishingrework.mixins;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FishingBobberEntity;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import pixelpacker.fishingrework.registers.Tags;

@Mixin(FishingBobberEntity.class)
public abstract class FishingBobberInvalidMixin {

    @Inject(method="removeIfInvalid", at = @At(value = "HEAD"), cancellable = true)
    private void removeIfInvalid(PlayerEntity player, CallbackInfoReturnable<Boolean> cir) {
        ItemStack itemStack = player.getMainHandStack(), itemStack2 = player.getOffHandStack();

        boolean isFishingRod = itemStack.isIn(Tags.FISHING_RODS), isFishingRod2 = itemStack2.isIn(Tags.FISHING_RODS);

        if (!player.isRemoved() && player.isAlive() && (isFishingRod || isFishingRod2)) {
            cir.setReturnValue(false);
        }
    }
}
