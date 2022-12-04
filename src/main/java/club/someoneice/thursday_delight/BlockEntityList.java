package club.someoneice.thursday_delight;

import club.someoneice.thursday_delight.dinner_package.DinnerPackageTileEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockEntityList {
    public static final DeferredRegister<BlockEntityType<?>> BLOCKENTITY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, ThursdayMain.MODID);

    public static final RegistryObject<BlockEntityType<DinnerPackageTileEntity>> DinnerItem = BLOCKENTITY.register("dinner_package", () -> BlockEntityType.Builder.of(DinnerPackageTileEntity::new, BlockList.DinnerPackageBlock.get()).build(null));

}
