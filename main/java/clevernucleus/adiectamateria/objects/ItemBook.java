package clevernucleus.adiectamateria.objects;

import java.util.List;

import javax.annotation.Nullable;

import clevernucleus.adiectamateria.Core;
import clevernucleus.adiectamateria.Objects;
import clevernucleus.adiectamateria.util.DecisionHandler;
import clevernucleus.adiectamateria.util.IModel;
import clevernucleus.adiectamateria.util.gui.GuiBook;
import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * @name AdiectaMateria
 * @author CleverNucleus
 * @license Apache 2.0
 */
public class ItemBook extends Item implements IModel {
	
public String var0;
	
	public ItemBook(String par0, String par1) {
		this.setUnlocalizedName(par0);
		this.setRegistryName(par0);
		this.var0 = par1;
		this.maxStackSize = 1;
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
     * Fired when the item is right-clicked - not to be confused with onItemUse().
     */
	@Override
    public ActionResult<ItemStack> onItemRightClick(World par0, EntityPlayer par1, EnumHand par2) {
		if(par0.isRemote) {
			Minecraft.getMinecraft().displayGuiScreen(new GuiBook());
		}
        return super.onItemRightClick(par0, par1, par2);
    }
	
    /**
     * Registers the item model to be displayed in the inventory.
     */
	@Override
	public void registerModels() {
		Core.proxy.registerItemRenderer(this, 0, "inventory");
	}
}
