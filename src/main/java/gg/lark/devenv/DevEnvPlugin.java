package gg.lark.devenv;

import gg.lark.devenv.command.DevCommand;
import gg.lark.devenv.feature.Feature;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class DevEnvPlugin extends JavaPlugin {

   public static Plugin getPlugin() {
      return JavaPlugin.getPlugin(DevEnvPlugin.class);
   }

   @Override
   public void onEnable() {
      PluginCommand devCommand = this.getCommand("dev");
      devCommand.setExecutor(new DevCommand());
      devCommand.setTabCompleter(new DevCommand());

      Feature.features.forEach(Feature::enable);
   }

}
