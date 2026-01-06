package com.amethystsmp.utils;

import java.util.*;

public class WeightedRandomSelector {
    
    private final List<WeightedEntry> entries = new ArrayList<>();
    private double totalWeight = 0;
    
    public void addEntry(String value, double weight) {
        if (weight > 0) {
            entries.add(new WeightedEntry(value, weight));
            totalWeight += weight;
        }
    }
    
    public String selectRandom() {
        if (entries.isEmpty()) return null;
        
        double random = Math.random() * totalWeight;
        double currentWeight = 0;
        
        for (WeightedEntry entry : entries) {
            currentWeight += entry.weight;
            if (random <= currentWeight) {
                return entry.value;
            }
        }
        
        return entries.get(entries.size() - 1).value;
    }
    
    private static class WeightedEntry {
        String value;
        double weight;
        
        WeightedEntry(String value, double weight) {
            this.value = value;
            this.weight = weight;
        }
    }
}