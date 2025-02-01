package com.upfault.boilerplatemod.config.categories;

import com.upfault.boilerplatemod.config.configs.ModConfig;
import me.shedaniel.clothconfig2.api.ConfigBuilder;
import me.shedaniel.clothconfig2.api.ConfigCategory;
import me.shedaniel.clothconfig2.api.ConfigEntryBuilder;
import net.minecraft.text.Text;

public class GeneralCategory {
	public static void build(ConfigBuilder builder, ModConfig config) {
		ConfigEntryBuilder entryBuilder = builder.entryBuilder();
		ConfigCategory general = builder.getOrCreateCategory(Text.translatable("category.boilerplatemod.general"));

		general.addEntry(
				entryBuilder.startBooleanToggle(Text.translatable("option.boilerplatemod.exampleOption"), config.exampleOption)
						.setDefaultValue(true)
						.setTooltip(Text.translatable("tooltip.boilerplatemod.exampleOption"))
						.setSaveConsumer(newValue -> config.exampleOption = newValue)
						.build()
		);

		general.addEntry(
				entryBuilder.startIntField(Text.translatable("option.boilerplatemod.exampleInt"), config.exampleInt)
						.setDefaultValue(42)
						.setTooltip(Text.translatable("tooltip.boilerplatemod.exampleInt"))
						.setSaveConsumer(newValue -> config.exampleInt = newValue)
						.build()
		);

		general.addEntry(
				entryBuilder.startStrField(Text.translatable("option.boilerplatemod.exampleString"), config.exampleString)
						.setDefaultValue("Hello, ClothConfig!")
						.setTooltip(Text.translatable("tooltip.boilerplatemod.exampleString"))
						.setSaveConsumer(newValue -> config.exampleString = newValue)
						.build()
		);
	}
}
