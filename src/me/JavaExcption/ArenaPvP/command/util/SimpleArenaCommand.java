package me.JavaExcption.ArenaPvP.command.util;

import me.JavaExcption.ArenaPvP.command.ArenaCommand;
import me.JavaExcption.ArenaPvP.command.PermissionTester;

public abstract class SimpleArenaCommand implements ArenaCommand{
    private final String name,usage;
    private final PermissionTester permission;
    private final String[] aliases;

    public SimpleArenaCommand(String name, String usage, PermissionTester permission, String... aliases) {
        this.name = name;
        this.usage = usage;
        this.permission = permission;
        this.aliases = aliases;
    }

    public String getName() {
        return name;
    }

    public String[] getAliases() {
        return aliases;
    }

    public PermissionTester getPermission() {
        return permission;
    }


    public String getUsageArgument() {
        return usage;
    }
}
