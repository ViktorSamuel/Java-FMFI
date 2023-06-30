package matches;

import java.io.*;
import java.util.*;

public class Matches {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PrintStream out = System.out;
        int totalMatches = scanner.nextInt();
        int maxMatches = scanner.nextInt();

        Player[] players = new Player[2];
        String[] playerTypes = new String[2];
        playerTypes[0] = scanner.next();
        playerTypes[1] = scanner.next();

        for (int i = 0; i <= 1; i++) {
            switch (playerTypes[i]) {
                case "MINIMALISTIC":
                    players[i] = new MinimalisticPlayer();
                    break;
                case "OPTIMAL":
                    players[i] = new OptimalPlayer();
                    break;
                case "HUMAN":
                    players[i] = new HumanPlayer(scanner, out);
                    break;
            }
        }

        int currentPlayer = 0;
        while (totalMatches > 0) {
            int take = players[currentPlayer].take(totalMatches, maxMatches);
            totalMatches = Math.max(totalMatches - take, 0);
            out.println("Hrac " + currentPlayer + " berie " + take + " zapaliek. Zostava "
                    + totalMatches + " zapaliek.");
            currentPlayer = 1 - currentPlayer;
            if (totalMatches <= 0) {
                out.println("Vyhrava hrac " + currentPlayer);
            }
        }
    }
}
