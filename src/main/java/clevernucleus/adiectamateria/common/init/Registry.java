package clevernucleus.adiectamateria.common.init;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nonnull;

import clevernucleus.adiectamateria.common.AdiectaMateria;
import clevernucleus.adiectamateria.common.init.grafter.GrafterItem;
import clevernucleus.adiectamateria.common.init.mudbrick.MudbrickBlock;
import clevernucleus.adiectamateria.common.init.ricecrop.RiceCropBlock;
import clevernucleus.adiectamateria.common.init.ryobasaw.RyobaSawItem;
import clevernucleus.adiectamateria.common.init.shoji.ShojiBlock;
import clevernucleus.adiectamateria.common.util.Group;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ComposterBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Food;
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
	public static final Block SANDLAMP = register("sandlamp", new Block(Block.Properties.create(Material.ROCK, MaterialColor.SAND).hardnessAndResistance(2.0F, 6.0F).sound(SoundType.STONE).lightValue(15)));
	public static final Block SANDLAMP_BRICK = register("sandlamp_brick", new Block(Block.Properties.from(SANDLAMP)));
	public static final Block SHOJI_PANEL = register("shoji_panel", new ShojiBlock(Block.Properties.create(Material.WOOL).hardnessAndResistance(0.3F).sound(SoundType.CLOTH).notSolid().lightValue(13)));
	public static final Block FINE_SHOJI_PANEL = register("fine_shoji_panel", new ShojiBlock(Block.Properties.from(SHOJI_PANEL)));
	public static final Block WOVEN_TILE = register("woven_tile", new Block(Block.Properties.from(Blocks.OAK_PLANKS)));
	
	public static final Item ARROW_FLETCHING = register("arrow_fletching", new Item(new Item.Properties().group(Group.INSTANCE)));
	public static final Item ARROW_HEAD = register("arrow_head", new Item(new Item.Properties().group(Group.INSTANCE)));
	public static final Item PAPERY_SHEET = register("papery_sheet", new Item(new Item.Properties().group(Group.INSTANCE)));
	public static final Item COOKED_RICE = register("cooked_rice", new Item(new Item.Properties().food(new Food.Builder().hunger(1).saturation(0.1F).fastToEat().build()).group(Group.INSTANCE)));
	public static final Item ONIGIRI = register("onigiri", new Item(new Item.Properties().food(new Food.Builder().hunger(9).saturation(1.0F).build()).group(Group.INSTANCE)));
	public static final Item SUSHI = register("sushi", new Item(new Item.Properties().food(new Food.Builder().hunger(6).saturation(1.0F).fastToEat().build()).group(Group.INSTANCE)));
	public static final Item RYOBA_SAW = register("ryoba_saw", new RyobaSawItem(new Item.Properties().group(Group.INSTANCE)));
	public static final Item GRAFTER = register("grafter", new GrafterItem(new Item.Properties().group(Group.INSTANCE)));
	
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
		
		ComposterBlock.CHANCES.put(RICE.asItem(), 0.3F);
	}
	
	@SubscribeEvent
	public static void registerBlocks(final RegistryEvent.Register<Block> par0) {
		for(Block var : blocks) {
			par0.getRegistry().register(var);
		}
	}
}
