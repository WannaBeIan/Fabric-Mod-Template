package com.upfault.boilerplatemod.util;

public class MathUtils {
	public static float clamp(float value, float min, float max) {
		if (value < min) return min;
		if (value > max) return max;
		return value;
	}

	public static int clamp(int value, int min, int max) {
		if (value < min) return min;
		if (value > max) return max;
		return value;
	}

	public static double lerp(double start, double end, double t) {
		return start + t * (end - start);
	}
}
