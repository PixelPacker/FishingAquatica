package pixelpacker.fishingrework.mixins;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FishingBobberEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tag.TagKey;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import pixelpacker.fishingrework.loot.crates.CrateLootTables;
import pixelpacker.fishingrework.registers.Tags;
import pixelpacker.fishingrework.util.LootTableGenerator;

import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

@Mixin(FishingBobberEntity.class)
public abstract class FishingMixin {
    private static Random rand = LootTableGenerator.random;
    @Shadow @Nullable public abstract PlayerEntity getPlayerOwner();

    @Inject(method = "use", at = @At(value = "RETURN", target = "Lnet/minecraft/entity/projectile/FishingBobberEntity;use(Lnet/minecraft/item/ItemStack;)I"))
    public void use(ItemStack usedItem, CallbackInfoReturnable<Integer> cir) {
        //Check return value of bobber, 0 = no fish, 1 = fish, 2 = entity
        //Injects on returns to check status of bobber instead of head
        if (cir.getReturnValue() != 1) {
            return;
        }
        PlayerEntity player = this.getPlayerOwner();

        int luckOfTheSeaLevel = EnchantmentHelper.getLuckOfTheSea(usedItem);

        if (player == null || LootTableGenerator.random.nextInt(100) >= (10 + luckOfTheSeaLevel)) {
            return;
        }

        //Checks tier of fishing rod, makes it able to get different crates depending on tier of fishing rod
        List<Item> cratesTableMainHand = getCrateTier(player.getMainHandStack());
        List<Item> cratesTableOffHand = getCrateTier(player.getOffHandStack());
        List<Item> cratesTable = cratesTableMainHand;
        //Used to check if the fishing rod tier of offhand because there shouldn't be any other way to have a successful fish without it being in offhand
        //In case the fishing rod is not tagged (E.g from another mod) it will provide a tier 1 crate
        if(cratesTableMainHand == null) {
            if(cratesTableOffHand != null){
                cratesTable = cratesTableOffHand;
            }else{
                cratesTable = CrateLootTables.TierOneCrates;
            }
        }
        int amountOfCrates = cratesTable.size();
        int chosenCrate = LootTableGenerator.random.nextInt(amountOfCrates);
        player.getInventory().insertStack(new ItemStack(cratesTable.get(chosenCrate)));
    }

    public List<Item> getCrateTier(ItemStack item) {
        if (item.isIn(Tags.TIER_1_FISHING_RODS)) {
            return CrateLootTables.TierOneCrates;
        } else if (item.isIn(Tags.TIER_2_FISHING_RODS)) {
            return CrateLootTables.TierTwoCrates;
        } else if (item.isIn(Tags.TIER_3_FISHING_RODS)) {
            return CrateLootTables.TierThreeCrates;
        } else if (item.isIn(Tags.TIER_4_FISHING_RODS)) {
            return CrateLootTables.TierFourCrates;
        } else {
            return null;
        }
    }
}
