package com.amethystsmp.listeners;

import com.amethystsmp.AmethystSMP;
import com.amethystsmp.utils.WeightedRandomSelector;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {
    private final AmethystSMP plugin;
    private final WeightedRandomSelector amethystSelector;
    
    public JoinListener(AmethystSMP plugin) {
        this.plugin = plugin;
        this.amethystSelector = new WeightedRandomSelector();
        
        amethystSelector.addEntry("pure", 40.0);
        amethystSelector.addEntry("blazing", 25.0);
        amethystSelector.addEntry("frost", 15.0);
        amethystSelector.addEntry("storm", 10.0);
        amethystSelector.addEntry("nature", 5.0);
        amethystSelector.addEntry("shadow", 3.0);
        amethystSelector.addEntry("wind", 1.0);
        amethystSelector.addEntry("blood", 0.5);
        amethystSelector.addEntry("sonic", 0.3);
        amethystSelector.addEntry("time", 0.2);
    }
    
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        
        if (!player.hasPlayedBefore()) {
            player.sendTitle(
                ChatColor.YELLOW + "" + ChatColor.BOLD + "WELCOME TO AMETHYST SMP",
                "",
                10, 70, 20
            );
            
            String selectedType = amethystSelector.selectRandom();
            
            player.sendMessage(ChatColor.GOLD + "Enjoy your journey with your first Amethyst!");
            
            player.getInventory().addItem(plugin.getAmethystManager().createAmethyst(selectedType));
        }
    }
}