package clevernucleus.adiectamateria.objects;

import java.util.List;

import clevernucleus.adiectamateria.Objects;
import clevernucleus.adiectamateria.util.DecisionHandler;
import clevernucleus.adiectamateria.util.Util;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * @name AdiectaMateria
 * @author CleverNucleus
 * @license Apache 2.0
 */

public class ItemOrb extends Item {
	
	private String var0;
	
	public ItemOrb(String par0, String par1) {
		this.setUnlocalizedName(par0);
		this.setTextureName(Util.MODID + ":" + par0);
		this.setCreativeTab(Objects.TAB_ADIECTAMATERIA);
		this.maxStackSize = 1;
		this.setMaxDamage(24);
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
    
    public static long getTime(World par0) {
        return par0.getWorldInfo().getWorldTime();
    }
    
    public static void setTime(World par0, long par1) {
        par0.getWorldInfo().setWorldTime(par1);
    }
    
    public static void setHourForward(World world, int hour) {
        long day = (getTime(world) / 24000L) * 24000L;
        long newTime = day + 24000L + hour * 1000;
        
        setTime(world, newTime);
    }
    
    @Override
    public ItemStack onItemRightClick(ItemStack par0, World par1, EntityPlayer par2) {
    	
    	ItemStack var1 = par2.getHeldItem();
    	
    	if(!par2.capabilities.isCreativeMode) {
    		var1.damageItem(1, par2);
    	}
    	
    	DecisionHandler.ifStatementsItemOrb(par0, par1, par2);
    	
		return par0;
    }
}
