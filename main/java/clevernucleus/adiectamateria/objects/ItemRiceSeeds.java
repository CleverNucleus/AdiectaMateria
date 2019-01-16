package clevernucleus.adiectamateria.objects;

import clevernucleus.adiectamateria.Objects;
import clevernucleus.adiectamateria.util.Util;
import net.minecraft.block.Block;
import net.minecraft.item.ItemSeeds;

/**
 * @name AdiectaMateria
 * @author CleverNucleus
 * @license Apache 2.0
 */

public class ItemRiceSeeds extends ItemSeeds {

	public ItemRiceSeeds(String par0, Block par1, Block par2) {
		super(par1, par2);
		this.setUnlocalizedName(par0);
		this.setTextureName(Util.MODID + ":" + par0);
		this.setCreativeTab(Objects.TAB_ADIECTAMATERIA);
		
		Objects.ITEMS.add(this);
	}
	
}