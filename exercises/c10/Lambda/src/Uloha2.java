import java.util.*;

public class Uloha2 {

    public static <T> void increaseAll(Map<T, Integer> map) {
        map.replaceAll((key, value) -> value + 1);
    }
}
