package clevernucleus.adiectamateria.objects;

import java.util.List;

import javax.annotation.Nullable;

import clevernucleus.adiectamateria.Core;
import clevernucleus.adiectamateria.Objects;
import clevernucleus.adiectamateria.util.DecisionHandler;
import clevernucleus.adiectamateria.util.IModel;
import clevernucleus.adiectamateria.util.Util;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * @name AdiectaMateria
 * @author CleverNucleus
 * @license Apache 2.0
 */

public class ItemOrb extends Item implements IModel {
	
public String var0;
	
	public ItemOrb(String par0, String par1) {
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
     * Determines the (total) world time.
     */
    public static long getTime(World par0) {
        return par0.getWorldInfo().getWorldTime();
    }
    
    /**
     * Sets the (total) world time.
     */
    public static void setTime(World par0, long par1) {
        par0.getWorldInfo().setWorldTime(par1);
    }
    
    /**
     * Sets the (total) world time to day or night but makes sure the time was moved forwards.
     * This is done this way so that it can remain compatible with time dependent mods e.g. Millenaire.
     */
    public static void setHourForward(World world, int hour) {
        long day = (getTime(world) / 24000L) * 24000L;
        long newTime = day + 24000L + hour * 1000;
        
        setTime(world, newTime);
    }
    
    /**
     * Gets the radius from the player to use.
     */
    public static AxisAlignedBB getEffectBounds(EntityPlayer par0) {
		return new AxisAlignedBB(par0.getPosition().add(-32, -32, -32), par0.getPosition().add(32, 32, 32));
	}
	
    /**
     * Fired when the item is right-clicked - not to be confused with onItemUse().
     */
	@Override
    public ActionResult<ItemStack> onItemRightClick(World par0, EntityPlayer par1, EnumHand par2) {
		
        ItemStack var4 = par1.getHeldItem(par2);
        
        if(!par1.capabilities.isCreativeMode) {
            var4.damageItem(1, par1);
        }
        
        DecisionHandler.ifStatementsItemOrb(par0, par1, par2);
        
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, var4);
    }
	
    /**
     * Registers the item model to be displayed in the inventory.
     */
	@Override
	public void registerModels() {
		Core.proxy.registerItemRenderer(this, 0, "inventory");
	}
}
