package graph.dagsp;

import graph.common.Graph;
import graph.topo.KahnTopoSort;
import java.util.*;

public class DAGPaths {

    public static void shortestPaths(Graph g, int src) {
        List<Integer> order = KahnTopoSort.sort(g);
        int INF = 1000000;
        int[] dist = new int[g.n];
        Arrays.fill(dist, INF);
        dist[src] = 0;

        for (int u : order) {
            if (dist[u] != INF) {
                for (Graph.Edge e : g.adj.get(u)) {
                    if (dist[e.to] > dist[u] + e.weight)
                        dist[e.to] = dist[u] + e.weight;
                }
            }
        }

        System.out.println("Shortest distances:");
        for (int i = 0; i < g.n; i++)
            System.out.println("From " + src + " to " + i + " = " +
                    (dist[i] == INF ? "∞" : dist[i]));
    }

    public static void longestPath(Graph g, int src) {
        List<Integer> order = KahnTopoSort.sort(g);
        int NEG_INF = -1000000;
        int[] dist = new int[g.n];
        Arrays.fill(dist, NEG_INF);
        dist[src] = 0;

        for (int u : order) {
            if (dist[u] != NEG_INF) {
                for (Graph.Edge e : g.adj.get(u)) {
                    if (dist[e.to] < dist[u] + e.weight)
                        dist[e.to] = dist[u] + e.weight;
                }
            }
        }

        System.out.println("Longest distances:");
        for (int i = 0; i < g.n; i++)
            System.out.println("From " + src + " to " + i + " = " +
                    (dist[i] == NEG_INF ? "∞" : dist[i]));
    }
}
