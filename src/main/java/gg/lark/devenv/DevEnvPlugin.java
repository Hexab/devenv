package gg.lark.devenv;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class DevEnvPlugin extends JavaPlugin {

   public static Plugin getPlugin() {
      return JavaPlugin.getPlugin(DevEnvPlugin.class);
   }

}
