package net.yanka.bakery.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.yanka.bakery.Bakery;
import net.yanka.bakery.item.ModCreativeModeTab;
import net.yanka.bakery.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Bakery.MOD_ID);

    public static RegistryObject<Block> VATA = registryBlock("vata",
            () -> new FallingBlock(Block.Properties.of(Material.SAND)
                    .strength(0.5F)
                    .sound(SoundType.SAND)
                    .jumpFactor(12)
                    .requiresCorrectToolForDrops()), ModCreativeModeTab.BATON_TAB);

    public static RegistryObject<Block> POLKA = registryBlock("polka",
            () -> new Block(Block.Properties.of(Material.WOOD)
                    .strength(1.0F).sound(SoundType.WOOD)
                    .air()
                    .requiresCorrectToolForDrops()), ModCreativeModeTab.BATON_TAB);

    public static RegistryObject<Block> HOLOD = registryBlock("holod",
            () -> new Block(Block.Properties.of(Material.METAL)
                    .strength(1.0F).sound(SoundType.METAL)
                    .explosionResistance(1000.0F)
                    .requiresCorrectToolForDrops()), ModCreativeModeTab.BATON_TAB);
    public static RegistryObject<Block> LAMP = registryBlock("lamp",
            () -> new Block(Block.Properties.of(Material.METAL)
                    .strength(1.5F)
                    .lightLevel((state) -> 15)
                    .requiresCorrectToolForDrops()), ModCreativeModeTab.BATON_TAB);
    public static <T extends Block>RegistryObject<T> registryBlock(String name, Supplier<T> block, CreativeModeTab tab){
        RegistryObject<T> toReturns = BLOCKS.register(name,block);
        registryBlockItem(name, toReturns, tab);
        return toReturns;
    }

    private static <T extends Block> RegistryObject<Item> registryBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () ->new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
