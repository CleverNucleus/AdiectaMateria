package clevernucleus.adiectamateria.common.item;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import clevernucleus.adiectamateria.common.AdiectaMateria.Core;
import clevernucleus.adiectamateria.common.Common;
import clevernucleus.adiectamateria.common.util.ObjectHolder;
import clevernucleus.adiectamateria.common.util.interfaces.IHasModel;
import clevernucleus.adiectamateria.common.util.recipes.Recipes;
import clevernucleus.adiectamateria.common.util.recipes.Transmuting;
import net.minecraft.block.Block;
import net.minecraft.block.BlockOldLog;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockProperties;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class ItemMeltyFlint extends Item implements IHasModel {
	public ItemMeltyFlint(String par0) {
		this.setUnlocalizedName(par0);
		this.setRegistryName(par0);
		this.setCreativeTab(ItemCreativeTab.MODTAB);
		
		ItemUnit.ITEMS.add(this);
	}
	
	@Override
	public void addInformation(ItemStack par0, World par1, List<String> par2, net.minecraft.client.util.ITooltipFlag par3) {
		par2.add(TextFormatting.GRAY + net.minecraft.client.resources.I18n.format(clevernucleus.adiectamateria.client.content.LangKeys.SUB_TEXT + this.getUnlocalizedName().substring(5)));
		
		super.addInformation(par0, par1, par2, par3);
	}
	
	@Override
	public EnumActionResult onItemUse(EntityPlayer par0, World par1, BlockPos par2, EnumHand par3, EnumFacing par4, float par5, float par6, float par7) {
		ItemStack var0 = par0.getHeldItem(par3);
		IBlockState var1 = par1.getBlockState(par2);
		
		if(Transmuting.getTransmutingMap().containsKey(var1)) {
			if(!par0.capabilities.isCreativeMode) {
				var0.shrink(1);
			}
			
			Common.proxy(par1.isRemote).spawnParticle(par1, par2, EnumParticleTypes.FLAME, 7);
			
			if(!par1.isRemote) {
				if(Transmuting.getTransmutingMap().get(var1) instanceof IBlockState) {
					par1.setBlockState(par2, ((IBlockState) Transmuting.getTransmutingMap().get(var1)));
				} else if(Transmuting.getTransmutingMap().get(var1) instanceof Item) {
					par1.setBlockState(par2, Blocks.AIR.getDefaultState());
					
					EntityItem var2 = new EntityItem(par1, par2.getX(), par2.getY(), par2.getZ(), new ItemStack((Item) Transmuting.getTransmutingMap().get(var1), 1));
					
					par1.spawnEntity(var2);
				}
			}
			
			/*if(var1.getBlock() == Blocks.LOG) {
				
				par1.setBlockState(par2, var1.withProperty(BlockOldLog.VARIANT, BlockPlanks.EnumType.BIRCH));*/
				
			par1.playSound(par0, par2, SoundEvents.BLOCK_ENCHANTMENT_TABLE_USE, SoundCategory.BLOCKS, 1.0F, itemRand.nextFloat() * 0.4F + 0.8F);
			
			return EnumActionResult.SUCCESS;
		} else {
			return EnumActionResult.FAIL;
		}
	}
	
	@Override
	public void registerModels() {
		Core.proxy.registerItemRenderer(this, 0, "inventory");
	}
}
