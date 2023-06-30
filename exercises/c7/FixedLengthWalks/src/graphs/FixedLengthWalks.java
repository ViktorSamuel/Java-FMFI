package graphs;

import java.util.*;

public class FixedLengthWalks {
    private DirectedGraph g;
    private int to;
    private int length;
    private LinkedList<Integer> walk;
    private List<List<Integer>> walks;

    public FixedLengthWalks(DirectedGraph g, int from, int to, int length) {
        this.g = g;
        this.to = to;
        this.length = length;

        walks = new LinkedList<>();
        walk = new LinkedList<>();

        walk.add(from);
        search();
    }

    private void search() {
        if (walk.size() == length + 1) {   // Dlzka zoznamu je vzdy o jedna vacsia, nez dlzka nim reprezentovanej cesty.
            if (walk.getLast() == to) {
                walks.add(Collections.unmodifiableList(new LinkedList<>(walk)));
            }
        } else {
            for (int successor : g.outgoingEdgesDestinations(walk.getLast())) {
                walk.add(successor);
                search();
                walk.removeLast();
            }
        }
    }

    public List<List<Integer>> getWalks() {
        return Collections.unmodifiableList(walks);
    }
}