package graphs;

import java.util.ArrayList;
import java.util.List;

public class Pahs {
    /**
     * Pomocna metoda pre metodu existsPath, ktora rekurzivne prehlada vsetky doposial nenavstivene vrcholy
     * dosiahnutelne z daneho vrcholu.
     * @param g       Orientovany alebo neorientovany graf, v ktorom sa prehladavanie realizuje.
     * @param vertex  Vrchol grafu g, v ktorom sa prehladavanie zacina.
     * @param visited Zoznam obsahujuci informacie o navstiveni jednotlivych vrcholov grafu. Pri volani metody by malo
     *                platit visited.get(vertex) == false.
     */
    private static void search(DirectedGraph g, int vertex, List<Boolean> visited) {
        visited.set(vertex, true);
        for (int successor : g.outgoingEdgesDestinations(vertex)) {
            if (!visited.get(successor)) {
                search(g, successor, visited);
            }
        }
    }

    /**
     * Metoda, ktora zisti, ci je dvojica vrcholov grafu spojena cestou.
     * @param g    Graf, v ktorom sa uloha realizuje.
     * @param from Pociatocny vrchol.
     * @param to   Koncovy vrchol.
     * @return     Vystup je true prave vtedy, ked v grafe g existuje cesta z vrcholu from do vrcholu to.
     */
    public static boolean existsPath(DirectedGraph g, int from, int to) {
        ArrayList<Boolean> visited = new ArrayList<>();
        for (int i = 0; i <= g.getVertexCount() - 1; i++) {
            visited.add(false);
        }
        search(g, from, visited);
        return visited.get(to);
    }
}
