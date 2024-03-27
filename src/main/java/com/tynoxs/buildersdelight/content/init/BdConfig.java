package com.tynoxs.buildersdelight.content.init;

import net.minecraftforge.common.ForgeConfigSpec;

public class BdConfig {
    public static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    public static final ForgeConfigSpec SPEC;

    public static final ForgeConfigSpec.ConfigValue<Boolean> playGuiOpenSound;
    public static final ForgeConfigSpec.ConfigValue<Boolean> playChiselingSound;

    public static ForgeConfigSpec.ConfigValue<Boolean> shouldPlayGuiOpenSound;
    public static ForgeConfigSpec.ConfigValue<Boolean> shouldPlayChiselingSound;



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
