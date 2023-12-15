package de.libertix.coordinatesystem.commands;

import de.libertix.coordinatesystem.CoordinateSystem;
import de.libertix.coordinatesystem.graph.Graph;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scheduler.BukkitTask;
import org.jetbrains.annotations.NotNull;

public class SpawnGraphCMD implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        Player player = (Player)sender;
        int argsCount = args.length;

        switch (argsCount) {
            case 0:
                new Graph(player.getLocation());
                return true;

            case 1:
                new Graph(player.getLocation(), Integer.parseInt(args[0]), 10, 500).addToGraphCollection(CoordinateSystem.graphCollection);
                return true;

            case 2:
                new Graph(player.getLocation(), Integer.parseInt(args[0]), Integer.parseInt(args[1]), 500).addToGraphCollection(CoordinateSystem.graphCollection);
                return true;

            case 3:
                new Graph(player.getLocation(), Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2])).addToGraphCollection(CoordinateSystem.graphCollection);
                return true;
        }

/*        Location playerLocation = player.getLocation();

        double exponent = Integer.parseInt(args[0]);
        int x0 = playerLocation.getBlockX();
        int y0 = playerLocation.getBlockY();
        int range = 20;

        //Calculate compression (double a) by dividing by 10 until yMax < 1000
        int yMax = (int) Math.pow(x0 + range, 2);
        double a = 1;
        while(yMax * a > 1000) {
            a = a / 10;
        }

        //Generate Graph
        for (int i=-range/2; i<range/2; i++) { // !Bei einem +1 bzw -1 machen!


            int x = i;
            int y = (int) (a * Math.pow(x, exponent));


            Block block = new Location(player.getWorld(), x + x0, y + y0, playerLocation.getBlockZ()).getBlock();
            block.setType(Material.RED_WOOL);
            player.sendMessage("§aNew block placed at " + String.format("x=%s y=%s z=%s", block.getX(), block.getY(), block.getZ()) );

        }

        player.sendMessage("§ax0=" + x0 + " y0="+y0 + "yMax=" + yMax + " compression (a)=" + a + " range=" + range);

 */
        return false;
    }
}
