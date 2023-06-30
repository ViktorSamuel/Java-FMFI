package graphs;

import java.util.*;

public class LineGraphs {

    public static UndirectedGraph lineGraph(UndirectedGraph g) {
        List<UndirectedEdge> edges = new ArrayList<>();
        int k = 0;
        int[][] orderedEdges = new int[g.getVertexCount()][g.getVertexCount()];

        for (int i = 0; i < g.getVertexCount(); i++) {
            for (int j = i + 1; j < g.getVertexCount(); j++) {
                if (g.hasEdge(i, j)) {
                    orderedEdges[i][j] = k;
                    orderedEdges[j][i] = k;
                    k++;
                }
            }
        }

        for(int i = 0; i < g.getVertexCount(); i++) {
            for(int j = 0; j < g.getVertexCount(); j++){
                if(g.hasEdge(i, j)){
                    for(int y = j + 1; y < g.getVertexCount(); y++){
                        if(g.hasEdge(i, y))
                            edges.add(new UndirectedEdge(orderedEdges[j][i], orderedEdges[y][i]));
                    }
                }
            }
        }
        return new AdjacencyListsUndirectedGraph(g.getUndirectedEdgeCount(), edges);
    }
}