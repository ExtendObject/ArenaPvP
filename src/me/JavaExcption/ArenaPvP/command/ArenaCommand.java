package me.JavaExcption.ArenaPvP.command;

import org.bukkit.command.CommandSender;

public interface ArenaCommand {
    String execute(CommandSender sender,String[] args) throws CommandNotFoundException;
    String getName();
    String[] getAliases();
    PermissionTester getPermission();
    String getUsageArgument();
    ArenaCommand getSuper() throws CommandNotFoundException;
}
