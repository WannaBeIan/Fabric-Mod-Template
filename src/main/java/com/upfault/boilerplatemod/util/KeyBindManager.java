package com.upfault.boilerplatemod.util;

import com.upfault.boilerplatemod.config.ConfigManager;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

import java.util.HashMap;
import java.util.Map;

public class KeyBindManager {
	private static final Map<KeyBinding, Runnable> keybindActions = new HashMap<>();

	/**
	 * Initializes key bindings and registers the tick event.
	 * This method should be called from your client mod initializer.
	 */
	public static void init() {
		// Register built-in key binds here.
		registerKeyBind("key.boilerplatemod.openConfig", GLFW.GLFW_KEY_BACKSLASH, "Boilerplate Mod", () -> {
			// Use the current screen as parent (or null if none) to build the config screen.
			Screen parent = MinecraftClient.getInstance().currentScreen;
			Screen configScreen = ConfigManager.getConfigScreen(parent).build();
			MinecraftClient.getInstance().setScreen(configScreen);
		});

		// Register the client tick event to poll for key presses.
		registerTickEvent();
	}

	public static void registerKeyBind(String translationKey, int keyCode, String category, Runnable action) {
		KeyBinding keyBinding = KeyBindingHelper.registerKeyBinding(
				new KeyBinding(translationKey, InputUtil.Type.KEYSYM, keyCode, category)
		);
		keybindActions.put(keyBinding, action);
	}

	public static void registerTickEvent() {
		ClientTickEvents.END_CLIENT_TICK.register(client -> {
			for (Map.Entry<KeyBinding, Runnable> entry : keybindActions.entrySet()) {
				while (entry.getKey().wasPressed()) {
					entry.getValue().run();
				}
			}
		});
	}
}
