package net.envirocraft.mc.witherkiller;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wither;
import org.jetbrains.annotations.NotNull;

public class Wkcmd implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {

        if (sender instanceof Player) {
            if (args.length == 0) {
                sender.sendMessage("you can do /witherkiller check or /witherkiller kill to check for or kill withers within 100 blocks of you");
            }
            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("check")) check((Player) sender);
                else if (args[0].equalsIgnoreCase("kill")) kill((Player) sender);
                else
                    sender.sendMessage("you can do /witherkiller check or /witherkiller kill to check for or kill withers within 100 blocks of you");
                return false;
            }
        }
        return true;
    }

    private void check(Player player) {
        int Withers = 0;
        for (Entity entity : player.getNearbyEntities(100, 100, 100)) {
            if (entity instanceof Wither)
                Withers++;
        }
        if (Withers == 0) {
            player.sendMessage("there are 0 Withers within 100 blocks of you");
        }
        if (Withers == 1) {
            player.sendMessage("there is 1 Wither within 100 blocks of you");
        } else if (Withers >= 2) {
            player.sendMessage("there are", String.valueOf(Withers), "Withers within 100 blocks of you");
        }

    }

    private void kill(Player player) {
        int Withers = 0;
        for (Entity entity : player.getNearbyEntities(100, 100, 100)) {
            if (entity instanceof Wither)
                Withers++;
            if (entity instanceof Wither)
                entity.remove();
            }
            if (Withers == 0) {
                player.sendMessage("0 Withers removed");
            }
            if (Withers == 1) {
                player.sendMessage("1 Wither removed");
            } else if (Withers >= 2) {
                player.sendMessage(String.valueOf(Withers), "Withers have been removed");
            }
    }
}




