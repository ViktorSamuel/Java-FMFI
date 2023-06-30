import robots.View;

import java.util.Scanner;

public class Test {
    static int nextCommand = 0;
    static String[] commands = {"UP", "RIGHT", "DOWN", "LEFT"};
    public static String nextAction() {
        if (nextCommand < commands.length) {
            return commands[nextCommand++];
        } else {
            return "SKIP";
        }
    }
    public static void main(String[] args) {
//        System.out.println(nextAction());
//        System.out.println(nextAction());
//        System.out.println(nextAction());
//        System.out.println(nextAction());
//        System.out.println(nextAction());
//        System.out.println(nextAction());

        String str = "PUT 3 UP";
        Scanner scanner = new Scanner(str);
        String command = scanner.next();
        System.out.println(str);
        System.out.println(command);
        System.out.println(str);
    }
}
