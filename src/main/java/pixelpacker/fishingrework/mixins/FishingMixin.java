package pixelpacker.fishingrework.mixins;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FishingBobberEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import pixelpacker.fishingrework.loot.crates.CrateLootTables;
import pixelpacker.fishingrework.registers.Tags;

import java.util.List;
import java.util.Random;

@Mixin(FishingBobberEntity.class)
public abstract class FishingMixin {
    private static final Random random = new Random();
    @Shadow @Nullable public abstract PlayerEntity getPlayerOwner();

    @Inject(method = "use", at = @At(value = "RETURN", target = "Lnet/minecraft/entity/projectile/FishingBobberEntity;use(Lnet/minecraft/item/ItemStack;)I"))
    public void use(ItemStack usedItem, CallbackInfoReturnable<Integer> cir) {
        //Check return value of bobber, 0 = no fish, 1 = fish, 2 = entity
        //Injects on returns to check status of bobber instead of head
        if(cir.getReturnValue() == 1){
            PlayerEntity player = this.getPlayerOwner();
            int luckOfTheSeaLevel = EnchantmentHelper.getLuckOfTheSea(usedItem);
            if (player != null && random.nextInt(100) <= (90 - luckOfTheSeaLevel)){
                if(player.getMainHandStack().isIn(Tags.FISHING_RODS)){
                    //Checks tier of fishing rod, makes it able to get different crates depending on tier of fishing rod
                    //TODO: Implement non basic crates, all tiers get same crate loot table
                    if(player.getMainHandStack().isIn(Tags.TIER_1_FISHING_RODS)){
                        List<Item> cratesTable = CrateLootTables.BasicCrateTable;
                        int amountOfCrates = cratesTable.size();
                        int chosenCrate = random.nextInt((amountOfCrates));
                        player.getInventory().insertStack(new ItemStack(cratesTable.get(chosenCrate)));

                    } else if (player.getMainHandStack().isIn(Tags.TIER_2_FISHING_RODS)) {
                        List<Item> cratesTable = CrateLootTables.BasicCrateTable;
                        int amountOfCrates = cratesTable.size();
                        int chosenCrate = random.nextInt((amountOfCrates));
                        player.getInventory().insertStack(new ItemStack(cratesTable.get(chosenCrate)));

                    } else if (player.getMainHandStack().isIn(Tags.TIER_3_FISHING_RODS)) {
                        List<Item> cratesTable = CrateLootTables.BasicCrateTable;
                        int amountOfCrates = cratesTable.size();
                        int chosenCrate = random.nextInt((amountOfCrates));
                        player.getInventory().insertStack(new ItemStack(cratesTable.get(chosenCrate)));

                    } else if (player.getMainHandStack().isIn(Tags.TIER_4_FISHING_RODS)) {
                        List<Item> cratesTable = CrateLootTables.BasicCrateTable;
                        int amountOfCrates = cratesTable.size();
                        int chosenCrate = random.nextInt((amountOfCrates));
                        player.getInventory().insertStack(new ItemStack(cratesTable.get(chosenCrate)));

                    } else{
                        //Backup in case there is another mod's fishing rod that isn't included in the tags
                        List<Item> cratesTable = CrateLootTables.BasicCrateTable;
                        int amountOfCrates = cratesTable.size();
                        int chosenCrate = random.nextInt((amountOfCrates));
                        player.getInventory().insertStack(new ItemStack(cratesTable.get(chosenCrate)));

                    }
                }
            }
        }
    }
}
