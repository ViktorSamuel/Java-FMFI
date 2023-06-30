package graphs;

import java.util.*;
// NEFUNGUJE
public class MinimumDominatingSet {

    private UndirectedGraph g;
    private Set<Set<Integer>> minSets = new HashSet<>();
    private Set<Integer> minSet = null;
    private Set<Integer> ptmSet;
    private List<Boolean> visited;

    private void search(int vertex) {
        boolean allVisited = true;
        for (int i = 0; i < g.getVertexCount(); i++) {
            if (!visited.get(i)) {
                allVisited = false;
                break;
            }
        }

        if (allVisited) {
            minSets.add(Collections.unmodifiableSet(ptmSet));
        } else {
            visited.set(vertex, true);
            ptmSet.add(vertex);
            for (int v : g.outgoingEdgesDestinations(vertex)) {
                visited.set(v, true);
            }
            for (int v : g.outgoingEdgesDestinations(vertex)) {
                if (!visited.get(v)) {
                    search(v);
                }
            }
        }
        visited.set(vertex, false);
        ptmSet.remove(vertex);
        for (int v : g.outgoingEdgesDestinations(vertex)) {
            visited.set(v, false);
        }
    }

    public MinimumDominatingSet(UndirectedGraph g) {
        this.g = g;

        for (int i = 0; i < g.getVertexCount(); i++) {
            visited = new ArrayList<>();
            for (int j = 0; j < g.getVertexCount(); j++) {
                visited.add(false);
            }
            ptmSet = new HashSet<>();
            search(i);
        }
        minSet();
    }

    private void minSet() {
        for (Set<Integer> set : minSets) {
            if (minSet == null) {
                minSet = set;
            }
            if (set.size() < minSet.size()) {
                minSet = set;
            }
        }
    }

    public Set<Integer> getMinimumDominatingSet() {
        if (minSet == null) {
            minSet = Collections.emptySet();
        }
        return Collections.unmodifiableSet(minSet);
    }
}
