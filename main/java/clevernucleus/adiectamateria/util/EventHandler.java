package clevernucleus.adiectamateria.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import baubles.api.BaublesApi;
import baubles.api.IBauble;
import clevernucleus.adiectamateria.Objects;
import clevernucleus.adiectamateria.objects.ItemTrinket;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDropsEvent;

/**
 * @name AdiectaMateria
 * @author CleverNucleus
 * @license Apache 2.0
 */

public class EventHandler {
	
	private static Random var0 = new Random();
	
	@SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
	public void onEvent(LivingDropsEvent par0) {
		if(par0.entity instanceof EntityZombie) {
			
			ItemStack var1 = EventHandler.getRareDrop();
			
			par0.drops.add(new EntityItem(par0.entity.worldObj, par0.entity.posX, par0.entity.posY, par0.entity.posZ, var1));
		}
		
		if(par0.entity instanceof EntitySkeleton) {
			
			ItemStack var1 = EventHandler.getRareDrop();
			
			par0.drops.add(new EntityItem(par0.entity.worldObj, par0.entity.posX, par0.entity.posY, par0.entity.posZ, var1));
		}
	}
	
	public static ItemStack getRareDrop() {
		
		int var2 = var0.nextInt(100);
		
		if(var2 < 2) {
			switch(var0.nextInt(6)) {
	            case 0: return new ItemStack(Objects.ITEM_TRINKET_HEAL, 1);
	            case 1: return new ItemStack(Objects.ITEM_TRINKET_INVISIBILITY, 1);
	            case 2: return new ItemStack(Objects.ITEM_TRINKET_SATURATION, 1);
	            case 3: return new ItemStack(Objects.ITEM_TRINKET_SPEED, 1);
	            case 4: return new ItemStack(Objects.ITEM_TRINKET_VISION, 1);
	            case 5: return new ItemStack(Objects.ITEM_TRINKET_WATER, 1);
	        }
		}
		return new ItemStack(Items.rotten_flesh, 0);
	}
}
