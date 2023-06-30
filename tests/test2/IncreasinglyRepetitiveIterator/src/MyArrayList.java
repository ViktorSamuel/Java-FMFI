import java.util.*;

public class MyArrayList<E> extends ArrayList<E> {

    @Override
    public Iterator<E> iterator() {
        return new IncreasinglyRepetitiveIterator<>(new Iterator<E>() {
        });
    }
}