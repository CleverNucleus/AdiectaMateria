package clevernucleus.adiectamateria.common.util;

import org.apache.commons.lang3.tuple.Pair;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.BooleanValue;

/**
 * Holder for mod configuration access settings.
 */
public class ConfigSetting {
	
	/** Initialised instance of the forge common config specifications. */
	public static final ForgeConfigSpec COMMON_SPEC;
	
	/** Initialised instance of our common config. */
	public static final ConfigSetting CONFIG;
	
	static {
		final Pair<ConfigSetting, ForgeConfigSpec> common = new ForgeConfigSpec.Builder().configure(ConfigSetting::new);
		
		COMMON_SPEC = common.getRight();
		CONFIG = common.getLeft();
	}
	
	public final BooleanValue genSaltpeter, genEndstone;
	
	public ConfigSetting(ForgeConfigSpec.Builder par0) {
		par0.comment("Set to false to disable the generation of these blocks in the world.").push("worldgen");
		
		this.genSaltpeter = par0.comment("Note: If set to false, there is no other method of obtaining Saltpeter.").translation("config.saltpeter").worldRestart().define("genSaltpeter", true);
		this.genEndstone = par0.worldRestart().define("genEndstone", true);
		
		par0.pop();
	}
}
