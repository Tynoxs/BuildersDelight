package com.tynoxs.buildersdelight.content.item;

import net.minecraft.advancements.Advancement;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

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
