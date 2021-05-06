package clevernucleus.adiectamateria.common.util;

import clevernucleus.adiectamateria.common.init.Registry;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class Group extends ItemGroup {
	public static final Group INSTANCE = new Group(ItemGroup.TABS.length, "adiectamateriatab");
	
	private Group(int par0, String par1) {
		super(par0, par1);
	}
	
	@Override
	public ItemStack makeIcon() {
		return new ItemStack(Registry.SALTPETER);
	}
}