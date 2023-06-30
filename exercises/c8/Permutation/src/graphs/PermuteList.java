package graphs;

import java.io.*;
import java.util.*;

public class PermuteList {

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
        PrintStream out = System.out;

        /* Nacitanie grafu reprezentujuceho permutaciu: */
        DirectedGraph g = readDirectedGraph(scanner, GraphImplementation.LISTS);
        Permutation p = null;
        boolean permutationCreated = false;
        try {
            p = new Permutation(g);
            permutationCreated = true;
        } catch (IllegalArgumentException e) {
            out.println("Vyhodena vynimka typu IllegalArgumentException");
        }

        /* Nacitanie permutovaneho zoznamu, aplikacia permutacie na tento zoznam a jeho vypisanie na konzolu: */
        if (permutationCreated) {
            String type = scanner.next();
            if (type.equals("Integer")) {
                int n = scanner.nextInt();
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = 0; i <= n - 1; i++) {
                    list.add(scanner.nextInt());
                }
                try {
                    p.apply(list);
                    out.println(list);
                } catch (IllegalArgumentException e) {
                    out.println("Vyhodena vynimka typu IllegalArgumentException");
                }
            }
            if (type.equals("String")) {
                int n = scanner.nextInt();
                LinkedList<String> list = new LinkedList<>();
                for (int i = 0; i <= n - 1; i++) {
                    list.add(scanner.next());
                }
                try {
                    p.apply(list);
                    out.println(list);
                } catch (IllegalArgumentException e) {
                    out.println("Vyhodena vynimka typu IllegalArgumentException");
                }
            }
        }
    }
}
