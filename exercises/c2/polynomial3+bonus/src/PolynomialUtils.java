public class PolynomialUtils {
    public static Polynomial add(Polynomial p1, Polynomial p2){ return p1.add(p2); }

    public static Polynomial multiply(Polynomial p1, Polynomial p2){
        if(p1.getDegree() < 0 || p2.getDegree() < 0) return new Polynomial();
        int[] newCoef = new int[p1.getDegree()+p2.getDegree()+1];
        for(int i = 0; i <= p1.getDegree(); i++){
            for(int j = 0; j <= p2.getDegree(); j++){
                newCoef[i+j] += p1.getCoefficient(i)*p2.getCoefficient(j);
            }
        }
        return new Polynomial(newCoef);
    }

    public static Polynomial formalDerivative(Polynomial p){
        if(p.getDegree() < 1) return new Polynomial();
        int[] newCoef = new int[p.getDegree()];
        for (int i = 1; i <= p.getDegree(); i++){
            newCoef[i-1] = p.getCoefficient(i)*i;
        }
        return new Polynomial(newCoef);
    }
}


