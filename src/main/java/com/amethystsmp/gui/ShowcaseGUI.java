package com.amethystsmp.gui;

import com.amethystsmp.AmethystSMP;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class ShowcaseGUI implements Listener {
    private final AmethystSMP plugin;
    private final String title = ChatColor.LIGHT_PURPLE + "✨ Amethyst Collection ✨";
    
    public ShowcaseGUI(AmethystSMP plugin) {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
    
    public void open(Player player) {
        Inventory inv = Bukkit.createInventory(null, 27, title);
        
        inv.setItem(10, plugin.getAmethystManager().createAmethyst("pure"));
        inv.setItem(11, plugin.getAmethystManager().createAmethyst("blazing"));
        inv.setItem(12, plugin.getAmethystManager().createAmethyst("frost"));
        inv.setItem(13, plugin.getAmethystManager().createAmethyst("storm"));
        inv.setItem(14, plugin.getAmethystManager().createAmethyst("nature"));
        inv.setItem(15, plugin.getAmethystManager().createAmethyst("shadow"));
        inv.setItem(16, plugin.getAmethystManager().createAmethyst("wind"));
        inv.setItem(19, plugin.getAmethystManager().createAmethyst("blood"));
        inv.setItem(20, plugin.getAmethystManager().createAmethyst("sonic"));
        inv.setItem(21, plugin.getAmethystManager().createAmethyst("time"));
        inv.setItem(22, plugin.getAmethystManager().createAmethyst("admin"));
        
        for (int i = 0; i < 27; i++) {
            if (inv.getItem(i) == null) {
                ItemStack filler = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
                inv.setItem(i, filler);
            }
        }
        
        player.openInventory(inv);
    }
    
    @EventHandler
    public void onClick(InventoryClickEvent event) {
        if (!event.getView().getTitle().equals(title)) return;
        
        event.setCancelled(true);
    }
}