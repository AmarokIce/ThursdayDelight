package club.someoneice.thursday_delight.dinner_package;

import club.someoneice.thursday_delight.BlockList;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
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
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.items.CapabilityItemHandler;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.List;


public class DinnerPackageBlock extends Block implements EntityBlock {

    public DinnerPackageBlock() {
        super(BlockBehaviour.Properties.of(Material.PLANT).sound(SoundType.GLASS).noOcclusion());
    }

    @Override
    public InteractionResult use(BlockState blockState, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (!level.isClientSide()) {
            var itemCap = level.getBlockEntity(pos).getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY);
            itemCap.ifPresent(cap->{
                var holdItem = player.getItemInHand(InteractionHand.MAIN_HAND);
                if (!holdItem.isEmpty()) {
                    var result = holdItem.copy();
                    for (int i = 0; i < 3; i ++) {
                        result = cap.insertItem(i,result,false);
                        if (result.isEmpty()) break;
                    }
                    if(result.isEmpty() || result.getCount()!=holdItem.getCount())
                        player.setItemInHand(InteractionHand.MAIN_HAND,result);
                    else{
                        player.sendMessage(new TextComponent("打包袋中有："), player.getUUID());
                        for (int i = 0; i < 3; i ++) {
                            var item = cap.getStackInSlot(i);
                            if (!item.isEmpty()) {
                                player.sendMessage(item.getDisplayName(), player.getUUID());
                            }
                        }
                    }
                } else {
                    if (player.isShiftKeyDown()) {
                        player.sendMessage(new TextComponent("打包袋中有："), player.getUUID());
                        for (int i = 0; i < 3; i ++) {
                            var item = cap.getStackInSlot(i);
                            if (!item.isEmpty()) {
                                player.sendMessage(item.getDisplayName(), player.getUUID());
                            }
                        }
                    } else {
                        for (int i = 0; i < 3; i ++) {
                            var item = cap.getStackInSlot(i);
                            if (!item.isEmpty()) {
                                var extracted = cap.extractItem(i,item.getCount(), false);
                                player.setItemInHand(InteractionHand.MAIN_HAND, extracted);
                                break;
                            }
                        }
                    }
                }
            });
        }
        return InteractionResult.SUCCESS;
    }

    @Override
    public List<ItemStack> getDrops(BlockState blockState, LootContext.Builder builder) {
        var ret = BlockList.DinnerPackage.get().getDefaultInstance();
        BlockEntity blockentity = builder.getOptionalParameter(LootContextParams.BLOCK_ENTITY);
        if(blockentity instanceof DinnerPackageBlockEntity dinnerPackageBlockEntity){
            if(!dinnerPackageBlockEntity.isItemListEmpty()){
                var tag = ret.getOrCreateTag();
                tag.put("contents", dinnerPackageBlockEntity.createItemListTag());
            }
        }
        return Collections.singletonList(ret);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new DinnerPackageBlockEntity(blockPos, blockState);
    }

    @Override
    public void setPlacedBy(Level level, BlockPos blockPos, BlockState blockState, @Nullable LivingEntity livingEntity, ItemStack itemStack) {
        var tag = itemStack.getOrCreateTag();
        if(tag.contains("contents")){
            BlockEntity blockentity = level.getBlockEntity(blockPos);
            if(blockentity instanceof DinnerPackageBlockEntity dinnerPackageBlockEntity){
                dinnerPackageBlockEntity.loadItemListFromTag((ListTag) tag.get("contents"));
            }
        }

    }
}
