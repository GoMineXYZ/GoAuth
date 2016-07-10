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
	private static String LOGIN_TEXT =
			"&b----------------------\n" +
					"Heya! The account you're currently on has been registered on this server.\n" +
					"Please use &4/login &fand follow the onscreen instructions to login!\n" +
					"If you've forgot your password, you can reset it at &chttps://GoMine.xyz\n" +
					"&b-----------------------";
	private static String REGISTER_EMAIL_TEXT = "&bPlease enter your email here";
    private static String CONFIRM_MESSAGE = "&bYou entered &4%s&b, would you like to proceed? (yes or no)";
    private static String INVALID_INPUT_MESSAGE = "&bPlease enter a valid &4%s&b, you entered: %s";
    private static String PASSWORD_TEXT = "&bPlease enter your password here (Minimum 8 characters at least 1 Uppercase, 1 Lowercase and 1 Number)";
    private static String REGISTER_ERROR_TEXT = "&4There was an error registering your account, sorry! (error code: %d)";

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

	public static String getLoginText() {
		if (LOGIN_TEXT.contains("&")) {
			LOGIN_TEXT = colorize(LOGIN_TEXT);
		}
		return LOGIN_TEXT;
	}

    public static String getRegisterEmailText() {
        if (REGISTER_EMAIL_TEXT.contains("&")) {
            REGISTER_EMAIL_TEXT = colorize(REGISTER_EMAIL_TEXT);
        }
        return REGISTER_EMAIL_TEXT;
    }

    public static String getConfirmMessage(String value) {
        if (CONFIRM_MESSAGE.contains("&")) {
            CONFIRM_MESSAGE = colorize(CONFIRM_MESSAGE);
        }
        return String.format(CONFIRM_MESSAGE, value);
    }

    public static String getInvalidInputMessage(String type, String value) {
        if (INVALID_INPUT_MESSAGE.contains("&")) {
            INVALID_INPUT_MESSAGE = colorize(INVALID_INPUT_MESSAGE);
        }
        return String.format(INVALID_INPUT_MESSAGE, type, value);
    }

    public static String getPasswordText() {
        if (PASSWORD_TEXT.contains("&")) {
            PASSWORD_TEXT = colorize(PASSWORD_TEXT);
        }
        return PASSWORD_TEXT;
    }

    public static String getRegisterErrorText(int code) {
        if (REGISTER_ERROR_TEXT.contains("&")) {
            REGISTER_ERROR_TEXT = colorize(REGISTER_ERROR_TEXT);
        }
        return String.format(REGISTER_ERROR_TEXT, code);
    }
}
