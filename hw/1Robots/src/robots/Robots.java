package robots;

import java.util.*;

/** Hlavna trieda starajuca sa o nacitavanie vstupu a vypisovanie vystupu. */
public class Robots {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /* Nacitanie rozmerov bludiska. */
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        scanner.nextLine();

        /* Nacitanie bludiska samotneho, vratane pociatocnej pozicie robota v nom. */
        Square[][] labyrinth = new Square[m][n];
        int robotRow = -1;
        int robotCol = -1;
        for (int i = 0; i <= m - 1; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j <= n - 1; j++) {
                switch (line.charAt(j)) {
                    case '#':
                        labyrinth[i][j] = new Wall(0);
                        break;
                    case '.':
                        labyrinth[i][j] = new EmptySquare(0);
                        break;
                    case '*':
                        labyrinth[i][j] = new Exit(0);
                        break;
                    case 'R':
                        robotRow = i;
                        robotCol = j;
                        labyrinth[i][j] = new EmptySquare(0);
                        break;
                }
            }
        }

        /* Nacitanie typu robota a jeho vytvorenie. */
        Robot robot = null;
        int commandCount;
        String[] commands;
        String robotType = scanner.nextLine();
        switch (robotType) {
            case "ProgrammedRobot":
                /* Nacitanie dlzky programu robota a nasledne samotnych prikazov tohto programu. */
                commandCount = scanner.nextInt();
                scanner.nextLine();
                commands = new String[commandCount];
                for (int i = 0; i <= commandCount - 1; i++) {
                    commands[i] = scanner.nextLine();
                }
                robot = new ProgrammedRobot(commands);
                break;
            case "CowardProgrammedRobot":
                /* Nacitanie dlzky programu robota a nasledne samotnych prikazov tohto programu. */
                commandCount = scanner.nextInt();
                scanner.nextLine();
                commands = new String[commandCount];
                for (int i = 0; i <= commandCount - 1; i++) {
                    commands[i] = scanner.nextLine();
                }
                robot = new CowardProgrammedRobot(commands);
                break;
            case "DirectionRotatingRobot":
                robot = new DirectionRotatingRobot();
                break;
            case "DepthFirstSearchRobot":
                robot = new DepthFirstSearchRobot();
                break;
        }

        /* Nacitanie poctu krokov simulacie a jej spustenie. */
        int simulationRouds = scanner.nextInt();
        Simulation simulation = new Simulation(labyrinth, robot, robotRow, robotCol);
        for (int i = 1; i <= simulationRouds; i++) {
            /* Kazda vygenerovana pohybova akcia robota sa vypise na vystup. */
            System.out.println(simulation.nextMove());
        }
    }
}
