package club.someoneice.thursday_delight

import club.someoneice.thursday_delight.FoodWithSauceBase.Sauce
import club.someoneice.thursday_delight.chili.Chili
import club.someoneice.thursday_delight.chili.ChiliCrop
import club.someoneice.thursday_delight.dinner_package.DinnerPackage
import com.nhoryzon.mc.farmersdelight.block.PieBlock
import net.fabricmc.api.EnvType
import net.fabricmc.api.Environment
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap
import net.minecraft.block.Block
import net.minecraft.client.render.RenderLayer
import net.minecraft.item.*
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry

public object RegisterInit {
    fun init() {
        registerRenderLayer()
    }

    val SweetChilliSauce: Item = RegisterInit.RegistryItem("sweet_chilli_sauce", ItemSauces())
    val ChilliSauce : Item = RegisterInit.RegistryItem("chilli_sauce", ItemSauces())

    val AppleJam : Item = RegisterInit.RegistryItem("apple_jam", ItemSauces())
    val BerryJam : Item = RegisterInit.RegistryItem("berry_jam", ItemSauces())
    val MalenJam : Item = RegisterInit.RegistryItem("melon_jam", ItemSauces())
    val CocoJam : Item = RegisterInit.RegistryItem("coco_jam", ItemSauces())

    val AppleSundae : Item = RegisterInit.RegistryItem("apple_sundae", ItemFoods(4, 0.4f, false, true, true, true))
    val BerrySundae : Item = RegisterInit.RegistryItem("berry_sundae", ItemFoods(4, 0.4f, false, true, true, true))
    val MalenSundae : Item = RegisterInit.RegistryItem("melon_sundae", ItemFoods(4, 0.4f, false, true, true, true))
    val CocoSundae : Item = RegisterInit.RegistryItem("coco_sundae", ItemFoods(4, 0.4f, false, true, true, true))

    val ApplePie : Item = RegisterInit.RegistryItem("apple_pie", ItemFoods(4, 0.4f))

    /* *Sauce food* */
    val FrenchFriesWithTomatoSauce  : Item = RegisterInit.RegistryItem("french_fries_with_tomatosauce", ItemTomatoSauceFoods(6, 0.2f, false))
    val OriginalWithTomatoSauce     : Item = RegisterInit.RegistryItem("original_with_tomatosauce",     ItemTomatoSauceFoods(10, 1.6f, false))
    val NuggetsWithTomatoSauce      : Item = RegisterInit.RegistryItem("nuggets_with_tomatosauce",      ItemTomatoSauceFoods(4, 0.2f, true))
    val PotatoPieWithTomatoSauce    : Item = RegisterInit.RegistryItem("potato_pie_with_tomatosauce",   ItemTomatoSauceFoods(6, 0.8f, false))
    val PaNiNiWithTomatoSauce       : Item = RegisterInit.RegistryItem("panini_with_tomatosauce",       ItemTomatoSauceFoods(2, 0.2f, false))
    val SausageWithTomatoSauce      : Item = RegisterInit.RegistryItem("sausage_with_tomatosauce",      ItemTomatoSauceFoods(6, 0.2f, false))

    val FrenchFriesWithSweetChilliSauce  : Item = RegisterInit.RegistryItem("french_fries_with_sweetchillisauce", ItemSweetChilliSauceFoods(6, 0.2f, false))
    val OriginalWithSweetChilliSauce     : Item = RegisterInit.RegistryItem("original_with_sweetchillisauce",     ItemSweetChilliSauceFoods(10, 1.6f, false))
    val NuggetsWithSweetChilliSauce      : Item = RegisterInit.RegistryItem("nuggets_with_sweetchillisauce",      ItemSweetChilliSauceFoods(4, 0.2f, true))
    val PotatoPieWithSweetChilliSauce    : Item = RegisterInit.RegistryItem("potato_pie_with_sweetchillisauce",   ItemSweetChilliSauceFoods(6, 0.8f, false))
    val PaNiNiWithSweetChilliSauce       : Item = RegisterInit.RegistryItem("panini_with_sweetchillisauce",       ItemSweetChilliSauceFoods(2, 0.2f, false))
    val SausageWithSweetChilliSauce      : Item = RegisterInit.RegistryItem("sausage_with_sweetchillisauce",      ItemSweetChilliSauceFoods(6, 0.2f, false))

    val FrenchFriesWithChilliSauce  : Item = RegisterInit.RegistryItem("french_fries_with_chillisauce", ItemChilliSauceFoods(6, 0.2f, false))
    val OriginalWithChilliSauce     : Item = RegisterInit.RegistryItem("original_with_chillisauce",     ItemChilliSauceFoods(10, 1.6f, false))
    val NuggetsWithChilliSauce      : Item = RegisterInit.RegistryItem("nuggets_with_chillisauce",      ItemChilliSauceFoods(4, 0.2f, true))
    val PotatoPieWithChilliSauce    : Item = RegisterInit.RegistryItem("potato_pie_with_chillisauce",   ItemChilliSauceFoods(6, 0.8f, false))
    val PaNiNiWithChilliSauce       : Item = RegisterInit.RegistryItem("panini_with_chillisauce",       ItemChilliSauceFoods(2, 0.2f, false))
    val SausageWithChilliSauce      : Item = RegisterInit.RegistryItem("sausage_with_chillisauce",      ItemChilliSauceFoods(6, 0.2f, false))

    /* KRices */
    val ChickenKRice : Item = RegisterInit.RegistryItem("chicken_k", KRice(12, 1.0f))
    val BraisedKRice : Item = RegisterInit.RegistryItem("braised_k", KRice(12, 1.0f))

    /* Other */
    val MushSoup : Item = RegisterInit.RegistryItem("mush_soup", ItemFoods(8, 0.5f, false, false, true, true, ItemStack(Items.BOWL)))
    val Salad : Item = RegisterInit.RegistryItem("chicken_salad", ItemFoods(8, 0.7f, true, false, false, false, ItemStack(Items.BOWL)))
    val ChiliMeatFrenchFries : Item = RegisterInit.RegistryItem("chili_french_fries", ItemFoods(6, 0.2f))
    val TenderBeef : Item = RegisterInit.RegistryItem("tender_beef", ItemFoods(8, 0.6f))
    val ChickenTako : Item = RegisterInit.RegistryItem("chicken_tako", ItemFoods(8, 0.6f))
    val TooBigChicken : Item = RegisterInit.RegistryItem("big_chicken", ItemFoods(8, 0.6f))
    val StarStar : Item = RegisterInit.RegistryItem("golden_star", ItemFoods(2, 0.1f, true, true, true, false))

    val ChiliCrop : Block = RegisterInit.RegistryBlock("chili", ChiliCrop())
    val Chili : Item = RegisterInit.RegistryItem("chili", Chili())

    val CHIZZA : Block = RegisterInit.RegistryBlock("chizza", PieBlock(Items.AIR))
    val CHIZZA_Item : Item = RegisterInit.RegistryItem("chizza", BlockItem(CHIZZA, Item.Settings().group(ThursdayMain.thursdayGroup)))

    /* Dinner Package */
    public val DinnerPackage : Block = RegisterInit.RegistryBlock("dinner_package", DinnerPackage())
    public val DinnerPackageItem : Item = RegisterInit.RegistryItem("dinner_package", BlockItem(DinnerPackage, Item.Settings().group(ThursdayMain.thursdayGroup)))


    private fun ItemItems(): Item {
        return Item(Item.Settings().group(ThursdayMain.thursdayGroup))
    }

    private fun ItemSauces(): Item {
        val set: Item.Settings = Item.Settings()
        val build: FoodComponent.Builder = FoodComponent.Builder()
        build.hunger(1).saturationModifier(0.1F).snack().alwaysEdible()
        set.food(build.build()).maxCount(1).recipeRemainder(Items.BOWL).group(ThursdayMain.thursdayGroup)

        return DrinkHelper(set, true, ItemStack(Items.BOWL))
    }

    private fun ItemFoods(hunger: Int, saturation: Float, wolf: Boolean, fast: Boolean, alwaysEat: Boolean, isDrink: Boolean, returnItem: ItemStack?): Item {
        val set: Item.Settings = Item.Settings()
        val build: FoodComponent.Builder = FoodComponent.Builder()
        set.group(ThursdayMain.thursdayGroup)
        build.hunger(hunger)
        build.saturationModifier(saturation)
        if (wolf) build.meat()
        if (fast) build.snack()
        if (alwaysEat) build.alwaysEdible()
        set.food(build.build())
        if (isDrink) set.maxCount(1)

        return DrinkHelper(set, isDrink, returnItem)
    }

    private fun ItemFoods(hunger: Int, saturation: Float, wolf: Boolean, fast: Boolean, alwaysEat: Boolean, isDrink: Boolean): Item {
        return ItemFoods(hunger, saturation, wolf, fast, alwaysEat, isDrink, null)
    }

    private fun ItemFoods(hunger: Int, saturation: Float): Item {
        return ItemFoods(hunger, saturation, false, false, false, false)
    }

    private fun KRice(hunger: Int, saturation: Float): Item {
        return ItemFoods(hunger, saturation, false, false, false, false, ItemStack(Items.BOWL))
    }

    private fun ItemSauceFoods(hunger: Int, saturation: Float, fast: Boolean, alwaysEat: Boolean, sauce: Sauce): Item {
        val set: Item.Settings = Item.Settings()
        val build: FoodComponent.Builder = FoodComponent.Builder()
        set.group(ThursdayMain.thursdayGroup)
        build.hunger(hunger)
        build.saturationModifier(saturation)
        if (fast) build.snack()
        if (alwaysEat) build.alwaysEdible()
        set.food(build.build())

        return FoodWithSauceBase(set, sauce)
    }

    private fun ItemTomatoSauceFoods(hunger: Int, saturation: Float, fast: Boolean): Item {
        return ItemSauceFoods(hunger, saturation, fast, true, Sauce.TomatoSauce)
    }

    private fun ItemChilliSauceFoods(hunger: Int, saturation: Float, fast: Boolean): Item {
        return ItemSauceFoods(hunger, saturation, fast, true, Sauce.ChilliSauce)
    }

    private fun ItemSweetChilliSauceFoods(hunger: Int, saturation: Float, fast: Boolean): Item {
        return ItemSauceFoods(hunger, saturation, fast, true, Sauce.SweetChilliSauce)
    }

    @Environment(EnvType.CLIENT)
    fun registerRenderLayer() {
        BlockRenderLayerMap.INSTANCE.putBlock(ChiliCrop, RenderLayer.getCutout())
    }
}

/* Registry item in auto and output item. */
fun RegisterInit.RegistryItem(name: String, itemListItem: Item): Item {
    Registry.register(Registry.ITEM, Identifier(ThursdayMain.modid, name), itemListItem)
    return itemListItem
}

fun RegisterInit.RegistryBlock(name: String, itemListBlock: Block): Block {
    Registry.register(Registry.BLOCK, Identifier(ThursdayMain.modid, name), itemListBlock)
    return itemListBlock
}

