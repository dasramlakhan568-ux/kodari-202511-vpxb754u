package com.amethystsmp.commands;

import com.amethystsmp.AmethystSMP;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class AmethystCommand implements CommandExecutor {
    private final AmethystSMP plugin;
    
    public AmethystCommand(AmethystSMP plugin) {
        this.plugin = plugin;
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission("amethystsmp.admin")) {
            sender.sendMessage(ChatColor.RED + "You don't have permission to use this command!");
            return true;
        }
        
        if (args.length == 0) {
            sender.sendMessage(ChatColor.GOLD + "=== Amethyst Commands ===");
            sender.sendMessage(ChatColor.YELLOW + "/am give <player> <type> - Give an amethyst");
            sender.sendMessage(ChatColor.YELLOW + "/am recipe on admin - Enable Admin Amethyst recipe");
            return true;
        }
        
        if (args[0].equalsIgnoreCase("give")) {
            if (args.length < 3) {
                sender.sendMessage(ChatColor.RED + "Usage: /am give <player> <type>");
                return true;
            }
            
            Player target = Bukkit.getPlayer(args[1]);
            if (target == null) {
                sender.sendMessage(ChatColor.RED + "Player not found!");
                return true;
            }
            
            String type = args[2].toLowerCase();
            ItemStack amethyst = plugin.getAmethystManager().createAmethyst(type);
            
            if (amethyst == null) {
                sender.sendMessage(ChatColor.RED + "Invalid amethyst type!");
                return true;
            }
            
            target.getInventory().addItem(amethyst);
            sender.sendMessage(ChatColor.GREEN + "Gave " + args[2] + " amethyst to " + target.getName());
            target.sendMessage(ChatColor.LIGHT_PURPLE + "You received a " + args[2] + " amethyst!");
            
            return true;
        }
        
        if (args[0].equalsIgnoreCase("recipe")) {
            if (args.length < 3 || !args[1].equalsIgnoreCase("on") || !args[2].equalsIgnoreCase("admin")) {
                sender.sendMessage(ChatColor.RED + "Usage: /am recipe on admin");
                return true;
            }
            
            plugin.getConfig().set("admin-amethyst-recipe-enabled", true);
            plugin.saveConfig();
            
            sender.sendMessage(ChatColor.GREEN + "Admin Amethyst recipe has been enabled!");
            sender.sendMessage(ChatColor.YELLOW + "It can only be crafted once, then it will be disabled permanently.");
            
            return true;
        }
        
        return true;
    }
}