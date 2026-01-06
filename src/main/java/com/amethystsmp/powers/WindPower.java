package com.amethystsmp.powers;

import org.bukkit.ChatColor;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

public class WindPower implements AmethystPower {
    
    @Override
    public void activate(Player player) {
        player.setVelocity(player.getVelocity().add(new Vector(0, 1.2, 0)));
        
        player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_FALLING, 200, 0));
        
        for (Entity entity : player.getNearbyEntities(5, 5, 5)) {
            if (entity instanceof LivingEntity && !(entity.equals(player))) {
                Vector push = entity.getLocation().toVector().subtract(player.getLocation().toVector()).normalize().multiply(1.5);
                entity.setVelocity(push);
            }
        }
        
        player.sendActionBar(ChatColor.WHITE + "💨 Wind Amethyst activated!");
        player.playSound(player.getLocation(), Sound.ITEM_ELYTRA_FLYING, 1.0f, 1.5f);
        player.getWorld().spawnParticle(Particle.CLOUD, player.getLocation().add(0, 1, 0), 40, 1, 0.5, 1, 0.1);
    }
    
    @Override
    public int getCooldown() {
        return 85;
    }
}