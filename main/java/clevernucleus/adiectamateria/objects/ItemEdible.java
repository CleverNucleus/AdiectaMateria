package clevernucleus.adiectamateria.objects;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import clevernucleus.adiectamateria.Core;
import clevernucleus.adiectamateria.Objects;
import clevernucleus.adiectamateria.util.IModel;
import clevernucleus.adiectamateria.util.Util;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * @name AdiectaMateria
 * @author CleverNucleus
 * @license Apache 2.0
 */

public class ItemEdible extends ItemFood implements IModel {
	
	public String var0;
 	
	public ItemEdible(String par0, String par1, int par2, boolean par3) {
		super(par2, par3);
		this.setUnlocalizedName(par0);
		this.setRegistryName(par0);
		this.setCreativeTab(CreativeTabs.FOOD);
		this.setMaxStackSize(par0 == Util.ITEM_GOD_JUICE ? 1 : 64);
		this.var0 = par1;
		
		Objects.ITEMS.add(this);
	}
	
	public ItemEdible(String par0, String par1, int par2, float par3, boolean par4) {
		super(par2, par3, par4);
		this.setUnlocalizedName(par0);
		this.setRegistryName(par0);
		this.setCreativeTab(CreativeTabs.FOOD);
		this.var0 = par1;
		
		Objects.ITEMS.add(this);
	}
	
	/**
	 * Determines whether the item has the visual enchantment effect.
	 */
	@SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack par0) {
        return this == Objects.ITEM_GOD_JUICE || this == Objects.ITEM_GREATER_APPLE ? true : false;
    }
    
	/**
     * Determines the item display font colour; e.g. EPIC is purple.
     */
	@Override
    public EnumRarity getRarity(ItemStack par0) {
        return this == Objects.ITEM_GOD_JUICE || this == Objects.ITEM_GREATER_APPLE ? EnumRarity.EPIC : EnumRarity.COMMON;
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
	 * Determines the use animation when consumed; e.g. a bottle returns DRINK.
	 */
	@Override
	public EnumAction getItemUseAction(ItemStack par0) {
		if(par0.getItem() == Objects.ITEM_GOD_JUICE) {
			return EnumAction.DRINK;
		}
        return EnumAction.EAT;
	}
	
	/**
	 * Fired when the item (food) is eaten/consumed.
	 */
	@Override
	protected void onFoodEaten(ItemStack par0, World par1, EntityPlayer par2) {
		if(par0.getItem() == Objects.ITEM_RYE_RAW) {
    		par2.addPotionEffect(new PotionEffect(Potion.getPotionById(17), 300, 0));
    	}
    	
    	if(par0.getItem() == Objects.ITEM_RYE_COOKED) {
    		par2.addPotionEffect(new PotionEffect(Potion.getPotionById(6), 10, 0));
    	}
    	
    	if(par0.getItem() == Objects.ITEM_GOD_JUICE) {
    		par2.addPotionEffect(new PotionEffect(Potion.getPotionById(7), 40, 0));
        	par2.addPotionEffect(new PotionEffect(Potion.getPotionById(5), 1200, 1));
        	par2.addPotionEffect(new PotionEffect(Potion.getPotionById(1), 1200, 1));
        	par2.addPotionEffect(new PotionEffect(Potion.getPotionById(14), 1200, 0));
        	par2.addPotionEffect(new PotionEffect(Potion.getPotionById(12), 1200, 1));
        	par2.addPotionEffect(new PotionEffect(Potion.getPotionById(11), 1200, 1));
        	par2.addPotionEffect(new PotionEffect(Potion.getPotionById(16), 1200, 0));
    	}
    	
    	if(par0.getItem() == Objects.ITEM_GREATER_APPLE) {
    		par2.addPotionEffect(new PotionEffect(Potion.getPotionById(23), 1200, 0));
    	}
	}
    
    /**
     * Registers the item model to be displayed in the inventory.
     */
	@Override
	public void registerModels() {
		Core.proxy.registerItemRenderer(this, 0, "inventory");
	}
}
