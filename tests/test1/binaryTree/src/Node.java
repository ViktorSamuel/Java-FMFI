public class Node {
    private String key;
    private Node left;
    private Node right;

    public Node(String key) {
        this.key = key;
    }

    public Node(String key, Node left, Node right) {
        this(key);
        this.left = left;
        this.right = right;
    }

    public String getKey() {
        return key;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node node) {
        this.left = node;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node node) {
        this.right = node;
    }
}

