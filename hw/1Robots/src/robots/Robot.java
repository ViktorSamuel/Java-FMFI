package robots;

/** Rozhranie, ktore by mali implementovat vsetky triedy reprezentujuce robotov. */
public interface Robot {

    /** Metoda, ktora na zaklade "vyhladu" robota z jeho momentalnej pozicie zvoli jeho nasledujucu akciu. */
    String nextAction(View view);

}
