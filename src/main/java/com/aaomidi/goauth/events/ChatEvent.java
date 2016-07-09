package com.aaomidi.goauth.events;

import com.aaomidi.goauth.GoAuth;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatEvent implements Listener {
	private final GoAuth instance;

	public ChatEvent(GoAuth instance) {
		this.instance = instance;
		instance.getServer().getPluginManager().registerEvents(this, instance);
	}

	public void onPlayerChat(AsyncPlayerChatEvent event) {
		Player player = event.getPlayer();

	}

}
