package clevernucleus.adiectamateria.common.item;

import clevernucleus.adiectamateria.common.AdiectaMateria;
import clevernucleus.adiectamateria.common.util.IItemModel;
import clevernucleus.adiectamateria.common.util.Util;
import net.minecraft.item.Item;

public class ItemBasic extends Item implements IItemModel {
	public ItemBasic(String par0) {
		this.setUnlocalizedName(par0);
		this.setRegistryName(par0);
		this.setCreativeTab(Util.MODTAB);
		
		ItemInit.ITEMS.add(this);
	}
	
	@Override
	public void registerModels() {
		AdiectaMateria.proxy.registerItemRenderer(this, 0, "inventory");
	}
}