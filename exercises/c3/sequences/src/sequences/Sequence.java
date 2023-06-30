package sequences;

/** Abstraktna trieda reprezentujuca nekonecnu postupnost celych cisel indexovanu od nuly. */
public abstract class Sequence {

    /** Abstraktna metoda, ktora ma vratit prvok postupnosti s indexom index. */
    public abstract int getValue(int index);

    /** Metoda, ktora vrati pole hodnot postupnosti na indexoch danych vstupnym polom indices. */
    public int[] getValues(int[] indices) {
        int n = indices.length;
        int[] result = new int[n];
        for (int i = 0; i <= n - 1; i++) {
            result[i] = getValue(indices[i]);
        }
        return result;
    }
}
