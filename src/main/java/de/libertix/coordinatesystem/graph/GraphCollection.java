package de.libertix.coordinatesystem.graph;

import org.bukkit.Location;

import java.util.ArrayList;

public class GraphCollection {
    private static ArrayList<Graph> graphs;
    public static int SIZE;

    public GraphCollection() {
        graphs = new ArrayList<Graph>();

    }

    public void addGraph(Graph graph) {
        graphs.add(graph);
    }

    public void removeGraph(Graph graph) {
        graphs.remove(graph);
    }

    public Graph findGraph(Location location) {
        for(Graph graph : graphs) {
            if(graph.containsBlockAt(location)) {
                return graph;
            }
        }
        return null;
    }
}
