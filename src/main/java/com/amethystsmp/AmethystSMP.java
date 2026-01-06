package com.amethystsmp;

import com.amethystsmp.commands.AmethystCommand;
import com.amethystsmp.commands.ShowcaseCommand;
import com.amethystsmp.listeners.AmethystListener;
import com.amethystsmp.listeners.CraftingListener;
import com.amethystsmp.listeners.JoinListener;
import com.amethystsmp.listeners.AdminAmethystListener;
import com.amethystsmp.managers.AmethystManager;
import com.amethystsmp.managers.CooldownManager;
import org.bukkit.plugin.java.JavaPlugin;

public class AmethystSMP extends JavaPlugin {
    private static AmethystSMP instance;
    private AmethystManager amethystManager;
    private CooldownManager cooldownManager;
    
    @Override
    public void onEnable() {
        instance = this;
        
        saveDefaultConfig();
        
        this.amethystManager = new AmethystManager();
        this.cooldownManager = new CooldownManager();
        
        getCommand("am").setExecutor(new AmethystCommand(this));
        getCommand("ams").setExecutor(new ShowcaseCommand(this));
        
        getServer().getPluginManager().registerEvents(new AmethystListener(this), this);
        getServer().getPluginManager().registerEvents(new CraftingListener(this), this);
        getServer().getPluginManager().registerEvents(new JoinListener(this), this);
        getServer().getPluginManager().registerEvents(new AdminAmethystListener(this), this);
        
        getLogger().info("AmethystSMP has been enabled!");
    }
    
    @Override
    public void onDisable() {
        getLogger().info("AmethystSMP has been disabled!");
    }
    
    public static AmethystSMP getInstance() {
        return instance;
    }
    
    public AmethystManager getAmethystManager() {
        return amethystManager;
    }
    
    public CooldownManager getCooldownManager() {
        return cooldownManager;
    }
}