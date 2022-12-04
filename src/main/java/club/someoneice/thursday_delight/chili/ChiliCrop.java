package club.someoneice.thursday_delight.chili;

import club.someoneice.thursday_delight.ItemList;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;

import java.util.Random;

public class ChiliCrop extends CropBlock {
    public ChiliCrop() {
        super(BlockBehaviour.Properties.of(Material.PLANT).noCollission());
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return ItemList.Chili.get();
    }

    @Override
    public InteractionResult use(BlockState blockState, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (this.isMaxAge(blockState)) {
            player.getInventory().add(new ItemStack(ItemList.Chili.get(), new Random().nextInt(1, 3)));
            return InteractionResult.SUCCESS;
        } else {
            return InteractionResult.FAIL;
        }
    }
}
