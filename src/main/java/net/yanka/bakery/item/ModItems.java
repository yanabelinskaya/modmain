package net.yanka.bakery.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.yanka.bakery.Bakery;
import net.yanka.bakery.block.ModBlocks;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Bakery.MOD_ID);

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    public static final RegistryObject<Item> BATON = ITEMS.register("baton",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.BATON_TAB)));

    public static final RegistryObject<Item> SKALKAA = ITEMS.register("skalkaa",
            SkalkaItem::new);

    public static final RegistryObject<Item> COFEE = ITEMS.register("cofee",
            CoffeeBombItem::new);

    public static final RegistryObject<Item> CHIZ = ITEMS.register("chiz",
            () -> new Item(new Item.Properties()
                    .food((new FoodProperties.Builder()).nutrition(5).saturationMod(0.5f)
                            .build()).tab(ModCreativeModeTab.BATON_TAB)));

}
