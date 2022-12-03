package club.someoneice.thursday_delight

import net.minecraft.entity.LivingEntity
import net.minecraft.entity.effect.StatusEffectInstance
import net.minecraft.entity.effect.StatusEffects
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.world.World

class FoodWithSauceBase(set: Settings, sauce: Sauce): Item(set) {
    private val sauce: Sauce = sauce

    override fun finishUsing(stack: ItemStack?, world: World?, user: LivingEntity?): ItemStack {
        if (user is PlayerEntity) {
            user.addStatusEffect(StatusEffectInstance(StatusEffects.REGENERATION, 20 * 30, 0))
            when (sauce) {
                Sauce.TomatoSauce       -> user.addStatusEffect(StatusEffectInstance(StatusEffects.SPEED, 20 * 30, 0))
                Sauce.SweetChilliSauce  -> user.addStatusEffect(StatusEffectInstance(StatusEffects.JUMP_BOOST, 20 * 30, 0))
                Sauce.ChilliSauce       -> user.addStatusEffect(StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 20 * 60, 0))
            }
        }

        return super.finishUsing(stack, world, user)
    }

    enum class Sauce {
        TomatoSauce,
        SweetChilliSauce,
        ChilliSauce
    }
}

