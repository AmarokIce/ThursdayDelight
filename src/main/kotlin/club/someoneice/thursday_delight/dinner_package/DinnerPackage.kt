package club.someoneice.thursday_delight.dinner_package

import club.someoneice.thursday_delight.RegisterInit
import net.minecraft.block.Block
import net.minecraft.block.BlockEntityProvider
import net.minecraft.block.BlockState
import net.minecraft.block.Material
import net.minecraft.block.entity.BlockEntity
import net.minecraft.entity.ItemEntity
import net.minecraft.entity.LivingEntity
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.inventory.Inventory
import net.minecraft.item.ItemStack
import net.minecraft.nbt.NbtCompound
import net.minecraft.nbt.NbtElement
import net.minecraft.sound.BlockSoundGroup
import net.minecraft.text.Text
import net.minecraft.text.TranslatableText
import net.minecraft.util.ActionResult
import net.minecraft.util.Hand
import net.minecraft.util.hit.BlockHitResult
import net.minecraft.util.math.BlockPos
import net.minecraft.world.World


class DinnerPackage : Block(Settings.of(Material.PLANT).strength(0.1f).sounds(BlockSoundGroup.GRASS).noCollision()),
    BlockEntityProvider {
    override fun createBlockEntity(pos: BlockPos, state: BlockState): BlockEntity {
        return DinnerPackageEntity(pos, state)
    }

    override fun onPlaced(world: World, blockPos: BlockPos, state: BlockState, placer: LivingEntity?, itemStack: ItemStack) {
        super.onPlaced(world, blockPos, state, placer, itemStack)
        val blockEntity = world.getBlockEntity(blockPos);
        if (blockEntity is DinnerPackageEntity) {
            if (!itemStack.hasNbt()) return
            blockEntity.readNbt(itemStack.getSubNbt("Items"))
        }
    }

    override fun onUse(blockState: BlockState, world: World, blockPos: BlockPos, player: PlayerEntity, hand: Hand, blockHitResult: BlockHitResult): ActionResult {
        val blockEntity = world.getBlockEntity(blockPos)
        if (player.isSpectator) return ActionResult.CONSUME
        if (world.isClient) return ActionResult.SUCCESS

        if (blockEntity is DinnerPackageEntity) {
            val items = blockEntity as Inventory

            if (player.isDescending) {
                player.sendMessage(Text.of("打包袋中有："), false)
                for (i in 0..2) {
                    if (!items.getStack(i).isEmpty) {
                        player.sendMessage(TranslatableText(items.getStack(i).item.translationKey), false)
                    }
                }

                return ActionResult.SUCCESS
            }

            if (!player.getStackInHand(hand).isEmpty && player.getStackInHand(hand).item != RegisterInit.DinnerPackageItem) {
                for (i in 0..2) {
                    if (items.getStack(i).isEmpty) {
                        items.setStack(i, player.getStackInHand(hand).copy())
                        player.getStackInHand(hand).count = 0
                        return ActionResult.SUCCESS
                    }
                }

                player.sendMessage(Text.of("打包袋中有："), false)
                for (i in 0..2) {
                    if (!items.getStack(i).isEmpty) {
                        player.sendMessage(TranslatableText(items.getStack(i).item.translationKey), false)
                    }
                }

                return ActionResult.SUCCESS
            } else {
                for (i in 2 downTo 0) {
                    if (!items.getStack(i).isEmpty) {
                        player.inventory.offerOrDrop(items.getStack(i));
                        items.getStack(i).count = 0
                        return ActionResult.SUCCESS
                    }
                }

            }
        }

        return ActionResult.FAIL
    }

    override fun onBreak(world: World, blockPos: BlockPos, state: BlockState, player: PlayerEntity) {
        super.onBreak(world, blockPos, state, player)
        val blockEntity = world.getBlockEntity(blockPos)
        if (blockEntity is DinnerPackageEntity) {
            val items = ItemStack(RegisterInit.DinnerPackageItem)
            val nbt: NbtElement = blockEntity.serializeInventory(NbtCompound())
            items.setSubNbt("Items", nbt)

            val itemEntity = ItemEntity(world, blockPos.x.toDouble(), blockPos.y.toDouble() + (0.5f.toDouble()) , blockPos.z.toDouble(), items)
            world.spawnEntity(itemEntity)
        }
    }
}