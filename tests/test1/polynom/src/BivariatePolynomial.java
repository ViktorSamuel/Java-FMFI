public class BivariatePolynomial {

    private int[][] coefficients;

    public BivariatePolynomial() {
        coefficients = new int[1][1];
    }

    public BivariatePolynomial(int a, int m, int n) {
        coefficients = new int[m+1][n+1];
        coefficients[m][n] = a;
    }

    public BivariatePolynomial(int[][] coefficients) {
        int rows = coefficients.length;
        int cols = 0;
        for (int i = 0; i < rows; i++) {
            if (coefficients[i] != null && coefficients[i].length > cols) {
                cols = coefficients[i].length;
            }
        }
        this.coefficients = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            if (coefficients[i] != null) {
                for (int j = 0; j < coefficients[i].length; j++) {
                    this.coefficients[i][j] = coefficients[i][j];
                }
            }
        }
    }

    public int getDegree() {
        int degree = Integer.MIN_VALUE;
        for (int i = 0; i < coefficients.length; i++) {
            for (int j = 0; j < coefficients[i].length; j++) {
                if (coefficients[i][j] != 0 && i+j > degree) {
                    degree = i+j;
                }
            }
        }
        return degree;
    }

    public int getCoefficient(int i, int j) {
        if (i < 0 || j < 0 || i >= coefficients.length || j >= coefficients[i].length) {
            return 0;
        }
        return coefficients[i][j];
    }
}
