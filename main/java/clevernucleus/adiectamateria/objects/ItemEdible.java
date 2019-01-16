package clevernucleus.adiectamateria.objects;

import java.util.ArrayList;
import java.util.List;

import clevernucleus.adiectamateria.Objects;
import clevernucleus.adiectamateria.util.Util;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
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

/**
 * @name AdiectaMateria
 * @author CleverNucleus
 * @license Apache 2.0
 */

public class ItemEdible extends ItemFood {
	
	private String var0;
	
	public ItemEdible(String par0, String par1, int par2, float par3, boolean par4) {
		super(par2, par3, par4);
		this.setUnlocalizedName(par0);
		this.setTextureName(Util.MODID + ":" + par0);
		this.setCreativeTab(CreativeTabs.tabFood);
		this.var0 = par1;
		this.setMaxStackSize(par0 == Util.ITEM_GOD_JUICE ? 1 : 64);
		
		Objects.ITEMS.add(this);
	}

	
	/**
	 * The animation and sound made when consuming the item.
	 * 
	 * @param par0
	 * @return
	 */
	@Override
    public EnumAction getItemUseAction(ItemStack par0) {
		if(par0.getItem() == Objects.ITEM_GOD_JUICE) {
			return EnumAction.drink;
		}
        return EnumAction.eat;
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
        return this == Objects.ITEM_GOD_JUICE || this == Objects.ITEM_GREATER_APPLE ? true : false;
    }
    
    /**
     * Return an item rarity from EnumRarity based on what item is being filtered.
     */
    public EnumRarity getRarity(ItemStack par0) {
        return this == Objects.ITEM_GOD_JUICE || this == Objects.ITEM_GREATER_APPLE ? EnumRarity.epic : EnumRarity.common;
    }
    
    /**
     * Adds potion effects in list form to specific items using this class.
     * 
     * @param par0
     * @param par1
     * @param par2
     */
    protected void onFoodEaten(ItemStack par0, World par1, EntityPlayer par2) {
    	if(par0.getItem() == Objects.ITEM_RYE_RAW) {
    		par2.addPotionEffect(new PotionEffect(Potion.hunger.id, 300, 0));
    	}
    	
    	if(par0.getItem() == Objects.ITEM_RYE_COOKED) {
    		par2.addPotionEffect(new PotionEffect(Potion.heal.id, 10, 0));
    	}
    	
    	if(par0.getItem() == Objects.ITEM_GOD_JUICE) {
    		par2.addPotionEffect(new PotionEffect(Potion.harm.id, 40, 0));
        	par2.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 1200, 1));
        	par2.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 1200, 1));
        	par2.addPotionEffect(new PotionEffect(Potion.invisibility.id, 1200, 0));
        	par2.addPotionEffect(new PotionEffect(Potion.fireResistance.id, 1200, 1));
        	par2.addPotionEffect(new PotionEffect(Potion.resistance.id, 1200, 1));
        	par2.addPotionEffect(new PotionEffect(Potion.nightVision.id, 1200, 0));
    	}
    	
    	if(par0.getItem() == Objects.ITEM_GREATER_APPLE) {
    		par2.addPotionEffect(new PotionEffect(Potion.field_76443_y.id, 1200, 0));
    	}
    }
}
