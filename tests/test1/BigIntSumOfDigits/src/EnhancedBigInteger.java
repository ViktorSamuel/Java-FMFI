import java.math.*;

public class EnhancedBigInteger extends BigInteger {

    public EnhancedBigInteger(String s) {
        super(s);
    }

    public int digitSum() {

        // Doprogramujte telo tejto metody. Zvysne casti tejto triedy nemente.
        String str = this.abs().toString();
        int sum = 0;
        for(int i = 0; i < str.length(); i++){
            sum += str.charAt(i) - '0';
        }
        return sum;
    }

}