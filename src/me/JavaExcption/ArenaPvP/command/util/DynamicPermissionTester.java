package me.JavaExcption.ArenaPvP.command.util;

import me.JavaExcption.ArenaPvP.command.ArenaCommand;
import me.JavaExcption.ArenaPvP.command.PermissionTester;
import org.bukkit.command.CommandSender;

public class DynamicPermissionTester implements PermissionTester{
    private ArenaCommand[] arenaCommands;

    public DynamicPermissionTester(ArenaCommand[] arenaCommands){
        this.arenaCommands = arenaCommands;
    }

    public boolean hasPermission(CommandSender sender) {
        for(ArenaCommand arenaCommand:arenaCommands){
            if(arenaCommand.getPermission().hasPermission(sender))return true;
        }
        return false;
    }
}
