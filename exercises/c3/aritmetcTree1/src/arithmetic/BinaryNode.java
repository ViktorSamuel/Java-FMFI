package arithmetic;

abstract class BinaryNode extends Node {

    private Node left;
    private Node right;

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public BinaryNode(Node left, Node right) {
        this.left = left;
        this.right = right;
    }

    public abstract String operatorToString();

    @Override
    public String toString() {
        return "(" + getLeft().toString() + operatorToString() + getRight().toString() + ")";
    }
}
