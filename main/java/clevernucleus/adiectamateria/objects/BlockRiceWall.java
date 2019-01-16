package clevernucleus.adiectamateria.objects;

import clevernucleus.adiectamateria.Core;
import clevernucleus.adiectamateria.Objects;
import clevernucleus.adiectamateria.util.IModel;
import net.minecraft.block.BlockPane;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

/**
 * @name AdiectaMateria
 * @author CleverNucleus
 * @license Apache 2.0
 */
public class BlockRiceWall extends BlockPane implements IModel {
	
	public BlockRiceWall(String par0, Material par1, boolean par2) {
		super(par1, par2);
		this.setUnlocalizedName(par0);
		this.setRegistryName(par0);
		this.setCreativeTab(Objects.TAB_ADIECTAMATERIA);
		this.setLightLevel(0.9375F);
		this.setHardness(0.3F);
		this.setSoundType(SoundType.CLOTH);
		
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
