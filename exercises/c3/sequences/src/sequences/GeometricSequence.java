package sequences;

public class GeometricSequence extends Sequence{
    private int a, q;
    public GeometricSequence(int a, int q){
        this.a = a;
        this.q = q;
    }
    @Override
    public int getValue(int i) {
        return a*(int)Math.pow(q, i);
    }
}
