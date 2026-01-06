package com.amethystsmp.powers;

import org.bukkit.ChatColor;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class TimePower implements AmethystPower {
    
    @Override
    public void activate(Player player) {
        for (Entity entity : player.getNearbyEntities(10, 10, 10)) {
            if (entity instanceof LivingEntity && !(entity instanceof Player)) {
                LivingEntity mob = (LivingEntity) entity;
                mob.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100, 3));
                mob.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 100, 2));
            }
        }
        
        player.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 400, 1));
        
        player.sendActionBar(ChatColor.DARK_PURPLE + "⏰ Time Amethyst activated!");
        player.playSound(player.getLocation(), Sound.BLOCK_PORTAL_AMBIENT, 1.0f, 1.8f);
        player.getWorld().spawnParticle(Particle.PORTAL, player.getLocation().add(0, 1, 0), 80, 2, 1, 2, 0.5);
    }
    
    @Override
    public int getCooldown() {
        return 130;
    }
}