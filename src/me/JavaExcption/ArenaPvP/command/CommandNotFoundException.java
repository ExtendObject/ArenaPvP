package me.JavaExcption.ArenaPvP.command;

public class CommandNotFoundException extends Exception{
    public CommandNotFoundException(String command){
        super("Could not find the command " + command);
    }
}
