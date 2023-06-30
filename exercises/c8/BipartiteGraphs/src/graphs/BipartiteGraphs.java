package graphs;

public class BipartiteGraphs {
    public static boolean isBipartite(UndirectedGraph g) {
        int n = g.getVertexCount();
        int[] colors = new int[n];
        boolean[] visited = new boolean[n];
        boolean bipartite = true;
        for (int i = 0; i < n && bipartite; i++) {
            if (!visited[i]) {
                bipartite = dfsColor(g, i, colors, visited);
            }
        }
        return bipartite;
    }

    private static boolean dfsColor(UndirectedGraph g, int v, int[] colors, boolean[] visited) {
        visited[v] = true;
        for (int u : g.outgoingEdgesDestinations(v)) {
            if (!visited[u]) {
                colors[u] = 1 - colors[v];
                if (!dfsColor(g, u, colors, visited)) {
                    return false;
                }
            } else if (colors[u] == colors[v]) {
                return false;
            }
        }
        return true;
    }

}
