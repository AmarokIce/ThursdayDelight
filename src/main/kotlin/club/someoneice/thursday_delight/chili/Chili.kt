package club.someoneice.thursday_delight.chili

import club.someoneice.thursday_delight.RegisterInit
import club.someoneice.thursday_delight.ThursdayMain
import net.minecraft.entity.LivingEntity
import net.minecraft.item.BlockItem
import net.minecraft.item.FoodComponent
import net.minecraft.item.ItemStack
import net.minecraft.world.World

class Chili: BlockItem(RegisterInit.ChiliCrop ,Settings().group(ThursdayMain.thursdayGroup).food(FoodComponent.Builder().hunger(2).saturationModifier(0.1f).snack().alwaysEdible().build()).fireproof()) {
    override fun finishUsing(stack: ItemStack, world: World, user: LivingEntity): ItemStack {
        user.fireTicks = 20 * 3
        return super.finishUsing(stack, world, user)
    }
}