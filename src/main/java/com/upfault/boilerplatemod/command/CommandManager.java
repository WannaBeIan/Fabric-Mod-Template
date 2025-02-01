package com.upfault.boilerplatemod.command;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;

import static net.minecraft.server.command.CommandManager.literal;

public class CommandManager {
	public static void registerCommands(CommandDispatcher<ServerCommandSource> dispatcher) {
		dispatcher.register(literal("example").executes(context -> {
			context.getSource().sendFeedback(() -> Text.of("Example command executed"), false);
			return 1;
		}));
	}
}