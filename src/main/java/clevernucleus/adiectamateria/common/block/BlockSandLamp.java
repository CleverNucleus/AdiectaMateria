package clevernucleus.adiectamateria.common.block;

import clevernucleus.adiectamateria.common.AdiectaMateria.Core;
import clevernucleus.adiectamateria.common.item.ItemCreativeTab;
import clevernucleus.adiectamateria.common.item.ItemInit;
import clevernucleus.adiectamateria.common.util.interfaces.IHasModel;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class BlockSandLamp extends Block implements IHasModel {
	public BlockSandLamp(String par0) {
		super(Material.ROCK);
		
		this.setUnlocalizedName(par0);
		this.setRegistryName(par0);
		this.setSoundType(SoundType.STONE);
		this.setCreativeTab(ItemCreativeTab.MODTAB);
		
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	
	@Override
	public void registerModels() {
		Core.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
}
