package graphs;

import java.io.*;
import java.util.*;

public class Graphs {

    public static Iterable<Integer> getPredecessors(DirectedGraph g, int v) {
        
        if(g == null) throw new IllegalArgumentException();
        TreeSet<Integer> set = new TreeSet<>();
        for(int i = 0; i < g.getVertexCount(); i++){
            if(g.hasEdge(i, v)) set.add(i);
        }
        return set;
    }

    public static int loopCount(DirectedGraph g) {

        if(g == null) throw new IllegalArgumentException();
        int loopCount = 0;
        for(int i = 0; i < g.getVertexCount(); i++){
            if(g.hasEdge(i, i)) loopCount++;
        }
        return loopCount;
    }

    public static int isolatedVertexCount(DirectedGraph g) {

        if(g == null) throw new IllegalArgumentException();
        int isolated = 0;
        boolean isIsloated = true;
        for (int i = 0; i < g.getVertexCount(); i++){
            for(int j = 0; j < g.getVertexCount(); j++)
                if(g.hasEdge(i, j) || g.hasEdge(j, i)) isIsloated = false;
            if(isIsloated) isolated++;
            isIsloated = true;
        }
        return isolated;
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
        PrintStream out = System.out;
        DirectedGraph g = null;
        try {
            g = readDirectedGraph(scanner, GraphImplementation.valueOf(scanner.next()));
        } catch (NoSuchElementException | IllegalArgumentException e) {
            out.println("Pokracujeme s g == null...");
        }
        while (scanner.hasNext())  {
            String command = scanner.next();
            switch (command) {
                case "getPredecessors":
                    try {
                        int v = scanner.nextInt();
                        List<Integer> predecessors = new ArrayList<>();
                        for (int u : getPredecessors(g, v)) {
                            predecessors.add(u);
                        }
                        Collections.sort(predecessors);
                        out.println("Predchodcovia vrcholu " + v + ": " + predecessors + ".");
                    } catch (IllegalArgumentException e) {
                        out.println("Vynimka typu IllegalArgumentException.");
                    }
                    break;
                case "loopCount":
                    try {
                        out.println("Pocet sluciek v grafe: " + loopCount(g) + ".");
                    } catch (IllegalArgumentException e) {
                        out.println("Vynimka typu IllegalArgumentException.");
                    }
                    break;
                case "isolatedVertexCount":
                    try {
                        out.println("Pocet izolovanych vrcholov grafu: " + isolatedVertexCount(g) + ".");
                    } catch (IllegalArgumentException e) {
                        out.println("Vynimka typu IllegalArgumentException.");
                    }
                    break;
            }
        }
    }
}
