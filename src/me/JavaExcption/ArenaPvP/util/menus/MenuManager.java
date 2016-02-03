package me.JavaExcption.ArenaPvP.util.menus;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.Plugin;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Henry on 2/3/2016.
 */
public class MenuManager implements Listener {

    private Map<Object, Menu> menus = new HashMap<Object, Menu>();

    public MenuManager(Plugin plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    public void addMenu(Object key, Menu menu) {
        menus.put(key, menu);
    }

    public Collection<Menu> getMenus() {
        return menus.values();
    }

    public Menu getMenu(Object key) {
        return menus.get(key);
    }

    @EventHandler
    public void onClick(InventoryDragEvent event) {
        Inventory inventory = event.getWhoClicked().getOpenInventory().getTopInventory();
        for(Menu menu : menus.values()) {
            if(menu.getInventory().getName().equals(inventory.getName())) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        Inventory inventory = player.getOpenInventory().getTopInventory();
        for(Menu menu : menus.values()) {
            if(menu.getInventory().getName().equals(inventory.getName())) {
                event.setCancelled(true);
                menu.click(player, event.getCurrentItem());
            }
        }
    }
}
