package sequences;

import java.util.*;

public class CommandInterpreter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String command = scanner.next();
            int initialValue, difference, quotient;
            Sequence sequence = null;
            switch (command) {
                case "ARITHMETIC":
                    initialValue = scanner.nextInt();
                    difference = scanner.nextInt();
                    sequence = new ArithmeticSequence(initialValue, difference);
                    break;
                case "GEOMETRIC":
                    initialValue = scanner.nextInt();
                    quotient = scanner.nextInt();
                    sequence = new GeometricSequence(initialValue, quotient);
                    break;
                case "FIBONACCI":
                    sequence = new FibonacciSequence();
                    break;
                case "EXIT":
                    System.exit(0);
                    break;
            }
            if (sequence != null) {
                int n = scanner.nextInt();
                int[] indices = new int[n];
                for (int i = 0; i <= n - 1; i++) {
                    indices[i] = scanner.nextInt();
                }
                int[] values = sequence.getValues(indices);
                for (int i = 0; i <= n - 1; i++) {
                    System.out.print(values[i]);
                    if (i <= n - 2) {
                        System.out.print(" ");
                    } else {
                        System.out.println();
                    }
                }
            }
        }
    }
}
