package graphs;

import java.util.*;

public class DirectedCycles {

    private ArrayList<Integer> predecessors;
    public static boolean isCycle(DirectedGraph g, int start) {
        int n = 0;
        /* Samotne prehladavanie do sirky: */
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            // Vyberieme vrchol z radu, prejdeme vsetkych jeho naslednikov, nenavstivenych spracujeme a vlozime do radu:
            int vertex = queue.remove();
            n++;
            for (int successor : g.outgoingEdgesDestinations(vertex)) {
                if(n == g.getVertexCount()) return false;
                if(g.hasEdge(successor, start) && n > 1) return true;
                queue.add(successor);
            }
        }
        return false;
    }

    public static boolean belongsToCycle(DirectedGraph g, int vertex) {
        if(g.hasEdge(vertex, vertex)) return true;
        return isCycle(g, vertex);
    }

    /**
     * Metoda, ktora precita textovu reprezentaciu orientovaneho grafu pozostavajucu z poctu vrcholov n, poctu hran m
     * a z m dvojic vrcholov udavajucich jednotlive orientovane hrany a vytvori podla nej graf urcenej implementacie.
     *
     * @param scanner        Skener, z ktoreho sa reprezentacia grafu cita.
     * @param implementation Implementacia vytvaraneho grafu (zoznamy naslednikov, alebo matica susednosti).
     * @return               Vytvoreny graf.
     */
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
        if (belongsToCycle(g, vertex)) {
            System.out.println("Vrchol " + vertex + " lezi na orientovanej kruznici.");
        } else {
            System.out.println("Vrchol " + vertex + " nelezi na orientovanej kruznici.");
        }
    }

}
