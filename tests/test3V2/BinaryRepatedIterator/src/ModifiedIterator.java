import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class ModifiedIterator <E> implements Iterator<E> {

    private boolean i = false;
    private E element = null;
    private Iterator<E> iterator;
    private Predicate<E> repeat;
    public ModifiedIterator(Iterator<E> iterator, Predicate<E> repeat){
        this.iterator = iterator;
        this.repeat = repeat;
        this.element = getElement();
    }

    @Override
    public boolean hasNext(){
        return element != null;
    }

    @Override
    public E next(){
        if(!this.hasNext()) throw new NoSuchElementException();
        try { return element; }
        finally { element = getElement(); }
    }
    private E getElement() {
        if(i){
            i = false;
            return element;
        }
        if(iterator.hasNext()){
            E next = iterator.next();
            i = repeat.test(next);
            return next;
        }
        return null;
    }
}
