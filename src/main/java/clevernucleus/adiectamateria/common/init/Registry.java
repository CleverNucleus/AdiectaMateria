package clevernucleus.adiectamateria.common.init;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nonnull;

import clevernucleus.adiectamateria.common.AdiectaMateria;
import clevernucleus.adiectamateria.common.init.MudBrick.MudbrickBlock;
import clevernucleus.adiectamateria.common.init.RiceCrop.RiceCropBlock;
import clevernucleus.adiectamateria.common.util.Group;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = AdiectaMateria.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Registry {
	private static List<Item> items = new ArrayList<Item>();
	private static List<Block> blocks = new ArrayList<Block>();
	
	public static final Block DRY_MUDBRICK = register("dry_mudbrick", new Block(Block.Properties.from(Blocks.COBBLESTONE)));
	public static final Block WET_MUDBRICK = register("wet_mudbrick", new MudbrickBlock(Block.Properties.from(Blocks.DIRT).tickRandomly()));
	public static final Block PADDY = register("paddy", new Block(Block.Properties.from(Blocks.DIRT)));
	public static final Block RICE = register("rice", new RiceCropBlock(Block.Properties.from(Blocks.WHEAT)));
	
	private static Item register(final @Nonnull String par0, @Nonnull Item par1) {
		par1.setRegistryName(new ResourceLocation(AdiectaMateria.MODID, par0));
		
		items.add(par1);
		
		return par1;
	}
	
	private static Block register(final @Nonnull String par0, @Nonnull Block par1) {
		par1.setRegistryName(new ResourceLocation(AdiectaMateria.MODID, par0));
		
		blocks.add(par1);
		
		register(par0, new BlockItem(par1, new Item.Properties().group(Group.INSTANCE)));
		
		return par1;
	}
	
	@SubscribeEvent
	public static void registerItems(final RegistryEvent.Register<Item> par0) {
		for(Item var : items) {
			par0.getRegistry().register(var);
		}
	}
	
	@SubscribeEvent
	public static void registerBlocks(final RegistryEvent.Register<Block> par0) {
		for(Block var : blocks) {
			par0.getRegistry().register(var);
		}
	}
}
