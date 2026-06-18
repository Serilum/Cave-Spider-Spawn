package com.natamus.cavespiderspawn;

import com.natamus.cavespiderspawn.config.ConfigHandler;
import com.natamus.collective.objects.SAMObject;
import net.minecraft.world.entity.EntityTypes;

public class ModCommon {

	public static void init() {
		ConfigHandler.initConfig();
		load();
	}

	private static void load() {
		new SAMObject(EntityTypes.SPIDER, EntityTypes.CAVE_SPIDER, null, ConfigHandler.chanceSpiderIsCaveSpider, false, false, false, ConfigHandler.onlySpawnCaveSpidersBelowSurface, ConfigHandler.onlySpawnCaveSpidersBelowSpecificY, ConfigHandler.belowSpecificY);
	}
}