package pixelpacker.fishingrework.mixins;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FishingBobberEntity;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import pixelpacker.fishingrework.registers.ItemRegister;

@Mixin(FishingBobberEntity.class)
public abstract class FishingBobberInvalidMixin {

    @Inject(method="removeIfInvalid", at = @At(value = "HEAD"), cancellable = true)
    private void removeIfInvalid(PlayerEntity player, CallbackInfoReturnable<Boolean> cir) {
        ItemStack itemStack = player.getMainHandStack(), itemStack2 = player.getOffHandStack();

        boolean gr = itemStack.isOf(ItemRegister.GOLD_FISHING_ROD), gr2 = itemStack2.isOf(ItemRegister.GOLD_FISHING_ROD);
        boolean ir = itemStack.isOf(ItemRegister.IRON_FISHING_ROD), ir2 = itemStack2.isOf(ItemRegister.IRON_FISHING_ROD);
        boolean dr = itemStack.isOf(ItemRegister.DIAMOND_FISHING_ROD), dr2 = itemStack2.isOf(ItemRegister.DIAMOND_FISHING_ROD);
        boolean nr = itemStack.isOf(ItemRegister.NETHERITE_FISHING_ROD), nr2 = itemStack2.isOf(ItemRegister.NETHERITE_FISHING_ROD);

        if (!player.isRemoved() && player.isAlive() && (gr || gr2 || ir || ir2 || dr || dr2 || nr || nr2)) {
            cir.setReturnValue(false);
        }
    }
}
