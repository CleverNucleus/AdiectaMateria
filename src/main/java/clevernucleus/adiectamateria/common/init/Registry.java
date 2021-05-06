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
import clevernucleus.adiectamateria.common.init.spindle.SpindleItem;
import clevernucleus.adiectamateria.common.util.Dual;
import clevernucleus.adiectamateria.common.util.Group;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ComposterBlock;
import net.minecraft.block.OreBlock;
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
	
	public static final Block SALTPETER_ORE = register("saltpeter_ore", new OreBlock(Block.Properties.copy(Blocks.IRON_ORE)));
	public static final Block DRY_MUDBRICK = register("dry_mudbrick", new Block(Block.Properties.copy(Blocks.COBBLESTONE)));
	public static final Block WET_MUDBRICK = register("wet_mudbrick", new MudbrickBlock(Block.Properties.copy(Blocks.DIRT).randomTicks()));
	public static final Block PADDY = register("paddy", new Block(Block.Properties.copy(Blocks.DIRT)));
	public static final Block SANDLAMP = register("sandlamp", new Block(Block.Properties.of(Material.STONE, MaterialColor.SAND).strength(2.0F, 6.0F).sound(SoundType.STONE).lightLevel(var -> 15)));
	public static final Block SANDLAMP_BRICK = register("sandlamp_brick", new Block(Block.Properties.copy(SANDLAMP)));
	public static final Block WOVEN_TILE = register("woven_tile", new Block(Block.Properties.copy(Blocks.OAK_PLANKS)));
	public static final Block SHOJI_PANEL = register("shoji_panel", new ShojiBlock(Block.Properties.of(Material.WOOL).strength(0.3F).sound(SoundType.WOOL).noOcclusion().lightLevel(var -> 15)));
	public static final Block FINE_SHOJI_PANEL = register("fine_shoji_panel", new ShojiBlock(Block.Properties.copy(SHOJI_PANEL)));
	public static final Block RICE = register("rice", new RiceCropBlock(Block.Properties.copy(Blocks.WHEAT)));
	
	public static final Item SOUL = register("soul", new Item(new Item.Properties().tab(Group.INSTANCE)));
	public static final Item SALTPETER = register("saltpeter", new Item(new Item.Properties().tab(Group.INSTANCE)));
	public static final Item PAPERY_SHEET = register("papery_sheet", new Item(new Item.Properties().tab(Group.INSTANCE)));
	public static final Item ONIGIRI = register("onigiri", new Item(new Item.Properties().food(new Food.Builder().nutrition(9).saturationMod(1.0F).build()).tab(Group.INSTANCE)));
	public static final Item COOKED_RICE = register("cooked_rice", new Item(new Item.Properties().food(new Food.Builder().nutrition(1).saturationMod(0.1F).fast().build()).tab(Group.INSTANCE)));
	public static final Item SUSHI = register("sushi", new Item(new Item.Properties().food(new Food.Builder().nutrition(6).saturationMod(1.0F).fast().build()).tab(Group.INSTANCE)));
	public static final Item ARROW_HEAD = register("arrow_head", new Item(new Item.Properties().tab(Group.INSTANCE)));
	public static final Item ARROW_FLETCHING = register("arrow_fletching", new Item(new Item.Properties().tab(Group.INSTANCE)));
	public static final Item PLANT_FIBRE = register("plant_fibre", new Item(new Item.Properties().tab(Group.INSTANCE)));
	public static final Item SPINDLE = register("spindle", new SpindleItem(new Item.Properties().tab(Group.INSTANCE)));
	public static final Item GRAFTER = register("grafter", new GrafterItem(new Item.Properties().tab(Group.INSTANCE)));
	public static final Item RYOBA_SAW = register("ryoba_saw", new RyobaSawItem(new Item.Properties().tab(Group.INSTANCE)));
	
	private static Item register(final @Nonnull String par0, @Nonnull Item par1) {
		par1.setRegistryName(new ResourceLocation(AdiectaMateria.MODID, par0));
		
		items.add(par1);
		
		return par1;
	}
	
	private static Block register(final @Nonnull String par0, @Nonnull Block par1) {
		par1.setRegistryName(new ResourceLocation(AdiectaMateria.MODID, par0));
		
		blocks.add(par1);
		
		register(par0, new BlockItem(par1, new Item.Properties().tab(Group.INSTANCE)));
		
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
	
	@SubscribeEvent
	public static void commonSetup(final net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent par0) {
		par0.enqueueWork(() -> {
			GrafterItem.USE_ON.put(Blocks.GRASS, Dual.make(RICE, 0.3F));
			GrafterItem.USE_ON.put(Blocks.GRASS, Dual.make(PLANT_FIBRE, 0.3F));
			GrafterItem.USE_ON.put(Blocks.TALL_GRASS, Dual.make(RICE, 0.3F));
			GrafterItem.USE_ON.put(Blocks.TALL_GRASS, Dual.make(PLANT_FIBRE, 0.3F));
			GrafterItem.USE_ON.put(Blocks.FERN, Dual.make(PLANT_FIBRE, 0.3F));
			GrafterItem.USE_ON.put(Blocks.LARGE_FERN, Dual.make(PLANT_FIBRE, 0.3F));
			GrafterItem.USE_ON.put(Blocks.JUNGLE_LEAVES, Dual.make(PLANT_FIBRE, 0.6F));
			GrafterItem.USE_ON.put(Blocks.OAK_LEAVES, Dual.make(PLANT_FIBRE, 0.6F));
			GrafterItem.USE_ON.put(Blocks.SPRUCE_LEAVES, Dual.make(PLANT_FIBRE, 0.6F));
			GrafterItem.USE_ON.put(Blocks.DARK_OAK_LEAVES, Dual.make(PLANT_FIBRE, 0.6F));
			GrafterItem.USE_ON.put(Blocks.ACACIA_LEAVES, Dual.make(PLANT_FIBRE, 0.6F));
			GrafterItem.USE_ON.put(Blocks.BIRCH_LEAVES, Dual.make(PLANT_FIBRE, 0.6F));
			GrafterItem.USE_ON.put(Blocks.VINE, Dual.make(PLANT_FIBRE, 0.9F));
			ComposterBlock.COMPOSTABLES.put(RICE, 0.3F);
			ComposterBlock.COMPOSTABLES.put(ONIGIRI, 0.85F);
			ComposterBlock.COMPOSTABLES.put(COOKED_RICE, 0.3F);
			ComposterBlock.COMPOSTABLES.put(SUSHI, 0.65F);
			ComposterBlock.COMPOSTABLES.put(PLANT_FIBRE, 0.3F);
		});
	}
}
