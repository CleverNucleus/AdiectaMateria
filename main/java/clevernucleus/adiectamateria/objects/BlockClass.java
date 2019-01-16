package clevernucleus.adiectamateria.objects;

import clevernucleus.adiectamateria.Objects;

import clevernucleus.adiectamateria.util.Util;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

/**
 * @name AdiectaMateria
 * @author CleverNucleus
 * @license Apache 2.0
 */

public class BlockClass extends Block {
	
	public BlockClass(String par0, Material par1, float par2, float par3, float par4, Block.SoundType par5) {
		super(par1);
		this.setBlockName(par0);
		this.setBlockTextureName(Util.MODID + ":" + par0);
		this.setCreativeTab(Objects.TAB_ADIECTAMATERIA);
		this.setHardness(par2);
		this.setResistance(par3);
		this.setLightLevel(par4);
		this.setStepSound(par5);
		
		Objects.BLOCKS.add(this);
	}
}
