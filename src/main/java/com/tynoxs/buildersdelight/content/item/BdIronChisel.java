package com.tynoxs.buildersdelight.content.item;

import com.tynoxs.buildersdelight.content.gui.menus.ContainerChisel;
import com.tynoxs.buildersdelight.content.init.BdConfig;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;

import javax.annotation.Nullable;

public class BdIronChisel extends Item {

    public BdIronChisel(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);

        if (!world.isClientSide) {
            if (BdConfig.shouldPlayGuiOpenSound.get()) {
                world.playSound(player, player.blockPosition(), SoundEvents.ARMOR_EQUIP_LEATHER.value(), SoundSource.PLAYERS, 1f, 1f);
            }

            ((ServerPlayer)player).openMenu(new MenuProvider() {
                @Override
                public Component getDisplayName() {
                    return Component.translatable("container.iron_chisel");
                }

                @Nullable
                @Override
                public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
                    ContainerChisel containerChisel = new ContainerChisel(id, inventory, new FriendlyByteBuf(null));
                    return containerChisel;
                }
            }, buffer -> buffer.writeBoolean(hand == InteractionHand.MAIN_HAND));
        }

        return InteractionResultHolder.sidedSuccess(stack, world.isClientSide);
    }
}
