package club.someoneice.thursday_delight;

import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

import javax.annotation.Nonnull;
import java.util.stream.Collectors;

@Mod(ThursdayMain.MODID)
public class ThursdayMain {
    public static final String MODID = "thursday_delight";
    private static final Logger LOGGER = LogUtils.getLogger();

    public static final CreativeModeTab TAB = new CreativeModeTab("pineapple") {
        @Nonnull @Override
        public ItemStack makeIcon() {
            return new ItemStack(Items.COOKED_CHICKEN);
        }
    };

    public ThursdayMain() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        ItemList.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BlockList.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BlockEntityList.BLOCKENTITY.register(FMLJavaModLoadingContext.get().getModEventBus());

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }
}
