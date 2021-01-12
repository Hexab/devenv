package gg.lark.devenv.feature.impl;

import gg.lark.devenv.DevEnvPlugin;
import gg.lark.devenv.feature.Feature;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class NoCreaturesFeature extends Feature {

    private final Listener listener = new Listener() {
        @EventHandler
        public void onCreatureSpawn(CreatureSpawnEvent event) {
            if(event.getSpawnReason() != CreatureSpawnEvent.SpawnReason.NATURAL) return;

            event.setCancelled(true);
        }
    };

    @Override
    public void enable() {
        Bukkit.getServer().getPluginManager().registerEvents(this.listener, DevEnvPlugin.getPlugin());
    }

    @Override
    public void disable() {
        HandlerList.unregisterAll(this.listener);
    }

    @Override
    public String getName() {
        return "nocreaturessss";
    }

}
