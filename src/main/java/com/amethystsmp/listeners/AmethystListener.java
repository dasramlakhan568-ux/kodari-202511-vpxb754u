package com.amethystsmp.listeners;

import com.amethystsmp.AmethystSMP;
import com.amethystsmp.powers.*;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class AmethystListener implements Listener {
    private final AmethystSMP plugin;
    
    public AmethystListener(AmethystSMP plugin) {
        this.plugin = plugin;
    }
    
    @EventHandler
    public void onAmethystUse(PlayerInteractEvent event) {
        if (event.getAction() != Action.RIGHT_CLICK_AIR && event.getAction() != Action.RIGHT_CLICK_BLOCK) return;
        
        Player player = event.getPlayer();
        ItemStack item = event.getItem();
        
        if (!plugin.getAmethystManager().isAmethyst(item)) return;
        
        String type = plugin.getAmethystManager().getAmethystType(item);
        if (type == null) return;
        
        if (type.equals("admin")) return;
        
        if (plugin.getCooldownManager().hasCooldown(player, type)) {
            int remaining = plugin.getCooldownManager().getRemainingCooldown(player, type);
            player.sendActionBar(ChatColor.RED + "⏰ Cooldown: " + remaining + "s");
            event.setCancelled(true);
            return;
        }
        
        event.setCancelled(true);
        
        AmethystPower power = getPowerForType(type);
        if (power != null) {
            power.activate(player);
            plugin.getCooldownManager().setCooldown(player, type, power.getCooldown());
        }
    }
    
    private AmethystPower getPowerForType(String type) {
        switch (type) {
            case "pure":
                return new PurePower();
            case "blazing":
                return new BlazingPower();
            case "frost":
                return new FrostPower();
            case "storm":
                return new StormPower();
            case "nature":
                return new NaturePower();
            case "shadow":
                return new ShadowPower();
            case "wind":
                return new WindPower();
            case "blood":
                return new BloodPower(plugin);
            case "sonic":
                return new SonicPower();
            case "time":
                return new TimePower();
            default:
                return null;
        }
    }
}