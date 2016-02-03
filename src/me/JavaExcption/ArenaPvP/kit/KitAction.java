package me.JavaExcption.ArenaPvP.kit;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

/**
 * Created by Henry on 2/3/2016.
 */
public interface KitAction {

    void giveKit(Player player);
    void interact(PlayerInteractEvent event, Player player, ItemStack itemStack);
}
