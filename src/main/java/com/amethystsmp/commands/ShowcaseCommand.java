package com.amethystsmp.commands;

import com.amethystsmp.AmethystSMP;
import com.amethystsmp.gui.ShowcaseGUI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ShowcaseCommand implements CommandExecutor {
    private final AmethystSMP plugin;
    
    public ShowcaseCommand(AmethystSMP plugin) {
        this.plugin = plugin;
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("Only players can use this command!");
            return true;
        }
        
        Player player = (Player) sender;
        ShowcaseGUI gui = new ShowcaseGUI(plugin);
        gui.open(player);
        
        return true;
    }
}