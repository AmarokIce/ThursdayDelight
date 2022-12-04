package club.someoneice.thursday_delight.dinner_package;

import club.someoneice.thursday_delight.BlockEntityList;
import club.someoneice.thursday_delight.tool.ItemStackHandlerMod;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;


public class DinnerPackageTileEntity extends BaseContainerBlockEntity implements WorldlyContainer, Container {
    private final ItemStackHandlerMod itemList = new ItemStackHandlerMod(3);
    public DinnerPackageTileEntity(BlockPos pos, BlockState state) {
        super(BlockEntityList.DinnerItem.get(), pos, state);
    }

    @Override
    public int getContainerSize() {
        return this.itemList.getItems().size();
    }

    @Override
    public boolean isEmpty() {
        return itemList.getItems().isEmpty();
    }

    @Override
    public ItemStack getItem(int i) {
        return itemList.getItems().get(i);
    }

    @Override
    public ItemStack removeItem(int p_18942_, int p_18943_) {
        return null;
    }

    @Override
    public ItemStack removeItemNoUpdate(int p_18951_) {
        return null;
    }

    @Override
    public void setItem(int i, ItemStack item) {
        this.itemList.getItems().set(i, item);
    }

    @Override
    public void setChanged() {

    }

    @Override
    public boolean stillValid(Player player) {
        return false;
    }

    @Override
    public void load(CompoundTag compoundTag) {
        super.load(compoundTag);
        this.loadFromTag(compoundTag);
    }

    protected void saveAdditional(CompoundTag compoundTag) {
        ContainerHelper.saveAllItems(compoundTag, this.itemList.getItems(), false);
        super.saveAdditional(compoundTag);
    }

    @Override
    protected Component getDefaultName() {
        return null;
    }

    @Override
    protected AbstractContainerMenu createMenu(int p_58627_, Inventory p_58628_) {
        return null;
    }

    public void loadFromTag(CompoundTag compoundTag) {
        this.itemList.setItems(NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY));
        ContainerHelper.loadAllItems(compoundTag, this.itemList.getItems());
    }

    public CompoundTag saveToTag(CompoundTag compoundTag) {
        ContainerHelper.saveAllItems(compoundTag, this.itemList.getItems(), false);
        return compoundTag;
    }

    @Override
    public int[] getSlotsForFace(Direction direction) {
        return new int[3];
    }

    @Override
    public boolean canPlaceItemThroughFace(int p_19235_, ItemStack p_19236_, @Nullable Direction p_19237_) {
        return false;
    }

    @Override
    public boolean canTakeItemThroughFace(int p_19239_, ItemStack p_19240_, Direction p_19241_) {
        return false;
    }

    @Override
    public void clearContent() {

    }
}