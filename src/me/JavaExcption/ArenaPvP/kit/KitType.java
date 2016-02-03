package me.JavaExcption.ArenaPvP.kit;

import me.JavaExcption.ArenaPvP.kit.ranked.Archer;
import me.JavaExcption.ArenaPvP.kit.ranked.BuildUHC;
import org.bukkit.entity.Player;

/**
 * Created by Henry on 2/3/2016.
 */
public enum  KitType {

    ARCHER("Archer", new Archer()),
    BUILDUHC("BuildUHC", new BuildUHC());

    private String name;
    private KitAction kitAction;

    KitType(String name, KitAction kitAction) {
        this.name = name;
        this.kitAction = kitAction;
    }

    public void giveKit(Player player) {
        kitAction.giveKit(player);
    }

}
