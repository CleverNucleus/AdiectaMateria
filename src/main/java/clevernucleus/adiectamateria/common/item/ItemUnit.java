package clevernucleus.adiectamateria.common.item;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.Item;

public class ItemUnit {
	
	/**
	 * The item array list holding all items added by this mod.
	 */
	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	public static final Item MELTY_FLINT = new ItemMeltyFlint("melty_flint");
	public static final Item RICE_PAPER = new ItemRicePaper("rice_paper");
	public static final Item RICE_COOKED = new ItemEdible("rice_cooked", 1, 0.3F);
	public static final Item RICE = new ItemRice("rice_seed");
	public static final Item BOOK = new ItemLexicaMateria("book");
	public static final Item RICE_GRAFTER = new ItemRiceGrafter("rice_grafter");
	public static final Item ONIGIRI = new ItemEdible("onigiri", 8, 2.0F).addDescription();
	public static final Item INFINITE_LAVA = new ItemInfiniteLiquidLava("infinite_lava");
	public static final Item INFINITE_WATER = new ItemInfiniteLiquidWater("infinite_water");
}
