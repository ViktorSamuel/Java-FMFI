package arithmetic;

public class Times extends BinaryNode {
    public Times(Node left, Node right) {
        super(left, right);
    }

    @Override
    public int evaluate() {
        return getLeft().evaluate() * getRight().evaluate();
    }

    @Override
    public String operatorToString(){ return "*"; }

}
