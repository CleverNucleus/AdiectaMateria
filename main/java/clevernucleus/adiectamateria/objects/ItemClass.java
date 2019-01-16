package clevernucleus.adiectamateria.objects;

import java.util.List;

import javax.annotation.Nullable;

import clevernucleus.adiectamateria.Objects;
import clevernucleus.adiectamateria.util.DecisionHandler;
import clevernucleus.adiectamateria.util.Util;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * @name AdiectaMateria
 * @author CleverNucleus
 * @license Apache 2.0
 */

public class ItemClass extends Item {
	
	private String var0;
	
	public ItemClass(String par0, String par1) {
		this.setUnlocalizedName(par0);
		this.setTextureName(Util.MODID + ":" + par0);
		this.setCreativeTab(Objects.TAB_ADIECTAMATERIA);
		this.var0 = par1;
		
		Objects.ITEMS.add(this);
	}
	
    /**
     * Adds a custom line of information to the mouse over description.
     */
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack par0, EntityPlayer par1, List par2, boolean par3) {
        par2.add(var0);
    }
    
    /**
     * Returns the enchanted effect based on what item is being filtered.
     */
    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack par0) {
        return this == Objects.ITEM_ALTERA_DUST ? true : false;
    }
    
    /**
     * Return an item rarity from EnumRarity based on what item is being filtered.
     */
    public EnumRarity getRarity(ItemStack par0) {
        return this == Objects.ITEM_ALTERA_DUST ? EnumRarity.epic : EnumRarity.common;
    }
    
    public boolean onItemUse(ItemStack par0, EntityPlayer par1, World par2, int par3, int par4, int par5, int par6, float par7, float par8, float par9) {
    	if(this == Objects.ITEM_ALTERA_DUST) {
    		
    		ItemStack var0 = par1.getHeldItem();
    		
    		if(!par1.capabilities.isCreativeMode) {
                --var0.stackSize;
            }
    		
    		if(!par1.canPlayerEdit(par6, par6, par6, par6, par0)) {
    			return false;
    		} else {
    			
    			par2.playSoundEffect((double)par3 + 0.5D, (double)par4 + 0.5D, (double)par5 + 0.5D, Util.MODID + ":transform", 1.0F, itemRand.nextFloat() * 0.4F + 0.8F);
    			
    			DecisionHandler.ifStatementsItemClass(par1, par2, par3, par4, par5, true);
    		}
    	} else {
    		return false;
    	}
    	return true;
    }
}
