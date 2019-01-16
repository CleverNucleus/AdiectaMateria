package clevernucleus.adiectamateria.util;

import java.util.ArrayList;
import java.util.List;

import clevernucleus.adiectamateria.Objects;
import clevernucleus.adiectamateria.objects.ItemOrb;
import clevernucleus.adiectamateria.objects.ItemTrinket;
import net.minecraft.block.Block;
import net.minecraft.block.BlockColored;
import net.minecraft.block.BlockConcretePowder;
import net.minecraft.block.BlockNewLog;
import net.minecraft.block.BlockOldLog;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.BlockSapling;
import net.minecraft.block.BlockPlanks.EnumType;
import net.minecraft.block.BlockSand;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.passive.EntityTameable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

/**
 * @name AdiectaMateria
 * @author CleverNucleus
 * @license Apache 2.0
 */
public class DecisionHandler extends Item {
	
	private static List DYE_COLOUR_0 = new ArrayList();
	private static List DYE_COLOUR_1 = new ArrayList();
	private static int[] dye_colour_0 = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
	private static int[] dye_colour_1 = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 0};
	
	/**
	 * Determines the object specific actions to perform for ItemClass' onItemUse().
	 */
	public static EnumActionResult ifStatementsItemClass(EntityPlayer par0, World par1, BlockPos par2, EnumHand par3, EnumFacing par4, float par5, float par6, float par7) {
		if(par1.getBlockState(par2).getBlock() == Blocks.ICE) {
			par1.setBlockState(par2, Blocks.FLOWING_WATER.getDefaultState());
			
			return EnumActionResult.SUCCESS;
		}
		
		if(par1.getBlockState(par2).getBlock() == Blocks.BOOKSHELF) {
			par1.setBlockToAir(par2);
			par0.addItemStackToInventory(new ItemStack(Objects.ITEM_BOOK, 1, 0));
			
			return EnumActionResult.SUCCESS;
		}
		
		if(par1.getBlockState(par2).getBlock() == Blocks.DIRT) {
			par1.setBlockState(par2, Blocks.GRASS.getDefaultState());
			
			return EnumActionResult.SUCCESS;
		}
		
		if(par1.getBlockState(par2).getBlock() == Blocks.GRASS) {
			par1.setBlockState(par2, Blocks.DIRT.getDefaultState());
			
			return EnumActionResult.SUCCESS;
		}
		
		if(par1.getBlockState(par2).getBlock() == Blocks.STONE) {
			par1.setBlockState(par2, Blocks.COBBLESTONE.getDefaultState());
			
			return EnumActionResult.SUCCESS;
		}
		
		if(par1.getBlockState(par2).getBlock() == Blocks.COBBLESTONE) {
			par1.setBlockState(par2, Blocks.STONE.getDefaultState());
			
			return EnumActionResult.SUCCESS;
		}
		
		if(par1.getBlockState(par2) == Blocks.SAND.getDefaultState()) {
			par1.setBlockState(par2, Blocks.GLASS.getDefaultState());
			
			return EnumActionResult.SUCCESS;
		}
		
		if(par1.getBlockState(par2).getBlock() == Blocks.GLASS) {
			par1.setBlockState(par2, Blocks.SAND.getDefaultState());
			
			return EnumActionResult.SUCCESS;
		}
		
		if(par1.getBlockState(par2).getBlock() == Blocks.OBSIDIAN) {
			par1.setBlockState(par2, Blocks.FLOWING_LAVA.getDefaultState());
			
			return EnumActionResult.SUCCESS;
		}
		
		if(par1.getBlockState(par2).getBlock() == Blocks.PUMPKIN) {
			par1.setBlockState(par2, Blocks.MELON_BLOCK.getDefaultState());
			
			return EnumActionResult.SUCCESS;
		}
		
		if(par1.getBlockState(par2).getBlock() == Blocks.MELON_BLOCK) {
			par1.setBlockState(par2, Blocks.PUMPKIN.getDefaultState());
			
			return EnumActionResult.SUCCESS;
		}
		
		if(par1.getBlockState(par2) == Blocks.SAND.getDefaultState().withProperty(BlockSand.VARIANT, BlockSand.EnumType.RED_SAND)) {
			par1.setBlockState(par2, Blocks.NETHERRACK.getDefaultState());
			
			return EnumActionResult.SUCCESS;
		}
		
		if(par1.getBlockState(par2).getBlock() == Blocks.NETHERRACK) {
			par1.setBlockState(par2, Blocks.SOUL_SAND.getDefaultState());
			
			return EnumActionResult.SUCCESS;
		}
		
		if(par1.getBlockState(par2).getBlock() == Blocks.SOUL_SAND) {
			par1.setBlockState(par2, Blocks.END_STONE.getDefaultState());
			
			return EnumActionResult.SUCCESS;
		}
		
		if(par1.getBlockState(par2).getBlock() == Blocks.END_STONE) {
			par1.setBlockState(par2, Blocks.SAND.getDefaultState().withProperty(BlockSand.VARIANT, BlockSand.EnumType.RED_SAND));
			
			return EnumActionResult.SUCCESS;
		}
		
		if(par1.getBlockState(par2).getBlock() == Blocks.CLAY) {
			par1.setBlockState(par2, Objects.BLOCK_CERAMIC.getDefaultState());
			
			return EnumActionResult.SUCCESS;
		}
		
		if(par1.getBlockState(par2).getBlock() == Objects.BLOCK_CERAMIC) {
			par1.setBlockState(par2, Blocks.CLAY.getDefaultState());
			
			return EnumActionResult.SUCCESS;
		}
		
		if(par1.getBlockState(par2).getBlock() == Blocks.GRAVEL) {
			par1.setBlockToAir(par2);
			par0.addItemStackToInventory(new ItemStack(Items.FLINT, 1, 0));
			
			return EnumActionResult.SUCCESS;
		}
		
		if(par1.getBlockState(par2).getBlock() == Objects.BLOCK_RICE) {
			par1.setBlockToAir(par2);
			par0.addItemStackToInventory(new ItemStack(Objects.BLOCK_PAPER_WALL, 16, 0));
			
			return EnumActionResult.SUCCESS;
		}
		
		if(par1.getBlockState(par2).getBlock() == Blocks.TALLGRASS) {
			par1.setBlockToAir(par2);
			par0.addItemStackToInventory(new ItemStack(Objects.ITEM_RICE_SEEDS, 1, 0));
			
			return EnumActionResult.SUCCESS;
		}
		
		if(par1.getBlockState(par2).getBlock() == Blocks.LEAVES || par1.getBlockState(par2).getBlock() == Blocks.LEAVES2) {
			par1.setBlockToAir(par2);
			par0.addItemStackToInventory(new ItemStack(Items.APPLE, 1, 0));
			
			return EnumActionResult.SUCCESS;
		}
		
		for(int var : dye_colour_0) {
			DYE_COLOUR_0.add(var);
		}
		
		for(int var : dye_colour_1) {
			DYE_COLOUR_1.add(var);
		}
		
		for(int var = 0; var < DYE_COLOUR_0.size(); var++) {
			int var0 = (int) DYE_COLOUR_0.get(var);
			int var1 = (int) DYE_COLOUR_1.get(var);
			
			if(par1.getBlockState(par2) == Blocks.WOOL.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.byMetadata(var0))) {
				par1.setBlockState(par2, Blocks.WOOL.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.byMetadata(var1)));
				
				return EnumActionResult.SUCCESS;
			}
			
			if(par1.getBlockState(par2) == Blocks.STAINED_GLASS.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.byMetadata(var0))) {
				par1.setBlockState(par2, Blocks.STAINED_GLASS.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.byMetadata(var1)));
				
				return EnumActionResult.SUCCESS;
			}
			
			if(par1.getBlockState(par2) == Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.byMetadata(var0))) {
				par1.setBlockState(par2, Blocks.STAINED_HARDENED_CLAY.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.byMetadata(var1)));
				
				return EnumActionResult.SUCCESS;
			}
			
			if(par1.getBlockState(par2) == Blocks.CONCRETE_POWDER.getDefaultState().withProperty(BlockConcretePowder.COLOR, EnumDyeColor.byMetadata(var0))) {
				par1.setBlockState(par2, Blocks.CONCRETE_POWDER.getDefaultState().withProperty(BlockConcretePowder.COLOR, EnumDyeColor.byMetadata(var1)));
				
				return EnumActionResult.SUCCESS;
			}
			
			if(par1.getBlockState(par2) == Blocks.CONCRETE.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.byMetadata(var0))) {
				par1.setBlockState(par2, Blocks.CONCRETE.getDefaultState().withProperty(BlockColored.COLOR, EnumDyeColor.byMetadata(var1)));
				
				return EnumActionResult.SUCCESS;
			}
		}
		
		if(par1.getBlockState(par2).getBlock() == Blocks.WHITE_GLAZED_TERRACOTTA) {
			par1.setBlockState(par2, Blocks.ORANGE_GLAZED_TERRACOTTA.getDefaultState());
			
			return EnumActionResult.SUCCESS;
		}
		
		if(par1.getBlockState(par2).getBlock() == Blocks.ORANGE_GLAZED_TERRACOTTA) {
			par1.setBlockState(par2, Blocks.MAGENTA_GLAZED_TERRACOTTA.getDefaultState());
			
			return EnumActionResult.SUCCESS;
		}
		
		if(par1.getBlockState(par2).getBlock() == Blocks.MAGENTA_GLAZED_TERRACOTTA) {
			par1.setBlockState(par2, Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA.getDefaultState());
			
			return EnumActionResult.SUCCESS;
		}
		
		if(par1.getBlockState(par2).getBlock() == Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA) {
			par1.setBlockState(par2, Blocks.YELLOW_GLAZED_TERRACOTTA.getDefaultState());
			
			return EnumActionResult.SUCCESS;
		}
		
		if(par1.getBlockState(par2).getBlock() == Blocks.YELLOW_GLAZED_TERRACOTTA) {
			par1.setBlockState(par2, Blocks.LIME_GLAZED_TERRACOTTA.getDefaultState());
			
			return EnumActionResult.SUCCESS;
		}
		
		if(par1.getBlockState(par2).getBlock() == Blocks.LIME_GLAZED_TERRACOTTA) {
			par1.setBlockState(par2, Blocks.PINK_GLAZED_TERRACOTTA.getDefaultState());
			
			return EnumActionResult.SUCCESS;
		}
		
		if(par1.getBlockState(par2).getBlock() == Blocks.PINK_GLAZED_TERRACOTTA) {
			par1.setBlockState(par2, Blocks.GRAY_GLAZED_TERRACOTTA.getDefaultState());
			
			return EnumActionResult.SUCCESS;
		}
		
		if(par1.getBlockState(par2).getBlock() == Blocks.GRAY_GLAZED_TERRACOTTA) {
			par1.setBlockState(par2, Blocks.SILVER_GLAZED_TERRACOTTA.getDefaultState());
			
			return EnumActionResult.SUCCESS;
		}
		
		if(par1.getBlockState(par2).getBlock() == Blocks.SILVER_GLAZED_TERRACOTTA) {
			par1.setBlockState(par2, Blocks.CYAN_GLAZED_TERRACOTTA.getDefaultState());
			
			return EnumActionResult.SUCCESS;
		}
		
		if(par1.getBlockState(par2).getBlock() == Blocks.CYAN_GLAZED_TERRACOTTA) {
			par1.setBlockState(par2, Blocks.PURPLE_GLAZED_TERRACOTTA.getDefaultState());
			
			return EnumActionResult.SUCCESS;
		}
		
		if(par1.getBlockState(par2).getBlock() == Blocks.PURPLE_GLAZED_TERRACOTTA) {
			par1.setBlockState(par2, Blocks.BLUE_GLAZED_TERRACOTTA.getDefaultState());
			
			return EnumActionResult.SUCCESS;
		}
		
		if(par1.getBlockState(par2).getBlock() == Blocks.BLUE_GLAZED_TERRACOTTA) {
			par1.setBlockState(par2, Blocks.BROWN_GLAZED_TERRACOTTA.getDefaultState());
			
			return EnumActionResult.SUCCESS;
		}
		
		if(par1.getBlockState(par2).getBlock() == Blocks.BROWN_GLAZED_TERRACOTTA) {
			par1.setBlockState(par2, Blocks.GREEN_GLAZED_TERRACOTTA.getDefaultState());
			
			return EnumActionResult.SUCCESS;
		}
		
		if(par1.getBlockState(par2).getBlock() == Blocks.GREEN_GLAZED_TERRACOTTA) {
			par1.setBlockState(par2, (IBlockState) Blocks.RED_GLAZED_TERRACOTTA.getDefaultState());
			
			return EnumActionResult.SUCCESS;
		}
		
		if(par1.getBlockState(par2).getBlock() == Blocks.RED_GLAZED_TERRACOTTA) {
			par1.setBlockState(par2, (IBlockState) Blocks.BLACK_GLAZED_TERRACOTTA.getDefaultState());
			
			return EnumActionResult.SUCCESS;
		}
		
		if(par1.getBlockState(par2).getBlock() == Blocks.BLACK_GLAZED_TERRACOTTA) {
			par1.setBlockState(par2, Blocks.WHITE_GLAZED_TERRACOTTA.getDefaultState());
			
			return EnumActionResult.SUCCESS;
		}
		
		if(par1.getBlockState(par2) == Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.OAK)) {
			par1.setBlockState(par2, Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE));
			
			return EnumActionResult.SUCCESS;
		}
		
		if(par1.getBlockState(par2) == Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.SPRUCE)) {
			par1.setBlockState(par2, Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.BIRCH));
			
			return EnumActionResult.SUCCESS;
		}
		
		if(par1.getBlockState(par2) == Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.BIRCH)) {
			par1.setBlockState(par2, Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.JUNGLE));
			
			return EnumActionResult.SUCCESS;
		}
		
		if(par1.getBlockState(par2) == Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.JUNGLE)) {
			par1.setBlockState(par2, Blocks.LOG2.getDefaultState().withProperty(BlockNewLog.VARIANT, BlockPlanks.EnumType.ACACIA));
			
			return EnumActionResult.SUCCESS;
		}
		
		if(par1.getBlockState(par2) == Blocks.LOG2.getDefaultState().withProperty(BlockNewLog.VARIANT, BlockPlanks.EnumType.ACACIA)) {
			par1.setBlockState(par2, Blocks.LOG2.getDefaultState().withProperty(BlockNewLog.VARIANT, BlockPlanks.EnumType.DARK_OAK));
			
			return EnumActionResult.SUCCESS;
		}
		
		if(par1.getBlockState(par2) == Blocks.LOG2.getDefaultState().withProperty(BlockNewLog.VARIANT, BlockPlanks.EnumType.DARK_OAK)) {
			par1.setBlockState(par2, Blocks.LOG.getDefaultState().withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.OAK));
			
			return EnumActionResult.SUCCESS;
		}
		
		if(par1.getBlockState(par2) == Blocks.PLANKS.getDefaultState().withProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.OAK)) {
			par1.setBlockState(par2, Blocks.PLANKS.getDefaultState().withProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.SPRUCE));
			
			return EnumActionResult.SUCCESS;
		}
		
		if(par1.getBlockState(par2) == Blocks.PLANKS.getDefaultState().withProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.SPRUCE)) {
			par1.setBlockState(par2, Blocks.PLANKS.getDefaultState().withProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.BIRCH));
			
			return EnumActionResult.SUCCESS;
		}
		
		if(par1.getBlockState(par2) == Blocks.PLANKS.getDefaultState().withProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.BIRCH)) {
			par1.setBlockState(par2, Blocks.PLANKS.getDefaultState().withProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.JUNGLE));
			
			return EnumActionResult.SUCCESS;
		}
		
		if(par1.getBlockState(par2) == Blocks.PLANKS.getDefaultState().withProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.JUNGLE)) {
			par1.setBlockState(par2, Blocks.PLANKS.getDefaultState().withProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.ACACIA));
			
			return EnumActionResult.SUCCESS;
		}
		
		if(par1.getBlockState(par2) == Blocks.PLANKS.getDefaultState().withProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.ACACIA)) {
			par1.setBlockState(par2, Blocks.PLANKS.getDefaultState().withProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.DARK_OAK));
			
			return EnumActionResult.SUCCESS;
		}
		
		if(par1.getBlockState(par2) == Blocks.PLANKS.getDefaultState().withProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.DARK_OAK)) {
			par1.setBlockState(par2, Blocks.PLANKS.getDefaultState().withProperty(BlockPlanks.VARIANT, BlockPlanks.EnumType.OAK));
			
			return EnumActionResult.SUCCESS;
		}
		
		if(par1.getBlockState(par2) == Blocks.SAPLING.getDefaultState().withProperty(BlockSapling.TYPE, BlockPlanks.EnumType.OAK)) {
			par1.setBlockState(par2, Blocks.SAPLING.getDefaultState().withProperty(BlockSapling.TYPE, BlockPlanks.EnumType.SPRUCE));
			
			return EnumActionResult.SUCCESS;
		}
		
		if(par1.getBlockState(par2) == Blocks.SAPLING.getDefaultState().withProperty(BlockSapling.TYPE, BlockPlanks.EnumType.SPRUCE)) {
			par1.setBlockState(par2, Blocks.SAPLING.getDefaultState().withProperty(BlockSapling.TYPE, BlockPlanks.EnumType.BIRCH));
			
			return EnumActionResult.SUCCESS;
		}
		
		if(par1.getBlockState(par2) == Blocks.SAPLING.getDefaultState().withProperty(BlockSapling.TYPE, BlockPlanks.EnumType.BIRCH)) {
			par1.setBlockState(par2, Blocks.SAPLING.getDefaultState().withProperty(BlockSapling.TYPE, BlockPlanks.EnumType.JUNGLE));
			
			return EnumActionResult.SUCCESS;
		}
		
		if(par1.getBlockState(par2) == Blocks.SAPLING.getDefaultState().withProperty(BlockSapling.TYPE, BlockPlanks.EnumType.JUNGLE)) {
			par1.setBlockState(par2, Blocks.SAPLING.getDefaultState().withProperty(BlockSapling.TYPE, BlockPlanks.EnumType.ACACIA));
			
			return EnumActionResult.SUCCESS;
		}
		
		if(par1.getBlockState(par2) == Blocks.SAPLING.getDefaultState().withProperty(BlockSapling.TYPE, BlockPlanks.EnumType.ACACIA)) {
			par1.setBlockState(par2, Blocks.SAPLING.getDefaultState().withProperty(BlockSapling.TYPE, BlockPlanks.EnumType.DARK_OAK));
			
			return EnumActionResult.SUCCESS;
		}
		
		if(par1.getBlockState(par2) == Blocks.SAPLING.getDefaultState().withProperty(BlockSapling.TYPE, BlockPlanks.EnumType.DARK_OAK)) {
			par1.setBlockState(par2, Blocks.SAPLING.getDefaultState().withProperty(BlockSapling.TYPE, BlockPlanks.EnumType.OAK));
			
			return EnumActionResult.SUCCESS;
		}
		return EnumActionResult.PASS;
	}
	
	/**
	 * Determines the object specific actions to perform for ItemOrb's onItemRightClick().
	 */
	public static ActionResult<ItemStack> ifStatementsItemOrb(World par0, EntityPlayer par1, EnumHand par2) {
		if(par1.inventory.getCurrentItem().getItem() == Objects.ITEM_ORB_DAY) {
			ItemOrb.setHourForward(par0, 0);
	        par0.playSound((EntityPlayer)null, par1.posX, par1.posY, par1.posZ, NoiseHandler.SOUND_DAYTIME, SoundCategory.NEUTRAL, 1.0F, (itemRand.nextFloat() * 0.4F + 0.8F));
		}
		
		if(par1.inventory.getCurrentItem().getItem() == Objects.ITEM_ORB_NIGHT) {
			ItemOrb.setHourForward(par0, 13);
	        par0.playSound((EntityPlayer)null, par1.posX, par1.posY, par1.posZ, NoiseHandler.SOUND_NIGHTTIME, SoundCategory.NEUTRAL, 1.0F, (itemRand.nextFloat() * 0.4F + 0.8F));
		}
		
		if(par1.inventory.getCurrentItem().getItem() == Objects.ITEM_ORB_RAIN) {
			if(par0.isRaining()) {
	        	par0.getWorldInfo().setRaining(false);
	        }
	        
	        if(!par0.isRaining()) {
	        	par0.getWorldInfo().setRaining(true);
	        }
	        
	        par0.playSound((EntityPlayer)null, par1.posX, par1.posY, par1.posZ, SoundEvents.ENTITY_LIGHTNING_THUNDER, SoundCategory.NEUTRAL, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
		}
		
		if(par1.inventory.getCurrentItem().getItem() == Objects.ITEM_ORB_ELEC) {
			if(!par0.isRemote) {
        		List<EntityLiving> list = par0.getEntitiesWithinAABB(EntityLiving.class, ItemOrb.getEffectBounds(par1));
        		
        		par0.playSound((EntityPlayer)null, par1.posX, par1.posY, par1.posZ, NoiseHandler.SOUND_STRIKE, SoundCategory.NEUTRAL, 1.0F, (itemRand.nextFloat() * 0.4F + 0.8F));
        		
				for (EntityLiving living : list) {
					if (living instanceof EntityTameable && ((EntityTameable) living).isTamed()) {
						continue;
					}
					par0.addWeatherEffect(new EntityLightningBolt(par0, living.posX, living.posY, living.posZ, false));
				}
        	}
		}
		
		if(par1.inventory.getCurrentItem().getItem() == Objects.ITEM_ORB_FIRE) {
        	
        	List<EntityLiving> list = par0.getEntitiesWithinAABB(EntityLiving.class, ItemOrb.getEffectBounds(par1));
        	
        	par0.playSound((EntityPlayer)null, par1.posX, par1.posY, par1.posZ, NoiseHandler.SOUND_WOOSH, SoundCategory.NEUTRAL, 1.0F, (itemRand.nextFloat() * 0.4F + 0.8F));
        	
			for (EntityLiving living : list) {
				if (living instanceof EntityTameable && ((EntityTameable) living).isTamed()) {
					continue;
				}
				living.setFire((int) (living.getHealth()));
			}
        }
		
		if(par1.inventory.getCurrentItem().getItem() == Objects.ITEM_ORB_ENDER) {
        	
        	List<EntityLiving> list = par0.getEntitiesWithinAABB(EntityLiving.class, ItemOrb.getEffectBounds(par1));
        	
        	par0.playSound((EntityPlayer)null, par1.posX, par1.posY, par1.posZ, NoiseHandler.SOUND_UP, SoundCategory.NEUTRAL, 1.0F, (itemRand.nextFloat() * 0.4F + 0.8F));
        	
			for (EntityLiving living : list) {
				if (living instanceof EntityTameable && ((EntityTameable) living).isTamed()) {
					continue;
				}
				living.setPosition(living.posX, living.posY + 100.0D, living.posZ);
			}
        }
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, par1.getHeldItem(par2));
	}
}
