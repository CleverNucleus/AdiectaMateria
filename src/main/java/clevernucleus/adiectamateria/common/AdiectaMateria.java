package clevernucleus.adiectamateria.common;

import clevernucleus.adiectamateria.common.util.ConfigSetting;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig.Type;

@Mod(AdiectaMateria.MODID)
public class AdiectaMateria {
	public static final String MODID = "adiectamateria";
	
	public AdiectaMateria() {
		ModLoadingContext.get().registerConfig(Type.COMMON, ConfigSetting.COMMON_SPEC);
	}
}
