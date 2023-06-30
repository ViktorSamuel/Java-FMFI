package graphs;

import java.util.*;

public class VertexSetDistances {
    /**
     * Pole obsahujuce pre kazdu dvojicu vrcholov (u,v) dlzku najkratsej cesty z u do v (alebo -1, ak ziadna neexistuje)
     */
    private int[][] distances;

    public VertexSetDistances(DirectedGraph g) {
        int n = g.getVertexCount();
        distances = new int[n][n];
        for (int u = 0; u <= n - 1; u++) {
            for (int v = 0; v <= n - 1; v++) {
                distances[u][v] = -1;
            }
        }
        // Pre kazdy vrchol u spocitaj dlzky najkratsich ciest z u do vsetkych ostatnych vrcholov:
        for (int u = 0; u <= n - 1; u++) {
            Queue<Integer> queue = new LinkedList<>();
            distances[u][u] = 0;
            queue.add(u);
            while (!queue.isEmpty()) {
                int vertex = queue.remove();
                for (int successor : g.outgoingEdgesDestinations(vertex)) {
                    if (distances[u][successor] == -1) {
                        distances[u][successor] = distances[u][vertex] + 1;
                        queue.add(successor);
                    }
                }
            }
        }
    }

    public int getDistance(Set<Integer> from, Set<Integer> to) {
        int result = -1;
        for (int u : from) {
            for (int v : to) {
                if (distances[u][v] >= 0 && (result == -1 || distances[u][v] < result)) {
                    result = distances[u][v];
                }
            }
        }
        return result;
    }
}