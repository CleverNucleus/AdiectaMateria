package clevernucleus.adiectamateria.util;

import clevernucleus.adiectamateria.Objects;
import clevernucleus.adiectamateria.objects.ItemOrb;
import clevernucleus.adiectamateria.objects.ItemTrinket;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

/**
 * @name AdiectaMateria
 * @author CleverNucleus
 * @license Apache 2.0
 */

public class DecisionHandler extends Item {
	public static boolean ifStatementsItemClass(EntityPlayer par1, World par2, int par3, int par4, int par5, boolean par6) {
		if(par2.getBlock(par3, par4, par5) == Blocks.dirt) {
			par2.setBlock(par3, par4, par5, Blocks.grass);
			return true;
		}
		 
		if(par2.getBlock(par3, par4, par5) == Blocks.grass) {
			par2.setBlock(par3, par4, par5, Blocks.dirt);
			return true;
		}
		
		if(par2.getBlock(par3, par4, par5) == Blocks.stone) {
			par2.setBlock(par3, par4, par5, Blocks.cobblestone);
			return true;
		}
		
		if(par2.getBlock(par3, par4, par5) == Blocks.cobblestone) {
			par2.setBlock(par3, par4, par5, Blocks.stone);
			return true;
		}
		
		if(par2.getBlock(par3, par4, par5) == Blocks.sand && par2.getBlock(par3, par4, par5).getDamageValue(par2, par3, par4, par5) == 0) {
			par2.setBlock(par3, par4, par5, Blocks.glass);
			return true;
		}
		
		if(par2.getBlock(par3, par4, par5) == Blocks.glass) {
			par2.setBlock(par3, par4, par5, Blocks.sand, 0, 2);
			return true;
		}
		
		if(par2.getBlock(par3, par4, par5) == Blocks.obsidian) {
			par2.setBlock(par3, par4, par5, Blocks.flowing_lava, 0, 2);
			return true;
		}
		
		if(par2.getBlock(par3, par4, par5) == Blocks.pumpkin) {
			par2.setBlock(par3, par4, par5, Blocks.melon_block);
			return true;
		}
		
		if(par2.getBlock(par3, par4, par5) == Blocks.melon_block) {
			par2.setBlock(par3, par4, par5, Blocks.pumpkin);
			return true;
		}
		
		if(par2.getBlock(par3, par4, par5) == Blocks.sand && par2.getBlock(par3, par4, par5).getDamageValue(par2, par3, par4, par5) == 1) {
			par2.setBlock(par3, par4, par5, Blocks.netherrack);
			return true;
		}
		
		if(par2.getBlock(par3, par4, par5) == Blocks.netherrack) {
			par2.setBlock(par3, par4, par5, Blocks.soul_sand);
			return true;
		}
		
		if(par2.getBlock(par3, par4, par5) == Blocks.soul_sand) {
			par2.setBlock(par3, par4, par5, Blocks.end_stone);
			return true;
		}
		
		if(par2.getBlock(par3, par4, par5) == Blocks.end_stone) {
			par2.setBlock(par3, par4, par5, Blocks.sand, 1, 2);
			return true;
		}
		
		if(par2.getBlock(par3, par4, par5) == Blocks.clay) {
			par2.setBlock(par3, par4, par5, Objects.BLOCK_CERAMIC);
			return true;
		}
		
		if(par2.getBlock(par3, par4, par5) == Objects.BLOCK_CERAMIC) {
			par2.setBlock(par3, par4, par5, Blocks.clay);
			return true;
		}
		
		if(par2.getBlock(par3, par4, par5) == Blocks.gravel) {
			par1.inventory.addItemStackToInventory(new ItemStack(Items.flint, 1, 0));
			par2.setBlockToAir(par3, par4, par5);
			return true;
		}
		
		if(par2.getBlock(par3, par4, par5) == Objects.BLOCK_RICE) {
			par1.inventory.addItemStackToInventory(new ItemStack(Objects.BLOCK_PAPER_WALL, 16, 0));
			par2.setBlockToAir(par3, par4, par5);
			return true;
		}
		
		if(par2.getBlock(par3, par4, par5) == Blocks.tallgrass) {
			par1.inventory.addItemStackToInventory(new ItemStack(Objects.ITEM_RICE_SEEDS, 1, 0));
			par2.setBlockToAir(par3, par4, par5);
			return true;
		}
		
		if(par2.getBlock(par3, par4, par5) == Blocks.leaves) {
			par1.inventory.addItemStackToInventory(new ItemStack(Items.apple, 1, 0));
			par2.setBlockToAir(par3, par4, par5);
			return true;
		}
		
		if(par2.getBlock(par3, par4, par5) == Blocks.wool) {
			par2.setBlock(par3, par4, par5, Blocks.wool, par2.getBlock(par3, par4, par5).getDamageValue(par2, par3, par4, par5) + 1, 2);
		}
		
		if(par2.getBlock(par3, par4, par5) == Blocks.stained_hardened_clay) {
			par2.setBlock(par3, par4, par5, Blocks.stained_hardened_clay, par2.getBlock(par3, par4, par5).getDamageValue(par2, par3, par4, par5) + 1, 2);
		}
		
		if(par2.getBlock(par3, par4, par5) == Blocks.stained_glass) {
			par2.setBlock(par3, par4, par5, Blocks.stained_glass, par2.getBlock(par3, par4, par5).getDamageValue(par2, par3, par4, par5) + 1, 2);
		}
		
		if(par2.getBlock(par3, par4, par5) == Blocks.planks && par2.getBlock(par3, par4, par5).getDamageValue(par2, par3, par4, par5) == 0) {
			par2.setBlock(par3, par4, par5, Blocks.planks, 1, 2);
			
			return true;
		}
		
		if(par2.getBlock(par3, par4, par5) == Blocks.planks && par2.getBlock(par3, par4, par5).getDamageValue(par2, par3, par4, par5) == 1) {
			par2.setBlock(par3, par4, par5, Blocks.planks, 2, 2);
			
			return true;
		}
		
		if(par2.getBlock(par3, par4, par5) == Blocks.planks && par2.getBlock(par3, par4, par5).getDamageValue(par2, par3, par4, par5) == 2) {
			par2.setBlock(par3, par4, par5, Blocks.planks, 3, 2);
			
			return true;
		}
		
		if(par2.getBlock(par3, par4, par5) == Blocks.planks && par2.getBlock(par3, par4, par5).getDamageValue(par2, par3, par4, par5) == 3) {
			par2.setBlock(par3, par4, par5, Blocks.planks, 4, 2);
			
			return true;
		}
		
		if(par2.getBlock(par3, par4, par5) == Blocks.planks && par2.getBlock(par3, par4, par5).getDamageValue(par2, par3, par4, par5) == 4) {
			par2.setBlock(par3, par4, par5, Blocks.planks, 5, 2);
			
			return true;
		}
		
		if(par2.getBlock(par3, par4, par5) == Blocks.planks && par2.getBlock(par3, par4, par5).getDamageValue(par2, par3, par4, par5) == 5) {
			par2.setBlock(par3, par4, par5, Blocks.planks, 0, 2);
			
			return true;
		}
		
		if(par2.getBlock(par3, par4, par5) == Blocks.log && par2.getBlock(par3, par4, par5).getDamageValue(par2, par3, par4, par5) == 0) {
			par2.setBlock(par3, par4, par5, Blocks.log, 1, 2);
			
			return true;
		}
		
		if(par2.getBlock(par3, par4, par5) == Blocks.log && par2.getBlock(par3, par4, par5).getDamageValue(par2, par3, par4, par5) == 1) {
			par2.setBlock(par3, par4, par5, Blocks.log, 2, 2);
			
			return true;
		}
		
		if(par2.getBlock(par3, par4, par5) == Blocks.log && par2.getBlock(par3, par4, par5).getDamageValue(par2, par3, par4, par5) == 2) {
			par2.setBlock(par3, par4, par5, Blocks.log, 3, 2);
			
			return true;
		}
		
		if(par2.getBlock(par3, par4, par5) == Blocks.log && par2.getBlock(par3, par4, par5).getDamageValue(par2, par3, par4, par5) == 3) {
			par2.setBlock(par3, par4, par5, Blocks.log, 4, 2);
			
			return true;
		}
		
		if(par2.getBlock(par3, par4, par5) == Blocks.log && par2.getBlock(par3, par4, par5).getDamageValue(par2, par3, par4, par5) == 4) {
			par2.setBlock(par3, par4, par5, Blocks.log, 5, 2);
			
			return true;
		}
		
		if(par2.getBlock(par3, par4, par5) == Blocks.log && par2.getBlock(par3, par4, par5).getDamageValue(par2, par3, par4, par5) == 5) {
			par2.setBlock(par3, par4, par5, Blocks.log, 0, 2);
			
			return true;
		}
		
		if(par2.getBlock(par3, par4, par5) == Blocks.sapling && par2.getBlock(par3, par4, par5).getDamageValue(par2, par3, par4, par5) == 0) {
			par2.setBlock(par3, par4, par5, Blocks.sapling, 1, 2);
			
			return true;
		}
		
		if(par2.getBlock(par3, par4, par5) == Blocks.sapling && par2.getBlock(par3, par4, par5).getDamageValue(par2, par3, par4, par5) == 1) {
			par2.setBlock(par3, par4, par5, Blocks.sapling, 2, 2);
			
			return true;
		}
		
		if(par2.getBlock(par3, par4, par5) == Blocks.sapling && par2.getBlock(par3, par4, par5).getDamageValue(par2, par3, par4, par5) == 2) {
			par2.setBlock(par3, par4, par5, Blocks.sapling, 3, 2);
			
			return true;
		}
		
		if(par2.getBlock(par3, par4, par5) == Blocks.sapling && par2.getBlock(par3, par4, par5).getDamageValue(par2, par3, par4, par5) == 3) {
			par2.setBlock(par3, par4, par5, Blocks.sapling, 4, 2);
			
			return true;
		}
		
		if(par2.getBlock(par3, par4, par5) == Blocks.sapling && par2.getBlock(par3, par4, par5).getDamageValue(par2, par3, par4, par5) == 4) {
			par2.setBlock(par3, par4, par5, Blocks.sapling, 5, 2);
			
			return true;
		}
		
		if(par2.getBlock(par3, par4, par5) == Blocks.sapling && par2.getBlock(par3, par4, par5).getDamageValue(par2, par3, par4, par5) == 5) {
			par2.setBlock(par3, par4, par5, Blocks.sapling, 0, 2);
			
			return true;
		}
		return par6;
	}
	
	public static void ifStatementsItemOrb(ItemStack par0, World par1, EntityPlayer par2) {
    	if(par2.inventory.getCurrentItem().getItem() == Objects.ITEM_ORB_DAY) {
    		
    		par1.playSoundEffect((double)par2.posX + 0.5D, (double)par2.posY + 0.5D, (double)par2.posZ + 0.5D, Util.MODID + ":daytime", 1.0F, itemRand.nextFloat() * 0.4F + 0.8F);
        	
    		ItemOrb.setHourForward(par1, 0);
    	}
    	
    	if(par2.inventory.getCurrentItem().getItem() == Objects.ITEM_ORB_NIGHT) {
    		
    		par1.playSoundEffect((double)par2.posX + 0.5D, (double)par2.posY + 0.5D, (double)par2.posZ + 0.5D, Util.MODID + ":nighttime", 1.0F, itemRand.nextFloat() * 0.4F + 0.8F);
        	
    		ItemOrb.setHourForward(par1, 13);
    	}
    	
    	if(par2.inventory.getCurrentItem().getItem() == Objects.ITEM_ORB_RAIN) {
    		if(par1.isRaining()) {
    			par1.getWorldInfo().setRaining(false);
    		}
    		
    		if(!par1.isRaining()) {
    			par1.getWorldInfo().setRaining(true);
    		}
    	}
    	
        if(par2.inventory.getCurrentItem().getItem() == Objects.ITEM_ORB_ELEC) {
        	
        	float f = 1.0F;
        	float f1 = par2.prevRotationPitch + (par2.rotationPitch - par2.prevRotationPitch) * f;
        	float f2 = par2.prevRotationYaw + (par2.rotationYaw - par2.prevRotationYaw) * f;
        	double d = par2.prevPosX + (par2.posX - par2.prevPosX) * (double)f;
        	double d1 = (par2.prevPosY + (par2.posY - par2.prevPosY) * (double)f + 1.6200000000000001D) - (double)par2.yOffset;
        	double d2 = par2.prevPosZ + (par2.posZ - par2.prevPosZ) * (double)f;
        	
        	Vec3 vec3d = Vec3.createVectorHelper(d, d1, d2);
        	
        	float f3 = MathHelper.cos(-f2 * 0.01745329F - 3.141593F);
        	float f4 = MathHelper.sin(-f2 * 0.01745329F - 3.141593F);
        	float f5 = -MathHelper.cos(-f1 * 0.01745329F);
        	float f6 = MathHelper.sin(-f1 * 0.01745329F);
        	float f7 = f4 * f5;
        	float f8 = f6;
        	float f9 = f3 * f5;
        	double d3 = 5000D;
        	
        	Vec3 vec3d1 = vec3d.addVector((double)f7 * d3, (double)f8 * d3 + 1, (double)f9 * d3);
        	MovingObjectPosition movingobjectposition = par1.rayTraceBlocks(vec3d, vec3d1);
        	
        	if(movingobjectposition == null) {
        		return;
        	}
        	
        	if(!par1.isRemote) {
        		int i = movingobjectposition.blockX;
        		int j = movingobjectposition.blockY;
        		int k = movingobjectposition.blockZ;
        		
        		par1.addWeatherEffect(new EntityLightningBolt(par1, i, j, k));
        		par1.playSoundEffect((double)par2.posX + 0.5D, (double)par2.posY + 0.5D, (double)par2.posZ + 0.5D, Util.MODID + ":strike", 1.0F, itemRand.nextFloat() * 0.4F + 0.8F);
        	}
        }
        
        if(par2.inventory.getCurrentItem().getItem() == Objects.ITEM_ORB_FIRE) {
        	
        	float f = 1.0F;
        	float f1 = par2.prevRotationPitch + (par2.rotationPitch - par2.prevRotationPitch) * f;
        	float f2 = par2.prevRotationYaw + (par2.rotationYaw - par2.prevRotationYaw) * f;
        	double d = par2.prevPosX + (par2.posX - par2.prevPosX) * (double)f;
        	double d1 = (par2.prevPosY + (par2.posY - par2.prevPosY) * (double)f + 1.6200000000000001D) - (double)par2.yOffset;
        	double d2 = par2.prevPosZ + (par2.posZ - par2.prevPosZ) * (double)f;
        	
        	Vec3 vec3d = Vec3.createVectorHelper(d, d1, d2);
        	
        	float f3 = MathHelper.cos(-f2 * 0.01745329F - 3.141593F);
        	float f4 = MathHelper.sin(-f2 * 0.01745329F - 3.141593F);
        	float f5 = -MathHelper.cos(-f1 * 0.01745329F);
        	float f6 = MathHelper.sin(-f1 * 0.01745329F);
        	float f7 = f4 * f5;
        	float f8 = f6;
        	float f9 = f3 * f5;
        	double d3 = 5000D;
        	
        	Vec3 vec3d1 = vec3d.addVector((double)f7 * d3, (double)f8 * d3 + 1, (double)f9 * d3);
        	MovingObjectPosition movingobjectposition = par1.rayTraceBlocks(vec3d, vec3d1);
        	
        	if(movingobjectposition == null) {
        		return;
        	}
        	
        	if(!par1.isRemote) {
        		int i = movingobjectposition.blockX;
        		int j = movingobjectposition.blockY;
        		int k = movingobjectposition.blockZ;
        		
        		par1.newExplosion(par2, i, j, k, 8.0F, true, false);
        		par1.playSoundEffect((double)par2.posX + 0.5D, (double)par2.posY + 0.5D, (double)par2.posZ + 0.5D, Util.MODID + ":woosh", 1.0F, itemRand.nextFloat() * 0.4F + 0.8F);
        	}
    	}
	}
}
