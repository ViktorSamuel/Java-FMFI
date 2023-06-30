import java.util.*;

public class Variations<E extends Comparable<E>> implements Iterator<List<E>> {
    private Set<E> setE;

    private TreeSet tempSet;
    private Boolean[] used;
    private int count;
    private int size;
    private List<E> listE = new ArrayList<>(); //zostavajuce prvky ktore mozeme pridat do k-tice(resultu)

    int level = 0;
    Stack<E> result = new Stack<>(); // obsahuje poslednú k-ticu ktory vratil next
    List<Integer> swapNumbers = new ArrayList<>();

    public Variations(Set<E> set, int k) {
        if (set == null || k < 0) {
            throw new IllegalArgumentException();
        } else {
            tempSet = new TreeSet();
            tempSet.addAll(set);
            size = k;
            used = new Boolean[k];
            Arrays.fill(used, Boolean.FALSE);
            setE = new TreeSet<>(set);
            count = 0;

            listE.addAll(tempSet);
            for (int i = 0; i < k; i++) {
                swapNumbers.add(1);
            }
        }

    }

    @Override
    public List<E> next() {

        if (hasNext()) {
            if (!result.isEmpty()) {
                result.pop();
                level--;
            }
            count++;
            while (result.size() != size) { //pridaj zostavajuce prvky z listE dokedy nebude k-tica plna
                if (listE.isEmpty()) { //vyčerpaly sa prvky

                    result.pop(); //chod o uroven nizsie
                    level--;

                    listE.addAll(tempSet); //znova pridaj vsetky do listu
                    listE.removeAll(result); // okrem tych co su v resulte

                    while (swapNumbers.get(level) > listE.size() - 1) { //uz sme presly vsetky prvky na poslenej urovny a musime ist o dalsie urovne nizsie
                        swapNumbers.set(level, 1);

                        level--;
                        result.pop();

                        listE.clear();
                        listE.addAll(tempSet);
                        listE.removeAll(result);
                    }

                    listE.add(0, listE.get(swapNumbers.get(level)));
                    listE.remove(swapNumbers.get(level) + 1);
                    swapNumbers.set(level, swapNumbers.get(level) + 1);
                }

                level++;
                result.add(listE.get(0));
                listE.remove(0);

            }
        } else {
            throw new NoSuchElementException();
        }
        return result;
    }



    @Override
    public boolean hasNext() {
        int allOptions;
        if (size == 0) {
            allOptions = 0;
        } else {
            allOptions = 1;
            for (int i = setE.size(); i > setE.size() - size; i--) {
                allOptions *= i;
            }
        }
        return count < allOptions;
    }
}