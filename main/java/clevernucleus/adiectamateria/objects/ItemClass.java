package clevernucleus.adiectamateria.objects;

import java.util.List;

import javax.annotation.Nullable;

import clevernucleus.adiectamateria.Core;
import clevernucleus.adiectamateria.Objects;
import clevernucleus.adiectamateria.util.DecisionHandler;
import clevernucleus.adiectamateria.util.IModel;
import clevernucleus.adiectamateria.util.NoiseHandler;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * @name AdiectaMateria
 * @author CleverNucleus
 * @license Apache 2.0
 */
public class ItemClass extends Item implements IModel {
	
	public String var0;
	
	public ItemClass(String par0, String par1) {
		this.setUnlocalizedName(par0);
		this.setRegistryName(par0);
		this.var0 = par1;
		this.setCreativeTab(Objects.TAB_ADIECTAMATERIA);
		
		Objects.ITEMS.add(this);
	}
	
	/**
	 * Determines whether the item has the visual enchantment effect.
	 */
    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack par0) {
        return this == Objects.ITEM_ALTERA_DUST ? true : false;
    }
	
    /**
     * Determines the item display font colour; e.g. EPIC is purple.
     */
    @SideOnly(Side.CLIENT)
    public EnumRarity getRarity(ItemStack par0) {
        return this == Objects.ITEM_ALTERA_DUST ? EnumRarity.EPIC : EnumRarity.COMMON;
    }
    
    /**
     * Adds a tool tip display message to the item.
     */
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack par0, @Nullable World par1, List<String> par2, ITooltipFlag par3) {
    	par2.add(var0);
        super.addInformation(par0, par1, par2, par3);
    }
    
    /**
     * Fired when the item is right-clicked on a block - not to be confused with onItemRightClick().
     */
    @Override
	public EnumActionResult onItemUse(EntityPlayer par0, World par1, BlockPos par2, EnumHand par3, EnumFacing par4, float par5, float par6, float par7) {
    	if(this == Objects.ITEM_ALTERA_DUST) {
    		
    		ItemStack var0 = par0.getHeldItem(par3);
    		
    		if(!par0.capabilities.isCreativeMode) {
                var0.shrink(1);
            }
    		
    		par1.playSound((EntityPlayer)null, par0.posX, par0.posY, par0.posZ, NoiseHandler.SOUND_TRANSFORM, SoundCategory.NEUTRAL, 1.0F, itemRand.nextFloat() * 0.4F + 0.8F);
    		
    		DecisionHandler.ifStatementsItemClass(par0, par1, par2, par3, par4, par5, par6, par7);
    	}
    	return EnumActionResult.PASS;
    }
    
    /**
     * Registers the item model to be displayed in the inventory.
     */
    @Override
	public void registerModels() {
		Core.proxy.registerItemRenderer(this, 0, "inventory");
	}
}
