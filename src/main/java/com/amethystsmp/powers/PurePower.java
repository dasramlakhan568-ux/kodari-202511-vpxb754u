package com.amethystsmp.powers;

import org.bukkit.ChatColor;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class PurePower implements AmethystPower {
    
    @Override
    public void activate(Player player) {
        player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 200, 0));
        
        AttributeInstance maxHealth = player.getAttribute(Attribute.GENERIC_MAX_HEALTH);
        double originalMax = maxHealth.getBaseValue();
        maxHealth.setBaseValue(originalMax + 4);
        
        if (player.getHealth() + 4 <= originalMax + 4) {
            player.setHealth(player.getHealth() + 4);
        }
        
        player.sendActionBar(ChatColor.LIGHT_PURPLE + "✨ Pure Amethyst activated!");
        player.playSound(player.getLocation(), Sound.BLOCK_AMETHYST_BLOCK_CHIME, 1.0f, 1.5f);
        player.getWorld().spawnParticle(Particle.ENCHANTMENT_TABLE, player.getLocation().add(0, 1, 0), 30, 0.5, 0.5, 0.5, 1);
        
        new BukkitRunnable() {
            @Override
            public void run() {
                maxHealth.setBaseValue(originalMax);
                if (player.getHealth() > originalMax) {
                    player.setHealth(originalMax);
                }
            }
        }.runTaskLater(org.bukkit.Bukkit.getPluginManager().getPlugin("AmethystSMP"), 3600L);
    }
    
    @Override
    public int getCooldown() {
        return 70;
    }
}