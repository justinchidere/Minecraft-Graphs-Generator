package de.libertix.coordinatesystem.graph;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;

public class Graph {
    private int id;
    private Block[] blocks;
    private double exponent;
    private double compression;
    private int blockCount;


    public Graph(Location location) {
        generate(location, 1, 10, 512);
    }

    public Graph(Location location, double exponent) {
        generate(location, exponent, 10, 512);
    }
    public Graph(Location location, double exponent, int range) {
        generate(location, exponent, range, 512);
    }

    public Graph(Location location, double exponent, int range, int maxYValueBeforeCompression) {
        generate(location, exponent, range, maxYValueBeforeCompression);
    }

    public Graph(Block[] blocks, double exponent, double compression) {
        this.id = id < 1 ? id + 1 : 1;
        this.blocks = blocks;
        this.exponent = exponent;
        this.compression = compression;
        this.blockCount = this.blocks.length;
    }

    private void generate(Location playerLocation, double exponent, int range, int maxYValueBeforeCompression) {

        int x0 = playerLocation.getBlockX();
        int y0 = playerLocation.getBlockY();

        //Calculate compression (double a) by dividing by 10 until yMax < 500
        int yMax = (int) Math.pow(range/2, exponent);
        double a = 1;
        while(yMax * a > maxYValueBeforeCompression) {
            a = a / 10;
            Bukkit.getConsoleSender().sendMessage(a + "");
        }

        //Generate Graph
        for (int i=-(range/2); i<range/2; i++) { // !Bei einem +1 bzw -1 machen!


            int x = i;
            int y = (int) (a * Math.pow(x, exponent));


            Block block = new Location(playerLocation.getWorld(), x + x0, y + y0, playerLocation.getBlockZ()).getBlock();
            block.setType(Material.RED_WOOL);
            //player.sendMessage("§aBlock placed at " + String.format("x=%s y=%s z=%s", block.getX(), block.getY(), block.getZ()) );

        }

        //player.sendMessage("§ax0=" + x0 + " y0="+y0 + "yMax=" + yMax + " compression (a)=" + a + " range=" + range);
    }

    public void delete() {
        for (Block block : blocks) {
            block.setType(Material.AIR);
        }
    }

    public void addToGraphCollection(GraphCollection graphCollection) {
        graphCollection.addGraph(this);
    }

    public boolean containsBlockAt(Location location) {
        for (Block block : blocks) {
            if(block.getLocation() == location) {
                return true;
            }
        }

        return false;
    }

    public int getId() {
        return id;
    }


    public double getExponent() {
        return exponent;
    }

    public double getCompression() {
        return compression;
    }

    public int getBlockCount() {
        return blockCount;
    }

}
