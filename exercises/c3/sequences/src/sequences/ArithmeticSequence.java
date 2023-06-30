package sequences;

public class ArithmeticSequence extends Sequence{
    private int a, d;
    public ArithmeticSequence(int a, int d){
        this.a = a;
        this.d = d;
    }
    @Override
    public int getValue(int i){
        return a+d*i;
    }
}
