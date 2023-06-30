package robots;

import java.util.*;

/** Trieda realizujuca simulaciu pohybu daneho robota v danom bludisku. */
public class Simulation {
    private Square[][] labyrinth;
    private Robot robot;
    private int robotRow;
    private int robotCol;

    /**
     * Vytvorenie novej simulacie.
     * @param labyrinth Dvojrozmerne pole policok typu Square reprezentujuce labyrint.
     * @param robot     Robot, ktoreho pohyb v labyrinte sa simuluje.
     * @param robotRow  Riadok, v ktorom sa robot nachadza na zaciatku simulacie.
     * @param robotCol  Stlpec, v ktorom sa robot nachadza na zaciatku simulacie.
     */
    public Simulation(Square[][] labyrinth, Robot robot, int robotRow, int robotCol) {
        int m = labyrinth.length;
        this.labyrinth = new Square[m][];
        for (int i = 0; i <= m - 1; i++) {
            this.labyrinth[i] = Arrays.copyOf(labyrinth[i], labyrinth[i].length);
        }
        this.robot = robot;
        this.robotRow = robotRow;
        this.robotCol = robotCol;
    }

    /** V pripade, ze uz robot objavil niektory vychod z bludiska, vrati nasledujuca metoda na vystupe retazec
     *  "FINISHED" a jej vykonavanie sa skonci. V opacnom pripade bude metoda vykonavat akcie robota na zaklade jeho
     *  metody nextAction, az kym sa robot pokusi vykonat nejaku pohybovu akciu.
     *  V pripade, ze sa pozadovana pohybova akcia da vykonat (policko, na ktore sa robot pokusa pohnut, je
     *  pristupne), metoda ju vykona a vrati ju na vystupe. V opacnom pripade sa pozicia robota nezmeni a na vystupe
     *  metody sa vrati retazec "FAIL".
     *  V simulacii mozno pokracovat opakovanymi volaniami tejto metody. */
    public String nextMove() {
        /* Ak uz robot objavil vychod z bludiska, vykonavanie metody sa ukonci s vystupnym retazcom "FINISHED". */
        if (labyrinth[robotRow][robotCol].isFinal()) {
            return "FINISHED";
        }
        /* Vytvorenie "vyhladu" robota na zaklade jeho momentalnej pozicie v bludisku. */
        View view = new View(
                labyrinth[robotRow][robotCol],
                labyrinth[robotRow - 1][robotCol],
                labyrinth[robotRow][robotCol + 1],
                labyrinth[robotRow + 1][robotCol],
                labyrinth[robotRow][robotCol - 1]
        );
        /* Zistenie nasledujucej akcie robota pomocou jeho metody nextAction a odsimulovanie tejto akcie. */
        String robotAction = robot.nextAction(view);
        Scanner scanner = new Scanner(robotAction);
        String command = scanner.next();
        switch (command) {
            case "UP":
                if (!view.getUp().isAccessible()) {
                    return "FAIL";
                }
                robotRow--;
                return robotAction;
            case "RIGHT":
                if (!view.getRight().isAccessible()) {
                    return "FAIL";
                }
                robotCol++;
                return robotAction;
            case "DOWN":
                if (!view.getDown().isAccessible()) {
                    return "FAIL";
                }
                robotRow++;
                return robotAction;
            case "LEFT":
                if (!view.getLeft().isAccessible()) {
                    return "FAIL";
                }
                robotCol--;
                return robotAction;
            case "PUT":
                /* Nacitanie argumentu nasledujuceho za prikazom PUT. */
                int record = scanner.nextInt();
                labyrinth[robotRow][robotCol] = new EmptySquare(record);
                /* Kedze PUT nie je pohybova akcia, treba v simulacii pokracovat. */
                return nextMove();
            case "SKIP":
                return robotAction;
        }
        return "FAIL";
    }
}
