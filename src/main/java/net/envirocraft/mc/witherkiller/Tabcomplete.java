package net.envirocraft.mc.witherkiller;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Tabcomplete implements TabCompleter {

    @Override
    public List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, String @NotNull [] args) {

        Main plugin = Main.plugin;
        List<String> output = new ArrayList<>();

        if (args.length == 0) {
            output.add("check");
            output.add("kill");
            return output;
        }
        if (args.length == 1) {
            if ("check".startsWith(args[0]) && sender.hasPermission("witherkiller.use")) { output.add("check"); }
            if ("kill".startsWith(args[0]) && sender.hasPermission("witherkiller.use")) { output.add("kill"); }
            return output;
        }
        return output;
    }
}
