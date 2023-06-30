package expressions;

import java.util.function.BinaryOperator;

public class NullaryNode<E> extends Node<E> {
    private E value;
    public NullaryNode(E value) {
        if(value == null) throw new IllegalArgumentException();
        this.value = value;
    }

    @Override
    public E evaluate() {
        return value;
    }
}
