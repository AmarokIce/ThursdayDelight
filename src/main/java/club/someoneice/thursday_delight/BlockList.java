package club.someoneice.thursday_delight;

import club.someoneice.thursday_delight.chili.ChiliCrop;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.block.PieBlock;

public class BlockList {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ThursdayMain.MODID);

    public static final RegistryObject<Block> CHIZZEA = BLOCKS.register("chizza", () -> new PieBlock(Properties.of(Material.CAKE) , null));
    public static final RegistryObject<Block> ChilliCrop = BLOCKS.register("chili", ChiliCrop::new);
    public static final RegistryObject<Block> DinnerPackageBlock = BLOCKS.register("dinner_package", club.someoneice.thursday_delight.dinner_package.DinnerPackageBlock::new);

    public static final RegistryObject<Item> DinnerPackage = ItemList.ITEMS.register("dinner_package", () -> new BlockItem(DinnerPackageBlock.get(), new Item.Properties().tab(ThursdayMain.TAB)));

}
