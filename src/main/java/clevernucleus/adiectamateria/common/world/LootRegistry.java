package clevernucleus.adiectamateria.common.world;

import clevernucleus.adiectamateria.common.AdiectaMateria;
import clevernucleus.adiectamateria.common.init.Registry;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = AdiectaMateria.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class LootRegistry {
	
	@SubscribeEvent
	public static void addDrops(final LivingDropsEvent par0) {
		LivingEntity var0 = par0.getEntityLiving();
		World var1 = var0.world;
		
		if(var1.isRemote) return;
		if(var0 instanceof PlayerEntity) {
			ItemEntity var2 = new ItemEntity(var1, var0.getPosX(), var0.getPosY(), var0.getPosZ(), new ItemStack(Registry.SOUL));
			
			par0.getDrops().add(var2);
		}
	}
}
