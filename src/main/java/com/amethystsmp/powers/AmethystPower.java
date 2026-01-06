package com.amethystsmp.powers;

import org.bukkit.entity.Player;

public interface AmethystPower {
    void activate(Player player);
    int getCooldown();
}