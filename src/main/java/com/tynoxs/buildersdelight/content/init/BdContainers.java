package com.tynoxs.buildersdelight.content.init;

import java.util.function.Supplier;

import com.tynoxs.buildersdelight.BuildersDelight;
import com.tynoxs.buildersdelight.content.block.connected.model.CTBlockModelLoader;
import com.tynoxs.buildersdelight.content.block.connected.model.CTPaneModelLoader;
import com.tynoxs.buildersdelight.content.gui.screens.ChiselScreen;
import com.tynoxs.buildersdelight.content.gui.menus.ContainerChisel;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.neoforged.neoforge.client.event.ModelEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;

import net.minecraft.world.inventory.MenuType;
import net.neoforged.neoforge.network.IContainerFactory;
import net.neoforged.neoforge.registries.DeferredRegister;

@EventBusSubscriber(modid = BuildersDelight.MODID)
public class BdContainers {

    public static final DeferredRegister<MenuType<?>> CONTAINERS = DeferredRegister.create(BuiltInRegistries.MENU, BuildersDelight.MODID);

    public static final Supplier<MenuType<ContainerChisel>> CHISEL_CONTAINER = registerMenuType(ContainerChisel::new,"chisel_container");

    @SubscribeEvent
    public static void registerScreens(RegisterMenuScreensEvent event) {
        event.register(CHISEL_CONTAINER.get(), ChiselScreen::new);
    }

    private static <T extends AbstractContainerMenu> Supplier<MenuType<T>> registerMenuType(IContainerFactory<T> factory, String name) {
        return CONTAINERS.register(name, () -> IMenuTypeExtension.create(factory));
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


