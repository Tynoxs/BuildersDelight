package com.tynoxs.buildersdelight;

import com.tynoxs.buildersdelight.content.entity.renderer.SitRenderer;
import com.tynoxs.buildersdelight.content.init.*;
import com.tynoxs.buildersdelight.content.recipe.ChiselRecipeFactory;
import com.tynoxs.buildersdelight.content.recipe.ClientChiselRecipeFactory;
import com.tynoxs.buildersdelight.util.UtilBlockRendering;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.neoforged.neoforge.common.MinecraftForge;
import net.neoforged.neoforge.event.AddReloadListenerEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("buildersdelight")
public class BuildersDelight {

	public static final String CommonConfigFile = "buildersdelight-common.toml";
	public static final String MODID = "buildersdelight";

	private static BuildersDelight instance;

	private ChiselRecipeFactory recipeFactory;
	private BdConfig config;

	public BuildersDelight() {
		instance = this;
		recipeFactory = new ChiselRecipeFactory();
		config = new BdConfig();
		IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
		ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, BdConfig.SPEC, CommonConfigFile);
		BdTabs.register(eventBus);
		BdBlocks.register(eventBus);
		BdItems.register(eventBus);
		BdDecoration.register(eventBus);
		BdEntities.register(eventBus);
		BdContainers.register(eventBus);
		BdSounds.register(eventBus);

		eventBus.addListener(this::clientSetup);
		eventBus.addListener(this::commonSetup);
		MinecraftForge.EVENT_BUS.addListener(this::addResourceReload);
	}

	private void commonSetup(FMLCommonSetupEvent event) {
		config.loadConfigValues();
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
