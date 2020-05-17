package clevernucleus.adiectamateria.common.util;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class Group extends ItemGroup {
	public static final Group INSTANCE = new Group(ItemGroup.GROUPS.length, "adiectamateriatab");
	
	private Group(int par0, String par1) {
		super(par0, par1);
	}
	
	@Override
	public ItemStack createIcon() {
		return new ItemStack(Items.SUGAR);
	}
}