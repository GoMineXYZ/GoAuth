package com.aaomidi.goauth.events;

import com.aaomidi.goauth.GoAuth;
import com.aaomidi.goauth.data.CacheHandler;
import com.aaomidi.goauth.model.User;
import com.aaomidi.goauth.utils.Lang;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatEvent implements Listener {
	private final GoAuth instance;

	public ChatEvent(GoAuth instance) {
		this.instance = instance;
		instance.getServer().getPluginManager().registerEvents(this, instance);
	}

	@EventHandler(priority = EventPriority.LOWEST)
	public void onPlayerChat(AsyncPlayerChatEvent event) {
		Player player = event.getPlayer();
		User user = CacheHandler.getUser(player);

		if (user == null) {
			throw new RuntimeException("Something went wrong."); //This really shouldn't happen.
		}
		if (user.isAuthenticated()) {
			return;
		}

		event.setMessage("");
		event.getRecipients().clear();
		event.setCancelled(true);


		if (user.isRegistered()) {
			player.sendMessage(Lang.getBLANK());
			player.sendMessage(Lang.getLoginText());
		}

		player.sendMessage(Lang.getBLANK());
		player.sendMessage(Lang.getRegisterText());
	}

}
