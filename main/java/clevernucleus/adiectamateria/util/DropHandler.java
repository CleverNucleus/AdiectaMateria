package clevernucleus.adiectamateria.util;

import java.util.Random;

import clevernucleus.adiectamateria.Objects;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * @name AdiectaMateria
 * @author CleverNucleus
 * @license Apache 2.0
 */
public class DropHandler {
	
	public static Random var0 = new Random();
	
	@SubscribeEvent
	public void onEntityDrop(LivingDropsEvent par0) {
		if(par0.getEntityLiving() instanceof EntityZombie) {
			
			ItemStack var1 = getRareDrop();
			
			par0.getDrops().add(new EntityItem(par0.getEntity().world, par0.getEntity().posX, par0.getEntity().posY, par0.getEntity().posZ, var1));
		}
		
		if(par0.getEntityLiving() instanceof EntitySkeleton) {
			
			ItemStack var1 = getRareDrop();
				
			par0.getDrops().add(new EntityItem(par0.getEntity().world, par0.getEntity().posX, par0.getEntity().posY, par0.getEntity().posZ, var1));
			
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
		return new ItemStack(Items.ROTTEN_FLESH, 0);
	}
}
