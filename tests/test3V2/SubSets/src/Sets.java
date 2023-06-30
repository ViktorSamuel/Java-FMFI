import java.util.*;

public class Sets {

    public static <T> Set<Set<T>> powerSet(Set<T> set) {
        Set<Set<T>> result = new HashSet<>();
        List<T> list = new ArrayList<>(set);
        int n = list.size();
        for (int i = 0; i < (1 << n); i++) {
            Set<T> subset = new HashSet<>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    subset.add(list.get(j));
                }
            }
            result.add(Collections.unmodifiableSet(subset));
        }
        return Collections.unmodifiableSet(result);
    }
}
