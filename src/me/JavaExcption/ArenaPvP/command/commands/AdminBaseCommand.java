package me.JavaExcption.ArenaPvP.command.commands;

import me.JavaExcption.ArenaPvP.command.ArenaCommand;
import me.JavaExcption.ArenaPvP.command.CommandNotFoundException;
import me.JavaExcption.ArenaPvP.command.util.DynamicPermissionTester;
import me.JavaExcption.ArenaPvP.command.util.SimpleBaseCommand;

import java.util.Arrays;
import java.util.HashSet;

public class AdminBaseCommand extends SimpleBaseCommand{
    public AdminBaseCommand(ArenaCommand... args) {
        super("arena", new DynamicPermissionTester(args) , "helpcommand", new HashSet<>(Arrays.asList(args)));
    }

    public ArenaCommand getSuper() throws CommandNotFoundException {
        throw new CommandNotFoundException("Super");
    }

    public String handle(Exception ex) {
        if(ex instanceof CommandNotFoundException){
            //TODO - Color
            String helpcommand = "";
            try {
                helpcommand = getHelpCommand().execute(null, null);
            }
            catch (Exception newexception){
                //Cannot be thrown
            }
            return helpcommand + "\nCommand not found: " + ((CommandNotFoundException) ex).getCommand();
        }
        return "An internal error has occurred";
    }
}
