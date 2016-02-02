package me.JavaExcption.ArenaPvP.command.util;

import me.JavaExcption.ArenaPvP.command.ArenaCommand;
import me.JavaExcption.ArenaPvP.command.BaseCommand;
import me.JavaExcption.ArenaPvP.command.CommandNotFoundException;
import me.JavaExcption.ArenaPvP.command.PermissionTester;
import org.bukkit.command.CommandSender;

import java.util.Set;

public abstract class SimpleBaseCommand extends SimpleArenaCommand implements BaseCommand{
    private Set<ArenaCommand> commands;
    private String helpcommand;

    public SimpleBaseCommand(String name, String usage, PermissionTester permission, String helpcommand, Set<ArenaCommand> commands, String... aliases) {
        super(name,usage,permission,aliases);
        this.commands = commands;
        this.helpcommand = helpcommand;
    }

    public Set<ArenaCommand> getSubCommands() {
        return commands;
    }

    public ArenaCommand getHelpCommand() throws CommandNotFoundException {
        return getCommand(helpcommand);
    }

    public ArenaCommand getCommand(String s) throws CommandNotFoundException {
        for(ArenaCommand command:getSubCommands()){
            if(command.getName().equalsIgnoreCase(s))return command;
        }
        for(ArenaCommand command:getSubCommands()){
            for(String alias:command.getAliases()){
                if(alias.equalsIgnoreCase(s))return command;
            }
        }
        throw new CommandNotFoundException(s);
    }

    public String execute(CommandSender sender, String[] args) throws CommandNotFoundException {
        if(args.length == 0)throw new CommandNotFoundException(helpcommand);
        return getCommand(args[0]).execute(sender,args);
    }
}
