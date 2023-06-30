package arithmetic;

class UnaryMinus extends UnaryNode {

    public UnaryMinus(Node child){
        super(child);
    }

    @Override
    public int evaluate() {
        return -getChild().evaluate();
    }

    @Override
    public String toString() {
        return "(-" + getChild().toString() + ")";
    }
}
