package clevernucleus.adiectamateria.common.world;

import java.util.Collection;

import clevernucleus.adiectamateria.common.AdiectaMateria;
import clevernucleus.adiectamateria.common.init.Registry;
import clevernucleus.adiectamateria.common.util.ConfigSetting;
import clevernucleus.adiectamateria.common.util.Dual;
import clevernucleus.adiectamateria.common.util.Util;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = AdiectaMateria.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class GenerationRegistry {
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
	
	private static final Dual<Decoration, ConfiguredFeature<?, ?>> SALT_GEN = Dual.get(() -> {
		ConfiguredPlacement<CountRangeConfig> var0 = Placement.COUNT_RANGE.configure(new CountRangeConfig(17, 5, 5, 60));
		OreFeatureConfig var1 = new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Registry.SALTPETER_ORE.getDefaultState(), 10);
		
		return Dual.make(Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(var1).withPlacement(var0));
	});
	
	private static final Dual<Decoration, ConfiguredFeature<?, ?>> ENDSTONE_GEN = Dual.get(() -> {
		ConfiguredPlacement<CountRangeConfig> var0 = Placement.COUNT_RANGE.configure(new CountRangeConfig(17, 5, 5, 60));
		OreFeatureConfig var1 = new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, Blocks.END_STONE.getDefaultState(), 10);
		
		return Dual.make(Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(var1).withPlacement(var0));
	});
	
	@SubscribeEvent
	public static void registerAfterLoad(final FMLLoadCompleteEvent par0) {
		if(ConfigSetting.CONFIG.genSaltpeter.get()) {
			for(Biome var : ForgeRegistries.BIOMES) {
				if(SALT_BIOMES.contains(var)) {
					var.addFeature(SALT_GEN.a(), SALT_GEN.b());
				}
			}
		}
		
		if(ConfigSetting.CONFIG.genEndstone.get()) {
			for(Biome var : ForgeRegistries.BIOMES) {
				var.addFeature(ENDSTONE_GEN.a(), ENDSTONE_GEN.b());
			}
		}
	}
}
