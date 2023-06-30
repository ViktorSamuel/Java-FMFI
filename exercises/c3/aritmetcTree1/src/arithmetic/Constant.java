package arithmetic;

class Constant extends NullaryNode {

    private int value;

    public Constant(int value) {
        this.value = value;
    }

    @Override
    public int evaluate() {
        return value;
    }

    @Override
    public String toString() {
        return Integer.toString(value);
    }
}
