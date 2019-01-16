package clevernucleus.adiectamateria.objects;

import clevernucleus.adiectamateria.Objects;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

/**
 * @name AdiectaMateria
 * @author CleverNucleus
 * @license Apache 2.0
 */
public class CreativeTabAdiectaMateria extends CreativeTabs {
	
	public CreativeTabAdiectaMateria(int par0, String par1) {
		super(par0, par1);
	}
	
	/**
	 * The item to display on the creative tab.
	 */
	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(Objects.ITEM_ALTERA_DUST);
	}
}
