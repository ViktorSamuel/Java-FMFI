import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

public class Complement {
    public static void main(String[] args) throws IOException
    {
        BufferedReader in = new BufferedReader(new FileReader("vstup.txt"));
        PrintStream out = new PrintStream("vystup.txt");
        int n;
        while ((n = in.read()) != -1)
        {
            switch (n)
            {
                case 48:
                    out.print("1");
                    break;
                case 49:
                    out.print("0");
                    break;
                default:
                    out.print((char)n);
            }
        }
        in.close();
        out.close();
    }
}
