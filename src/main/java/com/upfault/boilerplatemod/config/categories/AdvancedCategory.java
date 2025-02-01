package com.upfault.boilerplatemod.config.categories;

import com.upfault.boilerplatemod.config.configs.ModConfig;
import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.minecraft.text.Text;

public class AdvancedCategory {
	public static void build(ConfigBuilder builder, ModConfig config) {
		ConfigEntryBuilder entryBuilder = builder.entryBuilder();
		ConfigCategory advanced = builder.getOrCreateCategory(Text.translatable("category.boilerplatemod.advanced"));

		advanced.addEntry(
				entryBuilder.startDoubleField(Text.translatable("option.boilerplatemod.advanced.exampleDouble"), config.advancedSettings.exampleDouble)
						.setDefaultValue(3.14)
						.setTooltip(Text.translatable("tooltip.boilerplatemod.advanced.exampleDouble"))
						.setSaveConsumer(newValue -> config.advancedSettings.exampleDouble = newValue)
						.build()
		);

		advanced.addEntry(
				entryBuilder.startEnumSelector(
												Text.translatable("option.boilerplatemod.advanced.exampleEnum"),
								ModConfig.OptionEnum.class,
								config.advancedSettings.exampleEnum)
						.setDefaultValue(ModConfig.OptionEnum.OPTION_ONE)
						.setTooltip(Text.translatable("tooltip.boilerplatemod.advanced.exampleEnum"))
						.setSaveConsumer(newValue -> config.advancedSettings.exampleEnum = newValue)
						.build()
		);
	}
}
