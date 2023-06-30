import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.*;

public class RadixOrder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> strings = new ArrayList<>();

        while (scanner.hasNext()) {
            String s = scanner.next();
            if (s.equals("-")) {
                break;
            }
            strings.add(s);
        }

        // usporiadanie
        Collections.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                int len1 = s1.length();
                int len2 = s2.length();
                if (len1 < len2) {
                    return -1;
                } else if (len1 > len2) {
                    return 1;
                } else {
                    for (int i = 0; i < len1; i++) {
                        if (s1.charAt(i) < s2.charAt(i)) {
                            return -1;
                        } else if (s1.charAt(i) > s2.charAt(i)) {
                            return 1;
                        }
                    }
                    return 0;
                }
            }
        });

        // vypis
        int i = 0;
        System.out.print('[');
        for (String s : strings) {
            i++;
            if(i < strings.size()) System.out.print(s+", ");
            else System.out.print(s);
        }
        System.out.println(']');


    }
}
