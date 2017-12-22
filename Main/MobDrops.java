package com.ironically.wdt;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.entity.passive.EntityMooshroom;
import net.minecraft.entity.passive.EntityOcelot;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntitySheep;
import net.minecraft.entity.passive.EntitySquid;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.passive.EntityWolf;
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
		//DEBUG : System.out.println("WDT > Mob Killed Name > " + e.entityLiving.getName() );
		EntityLiving meme = (EntityLiving) e.entityLiving;
		
		if(meme instanceof EntityBlaze) {
			Blaze(e);
		}else if(meme instanceof EntityCaveSpider) {
			Cave_Spider(e);
		}else if(meme instanceof EntityChicken) {
			Chicken(e);
		}else if(meme instanceof EntityCow) {
			Cow(e);
		}else if(meme instanceof EntityCreeper) {
			Creeper(e);
		}else if(meme instanceof EntityDragon) {
			Ender_Dragon(e);
		}else if(meme instanceof EntityEnderman) {
			Enderman(e);
		}else if(meme instanceof EntityGhast) {
			Ghast(e);
		}else if(meme instanceof EntityHorse) {
			EntityHorse horsey = (EntityHorse) meme;
			switch(horsey.getHorseType()) {
				default: Horse(e);break;
				case 0: Horse(e);break;
				case 1: Donkey(e);break;
				case 2: Mule(e);break;
			}
			// NEEDS TO BE CUSTOM MADE!
		}else if(meme instanceof EntityMagmaCube) {
			Magma_Cube(e);
		}else if(meme instanceof EntityIronGolem) {
			Iron_Golem(e);
		}else if(meme instanceof EntityMooshroom) {
			Mooshroom(e);
		}else if(meme instanceof EntityOcelot) {
			Ocelot(e);
		}else if(meme instanceof EntityPig) {
			Pig(e);
		}else if(meme instanceof EntityPigZombie) {
			Zombie_Pigman(e);
		}else if(meme instanceof EntitySheep) {
			Sheep(e);
		}else if(meme instanceof EntitySilverfish) {
			Silverfish(e);
		}else if(meme instanceof EntitySkeleton) {
			EntitySkeleton skeleboi = (EntitySkeleton) meme;
			if(skeleboi.getSkeletonType() == 1) {
				Wither_Skeleton(e);
			}else {
				Skeleton(e);
			}
			// CUSTOM CODE NEEDED!
		}else if(meme instanceof EntitySlime) {
			Slime(e);
		}else if(meme instanceof EntitySquid) {
			Squid(e);
		}else if(meme instanceof EntityVillager) {
			Villager(e);
		}else if(meme instanceof EntityWitch) {
			Witch(e);
		}else if(meme instanceof EntityWither) {
			Wither(e);
		}else if(meme instanceof EntityWolf) {
			Wolf(e);
		}else if(meme instanceof EntityZombie) {
			EntityZombie zom = (EntityZombie) meme;
			if(zom.isVillager() == true) {
				Zombie_Villager(e);
			}else {
				Zombie(e);
			}
		}else {
			System.out.println("LOG: WDT: MOB KILLED: "+meme.getPersistentID());
		}
		return;
	}
	//===================
	
	/**
	
	
	*/
	private static Item getEquipedItem(Entity e) {
		return null; // METHOD BROKEN!
		//return new ItemStack(e.getHeldEquipment().iterator().next().getItem(),1).getItem();
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
		
		// === The Line Below is OPTIONAL. Toggle-able in the CONFIG. ===
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
		foods.add(Items.potato);
		foods.add(Items.apple);
		foods.add(Items.bread);
		//foods.add(Items.BEETROOT); NOT IN 1.7.10! This line is leftovers from 1.12 Edition of this mod.
		foods.add(Items.carrot);
		foods.add(Items.wheat_seeds);
		foods.add(Items.wheat);
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
		Entity w = e.entityLiving;
		int amt = ran.nextInt(2+e.lootingLevel);
		//Base Drop Tweaked.
		switch(amt) {
			// Normal Extra Drops 
			default:if(drop(NormalOdds)==true){w.dropItem(Items.bone, rand(4));};break;
			case 0: if(drop(NormalOdds)==true){w.dropItem(Items.leather, rand(3));};break;
			case 1: if(drop(NormalOdds)==true){w.dropItem(Items.bone, rand(3));};break;
			case 2: if(drop(NormalOdds)==true){w.dropItem(Items.wheat, rand(3));};break;
			// LOOTING DROPS
			//case 3: if(drop(NormalOdds)==true){w.dropItem(Items.BEETROOT_seeds, rand(6));};break; 1.12 EDITION ISSUE!
			case 4: if(drop(NormalOdds)==true){w.dropItem(Items.melon_seeds,rand(6));};break;
			case 5: if(drop(NormalOdds)==true){w.dropItem(Items.pumpkin_seeds, rand(6));};break;
		}
	}


	/**
	 * Horse Method Drops specific items.
	 * 
	 * @param e The event to Pull Objects from.
	 * */
	private static void Horse(LivingDropsEvent e) {
		Entity w = e.entityLiving;
		int amt = ran.nextInt(2+e.lootingLevel);
		//Base Drop Tweaked.
		switch(amt) {
			// Normal Extra Drops 
			default:if(drop(NormalOdds)==true){w.dropItem(Items.leather, rand(1));};break;
			case 0: if(drop(NormalOdds)==true){w.dropItem(Items.leather, rand(3));};break;
			case 1: if(drop(NormalOdds)==true){w.dropItem(Items.bone, rand(3));};break;
			case 2: if(drop(NormalOdds)==true){w.dropItem(Items.wheat, rand(3));};break;
			// LOOTING DROPS
			//case 3: if(drop(NormalOdds)==true){w.dropItem(Items.BEETROOT_seeds, rand(6));};break;
			case 4: if(drop(NormalOdds)==true){w.dropItem(Items.melon_seeds,rand(6));};break;
			case 5: if(drop(NormalOdds)==true){w.dropItem(Items.pumpkin_seeds, rand(6));};break;
		}
	}


	/**
	 * Donkey Method Drops specific items.
	 * 
	 * @param e The event to Pull Objects from.
	 * */
	private static void Donkey(LivingDropsEvent e) {
		Entity w = e.entityLiving;
		int amt = ran.nextInt(2+e.lootingLevel);
		//Base Drop Tweaked.
		switch(amt) {
			// Normal Extra Drops 
			default:if(drop(NormalOdds)==true){w.dropItem(Items.bone, rand(1));};break;
			case 0: if(drop(NormalOdds)==true){w.dropItem(Items.leather, rand(3));};break;
			case 1: if(drop(NormalOdds)==true){w.dropItem(Items.bone, rand(3));};break;
			case 2: if(drop(NormalOdds)==true){w.dropItem(Items.wheat, rand(3));};break;
			// LOOTING DROPS
			//case 3: if(drop(NormalOdds)==true){w.dropItem(Items.BEETROOT_seeds, rand(6));};break;
			case 4: if(drop(NormalOdds)==true){w.dropItem(Items.melon_seeds,rand(6));};break;
			case 5: if(drop(NormalOdds)==true){w.dropItem(Items.pumpkin_seeds, rand(6));};break;
		}
	}


	/**
	 * Zombie Villager Method Drops specific items.
	 * 
	 * @param e The event to Pull Objects from.
	 * */
	private static void Zombie_Villager(LivingDropsEvent e) {
		Entity w = e.entityLiving;
		int amt = ran.nextInt(2+e.lootingLevel);
		//Base Drop Tweaked.
		switch(amt) {
			// Normal Extra Drops 
			default:if(drop(NormalOdds)==true){w.dropItem(Items.bone, rand(1));};break;
			case 0: if(drop(NormalOdds)==true){w.dropItem(Items.bone, rand(3));};break;
			case 1: if(drop(NormalOdds)==true){w.dropItem(Items.rotten_flesh, rand(3));};break;
			// LOOTING DROPS
			case 3: if(drop(NormalOdds)==true){w.dropItem(Items.poisonous_potato, rand(2));};break;
			case 4: if(drop(NormalOdds)==true){w.dropItem(Items.iron_ingot,rand(3));};break;
			case 5: if(drop(NormalOdds)==true){w.dropItem(Items.emerald, rand(1));};break;
		}
	}


	/**
	 * Zombie Method Drops specific items.
	 * 
	 * @param e The event to Pull Objects from.
	 * */
	private static void Zombie(LivingDropsEvent e) {
		Entity w = e.entityLiving;
		int amt = ran.nextInt(2+e.lootingLevel);
		//Base Drop Tweaked.
		switch(amt) {
			// Normal Extra Drops 
			default:if(drop(NormalOdds)==true){w.dropItem(Items.bone, rand(1));};break;
			case 0: if(drop(NormalOdds)==true){w.dropItem(Items.rotten_flesh, rand(3));};break;
			case 1: if(drop(NormalOdds)==true){w.dropItem(Items.wheat_seeds, rand(3));};break;
			case 2: if(drop(NormalOdds)==true){w.dropItem(RandomFood(), rand(3));};break;
			// LOOTING DROPS
			//case 3: if(drop(NormalOdds)==true){w.dropItem(Items.BEETROOT_seeds, rand(6));};break;
			case 4: if(drop(NormalOdds)==true){w.dropItem(Items.melon_seeds,rand(6));};break;
			case 5: if(drop(NormalOdds)==true){w.dropItem(Items.pumpkin_seeds, rand(6));};break;
		}
	}


	/**
	 * Wither Skeleton Method Drops specific items.
	 * 
	 * @param e The event to Pull Objects from.
	 * */
	private static void Wither_Skeleton(LivingDropsEvent e) {
		Entity w = e.entityLiving;
		int amt = ran.nextInt(2+e.lootingLevel);
		if(MoreSkulls==true && drop(WitherSkull)==true ){w.dropItem(new ItemStack(Blocks.skull,1,1).getItem(), 1);}
		//Base Drop Tweaked.
		switch(amt) {
			// Normal Extra Drops 
			default:if(drop(NormalOdds)==true){w.dropItem(Items.bone, rand(1));};break;
			case 0: if(drop(NormalOdds)==true){w.dropItem(Items.nether_wart, rand(3));};break;
			case 1: if(drop(NormalOdds)==true){w.dropItem(Items.bone, rand(3));};break;
			case 2: if(drop(NormalOdds)==true){w.dropItem(Items.bone, rand(3));};break;
			// LOOTING DROPS
			case 3: if(drop(RareOdds)==true){w.dropItem(Items.bone, rand(8));};break;
			case 4: if(drop(RareOdds)==true){w.dropItem(getEquipedItem(w),1);};break;
			case 5: if(drop(WitherSkull)==true && MoreSkulls==false){w.dropItem(new ItemStack(Blocks.skull,1,1).getItem(), rand(1));};break;
		}
	}


	/**
	 * Witch Method Drops specific items.
	 * 
	 * @param e The event to Pull Objects from.
	 * */
	private static void Witch(LivingDropsEvent e) {
		Entity w = e.entityLiving;
		int amt = ran.nextInt(2+e.lootingLevel);
		//Base Drop Tweaked.
		switch(amt) {
			// Normal Extra Drops 
			default:if(drop(NormalOdds)==true){w.dropItem(Items.bone, rand(1));}	;break;
			case 0: if(drop(NormalOdds)==true){w.dropItem(Items.bone, rand(3));}	;break;
			case 1: if(drop(NormalOdds)==true){w.dropItem(RandomFood(), rand(3));}	;break;
			case 2: if(drop(NormalOdds)==true){w.dropItem(Items.stick, rand(3));}	;break;
			// LOOTING DROPS
			case 3: if(drop(NormalOdds)==true){w.dropItem(Items.glass_bottle, rand(6));};break;
			case 4: if(drop(NormalOdds)==true){w.dropItem(Items.glowstone_dust,rand(6));};break;
			case 5: if(drop(NormalOdds)==true){w.dropItem(Items.gunpowder, rand(6));};break;
		}
	}



	/**
	 * Slime Method Drops specific items.
	 * 
	 * @param e The event to Pull Objects from.
	 * */
	private static void Slime(LivingDropsEvent e) {
		Entity w = e.entityLiving;
		w.dropItem(Items.slime_ball, rand(2));
	}


	/**
	 * Skeleton Method Drops specific items.
	 * 
	 * @param e The event to Pull Objects from.
	 * */
	private static void Skeleton(LivingDropsEvent e) {
		Entity w = e.entityLiving;
		int amt = ran.nextInt(2+e.lootingLevel);
		if(MoreSkulls==true) {if(drop(SkeleSkull)==true){w.dropItem(Items.skull, 1);}}
		//Base Drop Tweaked.
		switch(amt) {
			// Normal Extra Drops 
			default:if(drop(NormalOdds)==true){w.dropItem(Items.bone, rand(1));};break;
			case 0: if(drop(NormalOdds)==true){w.dropItem(Items.bone, rand(3));};break;
			case 1: if(drop(NormalOdds)==true){w.dropItem(Items.bone, rand(3));};break;
			case 2: if(drop(RareOdds)==true){w.dropItem(Items.arrow, rand(3));};break;
			// LOOTING DROPS
			case 3: if(drop(SkeleSkull)==true && MoreSkulls==false){w.dropItem(Items.skull, 1);};break;
			case 4: if(drop(RareOdds)==true){w.dropItem(Items.bone, rand(8));};break;
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
	 * Magma Cube Method Drops specific items.
	 * 
	 * @param e The event to Pull Objects from.
	 * */
	private static void Magma_Cube(LivingDropsEvent e) {
		Entity w = e.entityLiving;
		w.dropItem(Items.magma_cream, rand(2));
	}
	
	
	/**
	 * Ghast Method Drops specific items.
	 * 
	 * @param e The event to Pull Objects from.
	 */
	private static void Ghast(LivingDropsEvent e) {
		Entity w = e.entityLiving;
		int amt = ran.nextInt(2+e.lootingLevel);
		//Base Drop Tweaked.
		switch(amt) {
			// Normal Extra Drops 
			default:if(drop(NormalOdds)==true){w.dropItem(Items.bone, rand(1));};break;
			case 0: if(drop(NormalOdds)==true){w.dropItem(Items.bone, rand(3));};break;
			case 1: if(drop(NormalOdds)==true){w.dropItem(Items.ghast_tear, rand(1));};break;
			case 2: if(drop(NormalOdds)==true){w.dropItem(Items.gunpowder, rand(2));};break;
			// LOOTING DROPS
			case 3: if(rand(4)>2){w.dropItem(Items.ghast_tear, rand(6));};break;
			case 4: if(rand(4)>2){w.dropItem(Items.gold_nugget,rand(6));};break;
			case 5: if(rand(4)>3){w.dropItem(Items.blaze_powder, rand(3));};break;
		}
	}
	
	

	
	/**
	 * Creeper Method Drops specific items.
	 * 
	 * @param e The event to Pull Objects from.
	 * */
	private static void Creeper(LivingDropsEvent e) {
		Entity w = e.entityLiving;
		int amt = ran.nextInt(2+e.lootingLevel);
		//Base Drop Tweaked.
		switch(amt) {
			// Normal Extra Drops 
			default:if(drop(NormalOdds)==true){w.dropItem(Items.bone, rand(1));};break;
			case 0: if(drop(NormalOdds)==true){w.dropItem(Items.bone, rand(3));};break;
			case 1: if(drop(NormalOdds)==true){w.dropItem(Items.gunpowder, rand(3));};break;
			case 2: if(rand(4)>3){w.dropItem(new ItemStack(Blocks.skull,1,4).getItem(), rand(1));};break;
			// LOOTING DROPS
			case 3: if(drop(NormalOdds)==true){w.dropItem(Items.gunpowder, rand(6));};break;
			case 4: if(drop(NormalOdds)==true){w.dropItem(Items.gunpowder,rand(8));};break;
			case 5: if(drop(NormalOdds)==true){w.dropItem(Items.gunpowder, rand(10));};break;
		}
	}


	/**
	 * Blaze Method Drops specific items.
	 * 
	 * @param e The event to Pull Objects from.
	 * */
	private static void Blaze(LivingDropsEvent e) {
		Entity w = e.entityLiving;
		int amt = ran.nextInt(2+e.lootingLevel);
		//Base Drop Tweaked.
		switch(amt) {
			// Normal Extra Drops 
			default:if(drop(NormalOdds)==true){w.dropItem(Items.blaze_rod, rand(1));};break;
			case 0: if(drop(NormalOdds)==true){w.dropItem(Items.blaze_rod, rand(3));};break;
			case 1: if(drop(NormalOdds)==true){w.dropItem(Items.blaze_powder, rand(3));};break;
			case 2: if(rand(4)>2){w.dropItem(Items.magma_cream, rand(3));};break;
			// LOOTING DROPS
			case 3: if(drop(NormalOdds)==true){w.dropItem(Items.blaze_rod, rand(6));};break;
			case 4: if(drop(NormalOdds)==true){w.dropItem(Items.blaze_powder,rand(6));};break;
			case 5: if(drop(NormalOdds)==true){w.dropItem(Items.magma_cream, rand(6));};break;
		}
	}


	/**
	 * Zombie Pigman Method Drops specific items.
	 * 
	 * @param e The event to Pull Objects from.
	 * */
	private static void Zombie_Pigman(LivingDropsEvent e) {
		Entity w = e.entityLiving;
		int amt = ran.nextInt(2+e.lootingLevel);
		//Base Drop Tweaked.
		switch(amt) {
			// Normal Extra Drops 
			default:if(drop(NormalOdds)==true){w.dropItem(Items.bone, rand(1));};break;
			case 0: if(drop(NormalOdds)==true){w.dropItem(Items.gold_nugget, rand(3));};break;
			case 1: if(drop(NormalOdds)==true){w.dropItem(Items.bone, rand(3));};break;
			case 2: if(drop(NormalOdds)==true){w.dropItem(Items.porkchop, rand(1));};break;
			// LOOTING DROPS
			case 3: if(drop(NormalOdds)==true){w.dropItem(getEquipedItem(w), rand(1));};break;
			case 4: if(drop(NormalOdds)==true){w.dropItem(Items.gold_nugget,rand(6));};break;
			case 5: if(drop(NormalOdds)==true){w.dropItem(Items.gold_ingot, rand(1));};break;
		}
	}


	/**
	 * Ocelot Method Drops specific items.
	 * 
	 * @param e The event to Pull Objects from.
	 * */
	private static void Ocelot(LivingDropsEvent e) {
		Entity w = e.entityLiving;
		int amt = ran.nextInt(2+e.lootingLevel);
		//Base Drop Tweaked.
		switch(amt) {
			// Normal Extra Drops 
			default:if(drop(NormalOdds)==true){w.dropItem(Items.bone, rand(1));};break;
			case 0: if(drop(NormalOdds)==true){w.dropItem(Items.bone, rand(2));};break;
			case 1: if(drop(NormalOdds)==true){w.dropItem(Items.fish, rand(2));};break;
			// LOOTING DROPS
			case 3: if(rand(4)>2){w.dropItem(Items.fish, rand(3));};break;
			case 4: if(rand(4)>3){w.dropItem(Items.emerald, rand(1));};break;
		}
	}


	/**
	 * Wolf Method Drops specific items.
	 * 
	 * @param e The event to Pull Objects from.
	 * */
	private static void Wolf(LivingDropsEvent e) {
		Entity w = e.entityLiving;
		int amt = ran.nextInt(2+e.lootingLevel);
		//Base Drop Tweaked.
		switch(amt) {
			// Normal Extra Drops 
			default:if(drop(NormalOdds)==true){w.dropItem(Items.bone, rand(3));};break;
			case 0: if(drop(NormalOdds)==true){w.dropItem(Items.bone, rand(3));};break;
			//case 1: if(drop(NormalOdds)==true){w.dropItem(Items.RABBIT, rand(1));};break;
			case 2: if(drop(NormalOdds)==true){w.dropItem(Items.beef, rand(1));};break;
			// LOOTING DROPS
			case 3: if(drop(NormalOdds)==true){w.dropItem(Items.bone, rand(4));};break;
		}
	}


	/**
	 * Iron Golem Method Drops specific items.
	 * 
	 * @param e The event to Pull Objects from.
	 * */
	private static void Iron_Golem(LivingDropsEvent e) {
		Entity w = e.entityLiving;
		int amt = ran.nextInt(2+e.lootingLevel);
		//Base Drop Tweaked.
		switch(amt) {
			// Normal Extra Drops 
			default:if(drop(NormalOdds)==true){w.dropItem(Items.iron_ingot, rand(1));};break;
			case 0: if(drop(NormalOdds)==true){w.dropItem(Items.iron_ingot, rand(3));};break;
			case 1: if(drop(NormalOdds)==true){w.dropItem(RandomFood(), rand(3));};break;
			case 2: if(drop(NormalOdds)==true){w.dropItem(IFB(Blocks.red_flower), rand(3));};break;
			// LOOTING DROPS
			case 3: if(rand(4)>2){w.dropItem(Items.iron_ingot, rand(6));};break;
			case 4: if(rand(4)>3){w.dropItem(Items.gold_ingot,rand(1));};break;
		}
	}


	/**
	 * Ender Dragon Method Drops specific items.
	 * 
	 * @param e The event to Pull Objects from.
	 * */
	private static void Ender_Dragon(LivingDropsEvent e) {
		Entity w = e.entityLiving;
		int amt = ran.nextInt(2+e.lootingLevel);
		//Base Drop Tweaked.
		switch(amt) {
			// Normal Extra Drops 
			default:if(drop(NormalOdds)==true){w.dropItem(Items.bone, rand(16));};break;
			case 0: if(drop(NormalOdds)==true){w.dropItem(Items.bone, rand(20));};break;
			case 1: if(drop(NormalOdds)==true){w.dropItem(Items.ender_pearl, rand(16));};break;
			case 2: if(drop(NormalOdds)==true){w.dropItem(Items.gunpowder, rand(15));};break;
			// LOOTING DROPS
			case 3: if(rand(4)>2){w.dropItem(Items.diamond, rand(16));};break;
			case 4: if(rand(4)>2){w.dropItem(Items.emerald,rand(16));};break;
			case 5: if(drop(NormalOdds)==true){w.dropItem(Items.gold_ingot, rand(16));};break;
		}
	}


	/**
	 * Wither Method Drops specific items.
	 * 
	 * @param e The event to Pull Objects from.
	 * */
	private static void Wither(LivingDropsEvent e) {
		Entity w = e.entityLiving;
		int amt = ran.nextInt(2+e.lootingLevel);
		//Base Drop Tweaked.
		switch(amt) {
			// Normal Extra Drops 
			default:if(drop(NormalOdds)==true){w.dropItem(Items.bone, rand(1));};break;
			case 0: if(drop(NormalOdds)==true){w.dropItem(Items.gold_ingot, rand(3));};break;
			case 1: if(drop(NormalOdds)==true){w.dropItem(Items.iron_ingot, rand(3));};break;
			case 2: if(drop(NormalOdds)==true){w.dropItem(Items.coal, rand(3));};break;
			// LOOTING DROPS
			case 3: if(drop(NormalOdds)==true){w.dropItem(Items.emerald, rand(6));};break;
			case 4: if(drop(NormalOdds)==true){w.dropItem(Items.diamond,rand(6));};break;
			case 5: if(drop(NormalOdds)==true){w.dropItem(Items.quartz, rand(6));};break;
		}
	}


	/**
	 * Enderman Method Drops specific items.
	 * 
	 * @param e The event to Pull Objects from.
	 * */
	private static void Enderman(LivingDropsEvent e) {
		Entity w = e.entityLiving;
		int amt = ran.nextInt(2+e.lootingLevel);
		//Base Drop Tweaked.
		switch(amt) {
			// Normal Extra Drops 
			default:if(drop(NormalOdds)==true){w.dropItem(Items.bone, rand(1));};break;
			case 0: if(drop(NormalOdds)==true){w.dropItem(Items.ender_pearl, rand(3));};break;
			case 1: if(drop(NormalOdds)==true){w.dropItem(Items.bone, rand(3));};break;
			case 2: if(rand(4)>3){w.dropItem(Items.emerald, rand(1));};break;
			// LOOTING DROPS
			case 3: if(rand(4)>2){w.dropItem(Items.ender_pearl, rand(5));};break;
			case 4: if(rand(4)>3){w.dropItem(Items.emerald,rand(2));};break;
			case 5: if(rand(4)>3){w.dropItem(Items.ender_eye, rand(3));};break;
		}
	}


	/**
	 * Cave Spider Method Drops specific items.
	 * 
	 * @param e The event to Pull Objects from.
	 * */
	private static void Cave_Spider(LivingDropsEvent e) {
		Entity w = e.entityLiving;
		int amt = ran.nextInt(2+e.lootingLevel);
		//Base Drop Tweaked.
		switch(amt) {
			// Normal Extra Drops 
			default:if(drop(NormalOdds)==true){w.dropItem(Items.bone, rand(1));};break;
			case 0: if(drop(NormalOdds)==true){w.dropItem(Items.bone, rand(2));};break;
			case 1: if(drop(NormalOdds)==true){w.dropItem(Items.spider_eye, rand(3));};break;
			case 2: if(drop(NormalOdds)==true){w.dropItem(Items.string, rand(3));};break;
			// LOOTING DROPS
			case 3: if(drop(NormalOdds)==true){w.dropItem(Items.string, rand(6));};break;
			case 4: if(drop(NormalOdds)==true){w.dropItem(Items.spider_eye,rand(6));};break;
			case 5: if(drop(NormalOdds)==true){w.dropItem(Items.gold_ingot, rand(2));};break;
		}
	}




	/**
	 * Cow Method Drops specific items for COWS
	 * 
	 * @param e The event to Pull Objects from.
	 * */
	private static void Cow(LivingDropsEvent e) {
		Entity w = e.entityLiving;
		int amt = ran.nextInt(2+e.lootingLevel);
		//Base Drop Tweaked.
		switch(amt) {
			// Normal Extra Drops 
			default:if(drop(NormalOdds)==true){w.dropItem(Items.beef, rand(1));};break;
			case 0: if(drop(NormalOdds)==true){w.dropItem(Items.leather, rand(3));};break;
			case 1: if(drop(NormalOdds)==true){w.dropItem(Items.bone, rand(3));};break;
			case 2: if(drop(NormalOdds)==true){w.dropItem(Items.wheat, rand(3));};break;
			// LOOTING DROPS
			//case 3: if(drop(NormalOdds)==true){w.dropItem(Items.BEETROOT_seeds, rand(6));};break;
			case 4: if(drop(NormalOdds)==true){w.dropItem(Items.melon_seeds,rand(6));};break;
			case 5: if(drop(NormalOdds)==true){w.dropItem(Items.pumpkin_seeds, rand(6));};break;
		}
		
	}
	/**
	 * Chicken Method Drops specific items.
	 * 
	 * @param e The event to Pull Objects from.
	 * */
	private static void Chicken(LivingDropsEvent e) {
		Entity w = e.entityLiving;
		int amt = ran.nextInt(4+e.lootingLevel);
		//Base Drop Tweaked.
		switch(amt) {
			// Normal Extra Drops 
			default:if(drop(NormalOdds)==true){w.dropItem(Items.chicken, rand(1));};break;
			case 0: if(drop(NormalOdds)==true){w.dropItem(Items.egg, rand(3));};break;
			case 1: if(drop(NormalOdds)==true){w.dropItem(Items.bone, rand(1));};break;
			case 2: if(drop(NormalOdds)==true){w.dropItem(Items.feather, rand(2));};break;
			case 4: if(drop(NormalOdds)==true){w.dropItem(Items.melon_seeds, rand(2));};break;
			// LOOTING DROPS
			case 5: if(drop(NormalOdds)==true){w.dropItem(Items.egg, rand(2));};break;
			case 6: if(drop(NormalOdds)==true){w.dropItem(Items.feather,rand(6));};break;
			case 7: if(drop(NormalOdds)==true){w.dropItem(Items.wheat_seeds, rand(6));};break;
		}
		
	}
	/**
	 * Pig Method Drops specific items.
	 * 
	 * @param e The event to Pull Objects from.
	 * */
	private static void Pig(LivingDropsEvent e) {
		Entity w = e.entityLiving;
		int amt = ran.nextInt(2+e.lootingLevel);
		//Base Drop Tweaked.
		switch(amt) {
			// Normal Extra Drops 
			default:if(drop(NormalOdds)==true){w.dropItem(Items.porkchop, rand(1));};break;
			case 0: if(drop(NormalOdds)==true){w.dropItem(Items.carrot, rand(3));};break;
			case 1: if(drop(NormalOdds)==true){w.dropItem(Items.bone, rand(1));};break;
			case 2: if(drop(NormalOdds)==true){w.dropItem(Items.porkchop, rand(2));};break;
			// LOOTING DROPS
			case 3: if(drop(NormalOdds)==true){w.dropItem(Items.porkchop, rand(6));};break;
			case 4: if(drop(NormalOdds)==true){w.dropItem(Items.carrot_on_a_stick,1);};break;
			case 5: if(drop(NormalOdds)==true){w.dropItem(Items.bone, rand(6));};break;
		}
		
	}
	

	
	/**
	 * Mooshroom Method Drops specific items.
	 * 
	 * @param e The event to Pull Objects from.
	 * */
	private static void Mooshroom(LivingDropsEvent e) {
		Entity w = e.entityLiving;
		int amt = ran.nextInt(2+e.lootingLevel);
		//Base Drop Tweaked.
		switch(amt) {
			// Normal Extra Drops 
			default:if(drop(NormalOdds)==true){w.dropItem(Items.mushroom_stew, rand(1));};break;
			case 0: if(drop(NormalOdds)==true){w.dropItem(Items.wheat, rand(3));};break;
			case 1: if(drop(NormalOdds)==true){w.dropItem(Items.bone, rand(1));};break;
			case 2: if(drop(NormalOdds)==true){w.dropItem(Items.milk_bucket, rand(1));};break;
			// LOOTING DROPS
			case 3: if(rand(4)>3){w.dropItem(Items.golden_apple, rand(2));};break;
			case 4: if(drop(NormalOdds)==true){w.dropItem(Items.beef,rand(6));};break;
			case 5: if(drop(NormalOdds)==true){w.dropItem(Items.pumpkin_seeds, rand(6));};break;
		}
		
	}
	/**
	 * Sheep Method Drops specific items.
	 * 
	 * @param e The event to Pull Objects from.
	 * */
	private static void Sheep(LivingDropsEvent e) {
		Entity w = e.entityLiving;
		int amt = ran.nextInt(2+e.lootingLevel);
		//Base Drop Tweaked.
		switch(amt) {
			// Normal Extra Drops 
			//default:if(drop(NormalOdds)==true){w.dropItem(Items.MUTTON, rand(1));};break;
			case 0: if(drop(NormalOdds)==true){w.dropItem(IFB(Blocks.wool), rand(3));};break;
			case 1: if(drop(NormalOdds)==true){w.dropItem(Items.bone, rand(1));};break;
			case 2: if(drop(NormalOdds)==true){w.dropItem(Items.wheat, rand(2));};break;
			// LOOTING DROPS
			//case 3: if(drop(NormalOdds)==true){w.dropItem(Items.BEETROOT_seeds, rand(2));};break;
			case 4: if(drop(NormalOdds)==true){w.dropItem(Items.pumpkin_seeds,rand(6));};break;
			case 5: if(drop(NormalOdds)==true){w.dropItem(Items.wheat_seeds, rand(6));};break;
		}
		
	}
	/**
	 * Squid Method Drops specific items.
	 * 
	 * @param e The event to Pull Objects from.
	 * */
	private static void Squid(LivingDropsEvent e) {
		Entity w = e.entityLiving;
		int amt = ran.nextInt(2+e.lootingLevel);
		//Base Drop Tweaked.
		switch(amt) {
			// Normal Extra Drops 
			default:if(drop(NormalOdds)==true){w.dropItem(Items.dye, rand(1));};break;
			case 0: if(drop(NormalOdds)==true){w.dropItem(Items.carrot, rand(3));};break;
			case 1: if(drop(NormalOdds)==true){w.dropItem(Items.bone, rand(1));};break;
			case 2: if(drop(NormalOdds)==true){w.dropItem(Items.porkchop, rand(2));};break;
			// LOOTING DROPS
			case 3: if(drop(NormalOdds)==true){w.dropItem(new ItemStack(Items.fishing_rod, 1, rand(50)).getItem(), rand(2));};break;
			case 4: if(drop(NormalOdds)==true){w.dropItem(Items.fish,rand(6));};break;
			case 5: if(drop(NormalOdds)==true){w.dropItem(Items.dye, rand(6));};break;
		}
		
	}
	/**
	 * Villager Method Drops specific items.
	 * 
	 * @param e The event to Pull Objects from.
	 * */
	private static void Villager(LivingDropsEvent e) {
		Entity w = e.entityLiving;
		int amt = ran.nextInt(2+e.lootingLevel);
		//Base Drop Tweaked.
		switch(amt) {
			// Normal Extra Drops 
			default:if(drop(NormalOdds)==true){w.dropItem(Items.bone, rand(1));};break;
			case 0: if(drop(NormalOdds)==true){w.dropItem(Items.potato, rand(3));};break;
			case 1: if(drop(NormalOdds)==true){w.dropItem(Items.bone, rand(1));};break;
			case 2: if(drop(NormalOdds)==true){w.dropItem(Items.apple, rand(2));};break;
			// LOOTING DROPS
			case 3: if(drop(NormalOdds)==true){w.dropItem(IFB(Blocks.red_flower), rand(2));};break;
			case 4: if(drop(NormalOdds)==true){w.dropItem(Items.iron_ingot,rand(6));};break;
			case 5: if(drop(NormalOdds)==true){w.dropItem(Items.emerald, rand(6));};break;
		}
		
	}
	

}

	

