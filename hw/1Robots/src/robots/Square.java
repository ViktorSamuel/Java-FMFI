package robots;

/** Abstraktna trieda reprezentujuca jedno policko labyrintu, na ktorom moze byt ulozeny nejaky celociselny zaznam
 * (record). */
public abstract class Square {
    private int record;

    /** Konstruktor, ktory vytvori nove policko s danym zaznamom. Kedze je samotna trieda Square abstraktna, je tento
     * konstruktor urceny vyhradne na pouzitie z podtried triedy Square. */
    public Square(int record) {
        this.record = record;
    }

    /** Metoda, ktora vrati true prave vtedy, ked je policko pristupne. */
    public abstract boolean isAccessible();

    /** Metoda, ktora vrati true prave vtedy, ked je policko vychodom z bludiska. */
    public abstract boolean isFinal();

    /** Metoda, ktora vrati zaznam ulozeny na policku. */
    public int getRecord() { return record; }
}
