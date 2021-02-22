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
 * <p>
 * Отсортировать матрицу решение гаусса рекурсивно обнулять первый столбик.
 */

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
 *https://www.youtube.com/watch?v=cSy6pB4ICGI
 * @return следует вывести слово YES, если решение существует и единственно,
 * * слово NO в случае, если решение не существует,
 * * и слово INF в случае, когда решений существует бесконечно много.
 */
public class Solution {


    /*TODO add elementary changes*/
    public static void main(String[] args) throws Exception {
        InputStream targetStream = new ByteArrayInputStream(TestData.Test_2.getBytes());
        double[][] matrix = scanMatrix(targetStream);
        printMatrix(matrix);
        try {
            for (double v : gaussSolve(matrix)) {
                System.out.printf("%f16 ", v);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static double[] gaussSolve(double[][] matrix) throws IllegalArgumentException {
        return gaussSecondStep(gaussFirstStep(matrix));
    }

    private static double[][] gaussFirstStep(double[][] matrix) {
        return setFirstColumnToZero(0, 0, matrix);
    }

    private static double[][] setFirstColumnToZero(int x, int y, double[][] matrix) {
        if (y > matrix.length - 2)
            return matrix;
        for (int i = y + 1; i < matrix.length; i++) {
            multiplyRow(i, y, matrix[i][y] / matrix[x][y], matrix);
        }
        return setFirstColumnToZero(x + 1, y + 1, matrix);
    }

    private static void multiplyRow(int row, int sourceRow, double k, double[][] matrix) {
        for (int i = 0; i < matrix[0].length; i++) {
            matrix[row][i] = matrix[row][i] - (matrix[sourceRow][i] * k);
        }
    }

    private static double[] gaussSecondStep(double[][] matrix) {
        double[] solution = new double[matrix[0].length - 1];
        for (int i = matrix.length - 1; i >= 0; i--) {
            double sum = 0;
            for (int j = matrix.length - 1; j > i; j--) {
                sum += matrix[i][j] * solution[j];
            }
            solution[i] = (matrix[i][matrix[0].length - 1] - sum) / matrix[i][i];
        }
        return solution;
    }


}