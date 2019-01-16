package clevernucleus.adiectamateria.objects;

import clevernucleus.adiectamateria.Core;
import clevernucleus.adiectamateria.Objects;
import clevernucleus.adiectamateria.util.IModel;
import clevernucleus.adiectamateria.util.Util;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

/**
 * @name AdiectaMateria
 * @author CleverNucleus
 * @license Apache 2.0
 */

public class BlockClass extends Block implements IModel {
	
	public BlockClass(String par0, Material par1, float par2, float par3, float par4, SoundType par5) {
		super(par1);
		this.setRegistryName(par0);
		this.setUnlocalizedName(par0);
		this.setCreativeTab(Objects.TAB_ADIECTAMATERIA);
		this.setHardness(par2);
		this.setResistance(par3);
		this.setLightLevel(par4);
		this.setSoundType(par5);
		
		Objects.BLOCKS.add(this);
		Objects.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
	}
	
	/**
	 * Registers the item model of the block displayed in the inventory.
	 */
	@Override
	public void registerModels() {
		Core.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
}
