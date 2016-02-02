package me.JavaExcption.ArenaPvP.command.util;

import me.JavaExcption.ArenaPvP.command.*;
import org.bukkit.command.CommandSender;

import java.util.Set;

public abstract class SimpleBaseCommand extends SimpleArenaCommand implements BaseCommand{
    private Set<ArenaCommand> commands;
    private String helpcommand;

    public SimpleBaseCommand(String name, PermissionTester permission, String helpcommand, Set<ArenaCommand> commands, String... aliases) {
        super(name,"<subcommand>",permission,aliases);
        this.commands = commands;
        this.helpcommand = helpcommand;
        this.commands.add(new HelpCommand(helpcommand,this));
    }

    public Set<ArenaCommand> getSubCommands() {
        return commands;
    }

    public ArenaCommand getHelpCommand() throws CommandNotFoundException {
        return getCommand(helpcommand);
    }

    public ArenaCommand getCommand(String s) throws CommandNotFoundException {
        for(ArenaCommand command:getSubCommands()){
            for(String alias:command.getAliases()){
                if(alias.equalsIgnoreCase(s))return command;
            }
        }
        throw new CommandNotFoundException(s);
    }

    public String execute(CommandSender sender, String[] args) throws CommandNotFoundException,InvalidArgumentsException {
        try {
            if (args.length == 0) return getHelpCommand().execute(sender, args);
            return getCommand(args[0]).execute(sender, args);
        }
        catch (Exception ex){
            return handle(ex);
        }
    }

    public abstract String handle(Exception ex);
}
