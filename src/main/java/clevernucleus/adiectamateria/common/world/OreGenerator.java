package clevernucleus.adiectamateria.common.world;

import java.util.Collection;

import clevernucleus.adiectamateria.common.init.Registry;
import clevernucleus.adiectamateria.common.util.Util;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class OreGenerator {
	private static final Collection<Biome> SALT_BIOMES = Util.set(var -> {
		var.add(Biomes.COLD_OCEAN);
		var.add(Biomes.DEEP_COLD_OCEAN);
		var.add(Biomes.DEEP_FROZEN_OCEAN);
		var.add(Biomes.DEEP_LUKEWARM_OCEAN);
		var.add(Biomes.DEEP_OCEAN);
		var.add(Biomes.DEEP_WARM_OCEAN);
		var.add(Biomes.DESERT);
		var.add(Biomes.DESERT_HILLS);
		var.add(Biomes.FROZEN_OCEAN);
		var.add(Biomes.LUKEWARM_OCEAN);
		var.add(Biomes.OCEAN);
		var.add(Biomes.WARM_OCEAN);
	});
	
	public static void generate() {
		for (Biome var : ForgeRegistries.BIOMES) {
			if (SALT_BIOMES.contains(var)) {
				ConfiguredPlacement<CountRangeConfig> var0 = Placement.COUNT_RANGE.configure(new CountRangeConfig(17, 5, 5, 60));
				
				var.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Registry.SALT_ORE.getDefaultState(), 10)).withPlacement(var0));
			}
		}
	}
}
