package me.JavaExcption.ArenaPvP.kit;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public interface Kit {
    ItemStack[] getInventory();
    ItemStack[] getArmor();
    void apply(Player p);
}
