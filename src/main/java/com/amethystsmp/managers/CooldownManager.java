package com.amethystsmp.managers;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class CooldownManager {
    private final Map<UUID, Map<String, Long>> cooldowns = new HashMap<>();
    
    public void setCooldown(Player player, String amethystType, int seconds) {
        UUID uuid = player.getUniqueId();
        cooldowns.putIfAbsent(uuid, new HashMap<>());
        cooldowns.get(uuid).put(amethystType, System.currentTimeMillis() + (seconds * 1000L));
    }
    
    public boolean hasCooldown(Player player, String amethystType) {
        UUID uuid = player.getUniqueId();
        if (!cooldowns.containsKey(uuid)) return false;
        if (!cooldowns.get(uuid).containsKey(amethystType)) return false;
        
        return cooldowns.get(uuid).get(amethystType) > System.currentTimeMillis();
    }
    
    public int getRemainingCooldown(Player player, String amethystType) {
        UUID uuid = player.getUniqueId();
        if (!cooldowns.containsKey(uuid)) return 0;
        if (!cooldowns.get(uuid).containsKey(amethystType)) return 0;
        
        long remaining = cooldowns.get(uuid).get(amethystType) - System.currentTimeMillis();
        return remaining > 0 ? (int) (remaining / 1000) : 0;
    }
    
    public void removeCooldown(Player player, String amethystType) {
        UUID uuid = player.getUniqueId();
        if (cooldowns.containsKey(uuid)) {
            cooldowns.get(uuid).remove(amethystType);
        }
    }
}