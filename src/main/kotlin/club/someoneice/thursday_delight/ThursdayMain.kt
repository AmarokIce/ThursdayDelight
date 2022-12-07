package club.someoneice.thursday_delight

// import club.someoneice.thursday_delight.client.Screens

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder
import net.minecraft.item.ItemGroup
import net.minecraft.item.ItemStack
import net.minecraft.item.Items
import net.minecraft.util.Identifier


object ThursdayMain {
    const val modid: String = "thursday_delight"
    val thursdayGroup: ItemGroup = FabricItemGroupBuilder.build(Identifier(modid, "thursday_group")) {
        ItemStack(Items.COOKED_CHICKEN)
    }
}

@Suppress("unused")
fun init() {
    println("Now install Thursday Delight!")
    RegisterInit.init()
    RegistryEntityHelper.init()

    // Why I use it?
    // Screens.init()
}

