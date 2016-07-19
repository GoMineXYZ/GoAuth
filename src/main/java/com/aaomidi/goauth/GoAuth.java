package com.aaomidi.goauth;


import com.aaomidi.goauth.data.ConfigReader;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.mkotb.xenapi.XenAPI;

import java.io.File;

public class GoAuth extends JavaPlugin {
	@Getter
	private XenAPI xenAPI;

	@Override
	public void onLoad() {
		File file = new File(getDataFolder(), "config.yml");
		if (!file.exists()) {
			saveDefaultConfig();
		}

		ConfigReader.setConfig(getConfig());
	}

	@Override
	public void onEnable() {
		this.startXenAPI();
	}

	@Override
	public void onDisable() {
		//Clean up for reloads.
	}

	private void startXenAPI() {
		xenAPI = XenAPI.create(ConfigReader.getBaseURL(), ConfigReader.getKey());
	}
}
