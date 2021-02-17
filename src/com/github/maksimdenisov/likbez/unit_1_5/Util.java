package com.github.maksimdenisov.likbez.unit_1_5;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Util {

    public static int[][] scanMatrix(InputStream inputStream) throws Exception {
        int n, m;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            Scanner scanner = new Scanner(reader.readLine());
            n = scanner.nextInt();
            m = scanner.nextInt();
            int[][] matrix = new int[n][m + 1];
            for (int i = 0; i < n; i++) {
                scanner = new Scanner(reader.readLine());
                for (int j = 0; j < m + 1; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            return matrix;
        } catch (Exception e) {
            System.out.println("Something went wrong");
            throw new Exception("stop");
        }
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (j == matrix[0].length - 1)
                    System.out.printf("= ", ints[j]);
                System.out.printf("%d ", ints[j]);
            }
            System.out.print("\n");
        }
    }
    public static void printMatrix(double[][] matrix) {
        for (double[] doubles : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (j == matrix[0].length - 1)
                    System.out.printf("= %f", doubles[j]);
                System.out.printf("%f", doubles[j]);
            }
            System.out.print("\n");
        }
    }
    public static double[][] getMatrix(int[][] matrix) {
        double[][] solveMatrix =  new double[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                solveMatrix[i][j] =  matrix[i][j];
            }
        }
        return solveMatrix;
    }
}
