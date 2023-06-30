import java.util.*;

public class StringOccurrences {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Integer> occurrences = new TreeMap<>();

        // citanie
        while (scan.hasNextLine()) {
            Scanner sc = new Scanner(scan.nextLine());
            List<String> line = new ArrayList<>();
            while (sc.hasNext()) {
                String word = sc.next();
                if (!line.contains(word)) {
                    line.add(word);
                    occurrences.merge(word, 1, Integer::sum);
                }
            }
        }

        // vypis v lexikografickom poradi
        for (Map.Entry<String, Integer> entry : occurrences.entrySet()) {
            System.out.printf("Slovo \"%s\" sa vyskytuje na %d roznych riadkoch.\n", entry.getKey(), entry.getValue());
        }
    }
}
