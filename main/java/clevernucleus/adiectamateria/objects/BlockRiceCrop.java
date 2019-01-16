package clevernucleus.adiectamateria.objects;

import clevernucleus.adiectamateria.Objects;
import clevernucleus.adiectamateria.util.Util;
import net.minecraft.block.BlockCrops;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

/**
 * @name AdiectaMateria
 * @author CleverNucleus
 * @license Apache 2.0
 */

public class BlockRiceCrop extends BlockCrops {
	
	public BlockRiceCrop(String par0) {
		this.setBlockName(par0);
		this.setBlockTextureName(Util.MODID + ":" + par0);
		Objects.BLOCKS.add(this);
	}
	
	@Override
	protected Item func_149866_i() {
        return Objects.ITEM_RICE_SEEDS;
    }
	
	@Override
    protected Item func_149865_P() {
        return Objects.ITEM_RICE_SEEDS;
    }
}