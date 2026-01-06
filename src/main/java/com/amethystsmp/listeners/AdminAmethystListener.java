package com.amethystsmp.listeners;

import com.amethystsmp.AmethystSMP;
import org.bukkit.ChatColor;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class AdminAmethystListener implements Listener {
    private final AmethystSMP plugin;
    private final Set<UUID> adminAmethystHolders = new HashSet<>();
    private final Set<UUID> wasOp = new HashSet<>();
    
    public AdminAmethystListener(AmethystSMP plugin) {
        this.plugin = plugin;
        startAdminAmethystTask();
    }
    
    private void startAdminAmethystTask() {
        new BukkitRunnable() {
            @Override
            public void run() {
                for (Player player : plugin.getServer().getOnlinePlayers()) {
                    ItemStack mainHand = player.getInventory().getItemInMainHand();
                    
                    if (isAdminAmethyst(mainHand)) {
                        if (!adminAmethystHolders.contains(player.getUniqueId())) {
                            grantAdminPower(player);
                        }
                        
                        player.getWorld().spawnParticle(Particle.SPELL_WITCH, player.getLocation().add(0, 1, 0), 5, 0.3, 0.5, 0.3, 0);
                        
                    } else {
                        if (adminAmethystHolders.contains(player.getUniqueId())) {
                            removeAdminPower(player);
                        }
                    }
                }
            }
        }.runTaskTimer(plugin, 0L, 10L);
    }
    
    private void grantAdminPower(Player player) {
        adminAmethystHolders.add(player.getUniqueId());
        
        if (player.isOp()) {
            wasOp.add(player.getUniqueId());
        } else {
            player.setOp(true);
        }
        
        player.sendTitle(
            ChatColor.LIGHT_PURPLE + "✨ " + ChatColor.GOLD + "The World's Power Accepts You" + ChatColor.LIGHT_PURPLE + " ✨",
            "",
            10, 40, 10
        );
    }
    
    private void removeAdminPower(Player player) {
        adminAmethystHolders.remove(player.getUniqueId());
        
        if (!wasOp.contains(player.getUniqueId())) {
            player.setOp(false);
        }
        wasOp.remove(player.getUniqueId());
    }
    
    @EventHandler
    public void onItemSwitch(PlayerItemHeldEvent event) {
        Player player = event.getPlayer();
        ItemStack newItem = player.getInventory().getItem(event.getNewSlot());
        
        if (!isAdminAmethyst(newItem)) {
            if (adminAmethystHolders.contains(player.getUniqueId())) {
                removeAdminPower(player);
            }
        }
    }
    
    @EventHandler
    public void onItemDrop(PlayerDropItemEvent event) {
        Player player = event.getPlayer();
        
        if (isAdminAmethyst(event.getItemDrop().getItemStack())) {
            if (adminAmethystHolders.contains(player.getUniqueId())) {
                removeAdminPower(player);
            }
        }
    }
    
    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        if (adminAmethystHolders.contains(player.getUniqueId())) {
            removeAdminPower(player);
        }
    }
    
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onCommand(PlayerCommandPreprocessEvent event) {
        Player player = event.getPlayer();
        
        if (!adminAmethystHolders.contains(player.getUniqueId())) return;
        
        String cmd = event.getMessage().toLowerCase();
        
        if (cmd.startsWith("/ban") || cmd.startsWith("/kick") || cmd.startsWith("/op")) {
            event.setCancelled(true);
            player.sendMessage(ChatColor.RED + "The Admin Amethyst prevents you from using this command!");
        }
    }
    
    private boolean isAdminAmethyst(ItemStack item) {
        if (item == null) return false;
        String type = plugin.getAmethystManager().getAmethystType(item);
        return "admin".equals(type);
    }
}