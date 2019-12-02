package clevernucleus.adiectamateria.common.item;

import java.util.List;

import clevernucleus.adiectamateria.common.AdiectaMateria.Core;
import clevernucleus.adiectamateria.common.Common;
import clevernucleus.adiectamateria.common.util.Component;
import clevernucleus.adiectamateria.common.util.interfaces.IHasModel;
import clevernucleus.adiectamateria.common.util.recipes.Transmuting;
import net.minecraft.block.BlockLog;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
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
	
	private void transmute(World par0, BlockPos par1, IBlockState par2, Component[] par3) {
		if(par3[1].hasProperties()) {
			IBlockState var0;
			
			if(par2.getBlock() instanceof BlockLog) {
				BlockLog.EnumAxis var1 = BlockLog.EnumAxis.fromFacingAxis(EnumFacing.Axis.byName("" + par2.getProperties().get(BlockLog.LOG_AXIS)));
				
				var0 = par3[1].getBlock().getDefaultState().withProperty(BlockLog.LOG_AXIS, var1).withProperty(par3[1].getProperty(), par3[1].getType());
			} else {
				var0 = par3[1].getBlock().getStateFromMeta(par2.getBlock().getMetaFromState(par2)).withProperty(par3[1].getProperty(), par3[1].getType());
			}
			
			par0.setBlockState(par1, var0);
		} else {
			par0.setBlockState(par1, par3[1].getBlock().getStateFromMeta(par2.getBlock().getMetaFromState(par2)));
		}
		
		EntityItem item = new EntityItem(par0, par1.getX(), par1.getY(), par1.getZ(), par3[1].getStack());
		
		par0.spawnEntity(item);
	}
	
	@Override
	public EnumActionResult onItemUse(EntityPlayer par0, World par1, BlockPos par2, EnumHand par3, EnumFacing par4, float par5, float par6, float par7) {
		ItemStack stack = par0.getHeldItem(par3);
		IBlockState state = par1.getBlockState(par2);
		
		boolean isMatch = false;
		
		for(Component[] var : Transmuting.getArray()) {
			Component var0 = var[0];
			Component var1 = var[1];
			
			if(state.getBlock() == var0.getBlock()) {
				if(var0.hasProperties()) {
					if(state == var0.getBlock().getActualState(state, par1, par2).withProperty(var0.getProperty(), var0.getType()) || state == var0.getBlock().getDefaultState().withProperty(var0.getProperty(), var0.getType())) {
						isMatch = true;
						
						if(!par1.isRemote) {
							transmute(par1, par2, state, var);
							
							break;
						}
					}
				} else {
					isMatch = true;
					
					if(!par1.isRemote) {
						transmute(par1, par2, state, var);
						
						break;
					}
				}
			}
		}
		
		if(isMatch) {
			if(!par0.capabilities.isCreativeMode) {
				stack.shrink(1);
			}
			
			Common.proxy(par1.isRemote).spawnParticle(par1, par2, EnumParticleTypes.FLAME, 7);
			
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
