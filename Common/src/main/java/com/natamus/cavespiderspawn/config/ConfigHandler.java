package com.natamus.cavespiderspawn.config;

import com.natamus.collective.config.DuskConfig;
import com.natamus.cavespiderspawn.util.Reference;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ConfigHandler extends DuskConfig {
	public static HashMap<String, List<String>> configMetaData = new HashMap<String, List<String>>();

	@Entry(min = 0, max = 1.0) public static double chanceSpiderIsCaveSpider = 0.15;
	@Entry public static boolean onlySpawnCaveSpidersBelowSurface = true;

	public static void initConfig() {
		configMetaData.put("chanceSpiderIsCaveSpider", Arrays.asList(
			"The chance a spider that has spawned is a cave spider."
		));
		configMetaData.put("onlySpawnCaveSpidersBelowSurface", Arrays.asList(
			"When enabled, cave spiders will only spawn below the surface."
		));

		DuskConfig.init(Reference.NAME, Reference.MOD_ID, ConfigHandler.class);
	}
}