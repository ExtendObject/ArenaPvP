package me.JavaExcption.ArenaPvP.arena;

import org.bukkit.Location;

import java.util.Set;

public interface Arena {
    Set<Location> getSpawns();
    void setSpawns(Set<Location> spawns);
    Location getSpectator();
    void setSpectator(Location l);
    int getSizeWidth();
    void setSizeWidth(int width);
    int getSizeHeight();
    void setSizeHeight(int height);
    boolean isOccupied();
    void setOccupied(boolean b);
    boolean isBuildAble();
    void setBuildAble(boolean b);
}
