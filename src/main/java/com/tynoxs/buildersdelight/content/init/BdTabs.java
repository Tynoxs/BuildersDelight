package com.tynoxs.buildersdelight.content.init;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class BdTabs {
	public static CreativeModeTab TabBlocks;
	public static CreativeModeTab TabDecoration;
	public static CreativeModeTab TabMaterials;

	public static void register() {
		TabBlocks = new CreativeModeTab("tab_blocks") {
			@Override
			@OnlyIn(Dist.CLIENT)
			public ItemStack makeIcon() {
				return new ItemStack(BdBlocks.SPRUCE_PLANKS_7.get());
			}
		};
		TabDecoration = new CreativeModeTab("tab_decoration") {
			@Override
			@OnlyIn(Dist.CLIENT)
			public ItemStack makeIcon() {
				return new ItemStack(BdDecoration.SPRUCE_TABLE_1.get());
			}
		};
		TabMaterials = new CreativeModeTab("tab_materials") {
			@Override
			@OnlyIn(Dist.CLIENT)
			public ItemStack makeIcon() {
				return new ItemStack(BdItems.SPRUCE_FURNITURE_KIT.get());
			}
		};
	}
}
