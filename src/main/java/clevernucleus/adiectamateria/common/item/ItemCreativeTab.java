package clevernucleus.adiectamateria.common.item;

import clevernucleus.adiectamateria.common.util.interfaces.IConstants;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemCreativeTab implements IConstants {
	public static final CreativeTabs MODTAB = new CreativeTabs(CreativeTabs.getNextID(), MODID) {
		
        @SideOnly(Side.CLIENT)
        public ItemStack getTabIconItem() {
            return new ItemStack(ItemInit.MELTY_FLINT);
        }
    };
}
