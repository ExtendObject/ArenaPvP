package me.JavaExcption.ArenaPvP.command;

public class InvalidArgumentsException extends Exception{
    public InvalidArgumentsException(){
        super("Invalid arguments!");
    }
    public InvalidArgumentsException(String s){
        super("Invalid args: " + s);
    }
}
