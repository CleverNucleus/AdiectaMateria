package clevernucleus.adiectamateria.common.block;

import clevernucleus.adiectamateria.common.AdiectaMateria;
import clevernucleus.adiectamateria.common.item.ItemInit;
import clevernucleus.adiectamateria.common.util.IItemModel;
import clevernucleus.adiectamateria.common.util.Util;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockDecorative extends Block implements IItemModel {
	public BlockDecorative(String par0, Material par1, SoundType par2) {
		super(par1);
		
		this.setUnlocalizedName(par0);
		this.setRegistryName(par0);
		this.setSoundType(par2);
		this.setCreativeTab(Util.MODTAB);
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	
	@Override
	public void registerModels() {
		AdiectaMateria.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
}
