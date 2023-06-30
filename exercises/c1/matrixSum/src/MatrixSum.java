import java.util.Scanner;

public class MatrixSum {
    public static int[][] matrix(Scanner in, int n, int m)
    {
        int[][] a = new int[n][m];

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                a[i][j] = in.nextInt();
            }
        }

        return a;
    }

    public static void addAndPrint(int[][] a, int[][] b, int n, int m)
    {
        int[][] c = new int[n][m];
        int max = 0;

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                c[i][j] = a[i][j] + b[i][j];

                if (Integer.toString(c[i][j]).length() > max) max = Integer.toString(c[i][j]).length();
            }
        }

        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < m; j++)
            {
                System.out.printf("%" + max + "d", c[i][j]);
                if(j < m-1) System.out.printf(" ");
            }
            System.out.printf("\n");
        }
    }
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int m = in.nextInt();

        int[][] a = matrix(in, n, m);
        int[][] b = matrix(in, n, m);

        addAndPrint(a, b, n, m);
    }
}
