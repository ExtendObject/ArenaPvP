package me.JavaExcption.ArenaPvP.fight;

import me.JavaExcption.ArenaPvP.arena.Arena;
import me.JavaExcption.ArenaPvP.kit.Kit;
import org.bukkit.entity.Player;

import java.util.Set;

public interface Fight {
    Arena getArena();
    Set<Player> getSpectators();
    Set<Player> getPlaying();
    Kit getKit();
    void end();
}
