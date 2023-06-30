import java.util.ArrayList;
import java.util.List;

public class Multiset<E>{
    /* List to store distinct values */
    private List<E> values;

    /* List to store counts of distinct values */
    private List<Integer> frequency;

    public Multiset(){
        values = new ArrayList<>();
        frequency = new ArrayList<>();
    }

    public void add(E e){
        int index = values.indexOf(e);
        int prevCount = 0;

        if (index != -1)
        {
            prevCount = frequency.get(index);
            frequency.set(index, prevCount+1);
        }
        else{
            values.add(e);
            frequency.add(1);
        }
    }

    public void remove(E e){
        int index = values.indexOf(e);
        int prevCount = 0;

        if (index != -1) {
            prevCount = frequency.get(index);
            if (prevCount > 1) frequency.set(index, prevCount - 1);
            else{
                frequency.remove(index);
                values.remove(index);
            }
        }
    }

    public boolean contains(E e){
        int index = values.indexOf(e);
        if(index != -1) return true;
        return false;
    }

    public int getMultiplicity(E e){
        int index = values.indexOf(e);

        if (index != -1){
            return frequency.get(index);
        }
        return 0;
    }

}
