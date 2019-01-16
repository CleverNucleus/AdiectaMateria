package clevernucleus.adiectamateria.util;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

/**
 * @name AdiectaMateria
 * @author CleverNucleus
 * @license Apache 2.0
 */
public class NoiseHandler {
	public static SoundEvent SOUND_TRANSFORM;
	public static SoundEvent SOUND_DAYTIME;
	public static SoundEvent SOUND_NIGHTTIME;
	public static SoundEvent SOUND_STRIKE;
	public static SoundEvent SOUND_WOOSH;
	public static SoundEvent SOUND_UP;
	
	public static void registerSounds() {
		SOUND_TRANSFORM = registerSound("transform");
		SOUND_DAYTIME = registerSound("daytime");
		SOUND_NIGHTTIME = registerSound("nighttime");
		SOUND_STRIKE = registerSound("strike");
		SOUND_WOOSH = registerSound("woosh");
		SOUND_UP = registerSound("up");
	}
	
	public static SoundEvent registerSound(String par0) {
		ResourceLocation var0 = new ResourceLocation(Util.MODID, par0);
		SoundEvent var1 = new SoundEvent(var0);
		var1.setRegistryName(var0);
		ForgeRegistries.SOUND_EVENTS.register(var1);
		
		return var1;
	}
}
