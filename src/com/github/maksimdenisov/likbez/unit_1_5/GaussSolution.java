package com.github.maksimdenisov.likbez.unit_1_5;

/**
 * https://prog-cpp.ru/gauss/
 */
public class GaussSolution {
    private static final double EPSILON = 0.00001;
    //[row][column]
    private final double[][] matrix;
    private String hasSolution = "";

    /****************************************************/

    public GaussSolution(double[][] matrix) {
        this.matrix = matrix;
        System.out.println("Incoming data");
        //TODO Prepare Matrix Sort перемещать столбцы с 0 влево
        printMatrix();
        doStraightRun();
        System.out.printf("Rank = %d, Extended rank = %d\n", getRank(), getRankExtended());
        if (getRank() < getRankExtended()) {
            hasSolution = "NO";
        } else {
            if (getRank() == getRankExtended()) {
                if (getRank() < matrix[0].length - 1) {
                    hasSolution = "INF";

                } else {
                    doReverseRun();
                    hasSolution = "YES";
                }
            } else {
                hasSolution = "INF";
            }
        }
    }

    public double[][] getMatrix() {
        return matrix;
    }

    public double[] getSolution() throws IllegalArgumentException {
        double[] solve = new double[matrix[0].length - 1];
        for (int i = 0; i < solve.length; i++) {
            solve[i] = matrix[i][matrix[0].length - 1] / matrix[i][i];
        }
        return solve;
    }

    public String hasSolution() {
        return hasSolution;
    }

    private void doStraightRun() {
        System.out.println("doStraightRun");
        for (int step = 0; step < matrix.length - 1; step++) {
            for (int i = step + 1; i < matrix.length; i++) {
                if (matrix[step][step] == 0) {
                    swapRows(step, i);
                } else {
                    if (matrix[i][step] == 0)
                        break;
                    multiplyRow(i, (matrix[step][step] / matrix[i][step]));
                    subtractRow(i, step);
                }
            }
            printMatrix();
        }
    }

    private void doReverseRun() {
        System.out.println("doReverseRun");
        for (int step = matrix[0].length - 2; step > 0; step--) {
            for (int i = step - 1; i >= 0; i--) {
                if (matrix[i][step] == 0)
                    continue;
                multiplyRow(i, (matrix[step][step] / matrix[i][step]));
                subtractRow(i, step);
            }
            printMatrix();
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

    private int getRank() {
        int rank = 0;
        for (double[] doubles : matrix) {
            for (int i = 0; i < doubles.length-1; i++) {
                if(!equalsZero(doubles[i])) {
                    rank++;
                    break;
                }
            }
        }
        return rank;
    }

    private int getRankExtended() {
        int rank = 0;
        for (double[] doubles : matrix) {
            for (int i = 0; i < doubles.length; i++) {
                if(!equalsZero(doubles[i])) {
                    rank++;
                    break;
                }
            }
        }
        return rank;
    }

    private boolean equalsZero(double val) {
        return (Math.abs(val) < EPSILON);
    }


    private void checkRowIndex(int row) {
        if (row < 0 || row > matrix.length - 1) {
            throw new IllegalArgumentException("Row index must be lower than " + (matrix.length - 1) + ", but  equals " + row);
        }
    }

    private void printMatrix() {
        Util.printMatrix(getMatrix());
    }

    public int getDebugRank() {
        return getRankExtended();
    }
}
