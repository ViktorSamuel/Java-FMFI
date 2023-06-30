package robots;

/** Trieda reprezentujuca prazdne policko -- t. j. pristupne policko, ktore nie je vychodom z bludiska. Policko sa teda
 * v tomto zmysle povazuje za prazdne aj vtedy, ked na nom stoji robot. */
public class EmptySquare extends Square {

    /** Konstruktor, ktory vytvori prazdne policko, na ktorom je ulozeny dany zaznam. */
    public EmptySquare(int record) {
        super(record);
    }

    /** Prazdne policko je vzdy pristupne. */
    @Override
    public boolean isAccessible() {
        return true;
    }

    /** Prazdne policko nikdy nie je vychodom z bludiska. */
    @Override
    public boolean isFinal() {
        return false;
    }
}
