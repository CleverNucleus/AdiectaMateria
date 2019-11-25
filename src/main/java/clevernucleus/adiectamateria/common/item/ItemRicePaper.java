package clevernucleus.adiectamateria.common.item;

import clevernucleus.adiectamateria.common.AdiectaMateria.Core;
import clevernucleus.adiectamateria.common.util.interfaces.IHasModel;
import net.minecraft.item.Item;

public class ItemRicePaper extends Item implements IHasModel {
	public ItemRicePaper(String par0) {
		this.setUnlocalizedName(par0);
		this.setRegistryName(par0);
		this.setCreativeTab(ItemCreativeTab.MODTAB);
		
		ItemUnit.ITEMS.add(this);
	}
	
	@Override
	public void registerModels() {
		Core.proxy.registerItemRenderer(this, 0, "inventory");
	}
}
