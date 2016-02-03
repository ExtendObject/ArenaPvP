package me.JavaExcption.ArenaPvP.fight;

import me.JavaExcption.ArenaPvP.arena.Arena;
import me.JavaExcption.ArenaPvP.arena.ArenaAllocatedException;
import me.JavaExcption.ArenaPvP.kit.Kit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Match implements Fight{
    private Player player1;
    private Player player2;
    private Set<Player> spectators = new HashSet<>();
    private Arena arena;
    private Location spawn1;
    private Location spawn2;
    private Kit k;

    public Match(Player player1, Player player2, Arena arena,Kit k) throws ArenaAllocatedException{
        if(arena.isOccupied())throw new ArenaAllocatedException(arena);
        if(arena.getSpawns().size() != 2)throw new ArenaAllocatedException(arena);
        arena.setOccupied(true);
        this.player1 = player1;
        this.player2 = player2;
        this.arena = arena;
        this.k = k;
        Iterator<Location> arenaiterator = arena.getSpawns().iterator();
        spawn1 = arenaiterator.next();
        spawn2 = arenaiterator.next();
        getPlayer1().teleport(getSpawn1());
        getPlayer2().teleport(getSpawn2());
        getKit().apply(getPlayer1());
        getKit().apply(getPlayer2());
    }

    public Arena getArena() {
        return arena;
    }

    public Set<Player> getSpectators() {
        return spectators;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public Set<Player> getPlaying() {
        return new HashSet<>(Arrays.asList(player1,player2));
    }

    public void end(){
        arena.setOccupied(false);
    }

    public Kit getKit(){
        return k;
    }

    public Location getSpawn1() {
        return spawn1;
    }

    public Location getSpawn2() {
        return spawn2;
    }
}
