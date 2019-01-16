package clevernucleus.adiectamateria.objects;

import clevernucleus.adiectamateria.Objects;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * @name AdiectaMateria
 * @author CleverNucleus
 * @license Apache 2.0
 */

public class CreativeTabAdiectaMateria extends CreativeTabs {
	
	public CreativeTabAdiectaMateria(String par1) {
		super(par1);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Item getTabIconItem() {
		return /*new ItemStack(Objects.ITEM_ALTERA_DUST).getItem();*/Objects.ITEM_ALTERA_DUST;
	}
}
