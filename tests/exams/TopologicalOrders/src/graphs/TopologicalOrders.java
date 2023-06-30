package graphs;

import java.util.*;
// GPT ?
public class TopologicalOrders {

    public static Set<DirectedEdge> minimumEdgeSetToRemove(DirectedGraph g, List<Integer> requestedTopologicalOrder) {
        Set<DirectedEdge> minimumEdgeSet = new HashSet<>();
        List<Integer> topologicalOrder = findTopologicalOrder(g);

        if (topologicalOrder.isEmpty()) {
            // Graph contains a cycle, no topological order possible
            return minimumEdgeSet;
        }

        int[] positions = new int[g.getNumVertices()];
        for (int i = 0; i < topologicalOrder.size(); i++) {
            positions[topologicalOrder.get(i)] = i;
        }

        for (int i = 1; i < requestedTopologicalOrder.size(); i++) {
            int currVertex = requestedTopologicalOrder.get(i);
            int prevVertex = requestedTopologicalOrder.get(i - 1);

            if (positions[currVertex] < positions[prevVertex]) {
                // Edge needed to maintain the topological order
                minimumEdgeSet.add(new DirectedEdge(prevVertex, currVertex));
            }
        }

        return minimumEdgeSet;
    }

    public static int topologicalOrderCount(DirectedGraph g) {
        int[] inDegree = new int[g.getNumVertices()];
        for (DirectedEdge edge : g.getEdges()) {
            inDegree[edge.getTo()]++;
        }

        List<Integer> topologicalOrder = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int vertex = 0; vertex < g.getNumVertices(); vertex++) {
            if (inDegree[vertex] == 0) {
                queue.offer(vertex);
            }
        }

        int count = 0;
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            topologicalOrder.add(vertex);

            for (DirectedEdge edge : g.getOutgoingEdges(vertex)) {
                int to = edge.getTo();
                inDegree[to]--;

                if (inDegree[to] == 0) {
                    queue.offer(edge.getTo());
                }
            }

            count++;
        }

        // If graph contains a cycle, no topological order possible
        if (count != g.getNumVertices()) {
            return 0;
        }

        return count; // or return topologicalOrder.size() for the list of topological orders
    }

    // Helper method to find a topological order using depth-first search
    private static List<Integer> findTopologicalOrder(DirectedGraph g) {
        List<Integer> topologicalOrder = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();

        for (int vertex = 0; vertex < g.getNumVertices(); vertex++) {
            if (!visited.contains(vertex)) {
                dfs(vertex, visited, topologicalOrder, g);
            }
        }

        Collections.reverse(topologicalOrder);
        return topologicalOrder;
    }

    private static void dfs(int vertex, Set<Integer> visited, List<Integer> topologicalOrder, DirectedGraph g) {
        visited.add(vertex);

        for (DirectedEdge edge : g.getOutgoingEdges(vertex)) {
            int neighbor = edge.getTo();
            if (!visited.contains(neighbor)) {
                dfs(neighbor, visited, topologicalOrder, g);
            }
        }

        topologicalOrder.add(vertex);
    }
}
