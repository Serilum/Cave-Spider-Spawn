package com.natamus.cavespiderspawn;

import com.natamus.cavespiderspawn.config.ConfigHandler;
import com.natamus.collective.objects.SAMObject;
import net.minecraft.world.entity.EntityType;

public class ModCommon {

	public static void init() {
		ConfigHandler.initConfig();
		load();
	}

	private static void load() {
		new SAMObject(EntityType.SPIDER, EntityType.CAVE_SPIDER, null, ConfigHandler.chanceSpiderIsCaveSpider, false, false, false, ConfigHandler.onlySpawnCaveSpidersBelowSurface, ConfigHandler.onlySpawnCaveSpidersBelowSpecificY, ConfigHandler.belowSpecificY);
	}
}