package club.someoneice.thursday_delight;

import club.someoneice.thursday_delight.dinner_package.DinnerPackageEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class RegistryEntityHelper {
    public static BlockEntityType<DinnerPackageEntity> DinnerPackageEntity;

    private static final Block DinnerPackage = RegisterInit.INSTANCE.getDinnerPackage();

    public static void init() {
        DinnerPackageEntity = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(ThursdayMain.modid, "dinner_package"), FabricBlockEntityTypeBuilder.create(DinnerPackageEntity::new, DinnerPackage).build(null));;
    }
}
