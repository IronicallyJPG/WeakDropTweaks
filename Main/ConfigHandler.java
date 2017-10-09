package com.ironically.wdt;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class ConfigHandler {

    public static Configuration config;
    
    // Drop Odds
    public static int NormalOdds 	= 50;
    public static int RareOdds		= 25;
    
    
    
    
    // Mob Specific Drop Odds
    public static int SkeleSkull 	= 50;
    public static int WitherSkull 	= 25;
    
    
    
    
    // Additional Tweaks
    public static boolean dropMoreSkulls = false;
    public static boolean evenMORE = false;
    
    
    //=======================================================================
    //=======================================================================
    //=======================================================================
    public static void init() {
        File file = new File("config/WeakDropTweaks.txt");
    	config = new Configuration(file);
        syncConfig();
        MobDrops.setOdds();
    }
    
    
    
    public static void syncConfig() {
        String category;
        
        category = "Regular Odds";
        config.addCustomCategoryComment(category, "Regular Drop Odds");
        NormalOdds 		= config.getInt("Normal Odds", 		category, 75, 0, 100, "Out of 100");
        RareOdds 		= config.getInt("Rare Odds", 		category, 30, 0, 100, "Out of 100");
        
        
      
        category = "Mob Specific";
        config.addCustomCategoryComment(category, "Mob Specific Drop Odds");
        WitherSkull 	= config.getInt("Wither Skull", 	category, 25, 0, 100, "Out of 100");
        SkeleSkull 		= config.getInt("Skeleton Skull", 	category, 50, 0, 100, "Out of 100");
        
        category = "Additional Tweaks";
        config.addCustomCategoryComment(category, "Additional Mob Drop Tweaks");
        dropMoreSkulls 	= config.getBoolean("Drop More Skulls", category, false, "Setting this to true Boosts the odds of a Skull Drop by a LOT");
        evenMORE 		= config.getBoolean("Skeleton Skull", 	category, false, "Setting this to true just drops MORE in general.");
        
        
        config.save();
    }
}
