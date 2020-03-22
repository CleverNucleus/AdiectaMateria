package clevernucleus.adiectamateria.common.block;

import java.util.Random;

import clevernucleus.adiectamateria.common.AdiectaMateria;
import clevernucleus.adiectamateria.common.item.ItemInit;
import clevernucleus.adiectamateria.common.util.IItemModel;
import clevernucleus.adiectamateria.common.util.Util;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

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
	public void randomTick(World par0, BlockPos par1, IBlockState par2, Random par3) {
		if(!par0.isAreaLoaded(par1, 1)) return;
		if(par0.isDaytime() && par3.nextInt(5) == 0) {
			par0.setBlockState(par1, BlockInit.MUD_BRICK_DRY.getDefaultState());
		}
	}
	
	@Override
	public void registerModels() {
		AdiectaMateria.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
	}
}
