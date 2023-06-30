package bst;

import java.io.*;
import java.util.*;

public class CommandInterpreter {

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        Scanner scanner = new Scanner(System.in);
        PrintStream out = System.out;
        while (scanner.hasNext()) {
            String command = scanner.next();
            int key;
            switch (command) {
                case "isEmpty":
                    if (bst.isEmpty()) {
                        out.println("Strom je prazdny.");
                    } else {
                        out.println("Strom nie je prazdny.");
                    }
                    break;
                case "add":
                    key = scanner.nextInt();
                    bst.add(key);
                    out.println("Pridavam uzol s klucom " + key + ".");
                    break;
                case "contains":
                    key = scanner.nextInt();
                    if (bst.contains(key)) {
                        out.println("Strom obsahuje uzol s klucom " + key + ".");
                    } else {
                        out.println("Strom neobsahuje uzol s klucom " + key + ".");
                    }
                    break;
                case "minKey":
                    if (!bst.isEmpty()) {
                        out.println("Minimalna hodnota kluca v strome: " + bst.minKey() + ".");
                    } else {
                        out.println("Strom je prazdny.");
                    }
                    break;
                case "inorderKeys":
                    int[] keys = bst.inorderKeys();
                    out.print("Kluce stromu v poradi inorder:");
                    if (keys != null) {
                        for (int x : keys) {
                            out.print(" " + x);
                        }
                    }
                    out.println();
                    break;
                case "exit":
                    System.exit(0);
                    break;
            }
        }
    }

}
