import java.util.Iterator;
import java.util.NoSuchElementException;

public class IncreasinglyRepetitiveIterator<E> implements Iterator<E>{

    private Iterator<E> iterator;
    private int i, k;
    private E element = null;

    public IncreasinglyRepetitiveIterator(Iterator<E> iterator){
       this.iterator = iterator;
       i = 0;
       k = 1;
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
        if(i == k){
            if(iterator.hasNext()) {
                k++;
                i = 1;
                return iterator.next();
            }
            return null;
        }
        return element;
    }

}
