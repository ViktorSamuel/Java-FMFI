package robots;

/** Trieda reprezentujuca stenu -- t. j. nepristupne policko bludiska. */
public class Wall extends Square {

    /** Konstruktor, ktory vytvori stenu s danym zaznamom. Kedze je ale stena nepristupnym polickom, je zaznam na tomto
     * policku prakticky nepouzitelny. */
    public Wall(int record) {
        super(record);
    }

    /** Stena je nepristupne policko. */
    @Override
    public boolean isAccessible() {
        return false;
    }

    /** Stena nikdy nemoze byt vychodom z bludiska. */
    @Override
    public boolean isFinal() {
        return false;
    }
}
