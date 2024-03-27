package com.tynoxs.buildersdelight.event;

import com.tynoxs.buildersdelight.BuildersDelight;
import com.tynoxs.buildersdelight.content.block.custom.lantern.IWeatheringBlock;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolActions;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.event.level.BlockEvent;

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
