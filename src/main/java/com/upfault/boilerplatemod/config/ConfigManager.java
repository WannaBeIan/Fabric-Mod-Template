package com.upfault.boilerplatemod.config;

import com.upfault.boilerplatemod.config.categories.AdvancedCategory;
import com.upfault.boilerplatemod.config.categories.GeneralCategory;
import com.upfault.boilerplatemod.config.configs.ModConfig;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.clothconfig2.api.ConfigBuilder;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;

public class ConfigManager {
	public static ConfigBuilder getConfigScreen(Screen parent) {
		ModConfig config = AutoConfig.getConfigHolder(ModConfig.class).getConfig();
		ConfigBuilder builder = ConfigBuilder.create()
				.setParentScreen(parent)
				.setTransparentBackground(true)
				.setShouldTabsSmoothScroll(true)
				.setShouldListSmoothScroll(true)
				.setTitle(Text.translatable("title.boilerplatemod.config"));

		GeneralCategory.build(builder, config);
		AdvancedCategory.build(builder, config);

		return builder;
	}
}
