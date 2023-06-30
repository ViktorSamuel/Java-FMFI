import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.UnaryOperator;

public class OutputRepeatingIterator<E> implements Iterator<E> {
    private Iterator<E> iterator;
    private int initialRepetitionCount;
    private UnaryOperator<Integer> f;

    private E element;
    private int repetitionsLeft;

    public OutputRepeatingIterator(Iterator<E> iterator, int initialRepetitionCount, UnaryOperator<Integer> f) {
        this.iterator = iterator;
        this.initialRepetitionCount = initialRepetitionCount;
        this.f = f;

        element = findNextElement();
        repetitionsLeft = initialRepetitionCount;
    }

    @Override
    public boolean hasNext() {
        if((repetitionsLeft == 0 && !iterator.hasNext()) || element == null) return false;
        return true;
    }

    @Override
    public E next() {
        if (!hasNext()) throw new NoSuchElementException();

        while (repetitionsLeft == 0) {
            element = findNextElement();
            if(element == null) throw new NoSuchElementException();
            repetitionsLeft = f.apply(initialRepetitionCount);
            initialRepetitionCount = repetitionsLeft;
        }
        repetitionsLeft--;

        return element;
    }

    private E findNextElement() {
        if (iterator.hasNext()) return iterator.next();
        else return null;
    }
}

// FUNGUJE
//
//
//    Filip Zrubak
//import java.util.Iterator;
//        import java.util.Queue;
//        import java.util.function.*;
//        import java.util.*;
//
//public class OutputRepeatingIterator <E> implements Iterator<E> {
//    private int initialRepetitionCount;
//    private UnaryOperator<Integer> f;
//    private Iterator<E> iterator;
//    private Queue<E> queue;
//
//    public OutputRepeatingIterator(Iterator<E> iterator, int initialRepetitionCount,UnaryOperator<Integer> f ){
//        this.f = f;
//        this.iterator = iterator;
//        this.initialRepetitionCount = initialRepetitionCount;
//        queue = new LinkedList<>();
//        hasNext();
//    }
//
//    @Override
//    public boolean hasNext() {
//        if (queue.isEmpty() && !iterator.hasNext()){
//            return false;
//        }
//        if (queue.isEmpty()){
//            E next = iterator.next();
//            for (int i = 0; i < initialRepetitionCount; i++){
//                queue.add(next);
//            }
//            initialRepetitionCount = f.apply(initialRepetitionCount);
//        }
//        return !queue.isEmpty();
//    }
//
//    @Override
//    public E next() {
//        if (!hasNext()){
//            throw new NoSuchElementException();
//        }
//        E tmp = queue.remove();
//        hasNext();
//        return tmp;
//    }
//}