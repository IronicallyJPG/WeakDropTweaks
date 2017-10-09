package com.ironically.wdt;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = WeakDropTweaks.MODID, version = WeakDropTweaks.VERSION)
public class WeakDropTweaks
{
    public static final String MODID = "ironic_wdt";
    public static final String VERSION = "1.2";
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	ConfigHandler.init();
        MinecraftForge.EVENT_BUS.register(new Events());
    }
}
