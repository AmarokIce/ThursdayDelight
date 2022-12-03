package club.someoneice.thursday_delight.daata

import club.someoneice.thursday_delight.RegisterInit
import com.nhoryzon.mc.farmersdelight.registry.ItemsRegistry
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.item.Items

class DataGenerator {
    companion object {
        val ItemList = ArrayList<Item>()
    }

    fun init() {
        for (i in ItemList) {
            IconDataHelper.ItemIconData(i)
        }

        RecipesDataHelper.craftingShapeless(ItemStack(RegisterInit.AppleSundae), arrayOf(ItemUtil.getItemByName("with_thursday", "sundae"), RegisterInit.AppleJam))
        RecipesDataHelper.craftingShapeless(ItemStack(RegisterInit.BerrySundae), arrayOf(ItemUtil.getItemByName("with_thursday", "sundae"), RegisterInit.BerrySundae))
        RecipesDataHelper.craftingShapeless(ItemStack(RegisterInit.CocoSundae), arrayOf(ItemUtil.getItemByName("with_thursday", "sundae"), RegisterInit.CocoJam))
        RecipesDataHelper.craftingShapeless(ItemStack(RegisterInit.MalenSundae), arrayOf(ItemUtil.getItemByName("with_thursday", "sundae"), RegisterInit.MalenJam))

        RecipesDataHelper.craftingShapeless(ItemStack(RegisterInit.FrenchFriesWithTomatoSauce), arrayOf(ItemsRegistry.TOMATO_SAUCE, ItemUtil.getItemByName("with_thursday", "french_fries")))
        RecipesDataHelper.craftingShapeless(ItemStack(RegisterInit.NuggetsWithTomatoSauce), arrayOf(ItemsRegistry.TOMATO_SAUCE, ItemUtil.getItemByName("with_thursday", "chicken_nugget")))
        RecipesDataHelper.craftingShapeless(ItemStack(RegisterInit.OriginalWithTomatoSauce), arrayOf(ItemsRegistry.TOMATO_SAUCE, ItemUtil.getItemByName("with_thursday", "original_recipe")))
        RecipesDataHelper.craftingShapeless(ItemStack(RegisterInit.PaNiNiWithTomatoSauce), arrayOf(ItemsRegistry.TOMATO_SAUCE, ItemUtil.getItemByName("with_thursday", "pnn_bread")))
        RecipesDataHelper.craftingShapeless(ItemStack(RegisterInit.PotatoPieWithTomatoSauce), arrayOf(ItemsRegistry.TOMATO_SAUCE, ItemUtil.getItemByName("with_thursday", "potato_pie")))
        RecipesDataHelper.craftingShapeless(ItemStack(RegisterInit.SausageWithTomatoSauce), arrayOf(ItemsRegistry.TOMATO_SAUCE, ItemUtil.getItemByName("with_thursday", "thuringia_sausage")))

        RecipesDataHelper.craftingShapeless(ItemStack(RegisterInit.FrenchFriesWithSweetChilliSauce), arrayOf(RegisterInit.SweetChilliSauce, ItemUtil.getItemByName("with_thursday", "french_fries")))
        RecipesDataHelper.craftingShapeless(ItemStack(RegisterInit.NuggetsWithSweetChilliSauce), arrayOf(RegisterInit.SweetChilliSauce, ItemUtil.getItemByName("with_thursday", "chicken_nugget")))
        RecipesDataHelper.craftingShapeless(ItemStack(RegisterInit.OriginalWithSweetChilliSauce), arrayOf(RegisterInit.SweetChilliSauce, ItemUtil.getItemByName("with_thursday", "original_recipe")))
        RecipesDataHelper.craftingShapeless(ItemStack(RegisterInit.PaNiNiWithSweetChilliSauce), arrayOf(RegisterInit.SweetChilliSauce, ItemUtil.getItemByName("with_thursday", "pnn_bread")))
        RecipesDataHelper.craftingShapeless(ItemStack(RegisterInit.PotatoPieWithSweetChilliSauce), arrayOf(RegisterInit.SweetChilliSauce, ItemUtil.getItemByName("with_thursday", "potato_pie")))
        RecipesDataHelper.craftingShapeless(ItemStack(RegisterInit.SausageWithSweetChilliSauce), arrayOf(RegisterInit.SweetChilliSauce, ItemUtil.getItemByName("with_thursday", "thuringia_sausage")))

        RecipesDataHelper.craftingShapeless(ItemStack(RegisterInit.FrenchFriesWithChilliSauce), arrayOf(RegisterInit.ChilliSauce, ItemUtil.getItemByName("with_thursday", "french_fries")))
        RecipesDataHelper.craftingShapeless(ItemStack(RegisterInit.NuggetsWithChilliSauce), arrayOf(RegisterInit.ChilliSauce, ItemUtil.getItemByName("with_thursday", "chicken_nugget")))
        RecipesDataHelper.craftingShapeless(ItemStack(RegisterInit.OriginalWithChilliSauce), arrayOf(RegisterInit.ChilliSauce, ItemUtil.getItemByName("with_thursday", "original_recipe")))
        RecipesDataHelper.craftingShapeless(ItemStack(RegisterInit.PaNiNiWithChilliSauce), arrayOf(RegisterInit.ChilliSauce, ItemUtil.getItemByName("with_thursday", "pnn_bread")))
        RecipesDataHelper.craftingShapeless(ItemStack(RegisterInit.PotatoPieWithChilliSauce), arrayOf(RegisterInit.ChilliSauce, ItemUtil.getItemByName("with_thursday", "potato_pie")))
        RecipesDataHelper.craftingShapeless(ItemStack(RegisterInit.SausageWithChilliSauce), arrayOf(RegisterInit.ChilliSauce, ItemUtil.getItemByName("with_thursday", "thuringia_sausage")))

        RecipesDataHelper.craftingShapeless(ItemStack(RegisterInit.Salad), arrayOf(Items.CARROT, Items.POTATO, ItemsRegistry.TOMATO_SAUCE, Items.BOWL, ItemUtil.getItemByName("with_thursday", "cooked_chicken_breast")))
        RecipesDataHelper.craftingShapeless(ItemStack(RegisterInit.ChiliMeatFrenchFries), arrayOf(RegisterInit.ChilliSauce, ItemUtil.getItemByName("with_thursday", "french_fries"), Items.COOKED_PORKCHOP, ItemsRegistry.TOMATO_SAUCE))
        RecipesDataHelper.craftingShapeless(ItemStack(RegisterInit.ChickenTako), arrayOf(RegisterInit.ChilliSauce, ItemUtil.getItemByName("with_thursday", "cooked_chicken_breast"), RegisterInit.TooBigChicken, Items.COOKED_CHICKEN, ItemsRegistry.TOMATO_SAUCE))
        RecipesDataHelper.craftingShapeless(ItemStack(RegisterInit.TooBigChicken), arrayOf(ItemUtil.getItemByName("with_thursday", "cooked_chicken_breast"), ItemUtil.getItemByName("with_thursday", "cooked_chicken_breast"), ItemUtil.getItemByName("with_thursday", "crumbs"), ItemUtil.getItemByName("with_thursday", "crumbs")))
        RecipesDataHelper.craftingShaped(ItemStack(RegisterInit.CHIZZA_Item), arrayOf("CCC", "TTT", "PBP", "C", ItemUtil.getItemByName("with_thursday", "cheese"), "T",ItemsRegistry.TOMATO_SAUCE, "P", Items.CARROT, "B", RegisterInit.TooBigChicken))


        RecipesDataHelper.craftingShaped(ItemStack(RegisterInit.DinnerPackageItem), arrayOf("PLP", "PLP", "PPP", "P", Items.PAPER, "L", Items.LEATHER))
    }
}