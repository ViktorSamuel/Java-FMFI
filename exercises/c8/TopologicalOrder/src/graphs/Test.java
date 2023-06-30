package graphs;

import java.util.*;

public class Test {

    public static List<Integer> topologicalSort(DirectedGraph g) {
        /* Inicializacia: */
        int n = g.getVertexCount();
        List<Integer> unprocessedPredecessors = new ArrayList<>();
        for (int v = 0; v <= n - 1; v++) {
            unprocessedPredecessors.add(0);
        }
        for (int v = 0; v <= n - 1; v++) {
            for (int successor : g.outgoingEdgesDestinations(v)) {
                unprocessedPredecessors.set(successor, unprocessedPredecessors.get(successor) + 1);
            }
        }
        Queue<Integer> ready = new LinkedList<>();
        for (int v = 0; v <= n - 1; v++) {
            if (unprocessedPredecessors.get(v) == 0) {
                ready.add(v);
            }
        }
        List<Integer> result = new LinkedList<>();

        /* Samotne topologicke triedenie: */
        while (!ready.isEmpty()) {
            int vertex = ready.remove();
            result.add(vertex);
            for (int successor : g.outgoingEdgesDestinations(vertex)) {
                unprocessedPredecessors.set(successor, unprocessedPredecessors.get(successor) - 1);
                if (unprocessedPredecessors.get(successor) == 0) {
                    ready.add(successor);
                }
            }
        }

        if (result.size() == n) {
            return result;
        } else {
            return null;
        }
    }

    public static DirectedGraph readDirectedGraph(Scanner scanner, GraphImplementation implementation) {
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        List<DirectedEdge> edges = new ArrayList<>();
        for (int i = 1; i <= m; i++) {
            edges.add(new DirectedEdge(scanner.nextInt(), scanner.nextInt()));
        }
        DirectedGraph g = null;
        switch (implementation) {
            case LISTS:
                g = new SuccessorListsDirectedGraph(n, edges);
                break;
            case MATRIX:
                g = new AdjacencyMatrixDirectedGraph(n, edges);
                break;
        }
        return g;
    }

    /* Metodu main nemente. */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DirectedGraph g = readDirectedGraph(scanner, GraphImplementation.LISTS);
        int vertex = scanner.nextInt();

        List<Integer> list = topologicalSort(g);
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }

    }

}
