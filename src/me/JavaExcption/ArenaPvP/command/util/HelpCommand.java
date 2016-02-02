package me.JavaExcption.ArenaPvP.command.util;

import me.JavaExcption.ArenaPvP.command.ArenaCommand;
import me.JavaExcption.ArenaPvP.command.BaseCommand;
import me.JavaExcption.ArenaPvP.command.CommandNotFoundException;
import org.bukkit.command.CommandSender;

public class HelpCommand extends SimpleArenaCommand{
    public static String getUsageString(ArenaCommand command){
        String s = command.getUsageArgument();
        //TODO - Color
        ArenaCommand last = command;
        while(true){
            try{
                last = last.getSuper();
            }
            catch (CommandNotFoundException ex){
                break;
            }
            //TODO - Color
            s += last.getName() + " ";
        }
        //TODO - Color
        return "/" + s;
    }

    private BaseCommand baseCommand;
    private String help;

    public HelpCommand(String name,BaseCommand baseCommand,String... aliases) {
        super(name, "?", baseCommand.getPermission(), aliases);
        this.baseCommand = baseCommand;
        help = "-----[Help]-----" + baseCommand.getName();
        for(ArenaCommand command:baseCommand.getSubCommands()){
            help += "\n" + getUsageString(command);
        }
    }

    public String execute(CommandSender sender, String[] args) throws CommandNotFoundException {
        return getHelp();
    }

    public String getHelp(){
        return help;
    }

    public ArenaCommand getSuper() throws CommandNotFoundException {
        return baseCommand;
    }
}
