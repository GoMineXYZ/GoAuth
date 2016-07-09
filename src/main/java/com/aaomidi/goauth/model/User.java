package com.aaomidi.goauth.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.bukkit.entity.Player;

@RequiredArgsConstructor
public class User {
	@Getter
	private final Player player;
	@Getter
	private boolean fetched = false;
	private boolean authenticated = false;
	private boolean registered = false;

	public void changePassword(String newPassword) {
		//TODO
	}

	public void changeEmail(String newEmail) {
		//TODO
	}

	public boolean isAuthenticated() {
		return authenticated;
	}

	public void setAuthenticated(boolean authenticated) {
		this.authenticated = authenticated;
		this.fetched = true;
	}

	public boolean isRegistered() {
		return registered;
	}

	public void setRegistered(boolean registered) {
		this.registered = registered;
		this.fetched = true;
	}


}
