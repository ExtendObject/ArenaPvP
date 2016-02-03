package me.JavaExcption.ArenaPvP.util;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Henry on 2/3/2016.
 */
public class ItemStackBuilder {

    private final ItemStack ITEM_STACK;

    public ItemStackBuilder(Material material) {
        this.ITEM_STACK = new ItemStack(material);
    }

    public ItemStackBuilder(ItemStack itemStack) {
        this.ITEM_STACK = itemStack;
    }

    public ItemStackBuilder withAmount(int amount) {
        ITEM_STACK.setAmount(amount);
        return this;
    }

    public ItemStackBuilder withName(String name) {
        final ItemMeta meta = ITEM_STACK.getItemMeta();
        meta.setDisplayName(Utils.colour(name));
        ITEM_STACK.setItemMeta(meta);
        return this;
    }

    public ItemStackBuilder withLore(String name) {
        final ItemMeta meta = ITEM_STACK.getItemMeta();
        List<String> lore = meta.getLore();
        if(lore == null) {
            lore = new ArrayList<String>();
        }
        lore.add(Utils.colour(name));
        meta.setLore(lore);
        ITEM_STACK.setItemMeta(meta);
        return this;
    }

    public ItemStackBuilder withDurability(int durability) {
        ITEM_STACK.setDurability((short) durability);
        return this;
    }

    public ItemStackBuilder withData(int data) {
        ITEM_STACK.setDurability((short) data);
        return this;
    }

    public ItemStackBuilder withEnchantment(Enchantment enchantment, final int level) {
        ITEM_STACK.addUnsafeEnchantment(enchantment, level);
        return this;
    }

    public ItemStackBuilder withEnchantment(Enchantment enchantment) {
        ITEM_STACK.addUnsafeEnchantment(enchantment, 1);
        return this;
    }

    public ItemStackBuilder withType(Material material) {
        ITEM_STACK.setType(material);
        return this;
    }

   public ItemStackBuilder clearLore() {
       final ItemMeta meta = ITEM_STACK.getItemMeta();
       meta.setLore(new ArrayList<String>());
       ITEM_STACK.setItemMeta(meta);
       return this;
   }

    public ItemStackBuilder clearEnchantments() {
        for(Enchantment enchantment : ITEM_STACK.getEnchantments().keySet()) {
            ITEM_STACK.removeEnchantment(enchantment);
        }
        return this;
    }

    public ItemStackBuilder withColour(Color colour) {
        Material type = ITEM_STACK.getType();
        if(type == Material.LEATHER_BOOTS || type == Material.LEATHER_LEGGINGS || type == Material.LEATHER_CHESTPLATE || type == Material.LEATHER_HELMET) {
            LeatherArmorMeta meta = (LeatherArmorMeta) ITEM_STACK.getItemMeta();
            meta.setColor(colour);
            ITEM_STACK.setItemMeta(meta);
            return this;
        } else {
            throw new IllegalArgumentException("withColour is only applicable with leather armor!");
        }
    }

    public ItemStack build() {
        return ITEM_STACK;
    }
}
