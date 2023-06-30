package sequences;

import java.util.Iterator;

public interface SequenceGenerator<E> extends Iterator<E> {
    public void setNextIndex(int index);
    public E getValue(int index);
}
