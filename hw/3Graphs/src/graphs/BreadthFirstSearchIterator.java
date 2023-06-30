package graphs;

import java.util.*;

public class BreadthFirstSearchIterator implements Iterator<Integer> {
    private DirectedGraph graph;
    private int startVertex;
    private Integer currentVertex;
    private Deque<Integer> queue = new ArrayDeque<>();
    private Set<Integer> visitedVertices = new HashSet<>();

    public BreadthFirstSearchIterator(DirectedGraph graph, int startVertex){
        if (graph == null || !graph.hasVertex(startVertex)) {
            throw new IllegalArgumentException();
        }
        this.graph = graph;
        this.startVertex = startVertex;
        queue.add(this.startVertex);
        visitedVertices.add(this.startVertex);
        currentVertex = this.startVertex;
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        currentVertex = queue.removeFirst();
        Iterable<Integer> outgoingDestinations = graph.outgoingEdgesDestinations(currentVertex);
        for (Integer destination : outgoingDestinations){
            if (visitedVertices.add(destination)){
                queue.add(destination);
            }
        }
        return currentVertex;
    }
}
