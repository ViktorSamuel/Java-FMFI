package graphs;

import java.util.*;

/**
 * Trieda realizujuca najdenie vsetkych (vrcholovych) k-farbeni daneho neorientovaneho grafu s danym poctom farieb k.
 */
public class Colourings {
    
    /**
     * Neorientovany graf, ktoreho farbenia sa hladaju.
     */
    private UndirectedGraph g;
    
    /**
     * Pocet pouzitych farieb; trieda teda realizuje najdenie vsetkych colours-farbeni grafu g.
     */
    private int colours;

    /**
     * Zoznam, v ktorom po vykonani konstruktora budu ulozene vsetky colours-farbenia grafu g. Pre graf o n vrcholoch
     * je kazde z najdenych farbeni reprezentovane ako zoznam dlzky n, pricom pre v = 0,...,n-1 je na v-tej pozicii
     * tohto zoznamu ulozena farba v danom farbeni priradena vrcholu v.
     */
    private List<List<Integer>> colourings;

     /**
     * Zoznam, v ktorom sa pri prehladavani s navratom budu postupne generovat vsetky colours-farbenia grafu g.
     */
    private ArrayList<Integer> colouring;

    /**
     * Konstruktor, ktory spusti prehladavanie s navratom hladajuce vsetky colours-farbenia grafu g.
     * @param g       Neorientovany graf, ktoreho farbenia sa hladaju.
     * @param colours Pocet farieb.
     */
    public Colourings(UndirectedGraph g, int colours) {
        if (colours <= 0) {
            throw new IllegalArgumentException();
        }
        this.g = g;
        this.colours = colours;

        colourings = new LinkedList<>(); // Inicializacia zoznamu vsetkych najdenych farbeni na prazdny zoznam.

        /* Inicializacia zoznamu colouring, v ktorom sa pri prehladavani s navratom budu postupne generovat vsetky
           colours-farbenia grafu g tak, aby bola kazdemu vrcholu priradena neplatna farba -1. */
        colouring = new ArrayList<>();
        for (int i = 0; i <= g.getVertexCount() - 1; i++) {
            colouring.add(-1);
        }
        search(0);                       // Spustenie samotneho prehladavania s navratom.
    }

    /**
     * Metoda realizujuca samotne prehladavanie s navratom postupne hladajuce vsetky colours-farbenia grafu g.
     * @param vertex Ak je hodnota tohto parametra medzi 0 a n-1, kde n je pocet vrcholov grafu g, vyskusaju sa vsetky
     *               pripustne moznosti pre farbu vrcholu vertex a metoda sa zavola rekurzivne pre vertex+1. Ak je
     *               hodnota tohto parametra rovna n, naslo sa nove farbenie, ktore sa prida do zoznamu colourings.
     */
    private void search(int vertex) {
        if (vertex == g.getVertexCount()) {
            colourings.add(Collections.unmodifiableList(new ArrayList<>(colouring)));
        } else {
            if(g.getUndirectedEdgeCount() == 1) return;
            for(int i = 0; i < colours; i++){
                boolean a = true;
                for(int e: g.outgoingEdgesDestinations(vertex)){
                    if(colouring.get(e) == i) a = false;
                }
                if(a){
                    colouring.set(vertex, i);
                    search(vertex+1);
                    colouring.set(vertex, -1);
                }
            }
        }
    }

    /**
     * Metoda, ktora vrati na vystupe zoznam vsetkych najdenych colours-farbeni grafu g.
     * @return Nemodifikovatelny pohlad na zoznam nemodifikovatelnych pohladov na zoznamy reprezentujuce jednotlive
     *         colours-farbenia grafu g.
     */
    public List<List<Integer>> getColourings() {
        return Collections.unmodifiableList(colourings);
    }
}
