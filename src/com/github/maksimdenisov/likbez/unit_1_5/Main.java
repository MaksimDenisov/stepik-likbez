        package com.github.maksimdenisov.likbez.unit_1_5;

        import java.io.BufferedReader;
        import java.io.ByteArrayInputStream;
        import java.io.InputStream;
        import java.io.InputStreamReader;
        import java.util.Scanner;

        class Main {
            public static void main(String[] args) {
                // put your code here
                try {
                    GaussSolution solution = new GaussSolution(scanMatrix(System.in));
                    System.out.println(solution.hasSolution);
                    if(solution.hasSolution.equals("YES")) {
                        double[] s = solution.getSolution();
                        StringBuilder result = new StringBuilder();
                        for (double d : s) {
                            result.append(String.format("%.10f",d)).append(" ");
                        }
                        System.out.println(result.toString().trim());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            public static double[][] scanMatrix(InputStream inputStream) throws Exception {
                int n, m;
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
                    Scanner scanner = new Scanner(reader.readLine());
                    n = scanner.nextInt();
                    m = scanner.nextInt();
                    double[][] matrix = new double[n][m + 1];
                    for (int i = 0; i < n; i++) {
                        scanner = new Scanner(reader.readLine());
                        for (int j = 0; j < m + 1; j++) {
                            matrix[i][j] = scanner.nextDouble();
                        }
                    }
                    return matrix;
                } catch (Exception e) {
                    System.out.println("Something went wrong");
                    throw new Exception("stop");
                }
            }

            public static class GaussSolution {
                private static final double EPSILON = 0.0000001;
                //[row][column]
                private final double[][] matrix;
                private String hasSolution = "";

                /****************************************************/

                public GaussSolution(double[][] matrix) {
                    this.matrix = matrix;
                    doStraightRun();
                    if (getRank() != getRankExtended()) {
                        hasSolution = "NO";
                    } else {
                        if (getRank() < matrix[0].length - 1) {
                            hasSolution = "INF";
                        }
                        else{
                            doReverseRun();
                            hasSolution = "YES";
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
                    try {
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
                        }
                    }
                    catch(ArrayIndexOutOfBoundsException e)    {
                        System.out.println("GFHJKL:");
                    }
                }

                private void doReverseRun() {
                    for (int step = matrix[0].length - 2; step > 0; step--) {
                        for (int i = step - 1; i >= 0; i--) {
                            if (matrix[i][step] == 0)
                                continue;
                            multiplyRow(i, (matrix[step][step] / matrix[i][step]));
                            subtractRow(i, step);
                        }
                    }
                }

                private void swapRows(int aRowIndex, int bRowIndex) {
                    checkRowIndex(aRowIndex);
                    checkRowIndex(bRowIndex);
                    for (int i = 0; i < matrix[0].length; i++) {
                        double swap = matrix[aRowIndex][i];
                        matrix[aRowIndex][i] = matrix[bRowIndex][i];
                        matrix[bRowIndex][i] = swap;
                    }
                }

                private void multiplyRow(int row, double k) {
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
                        for (int i = 0; i < doubles.length - 1; i++) {
                            if (!equalsZero(doubles[i])) {
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
                            if (!equalsZero(doubles[i])) {
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
            }
        }