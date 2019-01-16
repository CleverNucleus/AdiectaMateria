package clevernucleus.adiectamateria.objects;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import baubles.api.BaubleType;
import baubles.api.IBauble;
import clevernucleus.adiectamateria.Core;
import clevernucleus.adiectamateria.Objects;
import clevernucleus.adiectamateria.util.IModel;
import clevernucleus.adiectamateria.util.Util;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
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

public class ItemTrinket extends Item implements IModel, IBauble {
	
	public static final List<Item> TRINKET = new ArrayList<Item>();
	public static final Item[] trinket = new Item[] {Objects.ITEM_TRINKET_HEAL, Objects.ITEM_TRINKET_INVISIBILITY, Objects.ITEM_TRINKET_SATURATION, Objects.ITEM_TRINKET_SPEED, Objects.ITEM_TRINKET_VISION, Objects.ITEM_TRINKET_WATER};
	
	private String var0;
	
	public ItemTrinket(String par0, String par1) {
		this.setUnlocalizedName(par0);
		this.setRegistryName(par0);
		this.var0 = par1;
		this.maxStackSize = 1;
        this.setMaxDamage(24);
		this.setCreativeTab(Objects.TAB_ADIECTAMATERIA);
		
		Objects.ITEMS.add(this);
	}
	
	/**
     * Determines the item display font colour; e.g. EPIC is purple.
     */
	@SideOnly(Side.CLIENT)
    public EnumRarity getRarity(ItemStack stack) {
        return EnumRarity.UNCOMMON;
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
     * Determines what Bauble Slot the item will be accepted to.
     */
	@Override
	public BaubleType getBaubleType(ItemStack par0) {
		if(this == Objects.ITEM_TRINKET_SPEED || this == Objects.ITEM_TRINKET_INVISIBILITY || this == Objects.ITEM_TRINKET_SATURATION) {
			return BaubleType.RING;
		} else if(this == Objects.ITEM_TRINKET_HEAL || this == Objects.ITEM_TRINKET_WATER || this == Objects.ITEM_TRINKET_VISION) {
			return BaubleType.AMULET;
		}
		return null;
	}
	/**
	 * Fired when the item is removed from the Bauble Slot.
	 */
	@Override
	public void onUnequipped(ItemStack par0, EntityLivingBase par1) {
		if(this == Objects.ITEM_TRINKET_HEAL) {
			par1.removePotionEffect(Potion.getPotionById(6));
		}
		
		if(this == Objects.ITEM_TRINKET_INVISIBILITY) {
			par1.removePotionEffect(Potion.getPotionById(14));
		}
		
		if(this == Objects.ITEM_TRINKET_SATURATION) {
			par1.removePotionEffect(Potion.getPotionById(23));
		}
		
		if(this == Objects.ITEM_TRINKET_SPEED) {
			par1.removePotionEffect(Potion.getPotionById(1));
		}
		
		if(this == Objects.ITEM_TRINKET_VISION) {
			par1.removePotionEffect(Potion.getPotionById(16));
		}
		
		if(this == Objects.ITEM_TRINKET_WATER) {
			par1.removePotionEffect(Potion.getPotionById(13));
		}
	}
	
	/**
	 * Fired constantly when the item is in the Bauble Slot.
	 */
	@Override
	public void onWornTick(ItemStack par0, EntityLivingBase par1) {
		if(this == Objects.ITEM_TRINKET_HEAL) {
			
			PotionEffect var1 = par1.getActivePotionEffect(Potion.getPotionById(6));
			
			if(var1 == null || var1.getDuration() < 900) par1.addPotionEffect(new PotionEffect(Potion.getPotionById(6), 999999, 1));
		}
		
		if(this == Objects.ITEM_TRINKET_INVISIBILITY) {
			
			PotionEffect var1 = par1.getActivePotionEffect(Potion.getPotionById(14));
			
			if(var1 == null || var1.getDuration() < 900) par1.addPotionEffect(new PotionEffect(Potion.getPotionById(14), 999999, 1));
		}
		
		if(this == Objects.ITEM_TRINKET_SATURATION) {
			
			PotionEffect var1 = par1.getActivePotionEffect(Potion.getPotionById(23));
			
			if(var1 == null || var1.getDuration() < 900) par1.addPotionEffect(new PotionEffect(Potion.getPotionById(23), 999999, 1));
		}
		
		if(this == Objects.ITEM_TRINKET_SPEED) {
			
			PotionEffect var1 = par1.getActivePotionEffect(Potion.getPotionById(1));
			
			if(var1 == null || var1.getDuration() < 900) par1.addPotionEffect(new PotionEffect(Potion.getPotionById(1), 999999, 1));
		}
		
		if(this == Objects.ITEM_TRINKET_VISION) {
			
			PotionEffect var1 = par1.getActivePotionEffect(Potion.getPotionById(16));
			
			if(var1 == null || var1.getDuration() < 900) par1.addPotionEffect(new PotionEffect(Potion.getPotionById(16), 999999, 1));
		}
		
		if(this == Objects.ITEM_TRINKET_WATER) {
			
			PotionEffect var1 = par1.getActivePotionEffect(Potion.getPotionById(13));
			
			if(var1 == null || var1.getDuration() < 900) par1.addPotionEffect(new PotionEffect(Potion.getPotionById(13), 999999, 1));
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
