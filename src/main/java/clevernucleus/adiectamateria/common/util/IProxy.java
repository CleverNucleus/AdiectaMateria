package clevernucleus.adiectamateria.common.util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public interface IProxy {
	void registerItemRenderer(Item par0, int par1, String par2);
	void displayBook(EntityPlayer par0, boolean par1);
	void spawnParticle(World par0, BlockPos par1, EnumParticleTypes par2, int par3, boolean par4);
	
	EntityPlayer getPlayer();
}
