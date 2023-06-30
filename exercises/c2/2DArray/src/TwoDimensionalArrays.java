import java.util.Arrays;
public class TwoDimensionalArrays {
    public static int[][] copyOf(int[][] a){
        if(a == null) return null;
        else{
            int[][] b = new int[a.length][];
            for(int i = 0; i < a.length; i++){
                if(a[i] != null) b[i] = Arrays.copyOf(a[i], a[i].length);
            }
            return b;
        }
    }
}
