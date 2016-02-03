package me.JavaExcption.ArenaPvP.util;

import org.bukkit.ChatColor;

/**
 * Created by Henry on 2/3/2016.
 */
public class Utils {

    private Utils() {

    }

    public static String colour(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }
}
