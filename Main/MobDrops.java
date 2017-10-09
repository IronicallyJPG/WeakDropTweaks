package com.ironically.wdt;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityRabbit;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDropsEvent;

public class MobDrops {
	
	public static Random ran = new Random();
	
	private static int NormalOdds;
	private static int RareOdds;

	private static int SkeleSkull;
	private static int WitherSkull;
	
	private static boolean MoreSkulls;
	private static boolean MORE;
	
	public static void setOdds() {
		NormalOdds = ConfigHandler.NormalOdds;
		RareOdds = ConfigHandler.RareOdds;
		SkeleSkull = ConfigHandler.SkeleSkull;
		WitherSkull = ConfigHandler.WitherSkull;
		MoreSkulls = ConfigHandler.dropMoreSkulls;
		MORE = ConfigHandler.evenMORE;
	}
	
	public static void LivingDropEvent(LivingDropsEvent e) {
		//DEBUG : System.out.println("WDT > Mob Killed Name > " + e.getEntity().getName() );
		switch(e.getEntity().getName().toLowerCase()) {
			// Default incase an unknown mob is found.
			default: /*System.out.println("UNKNOWN MOB KILLED!")*/;break;
			// 44 MOBS HANDLED
			case "cow": 				Cow(e);break;
			case "chicken": 			Chicken(e);break;
			case "squid":				Squid(e);break;
			case "pig": 				Pig(e);break;
			case "sheep": 				Sheep(e);break;
			case "rabbit": 				Rabbit(e);break;
			case "mooshroom": 			Mooshroom(e);break;
			case "villager": 			Villager(e);;break;
			case "cave spider": 		Cave_Spider(e);break;
			case "enderman": 			Enderman(e);break;
			case "polar bear": 			Polar_Bear(e);break;
			case "spider": 				Cave_Spider(e);break;
			case "zombie pigman": 		Zombie_Pigman(e);break;
			case "blaze": 				Blaze(e);break;
			case "creeper": 			Creeper(e);break;
			case "elder guardian": 		Elder_Guardian(e);break;
			case "endermite": 			Enderman(e);break;
			case "evoker": 				Evoker(e);break;
			case "ghast": 				Ghast(e);break;
			case "guardian": 			Guardian(e);break;
			case "husk": 				Husk(e);break;
			case "magma cube": 			Magma_Cube(e);break;
			case "shulker": 			Shulker(e);break;
			case "silverfish": 			Silverfish(e);break;
			case "skeleton": 			Skeleton(e);break;
			case "slime": 				Slime(e);break;
			case "stray": 				Stray(e);break;
			case "vex": 				Vex(e);break;
			case "vindicator": 			Vindicator(e);break;
			case "witch": 				Witch(e);break;
			case "wither skeleton": 	Wither_Skeleton(e);break;
			case "zombie": 				Zombie(e);break;
			case "zombie villager": 	Zombie_Villager(e);break;
			case "donkey": 				Donkey(e);break;
			case "horse": 				Horse(e);break;
			case "llama":			 	Llama(e);break;
			case "mule": 				Mule(e);break;
			case "ocelot": 				Ocelot(e);break;
			case "parrot": 				Parrot(e);break;
			case "wolf": 				Wolf(e);break;
			case "iron golem": 			Iron_Golem(e);break;
			case "snow golem": 			Snow_Golem(e);break;
			case "wither": 				Wither(e);break;
			case "ender dragon": 		Ender_Dragon(e);break;
		}
	}
	//===================
	
	/**
	
	
	*/
	private static Item getEquipedItem(Entity e) {
		return new ItemStack(e.getHeldEquipment().iterator().next().getItem(),1).getItem();
	}
	
	/** Crunches the Odds and Spits True or False
	 * 
	 */
	private static boolean drop(int odds) {
		if(odds==100) {return true;}
		boolean ret = false;
		ret = (ran.nextInt(100)<=odds);
		// [DEBUG LINE] System.out.println("[DROPPED] "+odds);
		return ret;
	}
	
	/** Random Int returner that WILL ALWAYS RETURN MINIMUM int 1
	 * 
	 * @param max the Maximum it can return 
	 */
	private static int rand(int max) {
		if(max<=0)max=1;
		int ret = new Random().nextInt(max);
		
		// === The Line Below is OPTIONAL. Toggleable in the CONFIG. ===
		if(MORE==true){ret = new Random().nextInt(16)+6;return ret;}
		// =============================================================
		
		if(ret<=1)ret=1;
		return ret;
	}
	/** Returns Item from Block
	 * 
	 * @param b Block to get Item for.
	 */
	private static Item IFB(Block b) {
		return new ItemStack(b,1).getItem();
	}
	/** Returns Random Food Item
	 */
	private static Item RandomFood() {
		ArrayList<Item> foods = new ArrayList<Item>();
		foods.add(Items.POTATO);
		foods.add(Items.APPLE);
		foods.add(Items.BREAD);
		foods.add(Items.BEETROOT);
		foods.add(Items.CARROT);
		foods.add(Items.WHEAT_SEEDS);
		foods.add(Items.WHEAT);
		return foods.get(rand(foods.size()));
	}
	
	
	//=================================================================================================
	//=================================================================================================
	// TO ANYBODY READING THIS, This code does have doule layer randoms, this is to help add balance
	// as well as extra drops to the game WTIHOUT making it painfully obvious.
	//
	// Any critism or tips or ideas can be submitted to the Curse Page. I check daily :)
	//=================================================================================================
	//=================================================================================================
	//            ==                                ==       
	//               ALL MOB DROP METHODS ARE BELOW
	//            ==                                ==
	//=================================================================================================
	//=================================================================================================

	/**
	 * Mule Method Drops specific items.
	 * 
	 * @param e The event to Pull Objects from.
	 * */
	private static void Mule(LivingDropsEvent e) {
		Entity w = e.getEntity();
		int amt = ran.nextInt(2+e.getLootingLevel());
		//Base Drop Tweaked.
		switch(amt) {
			// Normal Extra Drops 
			default:if(drop(NormalOdds)==true){w.dropItem(Items.BONE, rand(4));};break;
			case 0: if(drop(NormalOdds)==true){w.dropItem(Items.LEATHER, rand(3));};break;
			case 1: if(drop(NormalOdds)==true){w.dropItem(Items.BONE, rand(3));};break;
			case 2: if(drop(NormalOdds)==true){w.dropItem(Items.WHEAT, rand(3));};break;
			// LOOTING DROPS
			case 3: if(drop(NormalOdds)==true){w.dropItem(Items.BEETROOT_SEEDS, rand(6));};break;
			case 4: if(drop(NormalOdds)==true){w.dropItem(Items.MELON_SEEDS,rand(6));};break;
			case 5: if(drop(NormalOdds)==true){w.dropItem(Items.PUMPKIN_SEEDS, rand(6));};break;
		}
	}


	/**
	 * Llama Method Drops specific items.
	 * 
	 * @param e The event to Pull Objects from.
	 * */
	private static void Llama(LivingDropsEvent e) {
		Entity w = e.getEntity();
		int amt = ran.nextInt(2+e.getLootingLevel());
		//Base Drop Tweaked.
		switch(amt) {
			// Normal Extra Drops 
			default:if(drop(NormalOdds)==true){w.dropItem(Items.LEATHER, rand(1));};break;
			case 0: if(drop(NormalOdds)==true){w.dropItem(Items.MUTTON, rand(3));};break;
			case 1: if(drop(NormalOdds)==true){w.dropItem(Items.BONE, rand(3));};break;
			case 2: if(drop(NormalOdds)==true){w.dropItem(Items.LEATHER, rand(3));};break;
			// LOOTING DROPS
			case 3: if(drop(NormalOdds)==true){w.dropItem(Items.PUMPKIN_SEEDS, rand(6));};break;
			case 4: if(drop(NormalOdds)==true){w.dropItem(Items.MELON_SEEDS,rand(6));};break;
			case 5: if(drop(NormalOdds)==true){w.dropItem(IFB(Blocks.CARPET), rand(2));};break;
		}
	}


	/**
	 * Horse Method Drops specific items.
	 * 
	 * @param e The event to Pull Objects from.
	 * */
	private static void Horse(LivingDropsEvent e) {
		Entity w = e.getEntity();
		int amt = ran.nextInt(2+e.getLootingLevel());
		//Base Drop Tweaked.
		switch(amt) {
			// Normal Extra Drops 
			default:if(drop(NormalOdds)==true){w.dropItem(Items.LEATHER, rand(1));};break;
			case 0: if(drop(NormalOdds)==true){w.dropItem(Items.LEATHER, rand(3));};break;
			case 1: if(drop(NormalOdds)==true){w.dropItem(Items.BONE, rand(3));};break;
			case 2: if(drop(NormalOdds)==true){w.dropItem(Items.WHEAT, rand(3));};break;
			// LOOTING DROPS
			case 3: if(drop(NormalOdds)==true){w.dropItem(Items.BEETROOT_SEEDS, rand(6));};break;
			case 4: if(drop(NormalOdds)==true){w.dropItem(Items.MELON_SEEDS,rand(6));};break;
			case 5: if(drop(NormalOdds)==true){w.dropItem(Items.PUMPKIN_SEEDS, rand(6));};break;
		}
	}


	/**
	 * Donkey Method Drops specific items.
	 * 
	 * @param e The event to Pull Objects from.
	 * */
	private static void Donkey(LivingDropsEvent e) {
		Entity w = e.getEntity();
		int amt = ran.nextInt(2+e.getLootingLevel());
		//Base Drop Tweaked.
		switch(amt) {
			// Normal Extra Drops 
			default:if(drop(NormalOdds)==true){w.dropItem(Items.BONE, rand(1));};break;
			case 0: if(drop(NormalOdds)==true){w.dropItem(Items.LEATHER, rand(3));};break;
			case 1: if(drop(NormalOdds)==true){w.dropItem(Items.BONE, rand(3));};break;
			case 2: if(drop(NormalOdds)==true){w.dropItem(Items.WHEAT, rand(3));};break;
			// LOOTING DROPS
			case 3: if(drop(NormalOdds)==true){w.dropItem(Items.BEETROOT_SEEDS, rand(6));};break;
			case 4: if(drop(NormalOdds)==true){w.dropItem(Items.MELON_SEEDS,rand(6));};break;
			case 5: if(drop(NormalOdds)==true){w.dropItem(Items.PUMPKIN_SEEDS, rand(6));};break;
		}
	}


	/**
	 * Zombie Villager Method Drops specific items.
	 * 
	 * @param e The event to Pull Objects from.
	 * */
	private static void Zombie_Villager(LivingDropsEvent e) {
		Entity w = e.getEntity();
		int amt = ran.nextInt(2+e.getLootingLevel());
		//Base Drop Tweaked.
		switch(amt) {
			// Normal Extra Drops 
			default:if(drop(NormalOdds)==true){w.dropItem(Items.BONE, rand(1));};break;
			case 0: if(drop(NormalOdds)==true){w.dropItem(Items.BONE, rand(3));};break;
			case 1: if(drop(NormalOdds)==true){w.dropItem(Items.ROTTEN_FLESH, rand(3));};break;
			// LOOTING DROPS
			case 3: if(drop(NormalOdds)==true){w.dropItem(Items.POISONOUS_POTATO, rand(2));};break;
			case 4: if(drop(NormalOdds)==true){w.dropItem(Items.IRON_INGOT,rand(3));};break;
			case 5: if(drop(NormalOdds)==true){w.dropItem(Items.EMERALD, rand(1));};break;
		}
	}


	/**
	 * Zombie Method Drops specific items.
	 * 
	 * @param e The event to Pull Objects from.
	 * */
	private static void Zombie(LivingDropsEvent e) {
		Entity w = e.getEntity();
		int amt = ran.nextInt(2+e.getLootingLevel());
		//Base Drop Tweaked.
		switch(amt) {
			// Normal Extra Drops 
			default:if(drop(NormalOdds)==true){w.dropItem(Items.BONE, rand(1));};break;
			case 0: if(drop(NormalOdds)==true){w.dropItem(Items.ROTTEN_FLESH, rand(3));};break;
			case 1: if(drop(NormalOdds)==true){w.dropItem(Items.WHEAT_SEEDS, rand(3));};break;
			case 2: if(drop(NormalOdds)==true){w.dropItem(RandomFood(), rand(3));};break;
			// LOOTING DROPS
			case 3: if(drop(NormalOdds)==true){w.dropItem(Items.BEETROOT_SEEDS, rand(6));};break;
			case 4: if(drop(NormalOdds)==true){w.dropItem(Items.MELON_SEEDS,rand(6));};break;
			case 5: if(drop(NormalOdds)==true){w.dropItem(Items.PUMPKIN_SEEDS, rand(6));};break;
		}
	}


	/**
	 * Wither Skeleton Method Drops specific items.
	 * 
	 * @param e The event to Pull Objects from.
	 * */
	private static void Wither_Skeleton(LivingDropsEvent e) {
		Entity w = e.getEntity();
		int amt = ran.nextInt(2+e.getLootingLevel());
		if(MoreSkulls==true && drop(WitherSkull)==true ){w.dropItem(new ItemStack(Blocks.SKULL,1,1).getItem(), 1);}
		//Base Drop Tweaked.
		switch(amt) {
			// Normal Extra Drops 
			default:if(drop(NormalOdds)==true){w.dropItem(Items.BONE, rand(1));};break;
			case 0: if(drop(NormalOdds)==true){w.dropItem(Items.NETHER_WART, rand(3));};break;
			case 1: if(drop(NormalOdds)==true){w.dropItem(Items.BONE, rand(3));};break;
			case 2: if(drop(NormalOdds)==true){w.dropItem(Items.BONE, rand(3));};break;
			// LOOTING DROPS
			case 3: if(drop(RareOdds)==true){w.dropItem(Items.BONE, rand(8));};break;
			case 4: if(drop(RareOdds)==true){w.dropItem(getEquipedItem(w),1);};break;
			case 5: if(drop(WitherSkull)==true && MoreSkulls==false){w.dropItem(new ItemStack(Blocks.SKULL,1,1).getItem(), rand(1));};break;
		}
	}


	/**
	 * Witch Method Drops specific items.
	 * 
	 * @param e The event to Pull Objects from.
	 * */
	private static void Witch(LivingDropsEvent e) {
		Entity w = e.getEntity();
		int amt = ran.nextInt(2+e.getLootingLevel());
		//Base Drop Tweaked.
		switch(amt) {
			// Normal Extra Drops 
			default:if(drop(NormalOdds)==true){w.dropItem(Items.BONE, rand(1));}	;break;
			case 0: if(drop(NormalOdds)==true){w.dropItem(Items.BONE, rand(3));}	;break;
			case 1: if(drop(NormalOdds)==true){w.dropItem(RandomFood(), rand(3));}	;break;
			case 2: if(drop(NormalOdds)==true){w.dropItem(Items.STICK, rand(3));}	;break;
			// LOOTING DROPS
			case 3: if(drop(NormalOdds)==true){w.dropItem(Items.GLASS_BOTTLE, rand(6));};break;
			case 4: if(drop(NormalOdds)==true){w.dropItem(Items.GLOWSTONE_DUST,rand(6));};break;
			case 5: if(drop(NormalOdds)==true){w.dropItem(Items.GUNPOWDER, rand(6));};break;
		}
	}


	/**
	 * Vindicator Method Drops specific items.
	 * 
	 * @param e The event to Pull Objects from.
	 * */
	private static void Vindicator(LivingDropsEvent e) {
		Entity w = e.getEntity();
		int amt = ran.nextInt(2+e.getLootingLevel());
		//Base Drop Tweaked.
		switch(amt) {
			// Normal Extra Drops 
			default:if(drop(NormalOdds)==true){w.dropItem(Items.BONE, rand(1));};break;
			case 0: if(drop(NormalOdds)==true){w.dropItem(Items.BONE, rand(3));};break;
			case 1: if(drop(NormalOdds)==true){w.dropItem(RandomFood(), rand(3));};break;
			case 2: if(drop(NormalOdds)==true){w.dropItem(Items.EMERALD, rand(1));};break;
			// LOOTING DROPS
			case 3: if(drop(NormalOdds)==true){w.dropItem(Items.POISONOUS_POTATO, rand(2));};break;
			case 4: if(drop(NormalOdds)==true){w.dropItem(RandomFood(),rand(6));};break;
			case 5: if(drop(NormalOdds)==true){w.dropItem(Items.EMERALD, rand(6));};break;
		}
	}


	/**
	 * Vex Method Drops specific items.
	 * 
	 * @param e The event to Pull Objects from.
	 * */
	private static void Vex(LivingDropsEvent e) {
		Entity w = e.getEntity();
		int amt = ran.nextInt(2+e.getLootingLevel());
		//Base Drop Tweaked.
		switch(amt) {
			// Normal Extra Drops 
			default:if(drop(NormalOdds)==true){w.dropItem(Items.GHAST_TEAR, rand(1));};break;
			case 0: break;
			case 1: break;
			case 2: break;
			// LOOTING DROPS
			case 3: if(rand(4)>3){w.dropItem(Items.DIAMOND, 1);};break;
			case 4: if(rand(4)>3){w.dropItem(Items.IRON_SWORD,rand(1));};break;
			case 5: if(rand(4)>3){w.dropItem(Items.GHAST_TEAR, rand(2));};break;
		}
	}


	/**
	 * Stray Method Drops specific items.
	 * 
	 * @param e The event to Pull Objects from.
	 * */
	private static void Stray(LivingDropsEvent e) {
		Entity w = e.getEntity();
		int amt = ran.nextInt(2+e.getLootingLevel());
		//Base Drop Tweaked.
		switch(amt) {
			// Normal Extra Drops 
			default:if(drop(NormalOdds)==true){w.dropItem(Items.BONE, rand(1));};break;
			case 0: if(drop(NormalOdds)==true){w.dropItem(Items.BONE, rand(3));};break;
			case 1: if(drop(NormalOdds)==true){w.dropItem(Items.BONE, rand(3));};break;
			case 2: if(rand(4)>3){w.dropItem(Items.ARROW, rand(3));};break;
			// LOOTING DROPS
			case 3: if(rand(4)>2){w.dropItem(Items.SKULL, rand(1));};break;
			case 4: if(rand(4)>3){w.dropItem(Items.BONE, rand(8));};break;
			case 5: if(rand(4)>3){w.dropItem(getEquipedItem(w), rand(1));};break;
		}
	}


	/**
	 * Slime Method Drops specific items.
	 * 
	 * @param e The event to Pull Objects from.
	 * */
	private static void Slime(LivingDropsEvent e) {
		Entity w = e.getEntity();
		w.dropItem(Items.SLIME_BALL, rand(2));
	}


	/**
	 * Skeleton Method Drops specific items.
	 * 
	 * @param e The event to Pull Objects from.
	 * */
	private static void Skeleton(LivingDropsEvent e) {
		Entity w = e.getEntity();
		int amt = ran.nextInt(2+e.getLootingLevel());
		if(MoreSkulls==true) {if(drop(SkeleSkull)==true){w.dropItem(Items.SKULL, 1);}}
		//Base Drop Tweaked.
		switch(amt) {
			// Normal Extra Drops 
			default:if(drop(NormalOdds)==true){w.dropItem(Items.BONE, rand(1));};break;
			case 0: if(drop(NormalOdds)==true){w.dropItem(Items.BONE, rand(3));};break;
			case 1: if(drop(NormalOdds)==true){w.dropItem(Items.BONE, rand(3));};break;
			case 2: if(drop(RareOdds)==true){w.dropItem(Items.ARROW, rand(3));};break;
			// LOOTING DROPS
			case 3: if(drop(SkeleSkull)==true && MoreSkulls==false){w.dropItem(Items.SKULL, 1);};break;
			case 4: if(drop(RareOdds)==true){w.dropItem(Items.BONE, rand(8));};break;
			case 5: if(drop(RareOdds)==true){w.dropItem(getEquipedItem(w), rand(1));};break;
		}
	}


	/**
	 * Silverfish Method Drops specific items.
	 * 
	 * @param e The event to Pull Objects from.
	 * */
	private static void Silverfish(LivingDropsEvent e) {
		// No Extra Drops deemed neccessary.
	}


	/**
	 * Shulker Method Drops specific items.
	 * 
	 * @param e The event to Pull Objects from.
	 * */
	private static void Shulker(LivingDropsEvent e) {
		// Nothing really extra to add here.
	}


	/**
	 * Magma Cube Method Drops specific items.
	 * 
	 * @param e The event to Pull Objects from.
	 * */
	private static void Magma_Cube(LivingDropsEvent e) {
		Entity w = e.getEntity();
		w.dropItem(Items.MAGMA_CREAM, rand(2));
	}


	/**
	 * Guardian Method Drops specific items.
	 * 
	 * @param e The event to Pull Objects from.
	 * */
	private static void Guardian(LivingDropsEvent e) {
		Entity w = e.getEntity();
		int amt = ran.nextInt(2+e.getLootingLevel());
		//Base Drop Tweaked.
		switch(amt) {
			// Normal Extra Drops 
			default:if(drop(NormalOdds)==true){w.dropItem(Items.BONE, rand(1));};break;
			case 0: if(drop(NormalOdds)==true){w.dropItem(Items.BONE, rand(2));};break;
			case 1: if(drop(NormalOdds)==true){w.dropItem(Items.PRISMARINE_SHARD, rand(3));};break;
			case 2: if(drop(NormalOdds)==true){w.dropItem(Items.FISH, rand(2));};break;
			// LOOTING DROPS
			case 3: if(rand(4)>2){w.dropItem(Items.PRISMARINE_CRYSTALS, rand(1));};break;
			case 4: if(rand(4)>2){w.dropItem(Items.BONE,rand(4));};break;
			case 5: if(rand(4)>2){w.dropItem(Items.PRISMARINE_SHARD, rand(8));};break;
		}
	}


	/**
	 * Ghast Method Drops specific items.
	 * 
	 * @param e The event to Pull Objects from.
	 * */
	private static void Ghast(LivingDropsEvent e) {
		Entity w = e.getEntity();
		int amt = ran.nextInt(2+e.getLootingLevel());
		//Base Drop Tweaked.
		switch(amt) {
			// Normal Extra Drops 
			default:if(drop(NormalOdds)==true){w.dropItem(Items.BONE, rand(1));};break;
			case 0: if(drop(NormalOdds)==true){w.dropItem(Items.BONE, rand(3));};break;
			case 1: if(drop(NormalOdds)==true){w.dropItem(Items.GHAST_TEAR, rand(1));};break;
			case 2: if(drop(NormalOdds)==true){w.dropItem(Items.GUNPOWDER, rand(2));};break;
			// LOOTING DROPS
			case 3: if(rand(4)>2){w.dropItem(Items.GHAST_TEAR, rand(6));};break;
			case 4: if(rand(4)>2){w.dropItem(Items.GOLD_NUGGET,rand(6));};break;
			case 5: if(rand(4)>3){w.dropItem(Items.BLAZE_POWDER, rand(3));};break;
		}
	}


	/**
	 * Evoker Method Drops specific items.
	 * 
	 * @param e The event to Pull Objects from.
	 * */
	private static void Evoker(LivingDropsEvent e) {
		Entity w = e.getEntity();
		int amt = ran.nextInt(2+e.getLootingLevel());
		//Base Drop Tweaked.
		switch(amt) {
			// Normal Extra Drops 
			default:if(drop(NormalOdds)==true){w.dropItem(Items.BONE, rand(1));};break;
			case 0: if(drop(NormalOdds)==true){w.dropItem(RandomFood(), rand(3));};break;
			case 1: if(drop(NormalOdds)==true){w.dropItem(Items.BONE, rand(3));};break;
			case 2: if(drop(NormalOdds)==true){w.dropItem(Items.BONE, rand(3));};break;
			// LOOTING DROPS
			case 3: if(rand(4)>2){w.dropItem(Items.EMERALD, rand(1));};break;
			case 4: if(rand(4)>2){w.dropItem(RandomFood(),rand(6));};break;
			case 5: if(rand(4)>3){w.dropItem(Items.TOTEM_OF_UNDYING, rand(1));};break;
		}
	}


	/**
	 * Elder Guardian Method Drops specific items.
	 * 
	 * @param e The event to Pull Objects from.
	 * */
	private static void Elder_Guardian(LivingDropsEvent e) {
		Entity w = e.getEntity();
		int amt = ran.nextInt(2+e.getLootingLevel());
		//Base Drop Tweaked.
		switch(amt) {
			// Normal Extra Drops 
			default:if(drop(NormalOdds)==true){w.dropItem(Items.BONE, rand(1));};break;
			case 0: if(drop(NormalOdds)==true){w.dropItem(Items.PRISMARINE_SHARD, rand(1));};break;
			case 1: if(drop(NormalOdds)==true){w.dropItem(Items.BONE, rand(3));};break;
			case 2: if(drop(NormalOdds)==true){w.dropItem(Items.FISH, rand(3));};break;
			// LOOTING DROPS
			case 3: if(rand(4)>2){w.dropItem(Items.PRISMARINE_CRYSTALS, rand(6));};break;
			case 4: if(rand(4)>2){w.dropItem(Items.FISH,rand(6));};break;
			case 5: if(rand(4)>2){w.dropItem(Items.PRISMARINE_CRYSTALS, rand(2));};break;
		}
	}


	/**
	 * Creeper Method Drops specific items.
	 * 
	 * @param e The event to Pull Objects from.
	 * */
	private static void Creeper(LivingDropsEvent e) {
		Entity w = e.getEntity();
		int amt = ran.nextInt(2+e.getLootingLevel());
		//Base Drop Tweaked.
		switch(amt) {
			// Normal Extra Drops 
			default:if(drop(NormalOdds)==true){w.dropItem(Items.BONE, rand(1));};break;
			case 0: if(drop(NormalOdds)==true){w.dropItem(Items.BONE, rand(3));};break;
			case 1: if(drop(NormalOdds)==true){w.dropItem(Items.GUNPOWDER, rand(3));};break;
			case 2: if(rand(4)>3){w.dropItem(new ItemStack(Blocks.SKULL,1,4).getItem(), rand(1));};break;
			// LOOTING DROPS
			case 3: if(drop(NormalOdds)==true){w.dropItem(Items.GUNPOWDER, rand(6));};break;
			case 4: if(drop(NormalOdds)==true){w.dropItem(Items.GUNPOWDER,rand(8));};break;
			case 5: if(drop(NormalOdds)==true){w.dropItem(Items.GUNPOWDER, rand(10));};break;
		}
	}


	/**
	 * Blaze Method Drops specific items.
	 * 
	 * @param e The event to Pull Objects from.
	 * */
	private static void Blaze(LivingDropsEvent e) {
		Entity w = e.getEntity();
		int amt = ran.nextInt(2+e.getLootingLevel());
		//Base Drop Tweaked.
		switch(amt) {
			// Normal Extra Drops 
			default:if(drop(NormalOdds)==true){w.dropItem(Items.BLAZE_ROD, rand(1));};break;
			case 0: if(drop(NormalOdds)==true){w.dropItem(Items.BLAZE_ROD, rand(3));};break;
			case 1: if(drop(NormalOdds)==true){w.dropItem(Items.BLAZE_POWDER, rand(3));};break;
			case 2: if(rand(4)>2){w.dropItem(Items.MAGMA_CREAM, rand(3));};break;
			// LOOTING DROPS
			case 3: if(drop(NormalOdds)==true){w.dropItem(Items.BLAZE_ROD, rand(6));};break;
			case 4: if(drop(NormalOdds)==true){w.dropItem(Items.BLAZE_POWDER,rand(6));};break;
			case 5: if(drop(NormalOdds)==true){w.dropItem(Items.MAGMA_CREAM, rand(6));};break;
		}
	}


	/**
	 * Zombie Pigman Method Drops specific items.
	 * 
	 * @param e The event to Pull Objects from.
	 * */
	private static void Zombie_Pigman(LivingDropsEvent e) {
		Entity w = e.getEntity();
		int amt = ran.nextInt(2+e.getLootingLevel());
		//Base Drop Tweaked.
		switch(amt) {
			// Normal Extra Drops 
			default:if(drop(NormalOdds)==true){w.dropItem(Items.BONE, rand(1));};break;
			case 0: if(drop(NormalOdds)==true){w.dropItem(Items.GOLD_NUGGET, rand(3));};break;
			case 1: if(drop(NormalOdds)==true){w.dropItem(Items.BONE, rand(3));};break;
			case 2: if(drop(NormalOdds)==true){w.dropItem(Items.PORKCHOP, rand(1));};break;
			// LOOTING DROPS
			case 3: if(drop(NormalOdds)==true){w.dropItem(getEquipedItem(w), rand(1));};break;
			case 4: if(drop(NormalOdds)==true){w.dropItem(Items.GOLD_NUGGET,rand(6));};break;
			case 5: if(drop(NormalOdds)==true){w.dropItem(Items.GOLD_INGOT, rand(1));};break;
		}
	}


	/**
	 * Polar Bear Method Drops specific items.
	 * 
	 * @param e The event to Pull Objects from.
	 * */
	private static void Polar_Bear(LivingDropsEvent e) {
		Entity w = e.getEntity();
		int amt = ran.nextInt(2+e.getLootingLevel());
		//Base Drop Tweaked.
		switch(amt) {
			// Normal Extra Drops 
			default:if(drop(NormalOdds)==true){w.dropItem(Items.BONE, rand(1));};break;
			case 0: if(drop(NormalOdds)==true){w.dropItem(Items.SNOWBALL, rand(3));};break;
			case 1: if(drop(NormalOdds)==true){w.dropItem(Items.FISH, rand(3));};break;
			case 2: if(drop(NormalOdds)==true){w.dropItem(Items.BONE, rand(4));};break;
			// LOOTING DROPS
			case 3: if(drop(NormalOdds)==true){w.dropItem(IFB(Blocks.ICE), rand(2));};break;
			case 4: if(drop(NormalOdds)==true){w.dropItem(Items.FISH,rand(6));};break;
			case 5: if(drop(NormalOdds)==true){w.dropItem(Items.BONE, rand(6));};break;
		}
	}


	/**
	 * Husk Method Drops specific items.
	 * 
	 * @param e The event to Pull Objects from.
	 * */
	private static void Husk(LivingDropsEvent e) {
		Entity w = e.getEntity();
		int amt = ran.nextInt(2+e.getLootingLevel());
		//Base Drop Tweaked.
		switch(amt) {
			// Normal Extra Drops 
			default:if(drop(NormalOdds)==true){w.dropItem(Items.BONE, rand(1));};break;
			case 0: if(drop(NormalOdds)==true){w.dropItem(RandomFood(), rand(3));};break;
			case 1: if(drop(NormalOdds)==true){w.dropItem(Items.IRON_INGOT, rand(2));};break;
			case 2: if(drop(NormalOdds)==true){w.dropItem(Items.ROTTEN_FLESH, rand(3));};break;
			// LOOTING DROPS
			case 3: if(rand(4)>3){w.dropItem(getEquipedItem(w), rand(1));};break;
			case 4: if(rand(4)>2){w.dropItem(Items.POISONOUS_POTATO,rand(6));};break;
			case 5: if(rand(4)>2){w.dropItem(Items.GOLD_NUGGET, rand(6));};break;
		}
	}


	/**
	 * Ocelot Method Drops specific items.
	 * 
	 * @param e The event to Pull Objects from.
	 * */
	private static void Ocelot(LivingDropsEvent e) {
		Entity w = e.getEntity();
		int amt = ran.nextInt(2+e.getLootingLevel());
		//Base Drop Tweaked.
		switch(amt) {
			// Normal Extra Drops 
			default:if(drop(NormalOdds)==true){w.dropItem(Items.BONE, rand(1));};break;
			case 0: if(drop(NormalOdds)==true){w.dropItem(Items.BONE, rand(2));};break;
			case 1: if(drop(NormalOdds)==true){w.dropItem(Items.FISH, rand(2));};break;
			// LOOTING DROPS
			case 3: if(rand(4)>2){w.dropItem(Items.FISH, rand(3));};break;
			case 4: if(rand(4)>3){w.dropItem(Items.EMERALD, rand(1));};break;
		}
	}


	/**
	 * Parrot Method Drops specific items.
	 * 
	 * @param e The event to Pull Objects from.
	 * */
	private static void Parrot(LivingDropsEvent e) {
		Entity w = e.getEntity();
		int amt = ran.nextInt(2+e.getLootingLevel());
		//Base Drop Tweaked.
		switch(amt) {
			// Normal Extra Drops 
			default:if(drop(NormalOdds)==true){w.dropItem(Items.BONE, rand(1));};break;
			case 0: if(drop(NormalOdds)==true){w.dropItem(Items.BONE, rand(2));};break;
			case 1: if(drop(NormalOdds)==true){w.dropItem(Items.FEATHER, rand(3));};break;
			case 2: if(drop(NormalOdds)==true){w.dropItem(Items.WHEAT_SEEDS, rand(3));};break;
			// LOOTING DROPS
			case 3: if(drop(NormalOdds)==true){w.dropItem(Items.FEATHER, rand(6));};break;
			case 4: if(drop(NormalOdds)==true){w.dropItem(Items.MELON_SEEDS,rand(6));};break;
			case 5: if(drop(NormalOdds)==true){w.dropItem(Items.PUMPKIN_SEEDS, rand(6));};break;
		}
	}


	/**
	 * Wolf Method Drops specific items.
	 * 
	 * @param e The event to Pull Objects from.
	 * */
	private static void Wolf(LivingDropsEvent e) {
		Entity w = e.getEntity();
		int amt = ran.nextInt(2+e.getLootingLevel());
		//Base Drop Tweaked.
		switch(amt) {
			// Normal Extra Drops 
			default:if(drop(NormalOdds)==true){w.dropItem(Items.BONE, rand(3));};break;
			case 0: if(drop(NormalOdds)==true){w.dropItem(Items.BONE, rand(3));};break;
			case 1: if(drop(NormalOdds)==true){w.dropItem(Items.RABBIT, rand(1));};break;
			case 2: if(drop(NormalOdds)==true){w.dropItem(Items.BEEF, rand(1));};break;
			// LOOTING DROPS
			case 3: if(drop(NormalOdds)==true){w.dropItem(Items.BONE, rand(4));};break;
		}
	}


	/**
	 * Iron Golem Method Drops specific items.
	 * 
	 * @param e The event to Pull Objects from.
	 * */
	private static void Iron_Golem(LivingDropsEvent e) {
		Entity w = e.getEntity();
		int amt = ran.nextInt(2+e.getLootingLevel());
		//Base Drop Tweaked.
		switch(amt) {
			// Normal Extra Drops 
			default:if(drop(NormalOdds)==true){w.dropItem(Items.IRON_INGOT, rand(1));};break;
			case 0: if(drop(NormalOdds)==true){w.dropItem(Items.IRON_INGOT, rand(3));};break;
			case 1: if(drop(NormalOdds)==true){w.dropItem(RandomFood(), rand(3));};break;
			case 2: if(drop(NormalOdds)==true){w.dropItem(IFB(Blocks.RED_FLOWER), rand(3));};break;
			// LOOTING DROPS
			case 3: if(rand(4)>2){w.dropItem(Items.IRON_INGOT, rand(6));};break;
			case 4: if(rand(4)>3){w.dropItem(Items.GOLD_INGOT,rand(1));};break;
		}
	}


	/**
	 * Ender Dragon Method Drops specific items.
	 * 
	 * @param e The event to Pull Objects from.
	 * */
	private static void Ender_Dragon(LivingDropsEvent e) {
		Entity w = e.getEntity();
		int amt = ran.nextInt(2+e.getLootingLevel());
		//Base Drop Tweaked.
		switch(amt) {
			// Normal Extra Drops 
			default:if(drop(NormalOdds)==true){w.dropItem(Items.BONE, rand(16));};break;
			case 0: if(drop(NormalOdds)==true){w.dropItem(Items.BONE, rand(20));};break;
			case 1: if(drop(NormalOdds)==true){w.dropItem(Items.ENDER_PEARL, rand(16));};break;
			case 2: if(drop(NormalOdds)==true){w.dropItem(Items.GUNPOWDER, rand(15));};break;
			// LOOTING DROPS
			case 3: if(rand(4)>2){w.dropItem(Items.DIAMOND, rand(16));};break;
			case 4: if(rand(4)>2){w.dropItem(Items.EMERALD,rand(16));};break;
			case 5: if(drop(NormalOdds)==true){w.dropItem(Items.GOLD_INGOT, rand(16));};break;
		}
	}


	/**
	 * Wither Method Drops specific items.
	 * 
	 * @param e The event to Pull Objects from.
	 * */
	private static void Wither(LivingDropsEvent e) {
		Entity w = e.getEntity();
		int amt = ran.nextInt(2+e.getLootingLevel());
		//Base Drop Tweaked.
		switch(amt) {
			// Normal Extra Drops 
			default:if(drop(NormalOdds)==true){w.dropItem(Items.BONE, rand(1));};break;
			case 0: if(drop(NormalOdds)==true){w.dropItem(Items.GOLD_INGOT, rand(3));};break;
			case 1: if(drop(NormalOdds)==true){w.dropItem(Items.IRON_INGOT, rand(3));};break;
			case 2: if(drop(NormalOdds)==true){w.dropItem(Items.COAL, rand(3));};break;
			// LOOTING DROPS
			case 3: if(drop(NormalOdds)==true){w.dropItem(Items.EMERALD, rand(6));};break;
			case 4: if(drop(NormalOdds)==true){w.dropItem(Items.DIAMOND,rand(6));};break;
			case 5: if(drop(NormalOdds)==true){w.dropItem(Items.QUARTZ, rand(6));};break;
		}
	}


	/**
	 * Snow Golem Method Drops specific items.
	 * 
	 * @param e The event to Pull Objects from.
	 * */
	private static void Snow_Golem(LivingDropsEvent e) {
		Entity w = e.getEntity();
		int amt = ran.nextInt(2+e.getLootingLevel());
		//Base Drop Tweaked.
		switch(amt) {
			// Normal Extra Drops 
			default:if(drop(NormalOdds)==true){w.dropItem(Items.SNOWBALL, rand(1));};break;
			case 0: if(drop(NormalOdds)==true){w.dropItem(Items.SNOWBALL, rand(3));};break;
			case 1: if(drop(NormalOdds)==true){w.dropItem(Items.PUMPKIN_SEEDS, rand(3));};break;
			case 2: if(rand(4)>3){w.dropItem(Items.GOLD_NUGGET, rand(3));};break;
			// LOOTING DROPS
			case 3: if(rand(4)>2){w.dropItem(Items.GOLD_INGOT, rand(1));};break;
			case 4: if(drop(NormalOdds)==true){w.dropItem(Items.MELON_SEEDS,rand(6));};break;
			case 5: if(drop(NormalOdds)==true){w.dropItem(Items.PUMPKIN_SEEDS, rand(6));};break;
		}
	}


	/**
	 * Enderman Method Drops specific items.
	 * 
	 * @param e The event to Pull Objects from.
	 * */
	private static void Enderman(LivingDropsEvent e) {
		Entity w = e.getEntity();
		int amt = ran.nextInt(2+e.getLootingLevel());
		//Base Drop Tweaked.
		switch(amt) {
			// Normal Extra Drops 
			default:if(drop(NormalOdds)==true){w.dropItem(Items.BONE, rand(1));};break;
			case 0: if(drop(NormalOdds)==true){w.dropItem(Items.ENDER_PEARL, rand(3));};break;
			case 1: if(drop(NormalOdds)==true){w.dropItem(Items.BONE, rand(3));};break;
			case 2: if(rand(4)>3){w.dropItem(Items.EMERALD, rand(1));};break;
			// LOOTING DROPS
			case 3: if(rand(4)>2){w.dropItem(Items.ENDER_PEARL, rand(5));};break;
			case 4: if(rand(4)>3){w.dropItem(Items.EMERALD,rand(2));};break;
			case 5: if(rand(4)>3){w.dropItem(Items.ENDER_EYE, rand(3));};break;
		}
	}


	/**
	 * Cave Spider Method Drops specific items.
	 * 
	 * @param e The event to Pull Objects from.
	 * */
	private static void Cave_Spider(LivingDropsEvent e) {
		Entity w = e.getEntity();
		int amt = ran.nextInt(2+e.getLootingLevel());
		//Base Drop Tweaked.
		switch(amt) {
			// Normal Extra Drops 
			default:if(drop(NormalOdds)==true){w.dropItem(Items.BONE, rand(1));};break;
			case 0: if(drop(NormalOdds)==true){w.dropItem(Items.BONE, rand(2));};break;
			case 1: if(drop(NormalOdds)==true){w.dropItem(Items.SPIDER_EYE, rand(3));};break;
			case 2: if(drop(NormalOdds)==true){w.dropItem(Items.STRING, rand(3));};break;
			// LOOTING DROPS
			case 3: if(drop(NormalOdds)==true){w.dropItem(Items.STRING, rand(6));};break;
			case 4: if(drop(NormalOdds)==true){w.dropItem(Items.SPIDER_EYE,rand(6));};break;
			case 5: if(drop(NormalOdds)==true){w.dropItem(Items.GOLD_INGOT, rand(2));};break;
		}
	}




	/**
	 * Cow Method Drops specific items for COWS
	 * 
	 * @param e The event to Pull Objects from.
	 * */
	private static void Cow(LivingDropsEvent e) {
		Entity w = e.getEntity();
		int amt = ran.nextInt(2+e.getLootingLevel());
		//Base Drop Tweaked.
		switch(amt) {
			// Normal Extra Drops 
			default:if(drop(NormalOdds)==true){w.dropItem(Items.BEEF, rand(1));};break;
			case 0: if(drop(NormalOdds)==true){w.dropItem(Items.LEATHER, rand(3));};break;
			case 1: if(drop(NormalOdds)==true){w.dropItem(Items.BONE, rand(3));};break;
			case 2: if(drop(NormalOdds)==true){w.dropItem(Items.WHEAT, rand(3));};break;
			// LOOTING DROPS
			case 3: if(drop(NormalOdds)==true){w.dropItem(Items.BEETROOT_SEEDS, rand(6));};break;
			case 4: if(drop(NormalOdds)==true){w.dropItem(Items.MELON_SEEDS,rand(6));};break;
			case 5: if(drop(NormalOdds)==true){w.dropItem(Items.PUMPKIN_SEEDS, rand(6));};break;
		}
		
	}
	/**
	 * Chicken Method Drops specific items.
	 * 
	 * @param e The event to Pull Objects from.
	 * */
	private static void Chicken(LivingDropsEvent e) {
		Entity w = e.getEntity();
		int amt = ran.nextInt(4+e.getLootingLevel());
		//Base Drop Tweaked.
		switch(amt) {
			// Normal Extra Drops 
			default:if(drop(NormalOdds)==true){w.dropItem(Items.CHICKEN, rand(1));};break;
			case 0: if(drop(NormalOdds)==true){w.dropItem(Items.EGG, rand(3));};break;
			case 1: if(drop(NormalOdds)==true){w.dropItem(Items.BONE, rand(1));};break;
			case 2: if(drop(NormalOdds)==true){w.dropItem(Items.FEATHER, rand(2));};break;
			case 4: if(drop(NormalOdds)==true){w.dropItem(Items.MELON_SEEDS, rand(2));};break;
			// LOOTING DROPS
			case 5: if(drop(NormalOdds)==true){w.dropItem(Items.EGG, rand(2));};break;
			case 6: if(drop(NormalOdds)==true){w.dropItem(Items.FEATHER,rand(6));};break;
			case 7: if(drop(NormalOdds)==true){w.dropItem(Items.WHEAT_SEEDS, rand(6));};break;
		}
		
	}
	/**
	 * Pig Method Drops specific items.
	 * 
	 * @param e The event to Pull Objects from.
	 * */
	private static void Pig(LivingDropsEvent e) {
		Entity w = e.getEntity();
		int amt = ran.nextInt(2+e.getLootingLevel());
		//Base Drop Tweaked.
		switch(amt) {
			// Normal Extra Drops 
			default:if(drop(NormalOdds)==true){w.dropItem(Items.PORKCHOP, rand(1));};break;
			case 0: if(drop(NormalOdds)==true){w.dropItem(Items.CARROT, rand(3));};break;
			case 1: if(drop(NormalOdds)==true){w.dropItem(Items.BONE, rand(1));};break;
			case 2: if(drop(NormalOdds)==true){w.dropItem(Items.PORKCHOP, rand(2));};break;
			// LOOTING DROPS
			case 3: if(drop(NormalOdds)==true){w.dropItem(Items.PORKCHOP, rand(6));};break;
			case 4: if(drop(NormalOdds)==true){w.dropItem(Items.CARROT_ON_A_STICK,1);};break;
			case 5: if(drop(NormalOdds)==true){w.dropItem(Items.BONE, rand(6));};break;
		}
		
	}
	/**
	 * Rabbit Method Drops specific items.
	 * 
	 * @param e The event to Pull Objects from.
	 * */
	private static void Rabbit(LivingDropsEvent e) {
		Entity w = e.getEntity();
		int amt = ran.nextInt(2+e.getLootingLevel());
		//Base Drop Tweaked.
		switch(amt) {
			// Normal Extra Drops 
			default:if(drop(NormalOdds)==true){w.dropItem(Items.RABBIT_HIDE, rand(1));};break;
			case 0: if(drop(NormalOdds)==true){w.dropItem(Items.CARROT, rand(3));};break;
			case 1: if(drop(NormalOdds)==true){w.dropItem(Items.BONE, rand(1));};break;
			case 2: if(drop(NormalOdds)==true){w.dropItem(Items.PORKCHOP, rand(2));};break;
			// LOOTING DROPS
			case 3: if(drop(NormalOdds)==true){w.dropItem(Items.RABBIT_FOOT, rand(2));};break;
			case 4: if(drop(NormalOdds)==true){w.dropItem(Items.CARROT,rand(6));};break;
			case 5: if(((EntityRabbit)w).getRabbitType()==4){w.dropItem(Items.GOLDEN_CARROT, rand(2));};break;
		}
		
	}
	/**
	 * Mooshroom Method Drops specific items.
	 * 
	 * @param e The event to Pull Objects from.
	 * */
	private static void Mooshroom(LivingDropsEvent e) {
		Entity w = e.getEntity();
		int amt = ran.nextInt(2+e.getLootingLevel());
		//Base Drop Tweaked.
		switch(amt) {
			// Normal Extra Drops 
			default:if(drop(NormalOdds)==true){w.dropItem(Items.MUSHROOM_STEW, rand(1));};break;
			case 0: if(drop(NormalOdds)==true){w.dropItem(Items.WHEAT, rand(3));};break;
			case 1: if(drop(NormalOdds)==true){w.dropItem(Items.BONE, rand(1));};break;
			case 2: if(drop(NormalOdds)==true){w.dropItem(Items.MILK_BUCKET, rand(1));};break;
			// LOOTING DROPS
			case 3: if(rand(4)>3){w.dropItem(Items.GOLDEN_APPLE, rand(2));};break;
			case 4: if(drop(NormalOdds)==true){w.dropItem(Items.BEEF,rand(6));};break;
			case 5: if(drop(NormalOdds)==true){w.dropItem(Items.PUMPKIN_SEEDS, rand(6));};break;
		}
		
	}
	/**
	 * Sheep Method Drops specific items.
	 * 
	 * @param e The event to Pull Objects from.
	 * */
	private static void Sheep(LivingDropsEvent e) {
		Entity w = e.getEntity();
		int amt = ran.nextInt(2+e.getLootingLevel());
		//Base Drop Tweaked.
		switch(amt) {
			// Normal Extra Drops 
			default:if(drop(NormalOdds)==true){w.dropItem(Items.MUTTON, rand(1));};break;
			case 0: if(drop(NormalOdds)==true){w.dropItem(IFB(Blocks.WOOL), rand(3));};break;
			case 1: if(drop(NormalOdds)==true){w.dropItem(Items.BONE, rand(1));};break;
			case 2: if(drop(NormalOdds)==true){w.dropItem(Items.WHEAT, rand(2));};break;
			// LOOTING DROPS
			case 3: if(drop(NormalOdds)==true){w.dropItem(Items.BEETROOT_SEEDS, rand(2));};break;
			case 4: if(drop(NormalOdds)==true){w.dropItem(Items.PUMPKIN_SEEDS,rand(6));};break;
			case 5: if(drop(NormalOdds)==true){w.dropItem(Items.WHEAT_SEEDS, rand(6));};break;
		}
		
	}
	/**
	 * Squid Method Drops specific items.
	 * 
	 * @param e The event to Pull Objects from.
	 * */
	private static void Squid(LivingDropsEvent e) {
		Entity w = e.getEntity();
		int amt = ran.nextInt(2+e.getLootingLevel());
		//Base Drop Tweaked.
		switch(amt) {
			// Normal Extra Drops 
			default:if(drop(NormalOdds)==true){w.dropItem(Items.DYE, rand(1));};break;
			case 0: if(drop(NormalOdds)==true){w.dropItem(Items.CARROT, rand(3));};break;
			case 1: if(drop(NormalOdds)==true){w.dropItem(Items.BONE, rand(1));};break;
			case 2: if(drop(NormalOdds)==true){w.dropItem(Items.PORKCHOP, rand(2));};break;
			// LOOTING DROPS
			case 3: if(drop(NormalOdds)==true){w.dropItem(new ItemStack(Items.FISHING_ROD, 1, rand(50)).getItem(), rand(2));};break;
			case 4: if(drop(NormalOdds)==true){w.dropItem(Items.FISH,rand(6));};break;
			case 5: if(drop(NormalOdds)==true){w.dropItem(Items.DYE, rand(6));};break;
		}
		
	}
	/**
	 * Villager Method Drops specific items.
	 * 
	 * @param e The event to Pull Objects from.
	 * */
	private static void Villager(LivingDropsEvent e) {
		Entity w = e.getEntity();
		int amt = ran.nextInt(2+e.getLootingLevel());
		//Base Drop Tweaked.
		switch(amt) {
			// Normal Extra Drops 
			default:if(drop(NormalOdds)==true){w.dropItem(Items.BONE, rand(1));};break;
			case 0: if(drop(NormalOdds)==true){w.dropItem(Items.POTATO, rand(3));};break;
			case 1: if(drop(NormalOdds)==true){w.dropItem(Items.BONE, rand(1));};break;
			case 2: if(drop(NormalOdds)==true){w.dropItem(Items.APPLE, rand(2));};break;
			// LOOTING DROPS
			case 3: if(drop(NormalOdds)==true){w.dropItem(IFB(Blocks.RED_FLOWER), rand(2));};break;
			case 4: if(drop(NormalOdds)==true){w.dropItem(Items.IRON_INGOT,rand(6));};break;
			case 5: if(drop(NormalOdds)==true){w.dropItem(Items.EMERALD, rand(6));};break;
		}
		
	}
	

}

	

