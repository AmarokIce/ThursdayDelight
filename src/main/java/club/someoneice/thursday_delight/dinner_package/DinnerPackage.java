package club.someoneice.thursday_delight.dinner_package;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.BlockHitResult;


public class DinnerPackage extends Block implements EntityBlock {
    public static final ResourceLocation CONTENTS = new ResourceLocation("contents");

    public DinnerPackage() {
        super(BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.GLASS).noOcclusion());
    }

    @Override
    public InteractionResult use(BlockState blockState, Level world, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        BlockEntity tileEntity = world.getBlockEntity(pos);
        if (world.isClientSide) {
            return InteractionResult.CONSUME;
        }

        if (tileEntity instanceof DinnerPackageTileEntity) {
            Container entity = (DinnerPackageTileEntity) tileEntity;
            if (!player.getItemInHand(InteractionHand.MAIN_HAND).isEmpty()) {
                for (int i = 0; i < 2; i ++) {
                    if (entity.getItem(i).isEmpty()) {
                        entity.setItem(i, player.getItemInHand(InteractionHand.MAIN_HAND).getContainerItem());
                        player.setItemInHand(InteractionHand.MAIN_HAND, ItemStack.EMPTY);
                        return InteractionResult.SUCCESS;
                    }
                }

                player.sendMessage(new TranslatableComponent("打包袋中有："), player.getUUID());
                for (int i = 0; i < 2; i ++) {
                    if (!entity.getItem(i).isEmpty()) {
                        player.sendMessage(new TextComponent(entity.getItem(i).getDisplayName().getString()), player.getUUID());
                    }
                }

                return InteractionResult.SUCCESS;
            } else {
                if (player.isDescending()) {
                    player.sendMessage(new TranslatableComponent("打包袋中有："), player.getUUID());
                    for (int i = 0; i < 2; i ++) {
                        if (!entity.getItem(i).isEmpty()) {
                            player.sendMessage(new TextComponent(entity.getItem(i).getDisplayName().getString()), player.getUUID());
                        }
                    }

                    return InteractionResult.SUCCESS;
                } else {
                    for (int i = 0; i < 2; i ++) {
                        if (!entity.getItem(i).isEmpty()) {
                            player.setItemInHand(InteractionHand.MAIN_HAND, entity.getItem(i).getContainerItem());
                            entity.setItem(i, ItemStack.EMPTY);
                            return InteractionResult.SUCCESS;
                        }
                    }
                }
            }

            return InteractionResult.FAIL;
        }

        return InteractionResult.FAIL;
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new DinnerPackageTileEntity(blockPos, blockState);
    }
}
