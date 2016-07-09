package com.aaomidi.goauth.model;

import lombok.RequiredArgsConstructor;
import org.bukkit.entity.Player;

@RequiredArgsConstructor
public class User {
	private final Player player;
	private final boolean locked;
	private final boolean authenticated;
	private final boolean registered;

	public void changePassword(String newPassword) {
		//TODO
	}

	public void changeEmail(String newEmail) {
		//TODO
	}

}
