package club.someoneice.thursday_delight.chili;

import club.someoneice.thursday_delight.BlockList;
import club.someoneice.thursday_delight.ThursdayMain;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class Chili extends BlockItem {
    public Chili() {
        super(BlockList.ChiliCrop.get() ,new Properties().tab(ThursdayMain.TAB).food(new FoodProperties.Builder().nutrition(2).saturationMod(0.1f).fast().alwaysEat().build()).fireResistant());
    }

    @Override
    public ItemStack finishUsingItem(ItemStack itemStack, Level world, LivingEntity player) {
        player.setRemainingFireTicks(20 * 3);
        return super.finishUsingItem(itemStack, world, player);
    }
}
