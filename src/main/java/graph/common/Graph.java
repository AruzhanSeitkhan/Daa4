package graph.common;

import java.util.*;

public class Graph {
    public int n;
    public boolean directed;
    public List<List<Edge>> adj;

    public Graph(int n, boolean directed) {
        this.n = n;
        this.directed = directed;
        adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v, int w) {
        if (u >= n || v >= n) {
            System.err.println(" Invalid edge: " + u + " → " + v + " (n=" + n + ")");
            return;
        }
        adj.get(u).add(new Edge(u, v, w));
        if (!directed) adj.get(v).add(new Edge(v, u, w));
    }

    public static class Edge {
        public int from, to, weight;
        public Edge(int f, int t, int w) {
            this.from = f;
            this.to = t;
            this.weight = w;
        }
    }
}
