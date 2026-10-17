package com.serilum.cavespiderspawn;

import com.serilum.cavespiderspawn.config.ConfigHandler;
import com.serilum.cavespiderspawn.util.Reference;
import com.natamus.collective.globalcallbacks.ConfigCallback;
import com.natamus.collective.objects.SAMObject;
import net.minecraft.world.entity.EntityTypes;

public class ModCommon {
	private static SAMObject samObject;

	public static void init() {
		ConfigHandler.initConfig();
		load();
	}

	private static void load() {
		samObject = new SAMObject(EntityTypes.SPIDER, EntityTypes.CAVE_SPIDER, null, ConfigHandler.chanceSpiderIsCaveSpider, false, false, false, ConfigHandler.onlySpawnCaveSpidersBelowSurface, ConfigHandler.onlySpawnCaveSpidersBelowSpecificY, ConfigHandler.belowSpecificY);

		ConfigCallback.CONFIG_CHANGED.register((String modid) -> {
			if (!modid.equals(Reference.MOD_ID)) {
				return;
			}

			samObject.changeChance = ConfigHandler.chanceSpiderIsCaveSpider;
			samObject.onlyBelowSurface = ConfigHandler.onlySpawnCaveSpidersBelowSurface;
			samObject.onlyBelowSpecificY = ConfigHandler.onlySpawnCaveSpidersBelowSpecificY;
			samObject.specificY = ConfigHandler.belowSpecificY;
		});
	}
}