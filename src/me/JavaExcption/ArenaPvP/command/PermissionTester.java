package me.JavaExcption.ArenaPvP.command;

import org.bukkit.command.CommandSender;

public interface PermissionTester {
    boolean hasPermission(CommandSender sender);
}
