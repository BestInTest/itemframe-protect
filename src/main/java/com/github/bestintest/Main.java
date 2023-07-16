package com.github.bestintest;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.hanging.HangingBreakEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Collection;

public class Main extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onEntityDamageByEntity(HangingBreakEvent event) {
        Location itemframeLoc =  event.getEntity().getLocation();
        Collection<Entity> nearbyEntites = itemframeLoc.getWorld().getNearbyEntities(itemframeLoc, 1, 1, 1);
        for (Entity e : nearbyEntites) {
            if (e.getType() == EntityType.BOAT || e.getType() == EntityType.CHEST_BOAT) {
                event.setCancelled(true);
            }
        }
    }
}