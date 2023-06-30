import java.util.Arrays;

public class Polynomial {
    private int[] coef;

    public Polynomial(){
        this.coef = new int[1];
    }

    public Polynomial(int a, int n){
        if (n < 0) throw new IllegalArgumentException("exponent cannot be negative: " + n);
        this.coef = new int[n+1];
        this.coef[n] = a;
    }

    public Polynomial(int[] coefficients){
        this.coef = Arrays.copyOf(coefficients, coefficients.length);
    }

    public int getDegree() {
        for (int i = this.coef.length-1; i >= 0; i--) {
            if (this.coef[i] != 0) {
                return i;
            }
        }
        return Integer.MIN_VALUE;
    }

    public int getCoefficient(int n){
        if(n >= 0 && n < coef.length) return coef[n];
        return 0;
    }

    public Polynomial add(Polynomial p){
        int[] newCoef = new int[Math.max(this.coef.length, p.coef.length)];
        for (int i = 0; i < this.coef.length; i++) newCoef[i] += this.coef[i];
        for (int i = 0; i < p.coef.length; i++) newCoef[i] += p.coef[i];
        return new Polynomial(newCoef);
    }

    public String toString(){
        if (this.getDegree() == Integer.MIN_VALUE) return "0";

        StringBuilder buffer = new StringBuilder();
        for (int i = this.coef.length-1; i >= 0; i--){
            if(this.coef[i] != 0){
                if(i != this.coef.length-1) buffer.append('+');
                buffer.append(this.coef[i]+"x^"+i);
            }
        }
        return buffer.toString();
    }

}
