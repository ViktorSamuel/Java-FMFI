package matrices;

import java.util.ArrayList;

public class Matrix<E> {
    private ArrayList<ArrayList<E>> matrix;
    private int colums;

    public Matrix(){
        this.matrix = new ArrayList<>();
        this.colums = 0;
    }

    public Matrix(int m, int n, E value){
        if (m < 0 || n < 0) {
            throw new NegativeMatrixDimensionException();
        }

        this.matrix = new ArrayList<>(m);
        this.colums = n;

        for (int i = 0; i < m; i++) {
            ArrayList<E> row = new ArrayList<>(n);
            for (int j = 0; j < n; j++) {
                row.add(value);
            }
            this.matrix.add(row);
        }
    }

    public int rowCount(){ return this.matrix.size();}

    public int columnCount(){ return colums; }

    public E get(int i, int j){
        if (i < 0 || i >= rowCount() || j < 0 || j >= columnCount()) {
            throw new IndexOutOfBoundsException();
        }
        return this.matrix.get(i).get(j);
    }

    public void set(int i, int j, E value){
        if (i < 0 || i >= rowCount() || j < 0 || j >= columnCount()) {
            throw new IndexOutOfBoundsException();
        }
        this.matrix.get(i).set(j, value);
    }
    public void addRow(E value){
        ArrayList<E> newRow = new ArrayList<>();
        for (int i = 0; i < colums; i++) newRow.add(value);
        this.matrix.add(newRow);
    }
    public void addColumn(E value){
        for (int i = 0; i < this.matrix.size(); i++){
            this.matrix.get(i).add(value);
        }
        this.colums++;
    }

    @Override
    public String toString(){
        return this.matrix.toString();
    }
}
