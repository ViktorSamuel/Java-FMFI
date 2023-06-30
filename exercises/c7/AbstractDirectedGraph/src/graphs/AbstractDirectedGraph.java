package graphs;

public abstract class AbstractDirectedGraph implements DirectedGraph {

    @Override
    public boolean equals(Object o){
        DirectedGraph g = (DirectedGraph) o;
        if (this.getVertexCount() != g.getVertexCount()) return false;

        for (int i = 0; i < this.getVertexCount(); i++) {
            for (int successor : this.outgoingEdgesDestinations(i)) {
                if(!g.hasEdge(i, successor)) return false;
            }
            for (int successor : g.outgoingEdgesDestinations(i)) {
                if(!this.hasEdge(i, successor)) return false;
            }
        }
        return true;
    }
}
