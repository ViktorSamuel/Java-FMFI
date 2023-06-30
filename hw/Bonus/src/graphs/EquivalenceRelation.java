package graphs;

import java.util.*;

public class EquivalenceRelation {
    private UndirectedGraph graph;
    private UndirectedGraph g;
    private List<Integer> componentId = new ArrayList<>();
    private Set<Set<Integer>> partition = new HashSet<>();
    private Set<Integer> set = new HashSet<>();
    private Integer id = 0;

    public EquivalenceRelation(int n, Set<DirectedEdge> generators) {
        List<UndirectedEdge> edges = new ArrayList<>();
        // base
        for(DirectedEdge edge: generators){
            UndirectedEdge uEdge = new UndirectedEdge(edge.getFrom(), edge.getTo());
            if(!edges.contains(uEdge)){
                edges.add(uEdge);
            }
        }

        // reflection
        for(int i = 0; i < n; i++){
            UndirectedEdge edge = new UndirectedEdge(i, i);
            if(!edges.contains(edge)) edges.add(edge);
        }

        this.g = new AdjacencyListsUndirectedGraph(n, edges);

        // partition
        for(int i = 0; i < n; i++) componentId.add(-1);
        for(int i = 0; i < n; i++){
            if (componentId.get(i) == -1) {
                search(i);
                partition.add(set);
                set = new HashSet<>();
                id++;
            }
        }
        // transition
        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                if(componentId.get(i) == componentId.get(j)){
                    UndirectedEdge edge = new UndirectedEdge(i, j);
                    if(!edges.contains(edge)) edges.add(edge);
                }
            }
        }

        this.graph = new AdjacencyListsUndirectedGraph(n, edges);
    }

    private void transition(){

    }

    private void search(int vertex) {
        componentId.set(vertex, id);
        set.add(vertex);
        for (int neighbour : g.outgoingEdgesDestinations(vertex)) {
            if (componentId.get(neighbour) == -1) {
                search(neighbour);
            }
        }
    }

    public boolean areEquivalent(int a, int b) {
        return graph.hasEdge(a, b);
    }

    public Set<Set<Integer>> inducedPartition() {
        return Collections.unmodifiableSet(partition);
    }

    public UndirectedGraph asGraph() {
        return graph;
    }
}
