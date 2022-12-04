package club.someoneice.thursday_delight;

import club.someoneice.thursday_delight.chili.Chili;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemList {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ThursdayMain.MODID);

    public static final RegistryObject<Item> SweetChilliSauce = ITEMS.register("sweet_chilli_sauce", ItemList::sauce);
    public static final RegistryObject<Item> ChilliSauce = ITEMS.register("chilli_sauce", ItemList::sauce);

    public static final RegistryObject<Item> AppleJam = ITEMS.register("apple_jam", ItemList::jam);
    public static final RegistryObject<Item> BerryJam = ITEMS.register("berry_jam", ItemList::jam);
    public static final RegistryObject<Item> MalenJam = ITEMS.register("melon_jam", ItemList::jam);
    public static final RegistryObject<Item> CocoJam  = ITEMS.register("coco_jam",  ItemList::jam);

    public static final RegistryObject<Item> ApplePie  = ITEMS.register("apple_pie", () -> ItemList.itemFoods(4, 0.4F));

    public static final RegistryObject<Item> FrenchFriesWithTomatoSauce = foodWithTomato("french_fries_with_tomatosauce", 6, 0.2f);
    public static final RegistryObject<Item> OriginalWithTomatoSauce = foodWithTomato("original_with_tomatosauce", 10, 1.6f);
    public static final RegistryObject<Item> NuggetsWithTomatoSauce = foodWithTomato("nuggets_with_tomatosauce", 4, 0.2f);
    public static final RegistryObject<Item> PotatoPieWithTomatoSauce = foodWithTomato("potato_pie_with_tomatosauce", 6, 0.8f);
    public static final RegistryObject<Item> PaNiNiWithTomatoSauce = foodWithTomato("panini_with_tomatosauce", 2, 0.2f);
    public static final RegistryObject<Item> SausageWithTomatoSauce = foodWithTomato("sausage_with_tomatosauce", 6, 0.2f);

    public static final RegistryObject<Item> FrenchFriesWithSweetChilliSauce = foodWithSweetChili("french_fries_with_sweetchillisauce", 6, 0.2f);
    public static final RegistryObject<Item> OriginalWithSweetChilliSauce = foodWithSweetChili("original_with_sweetchillisauce", 10, 1.6f);
    public static final RegistryObject<Item> NuggetsWithSweetChilliSauce = foodWithSweetChili("nuggets_with_sweetchillisauce", 4, 0.2f);
    public static final RegistryObject<Item> PotatoPieWithSweetChilliSauce = foodWithSweetChili("potato_pie_with_sweetchillisauce", 6, 0.8f);
    public static final RegistryObject<Item> PaNiNiWithSweetChilliSauce = foodWithSweetChili("panini_with_sweetchillisauce", 2, 0.2f);
    public static final RegistryObject<Item> SausageWithSweetChilliSauce = foodWithSweetChili("sausage_with_sweetchillisauce", 6, 0.2f);

    public static final RegistryObject<Item> FrenchFriesWithChilliSauce = foodWithChili("french_fries_with_chillisauce", 6, 0.2f);
    public static final RegistryObject<Item> OriginalWithChilliSauce = foodWithChili("original_with_chillisauce",10, 1.6f);
    public static final RegistryObject<Item> NuggetsWithChilliSauce = foodWithChili("nuggets_with_chillisauce", 4, 0.2f);
    public static final RegistryObject<Item> PotatoPieWithChilliSauce = foodWithChili("potato_pie_with_chillisauce", 6, 0.8f);
    public static final RegistryObject<Item> PaNiNiWithChilliSauce = foodWithChili("panini_with_chillisauce", 2, 0.2f);
    public static final RegistryObject<Item> SausageWithChilliSauce = foodWithChili("sausage_with_chillisauce", 6, 0.2f);

    public static final RegistryObject<Item> ChickenKRice = KGR("chicken_k");
    public static final RegistryObject<Item> BraisedKRice = KGR("braised_k");

    public static final RegistryObject<Item> MushSoup = ITEMS.register("mush_soup", () -> itemFoods(8, 0.5f, false, false, true, true, new ItemStack(Items.BOWL)));
    public static final RegistryObject<Item> Salad = ITEMS.register("chicken_salad", () -> itemFoods(8, 0.7f, true, false, false, false, new ItemStack(Items.BOWL)));
    public static final RegistryObject<Item> ChiliMeatFremchFries = ITEMS.register("chili_french_fries", () -> itemFoods(6, 0.2f));
    public static final RegistryObject<Item> TenderBeef = ITEMS.register("tender_beef", () -> itemFoods(8, 0.6f));
    public static final RegistryObject<Item> ChickenTako = ITEMS.register("chicken_tako", () -> itemFoods(8, 0.6f));
    public static final RegistryObject<Item> BigChicken = ITEMS.register("big_chicken", () -> itemFoods(8, 0.6f));
    public static final RegistryObject<Item> GoldenStar = ITEMS.register("golden_star", () -> itemFoods(2, 0.1f, true, true, true, false, null));

    public static final RegistryObject<Item> Chili = ITEMS.register("chili", Chili::new);

    /* Tools */
    public static Item itemItems() {
        return new Item(new Item.Properties().tab(ThursdayMain.TAB));
    }

    public static Item itemFoods(int hunger, float saturation, boolean wolf, boolean fast, boolean alwaysEat, boolean isDrink, ItemStack returnItem) {
        Item.Properties properties = new Item.Properties();
        FoodProperties.Builder builder = new FoodProperties.Builder();
        properties.tab(ThursdayMain.TAB);
        if (isDrink) properties.stacksTo(1);

        builder.nutrition(hunger);
        builder.saturationMod(saturation);
        if (wolf) builder.meat();
        if (fast) builder.fast();
        if (alwaysEat) builder.alwaysEat();
        properties.food(builder.build());

        return new ItemHelper(properties, isDrink, returnItem);
    }

    public static Item itemFoods(int hunger, float saturation, boolean isDrink, ItemStack returnItem) {
        return itemFoods(hunger, saturation, false, false, false, isDrink, returnItem);
    }

    public static Item itemFoods(int hunger, float saturation, boolean isDrink) {
        return itemFoods(hunger, saturation, false, false, false, isDrink, null);
    }

    public static Item itemFoods(int hunger, float saturation) {
        return itemFoods(hunger, saturation, false, false, false, false, null);
    }

    public static Item sauce() {
        return itemFoods(1, 0.1F, false, true, true, true, new ItemStack(Items.BOWL));
    }

    public static Item jam() {
        return itemFoods(4, 0.2F, false, true, true, true, new ItemStack(Items.BOWL));
    }

    public static RegistryObject<Item> foodWithTomato(String name, int hunger, float saturation) {
        Item.Properties properties = new Item.Properties();
        FoodProperties.Builder builder = new FoodProperties.Builder();
        properties.tab(ThursdayMain.TAB);

        builder.nutrition(hunger);
        builder.saturationMod(saturation);
        properties.food(builder.build());

        return ITEMS.register(name, () -> new SauceFoodHelper(properties, SauceFoodHelper.Sauce.TOMATO_SAUCE));
    }

    public static RegistryObject<Item> foodWithSweetChili(String name, int hunger, float saturation) {
        Item.Properties properties = new Item.Properties();
        FoodProperties.Builder builder = new FoodProperties.Builder();
        properties.tab(ThursdayMain.TAB);

        builder.nutrition(hunger);
        builder.saturationMod(saturation);
        properties.food(builder.build());

        return ITEMS.register(name, () -> new SauceFoodHelper(properties, SauceFoodHelper.Sauce.SWEET_CHILI_SAUCE));
    }

    public static RegistryObject<Item> foodWithChili(String name, int hunger, float saturation) {
        Item.Properties properties = new Item.Properties();
        FoodProperties.Builder builder = new FoodProperties.Builder();
        properties.tab(ThursdayMain.TAB);

        builder.nutrition(hunger);
        builder.saturationMod(saturation);
        properties.food(builder.build());

        return ITEMS.register(name, () -> new SauceFoodHelper(properties, SauceFoodHelper.Sauce.CHILI_SAUCE));
    }

    public static RegistryObject<Item> KGR(String name) {
        return ITEMS.register(name, () -> itemFoods(12, 1.0F, false, new ItemStack(Items.BOWL)));
    }
}
