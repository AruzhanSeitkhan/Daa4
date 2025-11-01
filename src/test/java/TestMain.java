import graph.common.*;
import graph.dagsp.*;
import java.util.*;
import java.io.File;

public class TestMain {
    public static void main(String[] args) {
        String[] files = {"data/small.json", "data/medium.json", "data/large.json"};

        for (String path : files) {
            File f = new File(path);
            if (!f.exists()) {
                System.out.println("File not found: " + path);
                continue;
            }

            System.out.println("\n= FILE: " + path + " =");
            List<Graph> graphs = JSONGraphReader.readMultipleGraphs(path);

            int i = 1;
            for (Graph g : graphs) {
                System.out.println("\n- Dataset " + i + " -");
                DAGPaths.shortestPaths(g, 0);
                DAGPaths.longestPath(g, 0);
                i++;
            }
        }
    }
}
