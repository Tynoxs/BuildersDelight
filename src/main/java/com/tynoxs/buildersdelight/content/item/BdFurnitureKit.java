package com.tynoxs.buildersdelight.content.item;

import com.tynoxs.buildersdelight.content.gui.menus.ContainerChisel;
import net.minecraft.advancements.Advancement;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.network.NetworkHooks;

import javax.annotation.Nullable;

public class BdFurnitureKit extends BdItem {
    public BdFurnitureKit(Properties properties) {
        super(properties);
    }

    @Override
    public void onCraftedBy(ItemStack stack, Level world, Player player) {
        super.onCraftedBy(stack, world, player);
        if (!world.isClientSide && player instanceof ServerPlayer serverPlayer) {
            Advancement advancement = world.getServer().getAdvancements().getAdvancement(
                    new ResourceLocation("buildersdelight:recipes/furniture_kit"));
            if (advancement != null) {
                serverPlayer.getAdvancements().award(advancement, "unlock");
            }
        }
    }
}
