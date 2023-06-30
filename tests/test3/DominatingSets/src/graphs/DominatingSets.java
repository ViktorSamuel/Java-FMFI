package graphs;

import java.util.*;

public class DominatingSets {

    public static boolean isDominatingSet(UndirectedGraph g, Set<Integer> vertices) {
        for (int u = 0; u <= g.getVertexCount() - 1; u++) {
            boolean isCovered = vertices.contains(u);
            for (int v : g.outgoingEdgesDestinations(u)) {
                isCovered = isCovered || vertices.contains(v);
            }
            if (!isCovered) {
                return false;
            }
        }
        return true;
    }
}