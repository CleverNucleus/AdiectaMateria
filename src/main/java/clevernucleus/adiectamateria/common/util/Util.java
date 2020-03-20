package clevernucleus.adiectamateria.common.util;

import clevernucleus.adiectamateria.common.item.ItemInit;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Util {
	public static final String MODID = "adiectamateria";
	public static final String NAME = "Adiecta Materia";
	public static final String VERSION = "2.2.5";
	public static final String PROXY_SERVER = "clevernucleus.adiectamateria.server.ServerProxy";
	public static final String PROXY_CLIENT = "clevernucleus.adiectamateria.client.ClientProxy";
	
	public static final String MODID_AE2 = "appliedenergistics2";
	public static final String MODID_TC = "tconstruct";
	public static final String MODID_TF = "thermalfoundation";
	
	public static final CreativeTabs MODTAB = new CreativeTabs(CreativeTabs.getNextID(), MODID) {
		
		@SideOnly(Side.CLIENT)
		public ItemStack getTabIconItem() {
			return new ItemStack(ItemInit.MELTY_FLINT);
		}
	};
}
