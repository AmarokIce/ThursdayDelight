package club.someoneice.thursday_delight.tool;

import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nonnull;

/**
* Code By Dragon
*/
public class ItemStackHandlerMod extends ItemStackHandler {

    public ItemStackHandlerMod(int itemSize) {
        super(itemSize);
    }

    public NonNullList<ItemStack> getItems() {
        return this.stacks;
    }

    public void setItems(NonNullList<ItemStack> data) {
        this.stacks = data;
    }

    protected void onContentsChanged(int slot)
    {

    }

}
