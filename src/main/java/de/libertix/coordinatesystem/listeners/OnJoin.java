package de.libertix.coordinatesystem.listeners;

import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class OnJoin implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        event.setJoinMessage("");
        for (Player player : Bukkit.getOnlinePlayers()) {
            player.sendMessage("§aDer Spieler §2" + event.getPlayer().getName() + " §aist jetzt auch dabei.");
        }
    }
}
