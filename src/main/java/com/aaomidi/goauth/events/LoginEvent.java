package com.aaomidi.goauth.events;

import com.aaomidi.goauth.GoAuth;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import xyz.mkotb.xenapi.XenAPI;

public class LoginEvent implements Listener {
	private final GoAuth instance;

	public LoginEvent(GoAuth instance) {
		this.instance = instance;
		instance.getServer().getPluginManager().registerEvents(this, instance);
	}

	@EventHandler(priority = EventPriority.LOWEST)
	public void onPlayerLogin(PlayerLoginEvent event) {
		Player player = event.getPlayer();
		XenAPI xenAPI = instance.getXenAPI();

	}
}
