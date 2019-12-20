package clevernucleus.adiectamateria.common.block;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockInit {
	
	/**
	 * The block array list holding all blocks added by this mod.
	 */
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	public static final Block RICE_CROP = new BlockRiceCrop("rice");
	public static final Block FLAX_CROP = new BlockFlax("flax").setHardness(0.0F);
	public static final Block PAPER_WALL = new BlockPaperWall("paperwall");
	public static final Block RICE_BLOCK = new BlockVanilla("rice_block", Material.ROCK, SoundType.WOOD).setHardness(2.0F).setResistance(10.0F);
	public static final Block SAND_LAMP = new BlockSandLamp("sandlamp").setHardness(1.5F).setResistance(10.0F).setLightLevel(1.0F);
	public static final Block SAND_LAMP_BRICK = new BlockSandLamp("sandlamp_brick").setHardness(1.5F).setResistance(10.0F).setLightLevel(1.0F);
	public static final Block MUD_BRICK = new BlockVanilla("mud_brick", Material.ROCK, SoundType.GROUND).setHardness(2.0F).setResistance(10.0F);
}
