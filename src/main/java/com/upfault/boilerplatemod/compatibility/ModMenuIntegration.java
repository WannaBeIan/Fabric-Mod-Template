package com.upfault.boilerplatemod.compatibility;

import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import com.upfault.boilerplatemod.config.ConfigManager;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class ModMenuIntegration implements ModMenuApi {
	@Override
	public ConfigScreenFactory<?> getModConfigScreenFactory() {
		return parent -> ConfigManager.getConfigScreen(parent).build();
	}
}