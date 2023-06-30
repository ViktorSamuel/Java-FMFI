package matches;

import java.io.PrintStream;
import java.util.Scanner;

public class HumanPlayer implements Player {
    Scanner scanner;
    PrintStream out;
    public HumanPlayer(Scanner scanner, PrintStream out){
        this.scanner = scanner;
        this.out = out;
    }
    @Override
    public int take(int totalMatches, int maxMatches){
        int n;
        do{
            out.print("Zadaj pocet zapaliek: ");
            n = scanner.nextInt();
        }
        while (n < 1 || n > maxMatches);
        return n;
    }
}
