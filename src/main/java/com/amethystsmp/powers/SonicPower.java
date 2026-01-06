package com.amethystsmp.powers;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

public class SonicPower implements AmethystPower {
    
    @Override
    public void activate(Player player) {
        Vector direction = player.getLocation().getDirection().normalize();
        player.setVelocity(direction.multiply(2.5));
        
        player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100, 3));
        
        player.sendActionBar(ChatColor.GOLD + "⚡ Sonic Amethyst activated!");
        player.playSound(player.getLocation(), Sound.ENTITY_FIREWORK_ROCKET_LAUNCH, 1.0f, 1.5f);
        
        Location particleLoc = player.getLocation().add(0, 1, 0);
        for (int i = 0; i < 10; i++) {
            player.getWorld().spawnParticle(Particle.EXPLOSION_NORMAL, particleLoc, 5, 0.3, 0.3, 0.3, 0.1);
            particleLoc.add(direction.clone().multiply(0.5));
        }
    }
    
    @Override
    public int getCooldown() {
        return 75;
    }
}