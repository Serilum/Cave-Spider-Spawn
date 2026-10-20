package com.serilum.cavespiderspawn.config;

import com.natamus.collective.config.DuskConfig;
import com.serilum.cavespiderspawn.util.Reference;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ConfigHandler extends DuskConfig {
	public static HashMap<String, List<String>> configMetaData = new HashMap<String, List<String>>();

	@Entry(min = 0, max = 1.0) public static double chanceSpiderIsCaveSpider = 0.15;
	@Entry public static boolean onlySpawnCaveSpidersBelowSurface = true;
	@Entry public static boolean onlySpawnCaveSpidersBelowSpecificY = false;
	@Entry(min = -1000, max = 1000) public static int belowSpecificY = 0;
	@Entry(registry = "dimension") public static String dimensionsToSpawnIn = "";
	@Entry(registry = "worldgen/biome") public static String biomesToSpawnIn = "";

	public static void initConfig() {
		configMetaData.put("chanceSpiderIsCaveSpider", Arrays.asList(
			"The chance a spider that has spawned is a cave spider."
		));
		configMetaData.put("onlySpawnCaveSpidersBelowSurface", Arrays.asList(
			"When enabled, cave spiders will only spawn below the surface."
		));
		configMetaData.put("onlySpawnCaveSpidersBelowSpecificY", Arrays.asList(
			"When enabled, cave spiders will only spawn below the specific y value set in 'belowSpecificY'."
		));
		configMetaData.put("belowSpecificY", Arrays.asList(
			"The specific y value used in 'onlySpawnCaveSpidersBelowSpecificY'."
		));
		configMetaData.put("dimensionsToSpawnIn", Arrays.asList(
			"Dimensions in which spiders can turn into cave spiders, separated by a comma. Leave empty for every dimension. For example: 'minecraft:overworld,minecraft:the_nether'."
		));
		configMetaData.put("biomesToSpawnIn", Arrays.asList(
			"Biomes in which spiders can turn into cave spiders, separated by a comma. Biome tags work too, starting with a '#'. Leave empty for every biome. For example: 'minecraft:dripstone_caves,minecraft:lush_caves'."
		));

		DuskConfig.init(Reference.NAME, Reference.MOD_ID, ConfigHandler.class);
	}
}