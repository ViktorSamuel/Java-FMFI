import java.math.BigInteger;

public class Factorial {
    public static BigInteger factorial(int n){
        BigInteger factorial = BigInteger.ONE;
        for (int i = n; i > 1; i--) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }
        return factorial;
    }
}
