package graphs;

import java.util.*;

public class Paths {

    public static boolean isWalk(DirectedGraph g, List<Integer> vertexList) {
        if(g == null || vertexList == null) throw new IllegalArgumentException();
        if (vertexList.size() < 1) return false;
        if (vertexList.size() == 1) return g.hasVertex(vertexList.get(0));

        for(int i = 0; i < vertexList.size()-1; i++){
            if(!g.hasVertex(vertexList.get(i)) || !g.hasVertex(vertexList.get(i+1))
                || !g.hasEdge(vertexList.get(i), vertexList.get(i+1)))
                return false;
        }
        return true;
    }

    public static boolean isPath(DirectedGraph g, List<Integer> vertexList) {
        if(g == null || vertexList == null) throw new IllegalArgumentException();
        if (vertexList.size() < 1 || vertexList.size() > g.getVertexCount()) return false;
        if (vertexList.size() == 1) return g.hasVertex(vertexList.get(0));

        ArrayList<Integer> visited = new ArrayList<>();
        for(int i = 0; i < vertexList.size()-1; i++){
            if(!g.hasVertex(vertexList.get(i)) || !g.hasVertex(vertexList.get(i+1))
                || vertexList.get(i) == vertexList.get(i+1)
                || visited.contains(vertexList.get(i)) || visited.contains(vertexList.get(i+1))
                || !g.hasEdge(vertexList.get(i), vertexList.get(i+1))) return false;
            visited.add(vertexList.get(i));
        }
        return true;
    }

    public static int walkLength(DirectedGraph g, List<Integer> walk) {
        if (g == null || walk == null || !isWalk(g, walk)) throw new IllegalArgumentException();

        return walk.size()-1;
    }
}
