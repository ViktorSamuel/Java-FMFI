package graphs;

import java.util.*;

public class FixedChordCountCycles {
    private UndirectedGraph g;
    private int throughVertex;
    private int chordCount;
    private int length;
    private LinkedList<Integer> cycle;
    private ArrayList<Boolean> visited;
    private List<List<Integer>> cycles;
    public FixedChordCountCycles(UndirectedGraph g, int throughVertex, int chordCount) {
        this.g = g;
        this.throughVertex = throughVertex;
        this.chordCount = chordCount;

        cycles = new LinkedList<>();

        for(int i = 3; i <= g.getVertexCount(); i++){
            cycle = new LinkedList<>();
            cycle.add(throughVertex);

            visited = new ArrayList<>();
            for (int j = 0; j < g.getVertexCount(); j++) {
                visited.add(false);
            }
            this.length = i;
            search();
        }
    }

    public boolean existsCycle() {
        for(List<Integer> c: cycles){
            List<UndirectedEdge> edges = new ArrayList<>();
            for(int u = 0; u < c.size() - 1; u++){
                edges.add(new UndirectedEdge(c.get(u), c.get(u+1)));
            }

            List<UndirectedEdge> ee = new ArrayList<>();
            for(int x: c){
                for(int y: c){
                    if(x != y && g.hasEdge(x, y) && !edges.contains(new UndirectedEdge(y, x)) && !ee.contains(new UndirectedEdge(y, x)))
                        ee.add(new UndirectedEdge(y, x));
                }
                if(ee.size() == chordCount) return true;
            }
        }
        return false;
    }

    private void search() {
        if (cycle.size() == length + 1) {   // Dlzka zoznamu je vzdy o jedna vacsia, nez dlzka nim reprezentovanej cesty.
            if (cycle.getLast() == throughVertex) {
                cycles.add(Collections.unmodifiableList(new LinkedList<>(cycle)));
            }
        } else {
            for (int successor : g.outgoingEdgesDestinations(cycle.getLast())) {
                if (!visited.get(successor)) {
                    visited.set(successor, true);
                    cycle.add(successor);
                    search();
                    cycle.removeLast();
                    visited.set(successor, false);
                }
            }
        }
    }
//  TEST
//    public static void main(String[] args) {
//        UndirectedGraph g;
//        List<UndirectedEdge> edges = new ArrayList<>();
//        edges.add(new UndirectedEdge(0, 1));
//        edges.add(new UndirectedEdge(1, 2));
//        edges.add(new UndirectedEdge(2, 0));
//
//        edges.add(new UndirectedEdge(3, 4));
//        edges.add(new UndirectedEdge(4, 5));
//        edges.add(new UndirectedEdge(5, 6));
//        edges.add(new UndirectedEdge(6, 3));
//
//        edges.add(new UndirectedEdge(3, 5));
//        edges.add(new UndirectedEdge(4, 6));
//
//        g = new AdjacencyListsUndirectedGraph(7, edges);
//        FixedChordCountCycles fccc = new FixedChordCountCycles(g, 6, 3);
//        System.out.println(fccc.existsCycle());
//    }
}
