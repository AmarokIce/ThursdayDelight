package club.someoneice.thursday_delight.dinner_package;

import club.someoneice.thursday_delight.BlockEntityList;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.wrapper.InvWrapper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;


public class DinnerPackageTileEntity extends BlockEntity {
    private final SimpleContainer itemList = new SimpleContainer(3);
    private final LazyOptional<IItemHandler> handler = LazyOptional.of(() -> new InvWrapper(itemList));
    public DinnerPackageTileEntity(BlockPos pos, BlockState state) {
        super(BlockEntityList.DinnerItem.get(), pos, state);
    }

    @SuppressWarnings("all")
    @Override
    public void load(CompoundTag compoundTag) {
        super.load(compoundTag);
        itemList.fromTag((ListTag) compoundTag.get("contents"));
    }

    protected void saveAdditional(CompoundTag compoundTag) {
        compoundTag.put("contents",itemList.createTag());
        super.saveAdditional(compoundTag);
    }

    public ListTag createItemListTag(){
        return itemList.createTag();
    }

    public boolean isItemListEmpty(){
        return itemList.isEmpty();
    }

    public void loadItemListFromTag(ListTag tag){
        itemList.fromTag(tag);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        handler.invalidate();
    }

    @NotNull
    @Override
    public <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if(cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
            return handler.cast();
        return super.getCapability(cap, side);
    }
}