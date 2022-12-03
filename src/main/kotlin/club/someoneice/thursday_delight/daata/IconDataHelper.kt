package club.someoneice.thursday_delight.daata

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.util.Identifier
import net.minecraft.util.registry.Registry
import java.io.BufferedWriter
import java.io.File
import java.nio.file.Files
import java.nio.file.Paths

object IconDataHelper {

    fun ItemIconData(item: Item) {
        ItemIconProcessor(ItemUtil.getModIDByItem(item), ItemUtil.getItemName(item))
    }

    private fun ItemIconProcessor(modid: String, name: String) {
        val basePath = "${System.getProperty("user.dir")}\\ovo\\resources\\assets\\${modid}"

        if (!File("${basePath}\\models\\item").exists()) File("${basePath}\\models\\item").mkdirs()
        if (!File("${basePath}\\textures\\item").exists()) File("${basePath}\\textures\\item").mkdirs()
        File("${basePath}\\models\\item\\${name}.json").createNewFile()

        val BaseMap = HashMap<String, Any>()
        val TexturesMap = HashMap<String, String>()
        BaseMap["parent"] = "item/generated"
        TexturesMap["layer0"] = "${modid}:item/${name}"
        BaseMap["textures"] = TexturesMap

        val gson = GsonBuilder().setPrettyPrinting().create()
        val writer: BufferedWriter = Files.newBufferedWriter(Paths.get("${basePath}\\models\\item\\${name}.json"))
        writer.append(gson.toJson(BaseMap))
        writer.close()
    }
}

object ItemUtil {
    fun getItemByName(modid: String, name: String): String {
        return "${modid}:${name}"
    }

    fun getItemRegistryName(item: Item): String {
        val itemIde: Identifier = Registry.ITEM.getId(item)
        return "${itemIde.namespace}:${itemIde.path}"
    }

    fun getItemName(item: Item): String {
        return Registry.ITEM.getId(item).path
    }

    fun getModIDByItem(item: Item): String {
        return Registry.ITEM.getId(item).namespace
    }
}

object RecipesDataHelper {
    private val gson: Gson = GsonBuilder().setPrettyPrinting().create()
    private val basePath = "${System.getProperty("user.dir")}\\ovo\\resources\\data\\thursday_delight"

    fun craftingShapeless(output: ItemStack, itemList: Array<Any>) {
        val path = File("${basePath}\\recipes\\shapeless")
        if (!path.exists()) path.mkdirs()

        File("${path}\\${ItemUtil.getItemName(output.item)}").createNewFile()

        val BaseMap = HashMap<String, Any>()
        val RecipeList = ArrayList<Any>()
        val ResultMap = HashMap<String, Any>()

        for (i in itemList) {
            val ItemMap = HashMap<String, String>()
            ItemMap["item"] = if (i is Item) {
                ItemUtil.getItemRegistryName(i)
            } else {
                i.toString()
            }

            RecipeList.add(ItemMap)
        }

        ResultMap["item"] = ItemUtil.getItemRegistryName(output.item)
        ResultMap["count"] = output.count

        BaseMap["type"] = "minecraft:crafting_shapeless"
        BaseMap["ingredients"] = RecipeList
        BaseMap["result"] = ResultMap

        val writerModel: BufferedWriter = Files.newBufferedWriter(Paths.get("${path}\\${ItemUtil.getItemName(output.item)}"))
        writerModel.append(gson.toJson(BaseMap))
        writerModel.close()
    }

    fun craftingShaped(output: ItemStack, itemList: Array<Any>) {
        val recipes = ArrayList<String>()
        val recipeIc = ArrayList<Char>()
        val recipesItem = ArrayList<Item>()
        val path = File("${basePath}\\recipes\\shaped")
        if (!path.exists()) path.mkdirs()

        File("${path}\\${ ItemUtil.getItemName(output.item)}").createNewFile()

        val BaseMap = HashMap<String, Any>()
        val RecipeList = ArrayList<String>()
        val KeyMap = HashMap<String, Any>()
        val ResultMap = HashMap<String, Any>()
        var recipesCounter = 0
        var startRecipes = false

        if (recipeIc.size != recipesItem.size) {
            throw Exception("Recipes is ${ItemUtil.getItemName(output.item)} has an error!")
        }

        RecipeList.add(itemList[0].toString())

        for (i in 1 .. itemList.size) {
            if ((i == 1 && itemList[0].toString().length == itemList[i].toString().length && itemList[i + 1].toString().length <= 3) || i < 3 ) {
                RecipeList.add(itemList[i].toString())
            } else if (!startRecipes){
                startRecipes = true
                continue
            }

            if (startRecipes && i != recipesCounter) {
                val ItemMap = HashMap<String, String>()
                ItemMap["item"] = ItemUtil.getItemRegistryName(itemList[i + 1] as Item)
                KeyMap[itemList[i].toString()] = ItemMap
                recipesCounter = i + 1
            }
        }

        ResultMap["item"] = ItemUtil.getItemRegistryName(output.item)
        ResultMap["count"] = output.count

        BaseMap["type"] = "minecraft:crafting_shaped"
        BaseMap["ingredients"] = RecipeList
        BaseMap["key"] = KeyMap
        BaseMap["result"] = ResultMap

        val writerModel: BufferedWriter = Files.newBufferedWriter(Paths.get("${path}\\${ItemUtil.getItemName(output.item)}"))
        writerModel.append(gson.toJson(BaseMap))
        writerModel.close()
    }

    fun smeltingRecipe(output: ItemStack, input: Item) {
        val path = File("${basePath}\\recipes\\smelting")
        if (!path.exists()) path.mkdirs()

        File("${path}\\${ItemUtil.getItemName(output.item)}").createNewFile()

        val BaseMap = HashMap<String, Any>()
        val KeyMap = HashMap<String, Any>()

        KeyMap["item"] = ItemUtil.getItemRegistryName(input)

        BaseMap["type"] = "minecraft:smelting"
        BaseMap["ingredient"] = KeyMap
        BaseMap["result"] = ItemUtil.getItemRegistryName(output.item)
        BaseMap["count"] = output.count
        BaseMap["experience"] = 0.5
        BaseMap["cookingtime"] = 200

        val writerModel: BufferedWriter = Files.newBufferedWriter(Paths.get("${path}\\${ItemUtil.getItemName(output.item)}"))
        writerModel.append(gson.toJson(BaseMap))
        writerModel.close()
    }

    fun smokingRecipe(output: ItemStack, input: Item) {
        val path = File("${basePath}\\recipes\\smoking")
        if (!path.exists()) path.mkdirs()

        File("${path}\\${ItemUtil.getItemName(input)}").createNewFile()

        val BaseMap = HashMap<String, Any>()
        val KeyMap = HashMap<String, Any>()

        KeyMap["item"] = ItemUtil.getItemRegistryName(input)

        BaseMap["type"] = "minecraft:smoking"
        BaseMap["ingredient"] = KeyMap
        BaseMap["result"] = ItemUtil.getItemRegistryName(output.item)
        BaseMap["count"] = output.count
        BaseMap["experience"] = 0.5
        BaseMap["cookingtime"] = 100

        val writerModel: BufferedWriter = Files.newBufferedWriter(Paths.get("${path}\\${ItemUtil.getItemName(output.item)}"))
        writerModel.append(gson.toJson(BaseMap))
        writerModel.close()
    }

    private fun blastRecipe(output: ItemStack, input: Item) {
        val path = File("${basePath}\\recipes\\blasting")
        if (!path.exists()) path.mkdirs()

        File("${path}\\${ItemUtil.getItemName(input)}").createNewFile()

        val BaseMap = HashMap<String, Any>()
        val KeyMap = HashMap<String, Any>()

        KeyMap["item"] = ItemUtil.getItemRegistryName(input)

        BaseMap["type"] = "minecraft:blasting"
        BaseMap["ingredient"] = KeyMap
        BaseMap["result"] = ItemUtil.getItemRegistryName(output.item)
        BaseMap["count"] = output.count
        BaseMap["experience"] = 0.5
        BaseMap["cookingtime"] = 100

        val writerModel: BufferedWriter = Files.newBufferedWriter(Paths.get("${path}\\${ItemUtil.getItemName(output.item)}"))
        writerModel.append(gson.toJson(BaseMap))
        writerModel.close()
    }
}