package graphs;

import java.util.*;

public class EqualityTester {
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


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<DirectedGraph> graphs = new ArrayList<>();
        for (int i = 0; i <= 1; i++) {
            String graphType = scanner.next();
            switch (graphType) {
                case "DIRECTED":
                    graphs.add(readDirectedGraph(scanner, GraphImplementation.valueOf(scanner.next())));
                    break;
                case "UNDIRECTED":
                    graphs.add(readUndirectedGraph(scanner, GraphImplementation.valueOf(scanner.next())));
                    break;
            }
        }
        if (graphs.get(0).equals(graphs.get(1))) {
            System.out.println("Grafy si su rovne.");
        } else {
            System.out.println("Grafy si nie su rovne.");
        }
    }

}
