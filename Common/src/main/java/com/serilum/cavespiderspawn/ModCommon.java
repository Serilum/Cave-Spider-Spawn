package com.serilum.cavespiderspawn;

import com.serilum.cavespiderspawn.config.ConfigHandler;
import com.serilum.cavespiderspawn.util.Reference;
import com.natamus.collective.globalcallbacks.ConfigCallback;
import com.natamus.collective.objects.SAMObject;
import net.minecraft.world.entity.EntityType;

public class ModCommon {
	private static SAMObject samObject;

	public static void init() {
		ConfigHandler.initConfig();
		load();
	}

	private static void load() {
		samObject = new SAMObject(EntityType.SPIDER, EntityType.CAVE_SPIDER, null, ConfigHandler.chanceSpiderIsCaveSpider, false, false, false, ConfigHandler.onlySpawnCaveSpidersBelowSurface, ConfigHandler.onlySpawnCaveSpidersBelowSpecificY, ConfigHandler.belowSpecificY);
		samObject.dimensionIds = ConfigHandler.dimensionsToSpawnIn;
		samObject.biomeIds = ConfigHandler.biomesToSpawnIn;

		ConfigCallback.CONFIG_CHANGED.register((String modid) -> {
			if (!modid.equals(Reference.MOD_ID)) {
				return;
			}

			samObject.changeChance = ConfigHandler.chanceSpiderIsCaveSpider;
			samObject.onlyBelowSurface = ConfigHandler.onlySpawnCaveSpidersBelowSurface;
			samObject.onlyBelowSpecificY = ConfigHandler.onlySpawnCaveSpidersBelowSpecificY;
			samObject.specificY = ConfigHandler.belowSpecificY;
			samObject.dimensionIds = ConfigHandler.dimensionsToSpawnIn;
			samObject.biomeIds = ConfigHandler.biomesToSpawnIn;
		});
	}
}