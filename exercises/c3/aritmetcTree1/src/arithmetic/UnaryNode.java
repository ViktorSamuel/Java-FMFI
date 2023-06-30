package arithmetic;

abstract class UnaryNode extends Node {

    private Node child;

    public Node getChild() {
        return child;
    }

    public UnaryNode(Node child) {
        this.child = child;
    }
}
