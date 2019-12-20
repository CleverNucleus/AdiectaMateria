package clevernucleus.adiectamateria.common.item;

import java.util.List;

import clevernucleus.adiectamateria.common.AdiectaMateria.Core;
import clevernucleus.adiectamateria.common.util.interfaces.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class ItemEdible extends ItemFood implements IHasModel {
	private boolean desc;
	
	public ItemEdible(String par0, int par1) {
		super(par1, false);
		
		this.setUnlocalizedName(par0);
		this.setRegistryName(par0);
		this.setCreativeTab(CreativeTabs.FOOD);
		this.desc = false;
		
		ItemInit.ITEMS.add(this);
	}
	
	public ItemEdible(String par0, int par1, float par2) {
		super(par1, par2, false);
		
		this.setUnlocalizedName(par0);
		this.setRegistryName(par0);
		this.setCreativeTab(CreativeTabs.FOOD);
		this.desc = false;
		
		ItemInit.ITEMS.add(this);
	}
	
	public ItemEdible addDescription() {
		this.desc = true;
		
		return this;
	}
	
	@Override
	public void addInformation(ItemStack par0, World par1, List<String> par2, net.minecraft.client.util.ITooltipFlag par3) {
		par2.add(TextFormatting.GRAY + net.minecraft.client.resources.I18n.format(clevernucleus.adiectamateria.client.content.LangKeys.SUB_TEXT + this.getUnlocalizedName().substring(5)));
		
		super.addInformation(par0, par1, par2, par3);
	}
	
	@Override
	public void registerModels() {
		Core.proxy.registerItemRenderer(this, 0, "inventory");
	}
}
