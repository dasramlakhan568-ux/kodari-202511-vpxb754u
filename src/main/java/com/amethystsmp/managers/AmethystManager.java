package com.amethystsmp.managers;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AmethystManager {
    
    public ItemStack createAmethyst(String type) {
        switch (type.toLowerCase()) {
            case "pure":
                return createPureAmethyst();
            case "blazing":
                return createBlazingAmethyst();
            case "frost":
                return createFrostAmethyst();
            case "storm":
                return createStormAmethyst();
            case "nature":
                return createNatureAmethyst();
            case "shadow":
                return createShadowAmethyst();
            case "wind":
                return createWindAmethyst();
            case "blood":
                return createBloodAmethyst();
            case "sonic":
                return createSonicAmethyst();
            case "time":
                return createTimeAmethyst();
            case "admin":
                return createAdminAmethyst();
            default:
                return null;
        }
    }
    
    private ItemStack createPureAmethyst() {
        ItemStack item = new ItemStack(Material.AMETHYST_SHARD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Pure Amethyst");
        
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.GRAY + "A beginner's magical shard");
        lore.add("");
        lore.add(ChatColor.GOLD + "Powers:");
        lore.add(ChatColor.YELLOW + "• Heart Boost for 3 minutes");
        lore.add(ChatColor.YELLOW + "• Speed I for 10 seconds");
        lore.add("");
        lore.add(ChatColor.DARK_GRAY + "Cooldown: 70 seconds");
        
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        
        return item;
    }
    
    private ItemStack createBlazingAmethyst() {
        ItemStack item = new ItemStack(Material.AMETHYST_SHARD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "Blazing Amethyst");
        
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.GRAY + "Infused with eternal flame");
        lore.add("");
        lore.add(ChatColor.GOLD + "Powers:");
        lore.add(ChatColor.YELLOW + "• Fire Resistance for 15 seconds");
        lore.add(ChatColor.YELLOW + "• Fire Burst around you");
        lore.add("");
        lore.add(ChatColor.DARK_GRAY + "Cooldown: 90 seconds");
        
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        
        return item;
    }
    
    private ItemStack createFrostAmethyst() {
        ItemStack item = new ItemStack(Material.AMETHYST_SHARD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + "Frost Amethyst");
        
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.GRAY + "Cold as eternal ice");
        lore.add("");
        lore.add(ChatColor.GOLD + "Powers:");
        lore.add(ChatColor.YELLOW + "• Freeze nearby mobs for 3 seconds");
        lore.add(ChatColor.YELLOW + "• Slowness immunity for 10 seconds");
        lore.add("");
        lore.add(ChatColor.DARK_GRAY + "Cooldown: 100 seconds");
        
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        
        return item;
    }
    
    private ItemStack createStormAmethyst() {
        ItemStack item = new ItemStack(Material.AMETHYST_SHARD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.BLUE + "" + ChatColor.BOLD + "Storm Amethyst");
        
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.GRAY + "Holds the power of thunder");
        lore.add("");
        lore.add(ChatColor.GOLD + "Powers:");
        lore.add(ChatColor.YELLOW + "• Call lightning strike");
        lore.add(ChatColor.YELLOW + "• Strength I for 10 seconds");
        lore.add("");
        lore.add(ChatColor.DARK_GRAY + "Cooldown: 110 seconds");
        
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        
        return item;
    }
    
    private ItemStack createNatureAmethyst() {
        ItemStack item = new ItemStack(Material.AMETHYST_SHARD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.GREEN + "" + ChatColor.BOLD + "Nature Amethyst");
        
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.GRAY + "Blessed by nature's grace");
        lore.add("");
        lore.add(ChatColor.GOLD + "Powers:");
        lore.add(ChatColor.YELLOW + "• Regeneration II for 8 seconds");
        lore.add(ChatColor.YELLOW + "• Remove poison and wither");
        lore.add("");
        lore.add(ChatColor.DARK_GRAY + "Cooldown: 80 seconds");
        
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        
        return item;
    }
    
    private ItemStack createShadowAmethyst() {
        ItemStack item = new ItemStack(Material.AMETHYST_SHARD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "Shadow Amethyst");
        
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.GRAY + "Shrouded in darkness");
        lore.add("");
        lore.add(ChatColor.GOLD + "Powers:");
        lore.add(ChatColor.YELLOW + "• Invisibility for 15 seconds");
        lore.add(ChatColor.YELLOW + "• Night Vision for 15 seconds");
        lore.add(ChatColor.YELLOW + "• Blink teleport (5 blocks)");
        lore.add("");
        lore.add(ChatColor.DARK_GRAY + "Cooldown: 95 seconds");
        
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        
        return item;
    }
    
    private ItemStack createWindAmethyst() {
        ItemStack item = new ItemStack(Material.AMETHYST_SHARD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.WHITE + "" + ChatColor.BOLD + "Wind Amethyst");
        
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.GRAY + "Swift as the wind itself");
        lore.add("");
        lore.add(ChatColor.GOLD + "Powers:");
        lore.add(ChatColor.YELLOW + "• Double jump boost");
        lore.add(ChatColor.YELLOW + "• Slow falling for 10 seconds");
        lore.add(ChatColor.YELLOW + "• Push enemies away");
        lore.add("");
        lore.add(ChatColor.DARK_GRAY + "Cooldown: 85 seconds");
        
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        
        return item;
    }
    
    private ItemStack createBloodAmethyst() {
        ItemStack item = new ItemStack(Material.AMETHYST_SHARD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Blood Amethyst");
        
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.GRAY + "Drains life from enemies");
        lore.add("");
        lore.add(ChatColor.GOLD + "Powers:");
        lore.add(ChatColor.YELLOW + "• Lifesteal for 10 seconds");
        lore.add(ChatColor.YELLOW + "• +10% attack damage");
        lore.add("");
        lore.add(ChatColor.DARK_GRAY + "Cooldown: 120 seconds");
        
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        
        return item;
    }
    
    private ItemStack createSonicAmethyst() {
        ItemStack item = new ItemStack(Material.AMETHYST_SHARD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + "Sonic Amethyst");
        
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.GRAY + "Speed beyond comprehension");
        lore.add("");
        lore.add(ChatColor.GOLD + "Powers:");
        lore.add(ChatColor.YELLOW + "• Supersonic dash (10 blocks)");
        lore.add(ChatColor.YELLOW + "• Speed IV for 5 seconds");
        lore.add("");
        lore.add(ChatColor.DARK_GRAY + "Cooldown: 75 seconds");
        
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        
        return item;
    }
    
    private ItemStack createTimeAmethyst() {
        ItemStack item = new ItemStack(Material.AMETHYST_SHARD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Time Amethyst");
        
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.GRAY + "Manipulates the flow of time");
        lore.add("");
        lore.add(ChatColor.GOLD + "Powers:");
        lore.add(ChatColor.YELLOW + "• Slow enemies for 5 seconds");
        lore.add(ChatColor.YELLOW + "• Haste II for 20 seconds");
        lore.add("");
        lore.add(ChatColor.DARK_GRAY + "Cooldown: 130 seconds");
        
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        
        return item;
    }
    
    private ItemStack createAdminAmethyst() {
        ItemStack item = new ItemStack(Material.AMETHYST_SHARD);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "✨ " + ChatColor.GOLD + ChatColor.BOLD + "Admin Amethyst" + ChatColor.DARK_PURPLE + ChatColor.BOLD + " ✨");
        
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.GRAY + "" + ChatColor.ITALIC + "The World's Ultimate Power");
        lore.add("");
        lore.add(ChatColor.GOLD + "Legendary Powers:");
        lore.add(ChatColor.YELLOW + "• Temporary Operator Status");
        lore.add(ChatColor.YELLOW + "• Rainbow Particle Aura");
        lore.add("");
        lore.add(ChatColor.RED + "Restrictions:");
        lore.add(ChatColor.DARK_RED + "× Cannot use /ban, /kick, /op");
        lore.add("");
        lore.add(ChatColor.LIGHT_PURPLE + "" + ChatColor.ITALIC + "Only one exists in the world");
        
        meta.setLore(lore);
        meta.addEnchant(Enchantment.LUCK, 10, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        
        return item;
    }
    
    public boolean isAmethyst(ItemStack item) {
        if (item == null || item.getType() != Material.AMETHYST_SHARD) return false;
        if (!item.hasItemMeta()) return false;
        ItemMeta meta = item.getItemMeta();
        if (!meta.hasDisplayName()) return false;
        
        String name = ChatColor.stripColor(meta.getDisplayName()).toLowerCase();
        return name.contains("amethyst");
    }
    
    public String getAmethystType(ItemStack item) {
        if (!isAmethyst(item)) return null;
        
        String name = ChatColor.stripColor(item.getItemMeta().getDisplayName()).toLowerCase();
        
        if (name.contains("pure")) return "pure";
        if (name.contains("blazing")) return "blazing";
        if (name.contains("frost")) return "frost";
        if (name.contains("storm")) return "storm";
        if (name.contains("nature")) return "nature";
        if (name.contains("shadow")) return "shadow";
        if (name.contains("wind")) return "wind";
        if (name.contains("blood")) return "blood";
        if (name.contains("sonic")) return "sonic";
        if (name.contains("time")) return "time";
        if (name.contains("admin")) return "admin";
        
        return null;
    }
    
    public List<String> getAllAmethystTypes() {
        return Arrays.asList("pure", "blazing", "frost", "storm", "nature", "shadow", "wind", "blood", "sonic", "time", "admin");
    }
}