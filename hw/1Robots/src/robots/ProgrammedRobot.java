package robots;

import java.util.*;

/** Trieda reprezentujuca programovaneho robota, ktory sa bez ohladu na bludisko zakazdym pokusi vykonat rovnaku
 * konecnu postupnost akcii z argumentu svojho konstruktora. */
public class ProgrammedRobot implements Robot {
    private String[] commands;
    private int nextCommand;

    /** Konstruktor, ktory vytvori programovaneho robota s danym konecnym programom. */
    public ProgrammedRobot(String[] commands) {
        this.commands = Arrays.copyOf(commands, commands.length);
        nextCommand = 0;
    }

    /** Nasledujucou akciou programovaneho robota je vzdy prvy este nevykonany prikaz jeho programu. V pripade, ze sa
     * uz vykonali vsetky prikazy programu robota, vykona sa akcia "SKIP". */
    @Override
    public String nextAction(View view) {
        if (nextCommand < commands.length) {
            return commands[nextCommand++];
        } else {
            return "SKIP";
        }
    }
}
