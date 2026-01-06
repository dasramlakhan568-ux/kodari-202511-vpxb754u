package com.amethystsmp.powers;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

public class StormPower implements AmethystPower {
    
    @Override
    public void activate(Player player) {
        Location targetLoc = player.getTargetBlock(null, 30).getLocation();
        player.getWorld().strikeLightning(targetLoc);
        
        player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 200, 0));
        
        player.sendActionBar(ChatColor.BLUE + "⚡ Storm Amethyst activated!");
        player.playSound(player.getLocation(), Sound.ENTITY_LIGHTNING_BOLT_THUNDER, 1.0f, 1.0f);
        player.getWorld().spawnParticle(Particle.ELECTRIC_SPARK, player.getLocation().add(0, 1, 0), 40, 0.5, 1, 0.5, 0.2);
    }
    
    @Override
    public int getCooldown() {
        return 110;
    }
}