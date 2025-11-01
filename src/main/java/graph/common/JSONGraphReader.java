package graph.common;

import com.google.gson.*;
import java.io.FileReader;
import java.util.*;

public class JSONGraphReader {

    public static List<Graph> readMultipleGraphs(String path) {
        List<Graph> graphs = new ArrayList<>();

        try (FileReader reader = new FileReader(path)) {
            JsonObject root = JsonParser.parseReader(reader).getAsJsonObject();
            JsonArray datasets = root.getAsJsonArray("datasets");

            for (JsonElement element : datasets) {
                JsonObject dataset = element.getAsJsonObject();

                boolean directed = dataset.get("directed").getAsBoolean();
                int n = dataset.get("n").getAsInt();
                Graph g = new Graph(n, directed);

                JsonArray edges = dataset.getAsJsonArray("edges");
                for (JsonElement edgeElem : edges) {
                    JsonObject edge = edgeElem.getAsJsonObject();
                    int u = edge.get("u").getAsInt();
                    int v = edge.get("v").getAsInt();
                    int w = edge.get("w").getAsInt();
                    g.addEdge(u, v, w);
                }

                graphs.add(g);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return graphs;
    }
}
