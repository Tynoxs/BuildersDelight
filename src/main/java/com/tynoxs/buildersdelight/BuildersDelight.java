package com.tynoxs.buildersdelight;

import com.tynoxs.buildersdelight.content.entity.renderer.SitRenderer;
import com.tynoxs.buildersdelight.content.init.*;
import com.tynoxs.buildersdelight.util.UtilBlockRendering;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("buildersdelight")
public class BuildersDelight {

	/**
	 * TODO:
	 * Change chisel gui / add recipes / add chisel all button
	 * Add JEI support
	 * Redo all frame textures / connected textures
	 * Redo all glass textures
	 * Redo remaining stone textures
	 * Make chiseled planks able to be used in recipes
	*/

	public static final String MODID = "buildersdelight";

	public BuildersDelight() {
		IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
		BdTabs.register();
		BdItems.ITEMS.register(eventBus);
		BdBlocks.BLOCKS.register(eventBus);
		BdDecoration.DECORATION.register(eventBus);
		BdEntities.ENTITIES.register(eventBus);
		BdContainers.CONTAINERS.register(eventBus);
		eventBus.addListener(this::clientSetup);
	}

	public void clientSetup(FMLClientSetupEvent event) {
		UtilBlockRendering.register();
		EntityRenderers.register(BdEntities.SIT.get(), SitRenderer::new);
	}
}