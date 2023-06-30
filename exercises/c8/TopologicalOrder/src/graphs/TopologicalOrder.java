package graphs;

import java.util.*;

public class TopologicalOrder {

    public static boolean topologicalSort(DirectedGraph g, List<Integer> vertices) {
        int i = 0;
        /* Inicializacia: */
        int n = g.getVertexCount();
        List<Integer> unprocessedPredecessors = new ArrayList<>();
        for (int v = 0; v < n; v++) {
            unprocessedPredecessors.add(0);
        }
        for (int v = 0; v < n; v++) {
            for (int successor : g.outgoingEdgesDestinations(v)) {
                unprocessedPredecessors.set(successor, unprocessedPredecessors.get(successor) + 1);
            }
        }
        ArrayList<Integer> ready = new ArrayList<>();
        for (int v = 0; v < n; v++) {
            if (unprocessedPredecessors.get(v) == 0) {
                ready.add(v);
            }
        }
        List<Integer> result = new LinkedList<>();

        /* Samotne topologicke triedenie: */
        while (!ready.isEmpty()) {
            if(!ready.contains(vertices.get(i))) return false;
            int vertex = ready.remove(ready.indexOf(vertices.get(i)));
            result.add(vertex);
            i++;
            for (int successor : g.outgoingEdgesDestinations(vertex)) {
                unprocessedPredecessors.set(successor, unprocessedPredecessors.get(successor) - 1);
                if (unprocessedPredecessors.get(successor) == 0) {
                    ready.add(successor);
                }
            }
        }
        return result.equals(vertices);
    }

    public static boolean isTopologicalOrder(DirectedGraph g, List<Integer> vertices) {
        if(vertices.size() != g.getVertexCount()) return false;
        return topologicalSort(g, vertices);
    }
}
