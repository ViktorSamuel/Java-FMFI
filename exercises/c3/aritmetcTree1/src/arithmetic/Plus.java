package arithmetic;

class Plus extends BinaryNode {

    public Plus(Node left, Node right) {
        super(left, right);
    }

    @Override
    public int evaluate() {
        return getLeft().evaluate() + getRight().evaluate();
    }

    @Override
    public String operatorToString(){ return "+"; }
}
