package com.tynoxs.buildersdelight.content.item;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Objects;

public class BdItem extends Item {

    public BdItem(Properties properties) {
        super(properties);
    }

    public void appendHoverText(@NotNull ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltip, @NotNull TooltipFlag pFlag) {
        String name = Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(pStack.getItem())).getPath();
        pTooltip.add(Component.translatable("tooltip.item." + name).withStyle(ChatFormatting.GRAY));
    }

}
