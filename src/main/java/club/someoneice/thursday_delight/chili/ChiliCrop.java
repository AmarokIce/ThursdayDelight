package club.someoneice.thursday_delight.chili;

import javax.annotation.Nullable;

import club.someoneice.thursday_delight.ItemList;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;
import vectorwing.farmersdelight.common.registry.ModSounds;

public class ChiliCrop extends CropBlock {

    public ChiliCrop() {
        super(BlockBehaviour.Properties.of(Material.PLANT).noCollission().sound(SoundType.CROP));
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return ItemList.Chili.get();
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (this.isMaxAge(state)) {
            // player.getInventory().add(new ItemStack(ItemList.Chili.get(), new Random().nextInt(1, 3)));
			popResource(level, pos, new ItemStack(ItemList.Chili.get(), level.random.nextInt(1, 3)));
            level.playSound(null, pos, ModSounds.ITEM_TOMATO_PICK_FROM_BUSH.get(), SoundSource.BLOCKS, 1.0F, 0.8F + level.random.nextFloat() * 0.4F);
            level.setBlock(pos, state.setValue(this.getAgeProperty(), 0), 2);
            return InteractionResult.SUCCESS;
        } else {
            return InteractionResult.FAIL;
        }
    }

    @Override
	public void playerDestroy(Level level, Player player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack stack) {
		super.playerDestroy(level, player, pos, state, blockEntity, stack);
        int num = 1;
		if (this.isMaxAge(state)) {
			num += level.random.nextInt(1, 3);
		}
        popResource(level, pos, new ItemStack(ItemList.Chili.get(), num));
	}

}
