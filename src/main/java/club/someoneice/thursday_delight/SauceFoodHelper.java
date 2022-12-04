package club.someoneice.thursday_delight;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class SauceFoodHelper extends Item {
    private Sauce sauce;
    public SauceFoodHelper(Properties properties, Sauce sauce) {
        super(properties);
        this.sauce = sauce;
    }

    @Override
    public ItemStack finishUsingItem(ItemStack itemStack, Level world, LivingEntity player) {
        if (player instanceof Player) {
            player.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 20 * 30, 0));
            switch (sauce) {
                case TOMATO_SAUCE -> {
                    player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 20 * 30, 0));
                }

                case SWEET_CHILI_SAUCE -> {
                    player.addEffect(new MobEffectInstance(MobEffects.JUMP, 20 * 30, 0));
                }

                case CHILI_SAUCE -> {
                    player.addEffect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 20 * 60, 0));
                }
            }
        }
        return super.finishUsingItem(itemStack, world, player);
    }

    public enum Sauce {
        TOMATO_SAUCE,
        SWEET_CHILI_SAUCE,
        CHILI_SAUCE
    }
}
