import java.math.BigInteger;

public class ExtendedBigInteger extends BigInteger {

    public ExtendedBigInteger(String val) { super(val); }

    public ExtendedBigInteger(BigInteger val) { super(val.toString());
    }

    public ExtendedBigInteger fallingFactorial(int k) {
        if (k == 0) {
            return new ExtendedBigInteger("1");
        }
        BigInteger result = this;
        for (int i = 1; i < k; i++) {
            result = result.multiply(this.subtract(new BigInteger(Integer.toString(i))));
        }
        return new ExtendedBigInteger(result);
    }

}
