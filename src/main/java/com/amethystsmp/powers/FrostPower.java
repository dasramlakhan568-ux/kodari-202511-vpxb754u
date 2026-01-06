package com.amethystsmp.powers;

import org.bukkit.ChatColor;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class FrostPower implements AmethystPower {
    
    @Override
    public void activate(Player player) {
        for (Entity entity : player.getNearbyEntities(8, 8, 8)) {
            if (entity instanceof LivingEntity && !(entity instanceof Player)) {
                LivingEntity mob = (LivingEntity) entity;
                mob.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 60, 10));
                mob.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 60, 128));
            }
        }
        
        player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 200, 0, false, false, false));
        player.removePotionEffect(PotionEffectType.SLOW);
        
        player.sendActionBar(ChatColor.AQUA + "❄ Frost Amethyst activated!");
        player.playSound(player.getLocation(), Sound.BLOCK_GLASS_BREAK, 1.0f, 0.5f);
        player.getWorld().spawnParticle(Particle.SNOWFLAKE, player.getLocation().add(0, 1, 0), 60, 3, 1, 3, 0.1);
    }
    
    @Override
    public int getCooldown() {
        return 100;
    }
}