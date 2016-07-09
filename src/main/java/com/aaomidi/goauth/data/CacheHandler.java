package com.aaomidi.goauth.data;

import com.aaomidi.goauth.model.User;
import org.bukkit.entity.Player;

import java.util.Map;
import java.util.WeakHashMap;

public class CacheHandler {
	private static final Map<Player, User> map = new WeakHashMap<>();

	public static void cachePlayer(Player player, User user) {
		map.put(player, user);
	}

	public static void uncachePlayer(Player player) {
		map.remove(player);
	}

	public static User getUser(Player player) {
		return map.get(player);
	}
}
