import java.util.*;

public class ListComparator<E extends Comparable<E>> implements Comparator<List<E>> {

    @Override
    public int compare(List<E> list1, List<E> list2) {
        if(list1.size() < list2.size()) return -1;
        if(list1.size() > list2.size()) return 1;

        for(int i = 0; i < list1.size(); i++){
            int compare = list1.get(i).compareTo(list2.get(i));
            if(compare != 0) return compare;
        }

        return 0;
    }

}
