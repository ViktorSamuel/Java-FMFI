package robots;

/** Trieda reprezentujuca vychod z bludiska. */
public class Exit extends Square {

    /** Konstruktor, ktory vytvori vychod z bludiska, na ktorom je ulozeny dany zaznam. */
    public Exit(int record) {
        super(record);
    }

    /** Vychod z bludiska je vzdy pristupny. */
    @Override
    public boolean isAccessible() {
        return true;
    }

    /** Vychod z bludiska je prekvapivo vychodom z bludiska. */
    @Override
    public boolean isFinal() {
        return true;
    }
}
