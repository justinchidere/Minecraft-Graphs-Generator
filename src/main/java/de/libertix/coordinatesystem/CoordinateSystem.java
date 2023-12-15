package de.libertix.coordinatesystem;

import de.libertix.coordinatesystem.commands.DeleteGraphCMD;
import de.libertix.coordinatesystem.commands.SpawnGraphCMD;
import de.libertix.coordinatesystem.graph.GraphCollection;
import de.libertix.coordinatesystem.listeners.OnJoin;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class CoordinateSystem extends JavaPlugin {
    public static Plugin plugin;
    public static GraphCollection graphCollection;

    @Override
    public void onEnable() {
        plugin = this;
        graphCollection = new GraphCollection();

        Bukkit.getPluginManager().registerEvents(new OnJoin(), this);
        this.getCommand("spawnGraph").setExecutor(new SpawnGraphCMD());
        this.getCommand("deleteGraph").setExecutor(new DeleteGraphCMD());
    }

    @Override
    public void onDisable() {
    }
}
