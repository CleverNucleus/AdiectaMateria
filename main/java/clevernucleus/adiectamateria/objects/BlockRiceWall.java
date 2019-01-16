package clevernucleus.adiectamateria.objects;

import clevernucleus.adiectamateria.Objects;
import clevernucleus.adiectamateria.util.Util;
import net.minecraft.block.Block;
import net.minecraft.block.BlockPane;
import net.minecraft.block.material.Material;

/**
 * @name AdiectaMateria
 * @author CleverNucleus
 * @license Apache 2.0
 */

public class BlockRiceWall extends BlockPane {
	
	public BlockRiceWall(String par0, String par1, Material par2, boolean par3) {
		super(Util.MODID + ":" + par0, Util.MODID + ":" + par1, par2, par3);
		this.setBlockName(par0);
		this.setBlockTextureName(Util.MODID + ":" + par0);
		this.setCreativeTab(Objects.TAB_ADIECTAMATERIA);
		this.setHardness(0.3F);
		this.setLightLevel(0.9375F);
		this.setStepSound(Block.soundTypeCloth);
		
		Objects.BLOCKS.add(this);
	}
}
