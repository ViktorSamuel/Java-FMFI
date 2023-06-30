package expressions;

import java.util.function.*;

public class BinaryNode<E> extends Node<E> {
    private BinaryOperator<E> operator;
    private Node<E> left;
    private Node<E> right;

    public BinaryNode(BinaryOperator<E> operator, Node<E> left, Node<E> right) {
        if(operator == null || left == null || right == null) throw new IllegalArgumentException();
        this.operator = operator;
        this.left = left;
        this.right = right;
    }

    @Override
    public E evaluate() {
        return operator.apply(this.left.evaluate(), this.right.evaluate());
    }

}
