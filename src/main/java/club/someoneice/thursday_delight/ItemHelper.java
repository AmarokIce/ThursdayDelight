package club.someoneice.thursday_delight;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class ItemHelper extends Item {
    private boolean isDrink;
    private ItemStack returnItem;

    public ItemHelper(Properties properties, boolean isDrink, ItemStack returnItem) {
        super(properties);
        this.isDrink = isDrink;
        this.returnItem = returnItem;
    }

     @Override
     @NotNull
     public UseAnim getUseAnimation(ItemStack itemStack) {
        if (this.isDrink) return UseAnim.DRINK;
        else return UseAnim.EAT;
     }

    @Override
    public ItemStack finishUsingItem(ItemStack itemStack, Level world, LivingEntity player) {
        if (player instanceof Player) {
            if (this.isDrink && this.returnItem == null) {
                return new ItemStack(Items.GLASS_BOTTLE);
            } else if (this.returnItem != null) {
                return this.returnItem;
            }
        }
        return super.finishUsingItem(itemStack, world, player);
    }
}
