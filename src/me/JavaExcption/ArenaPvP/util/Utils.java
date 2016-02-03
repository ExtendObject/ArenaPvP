package me.JavaExcption.ArenaPvP.util;

import net.md_5.bungee.api.ChatColor;

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
