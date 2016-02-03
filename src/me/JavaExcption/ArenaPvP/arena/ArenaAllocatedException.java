package me.JavaExcption.ArenaPvP.arena;

public class ArenaAllocatedException extends Exception{
    private Arena arena;

    public ArenaAllocatedException(Arena arena,String s){
        super(s);
        this.arena = arena;
    }

    public ArenaAllocatedException(Arena arena){
        super("Arena " + arena.getSpectator().toString() + " has been allocated incorrectly");
    }

    public Arena getArena(){
        return arena;
    }
}
