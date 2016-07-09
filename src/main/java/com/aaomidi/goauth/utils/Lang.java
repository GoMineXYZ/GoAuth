package com.aaomidi.goauth.utils;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Lang {
	@Getter
	@Setter
	private static Logger logger = Bukkit.getLogger();
	@Getter
	@Setter
	private static String PREFIX = "GoAuth ";
	@Getter
	private static String BLANK = "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n";
	private static String REGISTER_TEXT =
			"&b----------------------\n" +
					"Heya and welcome to &4Go&7Mine&f!\n" +
					"To start playing on this network, first you've gotta register your account.\n" +
					"You can register ingame or on &4https://GoMine.xyz/\n" +
					"To register ingame just use &4/register&f and follow the onscreen instructions!\n" +
					"&b-----------------------";

	public static String colorize(String string) {
		return ChatColor.translateAlternateColorCodes('&', string);
	}

	public static void log(Level level, Object o, Object... format) {
		logger.log(level, o.toString(), format);
	}

	public static void sendMessage(CommandSender commandSender, Object o, Object... format) {
		commandSender.sendMessage(colorize(String.format(getPREFIX() + o.toString(), format)));
	}

	public static String getRegisterText() {
		if (REGISTER_TEXT.contains("&")) {
			REGISTER_TEXT = colorize(REGISTER_TEXT);
		}
		return REGISTER_TEXT;
	}
}
