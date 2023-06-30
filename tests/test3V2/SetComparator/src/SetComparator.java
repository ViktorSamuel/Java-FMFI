import java.util.*;

public class SetComparator implements Comparator<Set<Integer>> {

    @Override
    public int compare(Set<Integer> set1, Set<Integer> set2) {
        if(set1.size() < set2.size()) return -1;
        else if(set1.size() > set2.size()) return 1;
        else {
            Set<Integer> copy1 = new HashSet<>(set1);
            Set<Integer> copy2 = new HashSet<>(set2);

            while (!copy1.isEmpty()){
                int min1 = Integer.MAX_VALUE;
                int min2 = Integer.MAX_VALUE;

                for(int x: copy1){
                    if(x < min1) min1 = x;
                }
                for(int x: copy2){
                    if(x < min2) min2 = x;
                }
                copy1.remove(min1);
                copy2.remove(min2);
                if(min1 < min2) return -1;
                else if (min1 > min2) return 1;
            }
        }
        return 0;
    }

}
