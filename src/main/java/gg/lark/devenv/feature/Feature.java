package gg.lark.devenv.feature;

import gg.lark.devenv.DevEnvPlugin;
import org.bukkit.plugin.java.JavaPlugin;

public interface Feature {

    /**
     * Enables the feature
     */
    void enable();

    /**
     * Disables the feature
     */
    void disable();

    /**
     * Gets the instance of the plugin that this is running on (kinda)
     *
     * @return the instance of the plugin
     */
    default JavaPlugin getPlugin() {
        return JavaPlugin.getPlugin(DevEnvPlugin.class);
    }

}
