import java.io.*;
import java.util.Scanner;

public class ConcatenateMatrices {
    public static void main(String[] args) throws IOException
    {
        int n, m;
        Scanner in = new Scanner(new FileInputStream("vstup.txt"));

        n = in.nextInt();
        m = in.nextInt();

        String[][] a = new String[n][m];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                a[i][j] = "";
            }
        }

        while (in.hasNext()){
            for (int i = 0; i < n; i++){
                for (int j = 0; j < m; j++){
                    a[i][j] = a[i][j].concat(in.next());
                }
            }
        }

        PrintStream out = new PrintStream("vystup.txt");

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++) {
                out.println("["+i+","+j+"]: "+a[i][j]);
            }
        }
        out.close();
        in.close();
    }
}
