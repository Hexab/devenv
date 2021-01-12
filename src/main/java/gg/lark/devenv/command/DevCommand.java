package gg.lark.devenv.command;

import gg.lark.devenv.feature.Feature;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class DevCommand implements CommandExecutor, TabCompleter {

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(args.length == 0) {
            this.sendHelpMessage(sender);
            return false;
        }

        if(args.length > 1) {

            if(args[0].equalsIgnoreCase("feature")) {

                if(args[1].equalsIgnoreCase("toggle")) {

                    if(args.length < 3) {
                        this.sendHelpMessage(sender);
                        return false;
                    }

                    Optional<Feature> hasFeature = Feature.features.stream().filter(feature1 -> feature1.getName().equalsIgnoreCase(args[2])).findFirst();

                    if(!hasFeature.isPresent()) {
                        sender.sendMessage(ChatColor.RED + "This feature doesn't exist");
                        return false;
                    }

                    Feature feature = hasFeature.get();
                    feature.enabled = !feature.enabled;

                    if(feature.enabled) {
                        feature.enable();
                    } else {
                        feature.disable();
                    }

                    sender.sendMessage(
                            ChatColor.YELLOW + "Feature " + feature.getName() + " has been " + (feature.enabled ? ChatColor.GREEN + "enabled" : ChatColor.RED + "disabled"));

                    return false;
                }

                if(args[1].equalsIgnoreCase("list")) {
                    this.listFeatures(sender);
                    return false;
                }

                this.sendHelpMessage(sender);
                return false;
            }

            this.sendHelpMessage(sender);
            return false;
        }

        this.sendHelpMessage(sender);
        return false;
    }

    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if(args.length == 1) return Collections.singletonList("feature");
        if(args.length == 2 && args[0].equalsIgnoreCase("feature")) return Arrays.asList("list", "toggle");
        if(args.length == 3 && args[1].equalsIgnoreCase("toggle")) return Feature.features.stream().map(Feature::getName).collect(Collectors.toList());

        return Collections.emptyList();
    }

    private void sendHelpMessage(CommandSender sender) {
        sender.sendMessage(ChatColor.YELLOW + "/dev feature list " + ChatColor.WHITE + "- " + ChatColor.GRAY + "Lists all available features");
        sender.sendMessage(ChatColor.YELLOW + "/dev feature toggle <feature> " + ChatColor.WHITE + "- " + ChatColor.GRAY + "Toggles a feature");
    }

    private void listFeatures(CommandSender sender) {
        Feature.features.forEach(feature -> {
            sender.sendMessage("- " + (feature.enabled ? ChatColor.GREEN : ChatColor.RED) + feature.getName());
        });
    }

}
