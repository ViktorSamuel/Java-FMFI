package graphs;

import java.util.*;

public class Permutation {
    private static DirectedGraph g;
    public Permutation(DirectedGraph g){
        int in, out;
        for(int i = 0; i < g.getVertexCount(); i++){
            in = 0;
            out = 0;
            for(int j = 0; j < g.getVertexCount(); j++){
                if(g.hasEdge(i, j)) out++;
                if(g.hasEdge(j, i)) in++;
            }
            if(in != 1 || out != 1) throw new IllegalArgumentException();
        }
        this.g = g;
    }

    public static <E> void apply(List<E> list){
        if(g.getVertexCount() != list.size()) throw new IllegalArgumentException();

        List<E> newList = new ArrayList<>();
        for(int i = 0; i < g.getVertexCount(); i++){
            newList.add(null);
        }
        for(int i = 0; i < g.getVertexCount(); i++){
            for(int e: g.outgoingEdgesDestinations(i)){
                newList.set(e, list.get(i));
            }
        }
        for(int i = 0; i < g.getVertexCount(); i++){
            list.set(i, newList.get(i));
        }
    }

}
