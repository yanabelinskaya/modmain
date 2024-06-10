package net.yanka.bakery.item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab BATON_TAB = new  CreativeModeTab("Baton Tab"){
        @Override
        public ItemStack makeIcon(){
        return  new ItemStack(ModItems.BATON.get());
        }
    };
}
