package clevernucleus.adiectamateria.common.item;

import clevernucleus.adiectamateria.common.AdiectaMateria.Core;
import clevernucleus.adiectamateria.common.util.interfaces.IHasModel;
import net.minecraft.item.Item;

public class ItemPaperySheet extends Item implements IHasModel {
	public ItemPaperySheet(String par0) {
		this.setUnlocalizedName(par0);
		this.setRegistryName(par0);
		this.setCreativeTab(ItemCreativeTab.MODTAB);
		
		ItemInit.ITEMS.add(this);
	}
	
	@Override
	public void registerModels() {
		Core.proxy.registerItemRenderer(this, 0, "inventory");
	}
}
