package expressions;

import java.util.function.*;

public class UnaryNode<E> extends Node<E> {
    private UnaryOperator<E> operator;
    private Node<E> child;
    public UnaryNode(UnaryOperator<E> operator, Node<E> child)  {
        if(operator == null || child == null) throw new IllegalArgumentException();
        this.operator = operator;
        this.child = child;
    }

    @Override
    public E evaluate() {
        return operator.apply(this.child.evaluate());
    }

}
