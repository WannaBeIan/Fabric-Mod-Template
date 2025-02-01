package com.upfault.boilerplatemod.event;

import com.upfault.boilerplatemod.util.KeyBindManager;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;

public class EventManager {
	public static void registerEvents() {
		ServerTickEvents.START_SERVER_TICK.register(server -> {

		});
		KeyBindManager.registerTickEvent();
	}
}
