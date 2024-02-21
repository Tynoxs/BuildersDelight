package com.tynoxs.buildersdelight.content.gui.screens;

import com.tynoxs.buildersdelight.content.gui.menus.ContainerChisel;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.world.item.ItemStack;

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
	private static final ResourceLocation right_arrow_green = new ResourceLocation("buildersdelight:textures/gui/right_arrow_green.png");
	private static final ResourceLocation right_arrow_red = new ResourceLocation("buildersdelight:textures/gui/right_arrow_red.png");
	private static final ResourceLocation down_arrow_green = new ResourceLocation("buildersdelight:textures/gui/down_arrow_green.png");

	@Override
	public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(graphics);
		super.render(graphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(graphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics graphics, float partialTicks, int pMouseX, int pMouseY) {
		int buttonX = this.leftPos + 28;
		int buttonY = this.topPos + 72;

		ItemStack slot0ItemStack = this.menu.getSlot(0).getItem();
		ItemStack slot1ItemStack = this.menu.getSlot(1).getItem();
		boolean hasResults = ContainerChisel.hasResults;

		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();

		// Render background texture
		RenderSystem.setShaderTexture(0, texture);
		graphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.disableBlend();

		// Display arrow towards variant slots, if item in slot 0
		renderArrow(graphics, slot0ItemStack, hasResults, right_arrow_green, right_arrow_red, 46, 22);

		// Display arrow towards player inventory, if item in slot 1
		renderArrow(graphics, slot1ItemStack, true, down_arrow_green, down_arrow_green, 32, 36);

		// Highlight button when hovering
		renderHoveredButton(graphics, pMouseX, pMouseY, buttonX, buttonY, chisel_hover_button);

		// Light up chisel all button
		if (toggled) {
			renderButton(graphics, buttonX, buttonY, chisel_all_button);
		}
	}


	// Helper method to render arrows
	private void renderArrow(GuiGraphics graphics, ItemStack itemStack, boolean condition, ResourceLocation trueTexture, ResourceLocation falseTexture, int posX, int posY) {
		if (!itemStack.isEmpty()) {
			ResourceLocation arrowTexture = condition ? trueTexture : falseTexture;
			RenderSystem.setShaderTexture(0, arrowTexture);
			graphics.blit(arrowTexture, this.leftPos + posX, this.topPos + posY, 0, 0, 8, 8, 8, 8);
			RenderSystem.disableBlend();
		}
	}

	// Helper method to render hovered button
	private void renderHoveredButton(GuiGraphics graphics, int pMouseX, int pMouseY, int buttonX, int buttonY, ResourceLocation buttonTexture) {
		if (isButtonHovered(pMouseX, pMouseY)) {
			renderButton(graphics, buttonX, buttonY, buttonTexture);
		}
	}

	// Helper method to render a button
	private void renderButton(GuiGraphics graphics, int buttonX, int buttonY, ResourceLocation buttonTexture) {
		RenderSystem.setShaderTexture(0, buttonTexture);
		graphics.blit(buttonTexture, buttonX, buttonY, 0, 0, 16, 16, 16, 16);
		RenderSystem.disableBlend();
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
