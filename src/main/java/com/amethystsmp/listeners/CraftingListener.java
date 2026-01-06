package com.amethystsmp.listeners;

import com.amethystsmp.AmethystSMP;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.ItemStack;

public class CraftingListener implements Listener {
    private final AmethystSMP plugin;
    
    public CraftingListener(AmethystSMP plugin) {
        this.plugin = plugin;
    }
    
    @EventHandler
    public void onCraft(CraftItemEvent event) {
        if (!(event.getWhoClicked() instanceof Player)) return;
        
        CraftingInventory inv = event.getInventory();
        ItemStack[] matrix = inv.getMatrix();
        
        if (matrix.length != 9) return;
        
        if (!isAdminAmethystRecipe(matrix)) return;
        
        Player player = (Player) event.getWhoClicked();
        
        if (!plugin.getConfig().getBoolean("admin-amethyst-recipe-enabled", false)) {
            event.setCancelled(true);
            player.sendMessage(ChatColor.RED + "The Admin Amethyst recipe has not been enabled yet!");
            return;
        }
        
        event.setCurrentItem(plugin.getAmethystManager().createAmethyst("admin"));
        
        plugin.getConfig().set("admin-amethyst-recipe-enabled", false);
        plugin.saveConfig();
        
        plugin.getServer().broadcastMessage(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "✨ The Admin Amethyst has been crafted! ✨");
        plugin.getServer().broadcastMessage(ChatColor.GRAY + "The recipe is now permanently disabled.");
    }
    
    private boolean isAdminAmethystRecipe(ItemStack[] matrix) {
        if (matrix[0] == null || matrix[1] == null || matrix[2] == null ||
            matrix[3] == null || matrix[4] == null || matrix[5] == null ||
            matrix[6] == null || matrix[7] == null || matrix[8] == null) {
            return false;
        }
        
        String t0 = plugin.getAmethystManager().getAmethystType(matrix[0]);
        String t1 = plugin.getAmethystManager().getAmethystType(matrix[1]);
        String t2 = plugin.getAmethystManager().getAmethystType(matrix[2]);
        String t3 = plugin.getAmethystManager().getAmethystType(matrix[3]);
        String t5 = plugin.getAmethystManager().getAmethystType(matrix[5]);
        String t6 = plugin.getAmethystManager().getAmethystType(matrix[6]);
        String t7 = plugin.getAmethystManager().getAmethystType(matrix[7]);
        String t8 = plugin.getAmethystManager().getAmethystType(matrix[8]);
        
        return "blazing".equals(t0) &&
               "frost".equals(t1) &&
               "storm".equals(t2) &&
               "shadow".equals(t3) &&
               matrix[4].getType() == Material.DRAGON_EGG &&
               "sonic".equals(t5) &&
               "blood".equals(t6) &&
               "nature".equals(t7) &&
               "time".equals(t8);
    }
}