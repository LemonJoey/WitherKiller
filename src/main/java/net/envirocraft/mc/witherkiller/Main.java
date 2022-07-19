package net.envirocraft.mc.witherkiller;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Main extends JavaPlugin {
    public static Main plugin;

    @Override
    public void onEnable() {
        plugin = this;
        getServer().getLogger().info("WitherKiller succesfully started");
        Objects.requireNonNull(getCommand("witherkiller")).setExecutor(new Wkcmd());
        Objects.requireNonNull(getCommand("witherkiller")).setTabCompleter(new Tabcomplete());
    }

    @Override
    public void onDisable() {
        getServer().getLogger().info("WitherKiller successfully shutdown");
    }
}
