package com.ironically.wdt;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = WeakDropTweaks.MODID, version = WeakDropTweaks.VERSION)
public class WeakDropTweaks
{
    public static final String MODID = "ironic_wdt";
    public static final String VERSION = "1.3.1 [1.7.10]";
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	ConfigHandler.init();
        MinecraftForge.EVENT_BUS.register(new Events());
    }
}
