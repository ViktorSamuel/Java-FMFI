package sequences;

public class FibonacciSequence extends Sequence{
    @Override
    public int getValue(int i){
        if(i == 0)return 0;
        else if(i == 1) return 1;
        else{
            int f0 = 0, f1 = 1, f;
            for (int j = 2; j <= i; j++){
                f = f1 + f0;
                f0 = f1;
                f1 = f;
            }
            return f1;
        }
    }
}
