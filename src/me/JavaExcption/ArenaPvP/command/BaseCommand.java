package me.JavaExcption.ArenaPvP.command;

import java.util.Set;

public interface BaseCommand extends ArenaCommand{
    Set<ArenaCommand> getSubCommands();
    ArenaCommand getHelpCommand() throws CommandNotFoundException;
    ArenaCommand getCommand(String s) throws CommandNotFoundException;
}
