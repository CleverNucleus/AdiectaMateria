package clevernucleus.adiectamateria.objects;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import baubles.api.BaubleType;
import baubles.api.IBauble;
import clevernucleus.adiectamateria.Objects;
import clevernucleus.adiectamateria.util.Util;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

/**
 * @name AdiectaMateria
 * @author CleverNucleus
 * @license Apache 2.0
 */

public class ItemTrinket extends Item implements IBauble {
	
	public static final List<Item> TRINKET = new ArrayList<Item>();
	public static final Item[] trinket = new Item[] {Objects.ITEM_TRINKET_HEAL, Objects.ITEM_TRINKET_INVISIBILITY, Objects.ITEM_TRINKET_SATURATION, Objects.ITEM_TRINKET_SPEED, Objects.ITEM_TRINKET_VISION, Objects.ITEM_TRINKET_WATER};
	
	private String var0;
	
	public ItemTrinket(String par0, String par1) {
		this.setUnlocalizedName(par0);
		this.setTextureName(Util.MODID + ":" + par0);
		this.setCreativeTab(Objects.TAB_ADIECTAMATERIA);
		this.maxStackSize = 1;
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
     * Return an item rarity from EnumRarity based on what item is being filtered.
     */
    public EnumRarity getRarity(ItemStack par0) {
        return EnumRarity.epic;
    }
    
    @Override
	public boolean canEquip(ItemStack par0, EntityLivingBase par1) {
		return true;
	}
    
	@Override
	public boolean canUnequip(ItemStack par0, EntityLivingBase par1) {
		return true;
	}
	
	@Override
	public BaubleType getBaubleType(ItemStack par0) {
		if(this == Objects.ITEM_TRINKET_SPEED || this == Objects.ITEM_TRINKET_INVISIBILITY || this == Objects.ITEM_TRINKET_SATURATION) {
			return BaubleType.RING;
		} else if(this == Objects.ITEM_TRINKET_HEAL || this == Objects.ITEM_TRINKET_WATER || this == Objects.ITEM_TRINKET_VISION) {
			return BaubleType.AMULET;
		}
		return null;
	}
	
	@Override
	public void onEquipped(ItemStack par0, EntityLivingBase par1) {
		onEquippedOrLoaded(par0, par1);
	}
	
	@Override
	public void onUnequipped(ItemStack par0, EntityLivingBase par1) {
		if(this == Objects.ITEM_TRINKET_HEAL) {
			par1.removePotionEffect(Potion.heal.id);
		}
		
		if(this == Objects.ITEM_TRINKET_INVISIBILITY) {
			par1.removePotionEffect(Potion.invisibility.id);
		}
		
		if(this == Objects.ITEM_TRINKET_SATURATION) {
			par1.removePotionEffect(Potion.field_76443_y.id);
		}
		
		if(this == Objects.ITEM_TRINKET_SPEED) {
			par1.removePotionEffect(Potion.moveSpeed.id);
		}
		
		if(this == Objects.ITEM_TRINKET_VISION) {
			par1.removePotionEffect(Potion.nightVision.id);
		}
		
		if(this == Objects.ITEM_TRINKET_WATER) {
			par1.removePotionEffect(Potion.waterBreathing.id);
		}
	}
	
	@Override
	public void onWornTick(ItemStack par0, EntityLivingBase par1) {
		if(this == Objects.ITEM_TRINKET_HEAL) {
			
			PotionEffect var1 = par1.getActivePotionEffect(Potion.heal);
			
			if(var1 == null || var1.getDuration() < 900) par1.addPotionEffect(new PotionEffect(Potion.heal.id, 999999, 1, true));
		}
		
		if(this == Objects.ITEM_TRINKET_INVISIBILITY) {
			
			PotionEffect var1 = par1.getActivePotionEffect(Potion.invisibility);
			
			if(var1 == null || var1.getDuration() < 900) par1.addPotionEffect(new PotionEffect(Potion.invisibility.id, 999999, 1, true));
		}
		
		if(this == Objects.ITEM_TRINKET_SATURATION) {
			
			PotionEffect var1 = par1.getActivePotionEffect(Potion.field_76443_y);
			
			if(var1 == null || var1.getDuration() < 900) par1.addPotionEffect(new PotionEffect(Potion.field_76443_y.id, 999999, 1, true));
		}
		
		if(this == Objects.ITEM_TRINKET_SPEED) {
			
			PotionEffect var1 = par1.getActivePotionEffect(Potion.moveSpeed);
			
			if(var1 == null || var1.getDuration() < 900) par1.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 999999, 1, true));
		}
		
		if(this == Objects.ITEM_TRINKET_VISION) {
			
			PotionEffect var1 = par1.getActivePotionEffect(Potion.nightVision);
			
			if(var1 == null || var1.getDuration() < 900) par1.addPotionEffect(new PotionEffect(Potion.nightVision.id, 999999, 1, true));
		}
		
		if(this == Objects.ITEM_TRINKET_WATER) {
			
			PotionEffect var1 = par1.getActivePotionEffect(Potion.waterBreathing);
			
			if(var1 == null || var1.getDuration() < 900) par1.addPotionEffect(new PotionEffect(Potion.waterBreathing.id, 999999, 1, true));
		}
	}
	
	public void onEquippedOrLoaded(ItemStack par0, EntityLivingBase par1) {}
}
