package graphs;

import java.util.*;

public class IntermediateVertexPaths {
    private List<List<Integer>> paths;
    private DirectedGraph g;
    private int to;
    private List<Integer> intermediateVertices;

    private LinkedList<Integer> path;

    private ArrayList<Boolean> visited;

    public IntermediateVertexPaths(DirectedGraph g, int from, int to, List<Integer> intermediateVertices) {
        this.g = g;
        this.to = to;
        this.intermediateVertices = intermediateVertices;
        paths = new LinkedList<>();

        visited = new ArrayList<>();
        for (int i = 0; i <= g.getVertexCount() - 1; i++) {
            visited.add(false);
        }
        path = new LinkedList<>();
        path.add(from);
        visited.set(from, true);
        search();
    }

    private void search() {
        if (path.getLast() == to) {
            int x = -1;
            for (Integer v : intermediateVertices) {
                if (!path.contains(v)) {
                    return;
                }
                int index = path.indexOf(v);
                if (index <= x) {
                    return;
                } else {
                    x = index;
                }
            }
            paths.add(Collections.unmodifiableList(new LinkedList<>(path)));
        } else {
            for (int successor : g.outgoingEdgesDestinations(path.getLast())) {
                if (!visited.get(successor)) {
                    visited.set(successor, true);
                    path.add(successor);
                    search();
                    path.removeLast();
                    visited.set(successor, false);
                }
            }
        }
    }

    public List<List<Integer>> getPaths() {
        return Collections.unmodifiableList(paths);
    }
}
