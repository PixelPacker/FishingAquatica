package pixelpacker.fishingrework.mixins;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.client.render.entity.FishingBobberEntityRenderer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import pixelpacker.fishingrework.registers.ItemRegister;

@Mixin(FishingBobberEntityRenderer.class)
public class FishingBobberRendererMixin {
    @WrapOperation(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;isOf(Lnet/minecraft/item/Item;)Z"))
    private boolean fishingRodHand(ItemStack instance, Item item, Operation<Boolean> original){
        return original.call(instance, item) || instance.isOf(ItemRegister.GOLD_FISHING_ROD) || instance.isOf(ItemRegister.IRON_FISHING_ROD) || instance.isOf(ItemRegister.DIAMOND_FISHING_ROD) || instance.isOf(ItemRegister.NETHERITE_FISHING_ROD);
    }
}