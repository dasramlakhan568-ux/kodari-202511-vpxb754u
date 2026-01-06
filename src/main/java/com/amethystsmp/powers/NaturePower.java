package com.amethystsmp.powers;

import org.bukkit.ChatColor;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class NaturePower implements AmethystPower {
    
    @Override
    public void activate(Player player) {
        player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 160, 1));
        
        player.removePotionEffect(PotionEffectType.POISON);
        player.removePotionEffect(PotionEffectType.WITHER);
        
        player.sendActionBar(ChatColor.GREEN + "🌿 Nature Amethyst activated!");
        player.playSound(player.getLocation(), Sound.BLOCK_GRASS_BREAK, 1.0f, 1.5f);
        player.getWorld().spawnParticle(Particle.VILLAGER_HAPPY, player.getLocation().add(0, 1, 0), 50, 0.5, 1, 0.5, 0);
    }
    
    @Override
    public int getCooldown() {
        return 80;
    }
}