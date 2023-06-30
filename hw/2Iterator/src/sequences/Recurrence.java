package sequences;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Function;

public class Recurrence<E> implements SequenceGenerator<E> {
    private List<E> values;
    private List<E> tmpValues;
    private Function<List<E>, E> formula;
    private int nextIndex;

    public Recurrence(List<E> initialValues, Function<List<E>, E> formula) {
        if (formula == null || initialValues == null || initialValues.isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.values = new LinkedList<>(initialValues);
        this.tmpValues = new LinkedList<>(initialValues);
        this.formula = formula;
        this.nextIndex = 0;
    }

    public void setNextIndex(int index) {
        if (index < 0) {
            throw new IllegalArgumentException();
        }
        this.nextIndex = index;
    }

    public E getValue(int index) {
        if (index < 0) {
            throw new IllegalArgumentException();
        }
        while (this.values.size() <= index) {
            E tmpValue = this.formula.apply(this.tmpValues);
            if (tmpValue == null) {
                throw new NoSuchElementException();
            }
            this.tmpValues.add(tmpValue);
            this.tmpValues.remove(0);
            this.values.add(tmpValue);
        }
        return this.values.get(index);
    }

    @Override
    public boolean hasNext() {
        while (this.values.size() <= this.nextIndex) {
            E tmpValue = this.formula.apply(this.tmpValues);
            if (tmpValue == null) {
                this.values.add(null);
                return false;
            }
            this.tmpValues.add(tmpValue);
            this.tmpValues.remove(0);
            this.values.add(tmpValue);
        }
        return this.values.get(this.nextIndex) != null;
    }

    @Override
    public E next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        this.nextIndex++;
        return this.values.get(this.nextIndex - 1);
    }
}
