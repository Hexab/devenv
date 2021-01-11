package gg.lark.devenv.feature.impl;

import gg.lark.devenv.feature.Feature;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class NoHungerFeature implements Feature {

    private final Listener listener = new Listener() {
        @EventHandler
        public void onFoodLevelChange(FoodLevelChangeEvent event) {
            event.setCancelled(true);
        }
    };

    public void enable() {
        Bukkit.getServer().getPluginManager().registerEvents(this.listener, this.getPlugin());
    }

    public void disable() {
        HandlerList.unregisterAll(this.listener);
    }

}
