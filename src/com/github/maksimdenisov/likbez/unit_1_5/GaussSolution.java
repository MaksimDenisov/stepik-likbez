package com.github.maksimdenisov.likbez.unit_1_5;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class GaussSolution {
    //[row][column]
    private final double[][] matrix;

    /****************************************************/
    public static void main(String[] args) throws Exception {
        InputStream stream = new ByteArrayInputStream(TestData.Test_2.getBytes());
        GaussSolution solution = new GaussSolution(Util.scanMatrix(stream));
        for (double v : solution.getSolve()) {
            System.out.printf("%f16 ", v);
        }
    }

    /****************************************************/

    public GaussSolution(double[][] matrix) {
        this.matrix = matrix;
        System.out.println("Incoming data");
        //TODO Prepare Matrix Sort перемещать столбцы с 0 влево
        printMatrix();
        doStraightRun();
        doReverseRun();
    }

    public double[][] getMatrix() {
        return matrix;
    }

    public double[] getSolve() throws IllegalArgumentException {
        double[] solve = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            solve[i] = matrix[i][matrix[0].length - 1] / matrix[i][i];
        }
        return solve;
    }

    public Integer getSolvesQuantity() {
        return Integer.MAX_VALUE;
    }

    private void doStraightRun() {
        System.out.println("doStraightRun");
        for (int step = 0; step < matrix.length - 1; step++) {
            for (int i = step + 1; i < matrix.length; i++) {
                if (matrix[step][step] == 0) {
                    swapRows(step, i);
                } else {
                    multiplyRow(i, (matrix[step][step] / matrix[i][step]));
                    subtractRow(i, step);
                }
            }
            printMatrix();
        }
    }

    private void doReverseRun() {
        System.out.println("doReverseRun");
        for (int step = matrix.length - 1; step > 0; step--) {
            for (int i = step - 1; i >= 0; i--) {
                multiplyRow(i, (matrix[step][step] / matrix[i][step]));
                subtractRow(i, step);
            }
            printMatrix();
        }
    }

    private void swapColumns(int aColIndex, int bColIndex) {
        checkColumnIndex(aColIndex);
        checkColumnIndex(bColIndex);
        for (int i = 0; i < matrix.length; i++) {
            double swap = matrix[i][aColIndex];
            matrix[i][aColIndex] = matrix[i][bColIndex];
            matrix[i][bColIndex] = swap;
        }
    }

    private void swapRows(int aRowIndex, int bRowIndex) {
        System.out.println("swapRows");
        checkRowIndex(aRowIndex);
        checkRowIndex(bRowIndex);
        for (int i = 0; i < matrix[0].length; i++) {
            double swap = matrix[aRowIndex][i];
            matrix[aRowIndex][i] = matrix[bRowIndex][i];
            matrix[bRowIndex][i] = swap;
        }
    }

    private void multiplyRow(int row, double k) {
        System.out.printf("multiplyRow #%d on %f\n", row, k);
        checkRowIndex(row);
        if (0 == k) {
            throw new IllegalArgumentException("Must be not equal 0");
        }

        for (int i = 0; i < matrix[0].length; i++) {
            matrix[row][i] = matrix[row][i] * k;
        }
    }

    private void subtractRow(int minuend, int subtrahend) {
        checkRowIndex(minuend);
        checkRowIndex(subtrahend);
        for (int i = 0; i < matrix[0].length; i++) {
            matrix[minuend][i] = matrix[minuend][i] - matrix[subtrahend][i];
        }
    }

    private int rank() {
        return 0;
    }

    private void check(int row, int column) {
        checkRowIndex(row);
        checkColumnIndex(column);
    }

    private void checkRowIndex(int row) {
        if (row < 0 || row > matrix.length - 1) {
            throw new IllegalArgumentException("Row index must be lower than " + (matrix.length - 1) + ", but  equals " + row);
        }
    }

    private void checkColumnIndex(int column) {
        if (column < 0 || column > matrix[0].length - 2) {
            throw new IllegalArgumentException("Column index must be lower than " + (matrix[0].length - 2) + ", but  equals " + column);
        }
    }

    private void printMatrix() {
        Util.printMatrix(getMatrix());
    }
}
