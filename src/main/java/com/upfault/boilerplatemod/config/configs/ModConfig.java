package com.upfault.boilerplatemod.config.configs;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;

@Config(name = "boilerplatemod")
public class ModConfig implements ConfigData {
	// General category options
	public boolean exampleOption = true;
	public int exampleInt = 42;
	public String exampleString = "Hello, ClothConfig!";

	// Advanced category options
	public AdvancedSettings advancedSettings = new AdvancedSettings();

	public static class AdvancedSettings {
		public double exampleDouble = 3.14;
		public OptionEnum exampleEnum = OptionEnum.OPTION_ONE;
	}

	public enum OptionEnum {
		OPTION_ONE,
		OPTION_TWO,
		OPTION_THREE
	}
}
