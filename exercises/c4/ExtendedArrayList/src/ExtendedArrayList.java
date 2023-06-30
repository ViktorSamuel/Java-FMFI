import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class ExtendedArrayList<E> extends ArrayList<E> {

    public ExtendedArrayList(){ super(); }

    public ExtendedArrayList(Collection<? extends E> collection){ super(collection); }

    public ExtendedArrayList(int initialCapacity){ super(initialCapacity); }

    public ExtendedArrayList(E[] array){
        super(Arrays.asList(array));
    }

    public void addAll(E[] array){
        this.addAll(Arrays.asList(array));
    }
}
