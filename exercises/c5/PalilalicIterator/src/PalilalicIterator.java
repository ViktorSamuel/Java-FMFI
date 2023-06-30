import java.util.Iterator;
import java.util.NoSuchElementException;

public class PalilalicIterator<E> implements Iterator<E> {
    private Iterator<E> iterator;
    private E element;
    int i = -1;
    public PalilalicIterator(Iterator<E> iterator){
        this.iterator = iterator;
        element = getElement();
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

    private E getElement(){
        i++;
        if(i % 2 == 0){
            if(iterator.hasNext()) return iterator.next();
            return null;
        }
        return element;
    }
}
