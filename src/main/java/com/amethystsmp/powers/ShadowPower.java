package com.amethystsmp.powers;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

public class ShadowPower implements AmethystPower {
    
    @Override
    public void activate(Player player) {
        player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 300, 0));
        player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 300, 0));
        
        Vector direction = player.getLocation().getDirection().normalize();
        Location teleportLoc = player.getLocation().add(direction.multiply(5));
        
        if (teleportLoc.getBlock().isPassable() && teleportLoc.clone().add(0, 1, 0).getBlock().isPassable()) {
            player.getWorld().spawnParticle(Particle.SMOKE_LARGE, player.getLocation().add(0, 1, 0), 20, 0.3, 0.5, 0.3, 0.05);
            player.teleport(teleportLoc);
            player.getWorld().spawnParticle(Particle.SMOKE_LARGE, teleportLoc.add(0, 1, 0), 20, 0.3, 0.5, 0.3, 0.05);
        }
        
        player.sendActionBar(ChatColor.DARK_GRAY + "👁 Shadow Amethyst activated!");
        player.playSound(player.getLocation(), Sound.ENTITY_ENDERMAN_TELEPORT, 1.0f, 0.8f);
    }
    
    @Override
    public int getCooldown() {
        return 95;
    }
}