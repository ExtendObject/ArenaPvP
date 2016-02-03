package me.JavaExcption.ArenaPvP.command;

public class CommandNotFoundException extends Exception{
    private String command;

    public CommandNotFoundException(String command){
        super("Could not find the command " + command);
        this.command = command;
    }

    public String getCommand(){
        return command;
    }
}
