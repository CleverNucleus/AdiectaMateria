package clevernucleus.adiectamateria.common.world;

import java.util.Collection;

import clevernucleus.adiectamateria.common.AdiectaMateria;
import clevernucleus.adiectamateria.common.init.Registry;
import clevernucleus.adiectamateria.common.util.ConfigSetting;
import clevernucleus.adiectamateria.common.util.Dual;
import clevernucleus.adiectamateria.common.util.Util;
import net.minecraft.block.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.gen.GenerationStage.Decoration;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = AdiectaMateria.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class GenerationRegistry {
	private static final Collection<ResourceLocation> SALT_BIOMES = Util.set(var -> {
		var.add(new ResourceLocation("ocean"));
		var.add(new ResourceLocation("deep_cold_ocean"));
		var.add(new ResourceLocation("deep_frozen_ocean"));
		var.add(new ResourceLocation("deep_lukewarm_ocean"));
		var.add(new ResourceLocation("deep_ocean"));
		var.add(new ResourceLocation("deep_warm_ocean"));
		var.add(new ResourceLocation("desert"));
		var.add(new ResourceLocation("desert_hills"));
		var.add(new ResourceLocation("frozen_ocean"));
		var.add(new ResourceLocation("lukewarm_ocean"));
		var.add(new ResourceLocation("ocean"));
		var.add(new ResourceLocation("warm_ocean"));
	});
	
	private static final Dual<Decoration, ConfiguredFeature<?, ?>> SALT_GEN = Dual.get(() -> {
		OreFeatureConfig var0 = new OreFeatureConfig(OreFeatureConfig.FillerBlockType.field_241882_a, Registry.SALTPETER_ORE.getDefaultState(), 15);
		TopSolidRangeConfig var1 = new TopSolidRangeConfig(5, 0, 55);
		ConfiguredFeature<?, ?> var2 = Feature.ORE.withConfiguration(var0).withPlacement(Placement.field_242907_l.configure(var1)).func_242728_a().func_242731_b(15);
		
		return Dual.make(Decoration.UNDERGROUND_ORES, var2);
	});
	
	private static final Dual<Decoration, ConfiguredFeature<?, ?>> ENDSTONE_GEN = Dual.get(() -> {
		OreFeatureConfig var0 = new OreFeatureConfig(OreFeatureConfig.FillerBlockType.field_241882_a, Blocks.END_STONE.getDefaultState(), 10);
		TopSolidRangeConfig var1 = new TopSolidRangeConfig(1, 0, 25);
		ConfiguredFeature<?, ?> var2 = Feature.ORE.withConfiguration(var0).withPlacement(Placement.field_242907_l.configure(var1)).func_242728_a().func_242731_b(10);
		
		return Dual.make(Decoration.UNDERGROUND_ORES, var2);
	});
	
	@SubscribeEvent(priority = EventPriority.HIGH)
	public static void registerBiomeFeatures(final BiomeLoadingEvent par0) {
		if(ConfigSetting.CONFIG.genSaltpeter.get()) {
			if(SALT_BIOMES.contains(par0.getName())) {
				par0.getGeneration().getFeatures(SALT_GEN.a()).add(() -> SALT_GEN.b());
			}
		}
		
		if(ConfigSetting.CONFIG.genEndstone.get()) {
			par0.getGeneration().getFeatures(ENDSTONE_GEN.a()).add(() -> ENDSTONE_GEN.b());
		}
	}
}
