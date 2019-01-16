package clevernucleus.adiectamateria;

import java.util.ArrayList;
import java.util.List;

import clevernucleus.adiectamateria.objects.*;
import clevernucleus.adiectamateria.util.Util;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

/**
 * @name AdiectaMateria
 * @author CleverNucleus
 * @license Apache 2.0
 */
public class Objects {
	public static final CreativeTabAdiectaMateria TAB_ADIECTAMATERIA = new CreativeTabAdiectaMateria(CreativeTabs.getNextID(), Util.CREATIVE_TAB);
	
	public static final List<Item> ITEMS = new ArrayList<Item>();
	public static final List<Block> BLOCKS = new ArrayList<Block>();
	
	public static final Block BLOCK_SAND_LAMP = new BlockClass(Util.BLOCK_SAND_LAMP, Material.ROCK, 1.5F, 10.0F, 1.0F, SoundType.STONE);
	public static final Block BLOCK_PAPER_WALL = new BlockRiceWall(Util.BLOCK_PAPER_WALL, Material.GLASS, true);
	public static final Block BLOCK_RICE_CROP = new BlockRiceCrop(Util.BLOCK_RICE_CROP);
	public static final Block BLOCK_RICE = new BlockClass(Util.BLOCK_RICE, Material.WOOD, 1.0F, 5.0F, 0.0F, SoundType.WOOD);
	public static final Block BLOCK_CERAMIC = new BlockClass(Util.BLOCK_CERAMIC, Material.ROCK, 1.5F, 10.0F, 0.0F, SoundType.STONE);
	public static final Item ITEM_PULVIS_DUST  = new ItemClass(Util.ITEM_PULVIS_DUST, Util.TOOL_TIP_PULVIS_DUST);
	public static final Item ITEM_ALTERA_DUST  = new ItemClass(Util.ITEM_ALTERA_DUST, Util.TOOL_TIP_ALTERA_DUST);
	public static final Item ITEM_RICE_PAPER  = new ItemClass(Util.ITEM_RICE_PAPER, Util.TOOL_TIP_RICE_PAPER);
	public static final Item ITEM_RICE_SEEDS = new ItemRiceSeeds(Util.ITEM_RICE_SEEDS);
	public static final Item ITEM_RYE_RAW = new ItemEdible(Util.ITEM_RYE_RAW, Util.TOOL_TIP_RYE_RAW, 1, 0.3F, false);
	public static final Item ITEM_RYE_COOKED = new ItemEdible(Util.ITEM_RYE_COOKED, Util.TOOL_TIP_RYE_COOKED, 8, 2.0F, false).setAlwaysEdible();
	public static final Item ITEM_GOD_JUICE = new ItemEdible(Util.ITEM_GOD_JUICE, Util.TOOL_TIP_GOD_JUICE, 20, 2.0F, false).setAlwaysEdible();
	public static final Item ITEM_GREATER_APPLE = new ItemEdible(Util.ITEM_GREATER_APPLE, Util.TOOL_TIP_GREATER_APPLE, 20, 2.0F, false).setAlwaysEdible();
	public static final Item ITEM_INFINITE_WATER = new ItemInfiniteLiquidWater(Util.ITEM_INFINITE_WATER, Util.TOOL_TIP_ALCHIMIA_ARTIFICII);
	public static final Item ITEM_INFINITE_LAVA = new ItemInfiniteLiquidLava(Util.ITEM_INFINITE_LAVA, Util.TOOL_TIP_ALCHIMIA_ARTIFICII);
	public static final Item ITEM_ORB_ELEC = new ItemOrb(Util.ITEM_ORB_ELEC, Util.TOOL_TIP_DEUS_ARTIFICII);
	public static final Item ITEM_ORB_FIRE = new ItemOrb(Util.ITEM_ORB_FIRE, Util.TOOL_TIP_DEUS_ARTIFICII);
	public static final Item ITEM_ORB_DAY = new ItemOrb(Util.ITEM_ORB_DAY, Util.TOOL_TIP_TEMPUS_ARTIFICII);
	public static final Item ITEM_ORB_NIGHT = new ItemOrb(Util.ITEM_ORB_NIGHT, Util.TOOL_TIP_TEMPUS_ARTIFICII);
	public static final Item ITEM_ORB_RAIN = new ItemOrb(Util.ITEM_ORB_RAIN, Util.TOOL_TIP_TEMPUS_ARTIFICII);
	public static final Item ITEM_ORB_ENDER = new ItemOrb(Util.ITEM_ORB_ENDER, Util.TOOL_TIP_DEUS_ARTIFICII);
	public static final Item ITEM_TRINKET_SPEED = new ItemTrinket(Util.ITEM_TRINKET_SPEED, Util.TOOL_TIP_TRINKET_SPEED);
	public static final Item ITEM_TRINKET_HEAL = new ItemTrinket(Util.ITEM_TRINKET_HEAL, Util.TOOL_TIP_TRINKET_HEAL);
	public static final Item ITEM_TRINKET_WATER = new ItemTrinket(Util.ITEM_TRINKET_WATER, Util.TOOL_TIP_TRINKET_WATER);
	public static final Item ITEM_TRINKET_INVISIBILITY = new ItemTrinket(Util.ITEM_TRINKET_INVISIBILITY, Util.TOOL_TIP_TRINKET_INVISIBILITY);
	public static final Item ITEM_TRINKET_VISION = new ItemTrinket(Util.ITEM_TRINKET_VISION, Util.TOOL_TIP_TRINKET_VISION);
	public static final Item ITEM_TRINKET_SATURATION = new ItemTrinket(Util.ITEM_TRINKET_SATURATION, Util.TOOL_TIP_TRINKET_SATURATION);
	public static final Item ITEM_BOOK = new ItemBook(Util.ITEM_BOOK, Util.TOOL_TIP_BOOK);
}
