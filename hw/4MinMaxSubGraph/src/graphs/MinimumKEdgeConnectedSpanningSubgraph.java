package graphs;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class MinimumKEdgeConnectedSpanningSubgraph {
    private UndirectedGraph g;
    private UndirectedGraph finalG = null;
    private Set<UndirectedEdge> gEdges;
    private Set<UndirectedEdge> edges;
    private Set<Set<UndirectedEdge>> edgesToTry;
    private Set<Set<UndirectedEdge>> kEdges;
    private int k;
    private int i;


    private void getCombinations(Set<Set<UndirectedEdge>> set){
        if(edges.size() == i){
            set.add(Collections.unmodifiableSet(new HashSet<>(edges)));
        }
        else{
            for(UndirectedEdge e: gEdges){
                if(!edges.contains(e)){
                    edges.add(e);
                    getCombinations(set);
                    edges.remove(e);
                }
            }
        }
    }

    private void find(){
        for(Set<UndirectedEdge> set: edgesToTry){
            Set<UndirectedEdge> newSet = new HashSet<>();
            for(UndirectedEdge edge: gEdges){
                if(!set.contains(edge)) {
                    newSet.add(edge);
                }

            }
            UndirectedGraph graph = new AdjacencyListsUndirectedGraph(g.getVertexCount(), newSet);
            if(!isContinuing(graph)) continue;

            kEdges = new HashSet<>();
            i = k-1;
            getCombinations(kEdges);

            boolean a = true;

            for(Set<UndirectedEdge> kSet: kEdges){
                Set<UndirectedEdge> kNewSet = new HashSet<>();
                for(UndirectedEdge edge: newSet){
                    if(!kSet.contains(edge)) {
                        kNewSet.add(edge);
                    }
                }
                UndirectedGraph kGraph = new AdjacencyListsUndirectedGraph(g.getVertexCount(), kNewSet);
                if(!isContinuing(kGraph)) {
                    a = false;
                    break;
                }
            }

            if(a){
                if(finalG == null) finalG = graph;
                else if (finalG.getUndirectedEdgeCount() > graph.getUndirectedEdgeCount()) {
                    finalG = graph;
                }
            }

        }
    }

    private boolean isContinuing(UndirectedGraph g){
        for(int j = 1; j < g.getVertexCount(); j++){
            if(!Pahs.existsPath(g, 0, j)) return false;
        }
        return true;
    }

    public MinimumKEdgeConnectedSpanningSubgraph(UndirectedGraph g, int k) {
        if(g.getVertexCount() == 1 || g.getUndirectedEdgeCount() == 1){
            finalG = g;
            return;
        }

        if(k > g.getUndirectedEdgeCount()) return;

        if(!isContinuing(g))  return;

        this.g = g;
        this.k = k;

        gEdges = new HashSet<>();
        for(int i = 0; i < g.getVertexCount(); i++){
            for(int j = 0; j < g.getVertexCount(); j++){
                if(g.hasEdge(i, j)){
                    UndirectedEdge edge = new UndirectedEdge(i, j);
                    if(!gEdges.contains(edge)) {
                        gEdges.add(edge);
                    }
                }
            }
        }

        edgesToTry = new HashSet<>();
        edges = new HashSet<>();
        for(i = g.getUndirectedEdgeCount()-(g.getVertexCount()+k-2); i >= 0; i--){
            getCombinations(edgesToTry);
        }

        find();
    }

    public UndirectedGraph getMinimumKEdgeConnectedSpanningSubgraph() {
        return finalG;
    }
}
