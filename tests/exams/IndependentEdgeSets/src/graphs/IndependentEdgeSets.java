package graphs;

import java.util.*;

public class IndependentEdgeSets {
    private List<Set<UndirectedEdge>> independentEdgeSets;
    private List<UndirectedEdge> edges;

    public IndependentEdgeSets(UndirectedGraph g) {
        edges = new ArrayList<>();
        independentEdgeSets = new ArrayList<>();

        for(int i = 0; i < g.getVertexCount(); i++){
            for(int n: g.outgoingEdgesDestinations(i)){
                UndirectedEdge edge = new UndirectedEdge(i, n);
                if(!edges.contains(edge)) edges.add(edge);
            }
        }

        int numberOfEdges = edges.size();

        for (int i = 0; i < (1 << numberOfEdges); i++){
            Set<UndirectedEdge> subset = new HashSet<>();
            for (int j = 0; j < numberOfEdges; j++) {
                if ((i & (1 << j)) != 0) {
                    subset.add(edges.get(j));
                }
            }
            if(subset.size() <= 1) independentEdgeSets.add(Collections.unmodifiableSet(subset));
            else{
                boolean ok = true;
                List<Integer> visited = new ArrayList<>();
                for(int j = 0; j < g.getVertexCount(); j++) visited.add(0);

                for(UndirectedEdge edge: subset){
                    List<Integer> vertexList = new ArrayList<>(edge.getIncidentVertices());
                    for(int vertex: vertexList){
                        visited.set(vertex, visited.get(vertex)+1);
                    }
                }

                for(int j = 0; j < g.getVertexCount(); j++){
                    if(visited.get(j) > 1) ok = false;
                }
                if(ok) independentEdgeSets.add(Collections.unmodifiableSet(subset));
            }
        }
    }

    /* Implementaciu nasledujucej metody nemente. */
    public List<Set<UndirectedEdge>> getIndependentEdgeSets() {
        return Collections.unmodifiableList(independentEdgeSets);
    }

}