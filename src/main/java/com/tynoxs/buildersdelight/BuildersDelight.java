package com.tynoxs.buildersdelight;

import com.tynoxs.buildersdelight.content.entity.renderer.SitRenderer;
import com.tynoxs.buildersdelight.content.init.*;
import com.tynoxs.buildersdelight.content.recipe.ChiselRecipeFactory;
import com.tynoxs.buildersdelight.content.recipe.ClientChiselRecipeFactory;
import com.tynoxs.buildersdelight.util.UtilBlockRendering;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.AddReloadListenerEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("buildersdelight")
public class BuildersDelight {

	private static BuildersDelight instance;

	private ChiselRecipeFactory recipeFactory;

	public static final String MODID = "buildersdelight";

	public BuildersDelight() {
		instance = this;
		recipeFactory = new ChiselRecipeFactory();
		IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
		BdTabs.TABS.register(eventBus);
		BdItems.ITEMS.register(eventBus);
		BdBlocks.BLOCKS.register(eventBus);
		BdDecoration.DECORATION.register(eventBus);
		BdEntities.ENTITIES.register(eventBus);
		BdContainers.CONTAINERS.register(eventBus);
		BdSounds.SOUND_EVENTS.register(eventBus);
		eventBus.addListener(this::clientSetup);
		MinecraftForge.EVENT_BUS.addListener( this::addResourceReload );
	}

	public void clientSetup(FMLClientSetupEvent event) {
		UtilBlockRendering.register();
		EntityRenderers.register(BdEntities.SIT.get(), SitRenderer::new);
		recipeFactory.clear();
		ClientChiselRecipeFactory clientChiselRecipeFactory = new ClientChiselRecipeFactory(recipeFactory);
		clientChiselRecipeFactory.loadClientRecipes();
	}

	public void addResourceReload(AddReloadListenerEvent event) {
		recipeFactory.clear();
		event.addListener(recipeFactory);
	}

	public ChiselRecipeFactory getRecipeFactory() {
		return recipeFactory;
	}

	public static BuildersDelight get(){
		return instance;
	}
}
