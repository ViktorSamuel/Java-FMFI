package graphs;

import java.util.*;

public class UndirectedCycles {
    static ArrayList<Integer> distances;
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
                if (n == g.getVertexCount()) return false;
                if (g.hasEdge(successor, start) && vertex != start) return true;
                queue.add(successor);
            }
        }
        return false;
    }

    public static boolean belongsToCycle(UndirectedGraph g, int vertex) {
        if(g.hasEdge(vertex, vertex) || g.getVertexCount() == g.getUndirectedEdgeCount()) return true;
        if(g.getVertexCount() < 3) return false;
        return isCycle(g, vertex);
    }

    /**
     * Metoda, ktora precita textovu reprezentaciu neorientovaneho grafu pozostavajucu z poctu vrcholov n, poctu hran m
     * a z m dvojic vrcholov udavajucich jednotlive neorientovane hrany a vytvori podla nej graf urcenej implementacie.
     *
     * @param scanner        Skener, z ktoreho sa reprezentacia grafu cita.
     * @param implementation Implementacia vytvaraneho grafu (zoznamy naslednikov, alebo matica susednosti).
     * @return               Vytvoreny graf.
     */
    public static UndirectedGraph readUndirectedGraph(Scanner scanner, GraphImplementation implementation) {
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        List<UndirectedEdge> edges = new ArrayList<>();
        for (int i = 1; i <= m; i++) {
            edges.add(new UndirectedEdge(scanner.nextInt(), scanner.nextInt()));
        }
        UndirectedGraph g = null;
        switch (implementation) {
            case LISTS:
                g = new AdjacencyListsUndirectedGraph(n, edges);
                break;
            case MATRIX:
                g = new AdjacencyMatrixUndirectedGraph(n, edges);
                break;
        }
        return g;
    }

    /* Metodu main nemente. */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UndirectedGraph g = (UndirectedGraph) readUndirectedGraph(scanner, GraphImplementation.LISTS);
        int vertex = scanner.nextInt();
        if (belongsToCycle(g, vertex)) {
            System.out.println("Vrchol " + vertex + " lezi na kruznici.");
        } else {
            System.out.println("Vrchol " + vertex + " nelezi na kruznici.");
        }
    }

}
