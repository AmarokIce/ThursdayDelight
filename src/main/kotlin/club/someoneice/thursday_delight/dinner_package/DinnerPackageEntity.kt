package club.someoneice.thursday_delight.dinner_package

import club.someoneice.thursday_delight.ImplementedInventory
import club.someoneice.thursday_delight.RegistryEntityHelper
import net.minecraft.block.BlockState
import net.minecraft.block.entity.BlockEntity
import net.minecraft.inventory.Inventories
import net.minecraft.item.ItemStack
import net.minecraft.nbt.NbtCompound
import net.minecraft.util.collection.DefaultedList
import net.minecraft.util.math.BlockPos


class DinnerPackageEntity(blockPos: BlockPos, blockState: BlockState) : BlockEntity(RegistryEntityHelper.DinnerPackageEntity, blockPos, blockState), ImplementedInventory {
    private var items = DefaultedList.ofSize(3, ItemStack.EMPTY)

    override fun getItems(): DefaultedList<ItemStack> {
        return items
    }

    fun serializeInventory(tag: NbtCompound): NbtCompound {
        Inventories.writeNbt(tag, this.items)
        return tag
    }

    override fun readNbt(nbt: NbtCompound) {
        super.readNbt(nbt)
        Inventories.readNbt(nbt, items)
    }

    override fun writeNbt(nbt: NbtCompound) {
        Inventories.writeNbt(nbt, items)
        return super.writeNbt(nbt)
    }

    override fun markDirty() {
    }
}
