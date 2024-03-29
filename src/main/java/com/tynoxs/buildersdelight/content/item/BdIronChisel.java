package com.tynoxs.buildersdelight.content.item;

import com.tynoxs.buildersdelight.content.gui.menus.ContainerChisel;
import com.tynoxs.buildersdelight.content.init.BdConfig;
import net.minecraft.advancements.Advancement;
import net.minecraft.nbt.CompoundTag;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
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

import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.network.NetworkHooks;

import javax.annotation.Nullable;

public class BdIronChisel extends BdItem {

    public BdIronChisel(Properties properties) {
        super(properties);
    }

    @Override
    public void onCraftedBy(ItemStack stack, Level world, Player player) {
        super.onCraftedBy(stack, world, player);
        if (!world.isClientSide && player instanceof ServerPlayer serverPlayer) {
            Advancement advancement = world.getServer().getAdvancements().getAdvancement(
                    new ResourceLocation("buildersdelight:recipes/iron_chisel"));
            if (advancement != null) {
                serverPlayer.getAdvancements().award(advancement, "unlock");
            }
        }
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);

        if (!world.isClientSide) {
            if (BdConfig.shouldPlayGuiOpenSound.get()) {
                world.playSound(null, player, SoundEvents.ARMOR_EQUIP_LEATHER, SoundSource.PLAYERS, 1f, 1f);
            }

            NetworkHooks.openScreen((ServerPlayer) player, new MenuProvider() {
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

    @Override
    public CompoundTag getShareTag(ItemStack stack) {
        CompoundTag nbt = super.getShareTag(stack);
        if (nbt != null)
            stack.getCapability(ForgeCapabilities.ITEM_HANDLER, null)
                    .ifPresent(capability -> nbt.put("Inventory", ((ItemStackHandler) capability).serializeNBT()));
        return nbt;
    }

    @Override
    public void readShareTag(ItemStack stack, @Nullable CompoundTag nbt) {
        super.readShareTag(stack, nbt);
        if (nbt != null)
            stack.getCapability(ForgeCapabilities.ITEM_HANDLER, null)
                    .ifPresent(capability -> ((ItemStackHandler) capability).deserializeNBT((CompoundTag) nbt.get("Inventory")));
    }
}
