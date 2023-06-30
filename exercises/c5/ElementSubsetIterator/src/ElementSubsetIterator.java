import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

public class ElementSubsetIterator<E> implements Iterator<E> {
    private Iterator<E> iterator;
    private Set<E> elements;
    private E element = null;

    public ElementSubsetIterator(Iterator<E> iterator, Set<E> elements){
        this.iterator = iterator;
        this.elements = new HashSet<>(elements);
        this.element = getNextElement();
    }

    @Override
    public boolean hasNext() {
        return this.element != null;
    }

    @Override
    public E next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        try { return element; }
        finally { element = getNextElement(); }
    }

    private E getNextElement() {
        while (this.iterator.hasNext()){
            E e = this.iterator.next();
            if (this.elements.contains(e)){
                return e;
            }
        }
        return null;
    }
}
