package com.tynoxs.buildersdelight.content.init;

import net.neoforged.neoforge.common.ModConfigSpec;

public class BdConfig {
    public static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
    public static final ModConfigSpec SPEC;

    public static final ModConfigSpec.ConfigValue<Boolean> playGuiOpenSound;
    public static final ModConfigSpec.ConfigValue<Boolean> playChiselingSound;

    public static ModConfigSpec.ConfigValue<Boolean> shouldPlayGuiOpenSound;
    public static ModConfigSpec.ConfigValue<Boolean> shouldPlayChiselingSound;



    static {
        BUILDER.push("Builder's Delight Config");

        playChiselingSound = BUILDER.comment("Plays a sound when chiseling an item, default: true").define("playGuiSounds", true);
        playGuiOpenSound = BUILDER.comment("Plays a sound when opening the iron chisel GUI, default: true").define("playChiselSounds", true);

        SPEC = BUILDER.build();
    }

    public void loadConfigValues() {
        shouldPlayGuiOpenSound = playGuiOpenSound;
        shouldPlayChiselingSound = playChiselingSound;
    }
}
