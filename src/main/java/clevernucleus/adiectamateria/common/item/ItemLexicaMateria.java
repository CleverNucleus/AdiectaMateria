package clevernucleus.adiectamateria.common.item;

import java.util.List;

import clevernucleus.adiectamateria.common.AdiectaMateria;
import clevernucleus.adiectamateria.common.util.IItemModel;
import clevernucleus.adiectamateria.common.util.Util;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class ItemLexicaMateria extends Item implements IItemModel {
	public ItemLexicaMateria(String par0) {
		this.setUnlocalizedName(par0);
		this.setRegistryName(par0);
		this.setCreativeTab(Util.MODTAB);
		this.maxStackSize = 1;
		
		ItemInit.ITEMS.add(this);
	}
	
	@Override
	public void addInformation(ItemStack par0, World par1, List<String> par2, net.minecraft.client.util.ITooltipFlag par3) {
		par2.add(TextFormatting.GRAY + net.minecraft.client.resources.I18n.format(clevernucleus.adiectamateria.client.content.LangKeys.SUB_TEXT + this.getUnlocalizedName().substring(5)));
		
		super.addInformation(par0, par1, par2, par3);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World par0, EntityPlayer par1, EnumHand par2) {
		ItemStack var0 = par1.getHeldItem(par2);
		
		if(!par1.isSneaking()) {
			AdiectaMateria.proxy.displayBook(par1, par0.isRemote);
		}
		
		return new ActionResult<ItemStack>(EnumActionResult.PASS, var0);
	}
	
	@Override
	public void registerModels() {
		AdiectaMateria.proxy.registerItemRenderer(this, 0, "inventory");
	}
}