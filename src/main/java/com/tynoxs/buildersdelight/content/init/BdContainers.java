package com.tynoxs.buildersdelight.content.init;

import com.tynoxs.buildersdelight.BuildersDelight;
import com.tynoxs.buildersdelight.content.block.connected.model.CTBlockModelLoader;
import com.tynoxs.buildersdelight.content.block.connected.model.CTPaneModelLoader;
import com.tynoxs.buildersdelight.content.gui.screens.ChiselScreen;
import com.tynoxs.buildersdelight.content.gui.menus.ContainerChisel;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.neoforged.neoforge.client.event.ModelEvent;
import net.neoforged.neoforge.common.extensions.IForgeMenuType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;

import net.minecraft.world.inventory.MenuType;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.network.IContainerFactory;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.ForgeRegistries;
import net.neoforged.neoforge.registries.RegistryObject;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class BdContainers {

    public static final DeferredRegister<MenuType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.MENU_TYPES, BuildersDelight.MODID);
    public static final RegistryObject<MenuType<ContainerChisel>> CHISEL_CONTAINER = registerMenuType(ContainerChisel::new,"chisel_container");

    @SubscribeEvent
    public static void clientLoad(FMLClientSetupEvent event) {
        event.enqueueWork(() -> MenuScreens.register(CHISEL_CONTAINER.get(), ChiselScreen::new));
    }

    private static <T extends AbstractContainerMenu>RegistryObject<MenuType<T>> registerMenuType(IContainerFactory<T> factory, String name) {
        return CONTAINERS.register(name, () -> IForgeMenuType.create(factory));
    }

    @SubscribeEvent
    public static void modelInit(ModelEvent.RegisterGeometryLoaders event) {
        CTBlockModelLoader.register(event);
        CTPaneModelLoader.register(event);
    }

    public static void register(IEventBus eventBus) {
        CONTAINERS.register(eventBus);
    }
}


