package graphs;

import java.io.*;
import java.util.*;

public class ReflexiveTransitiveClosure {

    private static void search(DirectedGraph g, int vertex, List<Boolean> visited) {
        visited.set(vertex, true);
        for (int successor : g.outgoingEdgesDestinations(vertex)) {
            if (!visited.get(successor)) {
                search(g, successor, visited);
            }
        }
    }

    public static boolean existsPath(DirectedGraph g, int from, int to) {
        ArrayList<Boolean> visited = new ArrayList<>();
        for (int i = 0; i <= g.getVertexCount() - 1; i++) {
            visited.add(false);
        }
        search(g, from, visited);
        return visited.get(to);
    }

    public static DirectedGraph reflexiveTransitiveClosure(DirectedGraph g) {
        ArrayList<DirectedEdge> rtcEdges = new ArrayList<>();

        for(int i = 0; i < g.getVertexCount(); i++){
            for(int j = 0; j < g.getVertexCount(); j++){
                if(existsPath(g, i, j) || i == j) rtcEdges.add(new DirectedEdge(i, j));
            }
        }
        return  new AdjacencyMatrixDirectedGraph(g.getVertexCount(), rtcEdges);
    }

    /**
     * Metoda vypise do daneho vystupneho prudu pocet vrcholov a hran orientovaneho grafu, ako aj vsetky dvojice
     * vrcholov tvoriace orientovane hrany grafu.
     *
     * @param g   Graf, pre ktory sa vypis realizuje.
     * @param out Vystupny prud, do ktoreho sa vypis realizuje.
     */
    public static void printDirectedGraph(DirectedGraph g, PrintStream out) {
        int n = g.getVertexCount();
        out.println(n + " " + g.getDirectedEdgeCount());
        for (int u = 0; u <= n - 1; u++) {
            for (int v = 0; v <= n - 1; v++) {
                if (g.hasEdge(u, v)) {
                    out.println(u + " " + v);
                }
            }
        }
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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DirectedGraph g = readDirectedGraph(scanner, GraphImplementation.valueOf(scanner.next()));
        printDirectedGraph(reflexiveTransitiveClosure(g), System.out);
    }

}
