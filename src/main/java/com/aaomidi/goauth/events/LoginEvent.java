package com.aaomidi.goauth.events;

import com.aaomidi.goauth.GoAuth;
import com.aaomidi.goauth.model.User;
import com.aaomidi.goauth.utils.Lang;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.scheduler.BukkitScheduler;
import xyz.mkotb.xenapi.XenAPI;
import xyz.mkotb.xenapi.ex.XenAPIException;
import xyz.mkotb.xenapi.req.GetUserRequest;
import xyz.mkotb.xenapi.resp.GetUserResponse;

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
		BukkitScheduler scheduler = instance.getServer().getScheduler();
		User user = new User(player);
		scheduler.runTaskAsynchronously(instance, () -> {
			try {
				GetUserResponse resp = xenAPI.getUser(new GetUserRequest(player.getName()));

				scheduler.runTask(instance, () -> {
					user.setRegistered(true);
				});

			} catch (XenAPIException ex) {
				ex.printStackTrace(); // TODO remove later

				scheduler.runTaskLater(instance, () -> {
					user.setRegistered(false);
					player.sendMessage(Lang.getBLANK());
					player.sendMessage(Lang.getRegisterText());
				}, 10L);
			}


		});
	}
}
