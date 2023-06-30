import java.util.*;

public class Uloha1 {

    public static <T> Map<T, Integer> listToMap(List<T> list) {
        Map<T, Integer> result = new HashMap<>();
        list.forEach(item -> result.put(item, result.getOrDefault(item, 0) + 1));
        return result;
    }
}