package me.JavaExcption.ArenaPvP.util.menus;

import me.JavaExcption.ArenaPvP.util.Utils;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * Created by Henry on 2/3/2016.
 */
public abstract class Menu implements InventoryHolder {

    private int size;
    protected Inventory inventory;

    public Menu(String title, int size) {
        inventory = Bukkit.createInventory(null, size, Utils.colour(title));
        this.size = size;
    }

    public void show(Player player) {
        player.openInventory(inventory);
    }

    public abstract void click(Player player, ItemStack itemStack);

    protected String getFriendlyName(ItemStack itemStack) {
        if(itemStack == null) {
            return null;
        }
        ItemMeta itemMeta = itemStack.getItemMeta();
        if(itemMeta == null || !itemMeta.hasDisplayName()) {
            return null;
        }
        return ChatColor.stripColor(itemMeta.getDisplayName());
    }
}
