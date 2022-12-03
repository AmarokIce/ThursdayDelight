package club.someoneice.thursday_delight.chili

import club.someoneice.thursday_delight.RegisterInit
import net.minecraft.block.BlockState
import net.minecraft.block.Blocks
import net.minecraft.block.CropBlock
import net.minecraft.block.Material
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.ItemConvertible
import net.minecraft.item.ItemStack
import net.minecraft.sound.BlockSoundGroup
import net.minecraft.util.ActionResult
import net.minecraft.util.Hand
import net.minecraft.util.hit.BlockHitResult
import net.minecraft.util.math.BlockPos
import net.minecraft.world.BlockView
import net.minecraft.world.World
import java.util.*

class ChiliCrop() : CropBlock(Settings.of(Material.PLANT).strength(0.0f).sounds(BlockSoundGroup.CROP).noCollision()) {
    override fun onUse(state: BlockState, world: World, pos: BlockPos, player: PlayerEntity, hand: Hand, hit: BlockHitResult): ActionResult {
        val i = this.getAge(state)
        if (i >= maxAge) {
            world.setBlockState(pos, withAge(i - 2), 2)
            val itemDrop: Int = Random().nextInt(1, 3)
            player.inventory.offerOrDrop(ItemStack(RegisterInit.Chili, itemDrop))
        }

        return super.onUse(state, world, pos, player, hand, hit)
    }

    override fun canPlantOnTop(floor: BlockState, world: BlockView?, pos: BlockPos?): Boolean {
        return floor.isOf(Blocks.SOUL_SAND) || floor.isOf(Blocks.SOUL_SOIL)
    }

    override fun getSeedsItem(): ItemConvertible {
        return RegisterInit.Chili
    }
}