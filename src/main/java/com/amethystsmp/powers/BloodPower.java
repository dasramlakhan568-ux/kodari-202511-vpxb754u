package com.amethystsmp.powers;

import com.amethystsmp.AmethystSMP;
import org.bukkit.ChatColor;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class BloodPower implements AmethystPower, Listener {
    private final Set<UUID> activeLifesteal = new HashSet<>();
    private final AmethystSMP plugin;
    
    public BloodPower(AmethystSMP plugin) {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
    
    @Override
    public void activate(Player player) {
        activeLifesteal.add(player.getUniqueId());
        
        AttributeInstance attackDamage = player.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE);
        AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "blood_boost", 0.1, AttributeModifier.Operation.MULTIPLY_SCALAR_1);
        attackDamage.addModifier(modifier);
        
        player.sendActionBar(ChatColor.DARK_RED + "💀 Blood Amethyst activated!");
        player.playSound(player.getLocation(), Sound.ENTITY_ZOMBIE_VILLAGER_CONVERTED, 1.0f, 0.8f);
        player.getWorld().spawnParticle(Particle.REDSTONE, player.getLocation().add(0, 1, 0), 40, 0.5, 1, 0.5, 1);
        
        new BukkitRunnable() {
            @Override
            public void run() {
                activeLifesteal.remove(player.getUniqueId());
                attackDamage.removeModifier(modifier);
            }
        }.runTaskLater(plugin, 200L);
    }
    
    @EventHandler
    public void onDamage(EntityDamageByEntityEvent event) {
        if (!(event.getDamager() instanceof Player)) return;
        if (!(event.getEntity() instanceof LivingEntity)) return;
        
        Player player = (Player) event.getDamager();
        
        if (!activeLifesteal.contains(player.getUniqueId())) return;
        
        double damage = event.getFinalDamage();
        double heal = damage * 0.5;
        
        if (player.getHealth() + heal <= player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue()) {
            player.setHealth(player.getHealth() + heal);
        } else {
            player.setHealth(player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());
        }
        
        player.getWorld().spawnParticle(Particle.HEART, player.getLocation().add(0, 2, 0), 3, 0.5, 0.5, 0.5, 0);
    }
    
    @Override
    public int getCooldown() {
        return 120;
    }
}