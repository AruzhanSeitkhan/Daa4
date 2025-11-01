package graph.topo;

import graph.common.Graph;
import java.util.*;

public class KahnTopoSort {
    public static List<Integer> sort(Graph g) {
        int[] indeg = new int[g.n];
        for (int u = 0; u < g.n; u++) {
            for (Graph.Edge e : g.adj.get(u)) indeg[e.to]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < g.n; i++)
            if (indeg[i] == 0) q.add(i);

        List<Integer> order = new ArrayList<>();
        while (!q.isEmpty()) {
            int u = q.poll();
            order.add(u);
            for (Graph.Edge e : g.adj.get(u)) {
                indeg[e.to]--;
                if (indeg[e.to] == 0) q.add(e.to);
            }
        }
        return order;
    }
}
