package graph.scc;

import graph.common.Graph;
import java.util.*;

public class TarjanSCC {
    private final Graph g;
    private int time = 0;
    private int[] disc, low;
    private boolean[] stackMember;
    private Stack<Integer> stack;
    public List<List<Integer>> components = new ArrayList<>();

    public TarjanSCC(Graph g) {
        this.g = g;
        disc = new int[g.n];
        low = new int[g.n];
        stackMember = new boolean[g.n];
        stack = new Stack<>();
        Arrays.fill(disc, -1);
    }

    public void run() {
        for (int i = 0; i < g.n; i++)
            if (disc[i] == -1)
                dfs(i);
    }

    private void dfs(int u) {
        disc[u] = low[u] = ++time;
        stack.push(u);
        stackMember[u] = true;

        for (Graph.Edge e : g.adj.get(u)) {
            int v = e.to;
            if (disc[v] == -1) {
                dfs(v);
                low[u] = Math.min(low[u], low[v]);
            } else if (stackMember[v]) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }

        if (low[u] == disc[u]) {
            List<Integer> comp = new ArrayList<>();
            while (true) {
                int v = stack.pop();
                stackMember[v] = false;
                comp.add(v);
                if (v == u) break;
            }
            components.add(comp);
        }
    }
}
