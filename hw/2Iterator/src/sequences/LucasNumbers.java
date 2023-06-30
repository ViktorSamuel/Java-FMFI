package sequences;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

public class LucasNumbers extends Recurrence<BigInteger> {
    public LucasNumbers() {
        super(getInitialValues(), new Function<List<BigInteger>, BigInteger>(){
            @Override
            public BigInteger apply(List<BigInteger> bigIntegers) {
                return bigIntegers.get(bigIntegers.size()-1).add(bigIntegers.get(bigIntegers.size()-2));
            }
        });
    }

    public static List<BigInteger> getInitialValues(){
        List<BigInteger> list = new LinkedList<>();
        list.add(BigInteger.TWO);
        list.add(BigInteger.ONE);
        return list;
    }
}
