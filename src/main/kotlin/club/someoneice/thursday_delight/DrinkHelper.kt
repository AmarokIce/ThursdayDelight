package club.someoneice.thursday_delight

import net.minecraft.entity.LivingEntity
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.item.Items
import net.minecraft.util.UseAction
import net.minecraft.world.World

class DrinkHelper(set: Settings, private val useAction: Boolean, private val returnItem: ItemStack?): Item(set) {
    override fun getUseAction(stack: ItemStack?): UseAction {
        return if (useAction) UseAction.DRINK else UseAction.EAT;
    }

    override fun finishUsing(stack: ItemStack?, world: World?, user: LivingEntity?): ItemStack {
        super.finishUsing(stack, world, user)
        return if (useAction) {
            returnItem ?: ItemStack(Items.GLASS_BOTTLE)
        } else returnItem ?: super.finishUsing(stack, world, user)
    }
}