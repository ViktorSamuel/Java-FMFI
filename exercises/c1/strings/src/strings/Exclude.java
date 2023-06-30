package strings;

public class Exclude {
    public static String[] exclude(String[] array, String value)
    {
        int n = array.length;
        int m = 0, i = 0;
        for (String str: array)
        {
            if(value.equals(str)) m++;
        }

        String[] a = new String[n-m];

        for (String str: array)
        {
            if (!value.equals(str))
            {
                a[i] = str;
                i++;
            }
        }
        return a;
    }
}
