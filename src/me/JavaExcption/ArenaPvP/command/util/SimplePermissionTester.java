package me.JavaExcption.ArenaPvP.command.util;

import me.JavaExcption.ArenaPvP.command.PermissionTester;
import org.bukkit.command.CommandSender;

public class SimplePermissionTester implements PermissionTester{
    private String permission;
    public SimplePermissionTester(String permission) {
        this.permission = permission;
    }

    public boolean hasPermission(CommandSender sender) {
        return sender.hasPermission(getPermission());
    }

    public String getPermission(){
        return permission;
    }
}
