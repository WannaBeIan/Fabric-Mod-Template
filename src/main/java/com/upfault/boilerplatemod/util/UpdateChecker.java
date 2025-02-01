package com.upfault.boilerplatemod.util;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class UpdateChecker {
	private static final Logger LOGGER = LoggerFactory.getLogger("UpdateChecker");
	// Replace these with your GitHub repository's owner and name.
	private static final String REPO_OWNER = "your-github-username";
	private static final String REPO_NAME = "boilerplatemod";
	// GitHub API URL for the latest release.
	private static final String UPDATE_URL = "https://api.github.com/repos/" + REPO_OWNER + "/" + REPO_NAME + "/releases/latest";
	// Current mod version (should match your gradle.properties and fabric.mod.json).
	public static final String CURRENT_VERSION = "1.0.0";

	public static void checkForUpdates() {
		new Thread(() -> {
			try {
				URL url = new URL(UPDATE_URL);
				HttpURLConnection connection = (HttpURLConnection) url.openConnection();
				connection.setRequestMethod("GET");
				connection.setConnectTimeout(5000);
				connection.setReadTimeout(5000);

				int responseCode = connection.getResponseCode();
				if (responseCode == HttpURLConnection.HTTP_OK) {
					BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
					StringBuilder content = new StringBuilder();
					String inputLine;
					while ((inputLine = in.readLine()) != null) {
						content.append(inputLine);
					}
					in.close();

					// GitHub returns a JSON with a "tag_name" field for the release version,
					// and an "html_url" for the release page.
					JsonObject json = new Gson().fromJson(content.toString(), JsonObject.class);
					String latestVersion = json.get("tag_name").getAsString();
					String downloadUrl = json.get("html_url").getAsString();

					if (isNewerVersion(latestVersion)) {
						LOGGER.info("A new version ({}) is available! Download it at: {}", latestVersion, downloadUrl);
					} else {
						LOGGER.info("You are using the latest version (" + CURRENT_VERSION + ").");
					}
				} else {
					LOGGER.warn("Update checker returned response code: " + responseCode);
				}
			} catch (Exception e) {
				LOGGER.error("Failed to check for updates", e);
			}
		}).start();
	}

	/**
	 * Checks for an update synchronously and returns a message if a newer version exists.
	 * If no update is available, returns an empty string.
	 *
	 * @return the update message or an empty string if up-to-date.
	 */
	public static String getUpdateMessage() {
		try {
			URL url = new URL(UPDATE_URL);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.setConnectTimeout(5000);
			connection.setReadTimeout(5000);

			int responseCode = connection.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) {
				BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				StringBuilder content = new StringBuilder();
				String inputLine;
				while ((inputLine = in.readLine()) != null) {
					content.append(inputLine);
				}
				in.close();

				JsonObject json = new Gson().fromJson(content.toString(), JsonObject.class);
				String latestVersion = json.get("tag_name").getAsString();
				if (isNewerVersion(latestVersion)) {
					return "A newer version is available " + CURRENT_VERSION + " -> " + latestVersion + "!";
				}
			} else {
				LOGGER.warn("Update checker returned response code: " + responseCode);
			}
		} catch (Exception e) {
			LOGGER.error("Failed to check for updates", e);
		}
		return "";
	}

	private static boolean isNewerVersion(String latest) {
		// Simple version comparison assuming versions formatted as "major.minor.patch"
		String[] latestParts = latest.replaceAll("[^0-9.]", "").split("\\.");
		String[] currentParts = CURRENT_VERSION.replaceAll("[^0-9.]", "").split("\\.");
		for (int i = 0; i < Math.min(latestParts.length, currentParts.length); i++) {
			int latestNum = Integer.parseInt(latestParts[i]);
			int currentNum = Integer.parseInt(currentParts[i]);
			if (latestNum > currentNum) return true;
			if (latestNum < currentNum) return false;
		}
		return latestParts.length > currentParts.length;
	}
}
