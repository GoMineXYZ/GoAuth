package com.aaomidi.goauth;


import com.aaomidi.goauth.data.ConfigReader;
import com.aaomidi.goauth.events.ChatEvent;
import com.aaomidi.goauth.events.LoginEvent;
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
		this.registerEvents();
	}

	@Override
	public void onDisable() {
		//Clean up for reloads.
	}

	private void startXenAPI() {
		xenAPI = XenAPI.create(ConfigReader.getBaseURL(), ConfigReader.getKey());
	}

	public void registerEvents() {
		this.getServer().getPluginManager().registerEvents(new ChatEvent(this), this);
		this.getServer().getPluginManager().registerEvents(new LoginEvent(this), this);
	}
}
