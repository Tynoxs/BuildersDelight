package com.tynoxs.buildersdelight.event;

import com.tynoxs.buildersdelight.BuildersDelight;
import com.tynoxs.buildersdelight.content.block.custom.IWeatheringBlock;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.common.ToolActions;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.event.level.BlockEvent;

@Mod.EventBusSubscriber(modid = BuildersDelight.MODID)
public class EventHandler
{
    @SubscribeEvent
    public static void toolInteract(BlockEvent.BlockToolModificationEvent event) {
        Block block = event.getState().getBlock();
        LevelAccessor level = event.getLevel();

        BlockState blockState = event.getState();
        if (event.getToolAction().equals(ToolActions.AXE_WAX_OFF)) {
            IWeatheringBlock.getUnwaxed(blockState).ifPresent(event::setFinalState);
        } else if (event.getToolAction().equals(ToolActions.AXE_SCRAPE) && block instanceof IWeatheringBlock) {
            IWeatheringBlock.getPrevious(blockState).ifPresent(event::setFinalState);
        }
    }
}
