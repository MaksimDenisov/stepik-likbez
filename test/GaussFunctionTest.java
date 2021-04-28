import com.github.maksimdenisov.likbez.unit_1_5.GaussSolution;
import com.github.maksimdenisov.likbez.unit_1_5.Util;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class GaussFunctionTest {

    @Test
    void Sample1HasSolution() throws Exception {
        GaussSolution gaussSolution = getSolution("""
                3 3
                4 2 1 1
                7 8 9 1
                9 1 3 2
                """);
        String has = "YES";
        double[] expectedSolution = new double[]{0.2608695652173913, 0.04347826086956526, -0.1304347826086957};

        assertSolution(gaussSolution, has, expectedSolution);
    }

    @Test
    void Sample2HasInfSolution() throws Exception {
        GaussSolution gaussSolution = getSolution("""
                2 3
                1 3 4 4
                2 1 4 5
                """);
        String has = "INF";

        assertSolution(gaussSolution, has);
    }

    @Test
    void Sample3HasNoSolution() throws Exception {
        GaussSolution gaussSolution = getSolution("""
                3 3
                1 3 2 7
                2 6 4 8
                1 4 3 1
                """);
        String has = "NO";

        assertSolution(gaussSolution, has);
    }

    @Test
    void Test1HasSolution() throws Exception {
        GaussSolution gaussSolution = getSolution("""
                3 3
                          6 1 2 21
                          4 -6 16 2
                          3 8 1 2
                """);
        String has = "YES";
        double[] expectedSolution = new double[]{4.13333, -1.13333, -1.33333};

        assertSolution(gaussSolution, has, expectedSolution);
    }

    @Test
    void Test2HasSolution() throws Exception {
        GaussSolution gaussSolution = getSolution("""
                4 4
                            5 -3 2 -8 1
                            1 1 1 1 0
                            3 5 1 4 0
                            4 2 3 1 3
                """);
        String has = "YES";
        double[] expectedSolution = new double[]{7, -8, -5, 6};

        assertSolution(gaussSolution, has, expectedSolution);
    }


    @Test
    void Test3HasSolution() throws Exception {
        GaussSolution gaussSolution = getSolution("""
                3 3
                                                 1 2 3 3
                                                 3 5 7 0
                                                 1 3 4 1
                """);
        String has = "YES";
        double[] expectedSolution = new double[]{-4, -13, 11};

        assertSolution(gaussSolution, has, expectedSolution);
    }

    @Test
    void Test4HasSolution() throws Exception {
        GaussSolution gaussSolution = getSolution("""
                4 4
                            2 5 4 1 20
                            1 3 2 1 11
                            2 10 9 7 40
                            3 8 9 2 37
                """);
        String has = "YES";
        double[] expectedSolution = new double[]{1, 2, 2, 0};

        assertSolution(gaussSolution, has, expectedSolution);
    }

    @Test
    void Test5HasSolution() throws Exception {
        GaussSolution gaussSolution = getSolution("""
                3 3
                1 -2 1 0
                2 2 -1 3
                4 -1 1 5
                    """);
        String has = "YES";
        double[] expectedSolution = new double[]{1, 2, 3};

        assertSolution(gaussSolution, has, expectedSolution);
    }

    @Test
    void Test6HasSolution() throws Exception {
        GaussSolution gaussSolution = getSolution("""
                  4 4
                  3 2 1 1 -2
                  1 -1 4 -1 -1
                  -2 -2 -3 1 9
                  1 5 -1 2 4
                """);
        String has = "YES";
        double[] expectedSolution = new double[]{-3, -1, 2, 7};

        assertSolution(gaussSolution, has, expectedSolution);
    }

    @Test
    void Test7HasSolution() throws Exception {
        GaussSolution gaussSolution = getSolution("""
                3 3
                0.12 0.18 -0.17 5.5
                0.06 0.09 0.15 -1.95
                0.22 -0.1 0.06 0.5
                    """);
        String has = "YES";
        double[] expectedSolution = new double[]{10, 5, -20};

        assertSolution(gaussSolution, has, expectedSolution);
    }

    @Test
    void Test8HasNoSolution() throws Exception {
        GaussSolution gaussSolution = getSolution("""
                      4 3
                               2 -1 3 1
                               2 -1 -1 -2
                               4 -2 6 0
                               6 8 -7 2
                """);
        String has = "NO";

        assertSolution(gaussSolution, has);
    }

    @Test
    void Test9HasInfSolution() throws Exception {
        GaussSolution gaussSolution = getSolution("""
                4 6
                1 2 1 1 3 1 7
                1 2 1 2 1 -1 1
                1 2 1 -1 5 -1 2
                1 2 1 -2 -4 -4 -1
                    """);
        String has = "INF";

        assertSolution(gaussSolution, has);
    }

    @Test
    void Test10HasInfSolution() throws Exception {
        GaussSolution gaussSolution = getSolution("""
                3 3
                3 -2 1 0
                5 -14 15 0
                1 2 -3 0
                    """);
        String has = "INF";

        assertSolution(gaussSolution, has);
    }

    @Test
    void Test11HasInfSolution() throws Exception {
        GaussSolution gaussSolution = getSolution("""
                5 4
                2 3 -1 1 0
                2 7 -3 0 1
                0 4 -2 -1 1
                2 -1 1 2 -1
                4 10 -4 1 1
                    """);
        String has = "INF";

        assertSolution(gaussSolution, has);
    }


    @Test
    void Test12HasNoSolution() throws Exception {
        GaussSolution gaussSolution = getSolution("""
                3 4
                3 -5 2 4 2
                7 -4 1 3 5
                5 7 -4 -6 3
                    """);
        String has = "NO";

        assertSolution(gaussSolution, has);
    }

    @Test
    void Test13HasSolution() throws Exception {
        GaussSolution gaussSolution = getSolution("""
                5 3
                0 2 -1 -4
                1 -1 5 3
                2 1 -1 0
                3 2 3 -1
                3 4 2 -5
                """);
        String has = "YES";
        double[] expectedSolution = new double[]{1, -2, 0};

        assertSolution(gaussSolution, has, expectedSolution);
    }

    @Test
    void Test19InfSolution() throws Exception {
        GaussSolution gaussSolution = getSolution("""
                3 2
                -10 -2.0 5.0
                4.0 6.0 5.0
                -8.0 3.0 4.0
                """);
        String has = "NO";
        assertSolution(gaussSolution, has);
    }

    @Test
    void Test20NoSolution() throws Exception {
        GaussSolution gaussSolution = getSolution("""
                8 2
                3.0 -3.0 -2.0
                -8.0 -9.0 -8.0
                -5.0 -7.0 2.0
                6.0 -9.0 0.0
                -1.0 -7.0 -5.0
                0.0 -1.0 -3.0
                6.0 9.0 -3.0
                7.0 4.0 9.0
                """);
        String has = "NO";

        assertSolution(gaussSolution, has);
    }

    @Test
    void TestNumber5() throws Exception {
        GaussSolution gaussSolution = getSolution("""
                3 3
                0 0 1 3
                1 0 0 2
                0 1 0 1
                """);
        String has = "YES";
        double[] expectedSolution = new double[]{2, 1, 3};

        assertSolution(gaussSolution, has, expectedSolution);
    }

    /**
     * My Matchers
     */
    private void assertSolution(GaussSolution gaussSolution, String expectedHasSolution) {
        assertNotNull(gaussSolution);
        System.out.println(gaussSolution.getDebugRank());
        assertEquals(expectedHasSolution, gaussSolution.hasSolution());
    }

    private void assertSolution(GaussSolution gaussSolution, String expectedHasSolution, double[] expected) {
        assertSolution(gaussSolution, expectedHasSolution);
        assertArrayEquals(expected, gaussSolution.getSolution(),0.00001);
    }

    private GaussSolution getSolution(String s) throws Exception {
        return new GaussSolution(Util.scanMatrix(getStream(s)));
    }

    private InputStream getStream(String s) {
        return new ByteArrayInputStream(s.getBytes());
    }
}