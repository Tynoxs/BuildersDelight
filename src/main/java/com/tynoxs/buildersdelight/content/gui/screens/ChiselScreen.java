package com.tynoxs.buildersdelight.content.gui.screens;

import com.tynoxs.buildersdelight.content.gui.menus.ContainerChisel;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.Minecraft;

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
	private static final ResourceLocation button_on = new ResourceLocation("buildersdelight:textures/gui/chisel_all_toggle.png");

	@Override
	public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(graphics);
		super.render(graphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(graphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics graphics, float partialTicks, int pMouseX, int pMouseY) {
		int buttonX = this.leftPos+28;
		int buttonY = this.topPos + 72;

		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.setShaderTexture(0, texture);
		graphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.disableBlend();

		if(toggled) {
			RenderSystem.setShaderColor(1, 1, 1, 1);
			RenderSystem.enableBlend();
			RenderSystem.defaultBlendFunc();
			RenderSystem.setShaderTexture(0, button_on);
			graphics.blit(button_on, buttonX, buttonY, 0, 0, 16, 16, 16, 16);
			RenderSystem.disableBlend();
		}

		if(pMouseX > buttonX && pMouseX <  buttonX+16) {
			if (pMouseY > buttonY && pMouseY < buttonY + 16) {
				Component text;
				if(toggled){
					text = Component.translatable("container.button.chisel_all_on");
				}else{
					text = Component.translatable("container.button.chisel_all_off");
				}

				this.renderTooltip(graphics, pMouseX, pMouseY);
			}
		}


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
		int buttonY = this.topPos + 72;
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
	protected void renderLabels(GuiGraphics graphics, int mouseX, int mouseY) {
		graphics.drawString(this.font, this.title, this.titleLabelX, this.titleLabelY, 4210752);
		graphics.drawString(this.font, this.playerInventoryTitle, this.inventoryLabelX, this.inventoryLabelY, 4210752);
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
