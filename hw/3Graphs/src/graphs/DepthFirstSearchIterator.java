package graphs;

import java.util.*;

public class DepthFirstSearchIterator implements Iterator<Integer> {
    private DirectedGraph graph;
    private int startVertex;
    private Integer currentVertex;
    private Set<Integer> visitedVertices = new HashSet<>();
    private Stack<Integer> stack = new Stack<>();

    public DepthFirstSearchIterator(DirectedGraph graph, int startVertex){
        if (graph == null || !graph.hasVertex(startVertex)) {
            throw new IllegalArgumentException();
        }
        this.graph = graph;
        this.startVertex = startVertex;
        currentVertex = this.startVertex;
        stack.push(this.startVertex);
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty() && visitedVertices.contains(stack.peek())) {
            stack.pop();
        }
        return !stack.isEmpty();
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        currentVertex = stack.pop();
        visitedVertices.add(currentVertex);
//        List<Integer> outgoing = new ArrayList<>((Collection) graph.outgoingEdgesDestinations(currentVertex));
        List<Integer> outgoing = new ArrayList<>();

        for (Integer x : graph.outgoingEdgesDestinations(currentVertex)){
            outgoing.add(x);
        }
        Collections.reverse(outgoing);
        for (Integer destination : outgoing){
            if (!visitedVertices.contains(destination)){
                stack.push(destination);
            }
        }
        return currentVertex;
    }
}
