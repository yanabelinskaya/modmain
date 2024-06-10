package net.yanka.bakery.item;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;

public class CoffeeBombItem extends Item {

    public CoffeeBombItem() {
        super(new Item.Properties().tab(ModCreativeModeTab.BATON_TAB).stacksTo(1));
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);

        if (!world.isClientSide) {
            world.explode(null, player.getX(), player.getY(), player.getZ(), 4.0F, Explosion.BlockInteraction.BREAK);
            itemstack.shrink(1);  // Уменьшает количество предметов в стеке на 1
        }

        return InteractionResultHolder.sidedSuccess(itemstack, world.isClientSide());
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack) {
        return UseAnim.DRINK;  // Анимация питья
    }
}
