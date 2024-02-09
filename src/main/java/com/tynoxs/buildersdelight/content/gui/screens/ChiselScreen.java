package com.tynoxs.buildersdelight.content.gui.screens;

import com.tynoxs.buildersdelight.content.gui.menus.ContainerChisel;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;

import com.mojang.blaze3d.systems.RenderSystem;

public class ChiselScreen extends AbstractContainerScreen<ContainerChisel> {

	private static boolean toggled = false;

	public ChiselScreen(ContainerChisel container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.titleLabelX = 54;
		this.titleLabelY = 7;
		this.inventoryLabelX = 19;
		this.inventoryLabelY = this.imageHeight - 64;
		this.imageWidth = 200;
		this.imageHeight = 200;
	}

	private static final ResourceLocation texture = new ResourceLocation("buildersdelight:textures/gui/chisel_gui.png");
	private static final ResourceLocation chisel_all_button = new ResourceLocation("buildersdelight:textures/gui/chisel_all_button.png");
	private static final ResourceLocation chisel_hover_button = new ResourceLocation("buildersdelight:textures/gui/chisel_hover_button.png");
	private static final ResourceLocation right_arrow = new ResourceLocation("buildersdelight:textures/gui/right_arrow.png");
	private static final ResourceLocation down_arrow = new ResourceLocation("buildersdelight:textures/gui/down_arrow.png");

	@Override
	public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(graphics);
		super.render(graphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(graphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics graphics, float partialTicks, int pMouseX, int pMouseY) {
		int buttonX = this.leftPos+28;
		int buttonY = this.topPos+72;

		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.setShaderTexture(0, texture);
		graphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.disableBlend();

		//Display arrow towards variant slots, if item in slot 0
		if(!this.menu.getSlot(0).getItem().isEmpty()) {
			RenderSystem.setShaderTexture(0, right_arrow);
			graphics.blit(right_arrow, this.leftPos+46, this.topPos+22, 0, 0, 8, 8, 8, 8);
			RenderSystem.disableBlend();
		}

		//Display arrow towards player inventory, if item in slot 1
		if(!this.menu.getSlot(1).getItem().isEmpty()) {
			RenderSystem.setShaderTexture(0, down_arrow);
			graphics.blit(down_arrow, this.leftPos+32, this.topPos+36, 0, 0, 8, 8, 8, 8);
			RenderSystem.disableBlend();
		}

		//Highlight button when hovering
		if (isButtonHovered(pMouseX, pMouseY)) {
			RenderSystem.setShaderTexture(0, chisel_hover_button);
			graphics.blit(chisel_hover_button, buttonX, buttonY, 0, 0, 16, 16, 16, 16);
			RenderSystem.disableBlend();
		}

		//Light up chisel all button
		if (toggled) {
			RenderSystem.setShaderTexture(0, chisel_all_button);
			graphics.blit(chisel_all_button, buttonX, buttonY, 0, 0, 16, 16, 16, 16);
			RenderSystem.disableBlend();
		}

	}

	private boolean isButtonHovered(int mouseX, int mouseY) {
		int buttonX = this.leftPos + 28;
		int buttonY = this.topPos + 72;
		return mouseX >= buttonX && mouseX < buttonX + 16 && mouseY >= buttonY && mouseY < buttonY + 16;
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	public boolean mouseClicked(double pMouseX, double pMouseY, int pButton) {
		int buttonX = this.leftPos+28;
		int buttonY = this.topPos+72;
		if(pMouseX > buttonX && pMouseX <  buttonX+16){
			if(pMouseY > buttonY && pMouseY <  buttonY+16) {
				toggled = !toggled;
				if(toggled){
					this.minecraft.gameMode.handleInventoryButtonClick((this.menu).containerId, 1);
				}else {
					this.minecraft.gameMode.handleInventoryButtonClick((this.menu).containerId, 0);
				}
			}
		}
		return super.mouseClicked(pMouseX, pMouseY, pButton);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		if(toggled){
			this.minecraft.gameMode.handleInventoryButtonClick((this.menu).containerId, 1);
		}
	}
}
