package graphs;

import java.util.*;

public class InducedSubgraphs {
    public static UndirectedGraph inducedSubgraph(UndirectedGraph g, Set<Integer> vertices) {
        List<Integer> vertexList = new ArrayList<>(vertices);
        Collections.sort(vertexList);

        List<UndirectedEdge> edges = new ArrayList<>();

        for(int vertex: vertexList){
            for(int succesor: g.outgoingEdgesDestinations(vertex)){
                UndirectedEdge edge = new UndirectedEdge(vertexList.indexOf(vertex), vertexList.indexOf(succesor));
                if(vertexList.contains(succesor) && !edges.contains(edge)){
                    edges.add(edge);
                }
            }
        }
        return new AdjacencyListsUndirectedGraph(vertexList.size(), edges);
    }
}
