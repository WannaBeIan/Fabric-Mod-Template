package com.upfault.boilerplatemod.util;

import java.awt.Color;

public class ColorUtils {

	public static int rgbToInt(int red, int green, int blue) {
		return new Color(red, green, blue).getRGB();
	}

	public static int argbToInt(int alpha, int red, int green, int blue) {
		return new Color(red, green, blue, alpha).getRGB();
	}

	public static int getRed(int color) {
		return (color >> 16) & 0xFF;
	}

	public static int getGreen(int color) {
		return (color >> 8) & 0xFF;
	}

	public static int getBlue(int color) {
		return color & 0xFF;
	}

	/**
	 * Converts an RGB color int into a Minecraft hex color code (e.g. "§x§F§F§A§B§C§D").
	 *
	 * @param color the RGB color integer.
	 * @return the Minecraft-formatted hex color code.
	 */
	public static String toHexColorCode(int color) {
		String hex = String.format("%06X", (0xFFFFFF & color));
		StringBuilder builder = new StringBuilder("§x");
		for (char c : hex.toCharArray()) {
			builder.append("§").append(c);
		}
		return builder.toString();
	}

	/**
	 * Applies a smooth chroma effect to the entire text.
	 * The whole string will be colored with one rainbow color that shifts over time.
	 *
	 * @param text the input text.
	 * @return the text with a smooth rainbow color applied.
	 */
	public static String applySmoothChroma(String text) {
		// Cycle over 10 seconds.
		long time = System.currentTimeMillis();
		float hue = (time % 10000L) / 10000f; // Value between 0 and 1.
		int color = Color.HSBtoRGB(hue, 1.0f, 1.0f);
		String colorCode = toHexColorCode(color);
		return colorCode + text + "§r"; // Append reset formatting.
	}

	/**
	 * Applies a per-letter chroma effect to the text.
	 * Each character is assigned a color with a hue offset based on its index.
	 *
	 * @param text the input text.
	 * @return the text with each letter colored individually in a rainbow gradient.
	 */
	public static String applyChromaPerLetter(String text) {
		long time = System.currentTimeMillis();
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < text.length(); i++) {
			// Adjust hue for each letter (offset each by 150ms equivalent).
			float hue = ((time + i * 150L) % 10000L) / 10000f;
			int color = Color.HSBtoRGB(hue, 1.0f, 1.0f);
			String colorCode = toHexColorCode(color);
			builder.append(colorCode).append(text.charAt(i));
		}
		builder.append("§r");
		return builder.toString();
	}
}
