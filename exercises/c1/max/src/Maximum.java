import java.util.Scanner;
public class Maximum
{
    public static void main(String[] args)
    {
        int max = Integer.MIN_VALUE;
        Scanner in = new Scanner(System.in);
        int num;
        while(in.hasNextInt())
        {
            num = in.nextInt();
            if(num > max)
            {
                max = num;
            }
        }
        System.out.println(max);
    }
}
