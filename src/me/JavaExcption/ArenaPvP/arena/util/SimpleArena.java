package me.JavaExcption.ArenaPvP.arena.util;

import me.JavaExcption.ArenaPvP.arena.Arena;
import org.bukkit.Location;

import java.util.Set;

public class SimpleArena implements Arena{
    private Location spectator;
    private Set<Location> spawns;
    private boolean occupied = false,buildable;
    private int sizewidth,sizeheight;

    public SimpleArena(Set<Location> spawns, int sizeheight, int sizewidth, boolean buildable,Location spectator) {
        this.sizeheight = sizeheight;
        this.sizewidth = sizewidth;
        this.buildable = buildable;
        this.spawns = spawns;
        this.spectator = spectator;
    }

    public boolean isBuildAble() {
        return buildable;
    }

    public void setBuildAble(boolean buildable) {
        this.buildable = buildable;
    }


    public Location getSpectator() {
        return spectator;
    }

    public void setSpectator(Location spectator) {
        this.spectator = spectator;
    }

    public boolean isOccupied() {
        return occupied;
    }


    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public int getSizeHeight() {
        return sizeheight;
    }

    public void setSizeHeight(int sizeheight) {
        this.sizeheight = sizeheight;
    }

    public int getSizeWidth() {
        return sizewidth;
    }

    public void setSizeWidth(int sizewidth) {
        this.sizewidth = sizewidth;
    }

    public Set<Location> getSpawns() {
        return spawns;
    }

    public void setSpawns(Set<Location> spawns) {
        this.spawns = spawns;
    }
}
