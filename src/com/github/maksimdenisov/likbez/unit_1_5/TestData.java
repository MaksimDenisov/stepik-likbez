package com.github.maksimdenisov.likbez.unit_1_5;

public class TestData {


    public static String SAMPLE_1 = """
            3 3
            4 2 1 1
            7 8 9 1
            9 1 3 2
            """;/*
            YES
            0.2608695652173913 0.04347826086956526 -0.1304347826086957
    Sample Input 2:*/
    public static String SAMPLE_2 = """
            2 3
            1 3 4 4
            2 1 4 5
            """;/*
            INF
            Sample Input 3:*/
    public static String SAMPLE_3 = """
            3 3
            1 3 2 7
            2 6 4 8
            1 4 3 1
            """;/*
            NO */

    public static final String Test_1 = """
                        3 3
                        6 1 2 21
                        4 -6 16 2
                        3 8 1 2
            """;
/*
    ANSWER:
    YES
4.13333-1.13333-1.33333
*/

    public static final String Test_2 = """
                        4 4
                        5 -3 2 -8 1
                        1 1 1 1 0
                        3 5 1 4 0
                        4 2 3 1 3
            """;
/*    ANSWER:
    YES
7-8-5 6*/


    public static final String Test_7 = """
            3 3
            0.12 0.18 -0.17 5.5
            0.06 0.09 0.15 -1.95
            0.22 -0.1 0.06 0.5
                     """;
    /*
        ANSWER:
            YES
        10 5 -20
        */
    public static final String Test_11 = """
            5 4
            2 3 -1 1 0
            2 7 -3 0 1
            0 4 -2 -1 1
            2 -1 1 2 -1
            4 10 -4 1 1
                    """;
    public static final String Test_12 = """
                        3 4
                        3 -5 2 4 2
                        7 -4 1 3 5
                        5 7 -4 -6 3
            """;

}
