package graphs;

import java.util.*;

public class Eccentricities {

    private List<Integer> distances;

    private List<Integer> predecessors;

    public int ShortestPathsFromVertex(DirectedGraph g, int start) {
        /* Inicializacia zoznamov distances a predecessors: */
        distances = new ArrayList<>();
        predecessors = new ArrayList<>();
        for (int i = 0; i <= g.getVertexCount() - 1; i++) {
            distances.add(-1);
        }

        /* Samotne prehladavanie do sirky: */
        Queue<Integer> queue = new LinkedList<>();
        distances.set(start, 0);
        queue.add(start);
        while (!queue.isEmpty()) {
            // Vyberieme vrchol z radu, prejdeme vsetkych jeho naslednikov, nenavstivenych spracujeme a vlozime do radu:
            int vertex = queue.remove();
            for (int successor : g.outgoingEdgesDestinations(vertex)) {
                if (distances.get(successor) == -1) {
                    distances.set(successor, distances.get(vertex) + 1);
                    queue.add(successor);
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for(int x: distances){
            if(x > max) max = x;
        }
        return max;
    }

    private  ArrayList<Integer> eccentricity = new ArrayList<>();
    private int radius;
    private boolean c = true;
    public Eccentricities(UndirectedGraph g) {
        if(g.getVertexCount() == 1) eccentricity.add(0);
        else {
            for (int i = 0; i < g.getVertexCount(); i++) {
                eccentricity.add(ShortestPathsFromVertex(g, i));
            }
            if(eccentricity.contains(0)) c = false;
            radius = radius();
        }
    }

    public int eccentricity(int vertex) {
        if(!c) return Integer.MAX_VALUE;
        if(eccentricity.size()==1) return eccentricity.get(0);
        return eccentricity.get(vertex);
    }

    public int radius() {
        if(!c) return Integer.MAX_VALUE;
        int r = Integer.MAX_VALUE;
        for(int i = 0; i < eccentricity.size(); i++){
            if(r > eccentricity.get(i)) r = eccentricity.get(i);
        }
        return r;
    }

    public boolean isCentral(int vertex) {
        if(eccentricity.size()==1 || !c) return true;
        return eccentricity.get(vertex)==radius;
    }

}
