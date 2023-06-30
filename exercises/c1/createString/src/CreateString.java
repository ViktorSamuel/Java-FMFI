import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class CreateString {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        Scanner scan;
        String str;
        StringBuilder buffer = new StringBuilder();
        int n;
        while ((line = in.readLine()) != null) {

            scan = new Scanner(line);
            str = scan.next();

            while(scan.hasNextInt()){
                n = scan.nextInt();
                buffer.append(str.charAt(n));
            }
        }
        String out = buffer.toString();
        System.out.println("Dlzka retazca: "+out.length());
        System.out.println("Retazec: "+out);
    }
}
