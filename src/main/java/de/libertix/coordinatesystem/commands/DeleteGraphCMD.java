package de.libertix.coordinatesystem.commands;

import de.libertix.coordinatesystem.CoordinateSystem;
import de.libertix.coordinatesystem.graph.Graph;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.block.BlockFace;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class DeleteGraphCMD implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player player = (Player) sender;
        Location playerLocation = player.getLocation();
        Location blockLocation = playerLocation.subtract(0, 1, 0).getBlock().getLocation();

        int argsCount = args.length;

        Graph graph;

        switch (argsCount) {
            case 0:
                 graph = CoordinateSystem.graphCollection.findGraph(blockLocation);

                if (graph != null) {
                    player.sendMessage("§aGraph #" + graph.getId() + " successfully localized and deleted!");
                    graph.delete();
                } else {
                    player.sendMessage("§cThe block you are standing at is not a part of a graph. ("+ blockLocation.toString() + ")");
                }
                return true;

            case 3:
                 graph = CoordinateSystem.graphCollection.findGraph(blockLocation);

                if (graph != null) {
                    player.sendMessage("§aGraph #" + graph.getId() + " successfully localized and deleted!");
                    graph.delete();
                } else {
                    player.sendMessage("§cThe block you are standing at is not a part of a graph. ("+ blockLocation.toString() + ")");
                }
                return true;
        }



        return false;
        }

    }
