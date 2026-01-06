package com.amethystsmp.powers;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class BlazingPower implements AmethystPower {
    
    @Override
    public void activate(Player player) {
        player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 300, 0));
        
        Location loc = player.getLocation();
        for (Entity entity : player.getNearbyEntities(5, 5, 5)) {
            if (entity instanceof LivingEntity && !(entity instanceof Player)) {
                entity.setFireTicks(100);
            }
        }
        
        player.sendActionBar(ChatColor.RED + "🔥 Blazing Amethyst activated!");
        player.playSound(player.getLocation(), Sound.ITEM_FIRECHARGE_USE, 1.0f, 1.0f);
        player.getWorld().spawnParticle(Particle.FLAME, loc.add(0, 1, 0), 50, 2, 1, 2, 0.1);
    }
    
    @Override
    public int getCooldown() {
        return 90;
    }
}