package net.yanka.bakery.item;

import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.CreativeModeTab;

public class SkalkaItem extends SwordItem {
    public SkalkaItem() {
        super(Tiers.IRON, 3, -2.4F, new Properties().tab(ModCreativeModeTab.BATON_TAB));
    }
}

