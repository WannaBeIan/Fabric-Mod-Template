package com.upfault.boilerplatemod.client;

import com.upfault.boilerplatemod.command.CommandManager;
import com.upfault.boilerplatemod.config.configs.ModConfig;
import com.upfault.boilerplatemod.event.EventManager;
import com.upfault.boilerplatemod.util.KeyBindManager;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;

public class BoilerplateModClient implements ClientModInitializer {
	public static final String MOD_ID = "boilerplatemod";

	@Override
	public void onInitializeClient() {
		AutoConfig.register(ModConfig.class, JanksonConfigSerializer::new);
		CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, dedicated) ->
				CommandManager.registerCommands(dispatcher));
		EventManager.registerEvents();

		KeyBindManager.init();
	}
}
