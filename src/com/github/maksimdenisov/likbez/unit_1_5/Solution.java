package com.github.maksimdenisov.likbez.unit_1_5;

/**
 * https://stepik.org/lesson/9582/step/8?unit=1810
 **/

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static com.github.maksimdenisov.likbez.unit_1_5.Util.*;

/**
 * В первой строке задаются два числа: количество уравнений n (n ≥ 1) и
 * количество неизвестных m (m≥1). Далее идут n строк, каждая из которых содержит m+1 число.
 * Первые m чисел — это коэффициенты i-го уравнения системы, а последнее,
 * (m+1)-е число — коэффициент b_i
 * , стоящий в правой части i-го уравнения.
 * Формат выходных данных:
 * В первой строке следует вывести слово YES, если решение существует и единственно,
 * слово NO в случае, если решение не существует,
 * и слово INF в случае, когда решений существует бесконечно много.
 * Если решение существует и единственно, то во второй строке следует
 * вывести решение системы в виде m чисел,разделенных пробелом.
 */
public class Solution {

    private static String SAMPLE_1 = """
            3 3
            4 2 1 1
            7 8 9 1
            9 1 3 2
            """;/*
            YES
            0.2608695652173913 0.04347826086956526 -0.1304347826086957
    Sample Input 2:*/
    private static String SAMPLE_2 = """
            2 3
            1 3 4 4
            2 1 4 5
            """;/*
            INF
            Sample Input 3:*/
    private static String SAMPLE_3 = """
            3 3
            1 3 2 7
            2 6 4 8
            1 4 3 1
            """;/*
            NO */

    public static void main(String[] args) throws Exception {
        InputStream targetStream = new ByteArrayInputStream(SAMPLE_1.getBytes());
        int[][] matrix = scanMatrix(targetStream);
        printMatrix(matrix);
        String hasSolution = hasSolution(matrix);
        System.out.println(hasSolution);
        double[] solve = solve(matrix);
        for (double v : solve) {
            System.out.printf("%.16f", v);
        }
    }

    private static double[] solve(int[][] matrix) {
        double[][] solveMatrix = getMatrix(matrix);
        printMatrix(solveMatrix);
        System.out.println("---------------------");
        for (int i = 0; i < solveMatrix.length - 1; i++) {
            for (int m = i + 1; m < solveMatrix.length; m++) {
                double k = solveMatrix[m][i] / solveMatrix[i][i];
                for (int j = i; j < solveMatrix[0].length; j++) {
                    solveMatrix[m][j] = solveMatrix[m][j] - (solveMatrix[i][j] * k);
                }
                printMatrix(solveMatrix);
                System.out.println("---------------------");
            }
        }
        double[] solution = new double[solveMatrix[0].length - 1];
        for (int i = solveMatrix.length - 1; i >= 0; i--) {
            double sum = 0;
            for (int j = solveMatrix.length - 1; j > i; j--) {
                sum += solveMatrix[i][j] * solution[j];
            }
            solution[i] = (solveMatrix[i][solveMatrix[0].length - 1] - sum) / solveMatrix[i][i];
        }
        return solution;
    }


    /**
     * ТЕОРЕМА 1 (Кронекера – Капелли). Система линейных
     * уравнений (1) совместна тогда и только тогда, когда ранг
     * основной матрицы системы равен рангу ее расширенной
     * матрицы, т.е. r(A) = r(A*).
     * <p>
     * ТЕОРЕМА 2 (критерий единственности решения). Система
     * линейных уравнений (1) имеет единственное решение тогда и
     * только тогда, когда ранг основной матрицы системы равен
     * рангу ее расширенной матрицы и равен числу переменных, т.е.
     * r(A) = r(A*) = n.
     *
     * @return следует вывести слово YES, если решение существует и единственно,
     * * слово NO в случае, если решение не существует,
     * * и слово INF в случае, когда решений существует бесконечно много.
     */
    private static String hasSolution(int[][] matrix) {
        return "NO";
    }

}