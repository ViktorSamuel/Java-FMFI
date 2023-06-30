package sequences;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

public class FibonacciNumbers extends Recurrence<BigInteger>{
    public FibonacciNumbers() {
        super(getInitialValues(), new Function<List<BigInteger>, BigInteger>(){
            @Override
            public BigInteger apply(List<BigInteger> fibonacciNumbers) {
                return fibonacciNumbers.get(fibonacciNumbers.size()-1).add(fibonacciNumbers.get(fibonacciNumbers.size()-2));
            }
        });
    }
    public static List<BigInteger> getInitialValues(){
        List<BigInteger> list = new LinkedList<>();
        list.add(BigInteger.ZERO);
        list.add(BigInteger.ONE);
        return list;
    }
}
