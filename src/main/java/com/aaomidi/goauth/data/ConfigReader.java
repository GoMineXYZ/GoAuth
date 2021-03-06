package com.aaomidi.goauth.data;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.configuration.file.FileConfiguration;

public class ConfigReader {
	@Getter
	@Setter
	private static FileConfiguration config;
	private static String baseURL;
	private static String key;
	private static String prefix;

	public static String getPrefix() {
		if (prefix == null) {
			prefix = config.getString("General-Settings.Prefix");
		}
		return prefix;
	}

	public static String getBaseURL() {
		if (baseURL == null) {
			baseURL = config.getString("API-Settings.Base-URL");
		}
		return baseURL;
	}

	public static String getKey() {
		if (key == null) {
			key = config.getString("API-Settings.Key");
		}
		return key;
	}
}
