package test.algorithmTesting;

import main.exception.EuclideanException;
import main.model.EuclideanData;
import main.util.Euclid;
import org.junit.jupiter.api.*;

import static main.util.Euclid.calcEuclidIterative;

@DisplayName("Euclidean Algorithm testing")
class EuclidTest {

    private int a;
    private int b;
    private int expectedResult;
    private int result;

    @Nested
    @DisplayName("Test algorithm implementations with valid numbers")
    class WhenValid {

        @BeforeEach
        void resetResult() {
            a = 544;
            b = 391;
            expectedResult = 17;
            result = 0;
        }

        @Test
        @DisplayName("Iterative implementation")
        void ValidEuclideanIterative() {
            result = calcEuclidIterative(a, b);
            Assertions.assertTrue(result == expectedResult, "Error, wrong value for c: " + String.valueOf(result));
        }

        @Test
        @DisplayName("Recursive implementation")
        void ValidEuclideanRecursive() {
            result = Euclid.calcEuclidRecursive(a, b);
            Assertions.assertTrue(result == expectedResult, "Error, wrong value for c: " + String.valueOf(result));
        }

        @Test
        @DisplayName("Extended iterative implementation")
        void ValidExtendedEuclideanIterative() {
            EuclideanData euclideanData = Euclid.calcEuclideanExtendedIterative(a, b);
            Assertions.assertTrue(euclideanData.getA() == expectedResult, "Error, wrong value for c: " + String.valueOf(result));
        }

    }

    @Nested
    @DisplayName("Test algorithm implementations with invalid numbers")
    class WhenInvalid {

        @BeforeEach
        void resetResult() {
            a = 391;
            b = 544;
        }

        @Test
        @DisplayName("Throws exception because b > a")
        void InvalidEuclideanIterative() {
            Throwable exception = Assertions.assertThrows(EuclideanException.class, () -> {
                Euclid.calcAlgo(new Euclid.EuclideanIterative(), a, b);
            });
            Assertions.assertEquals("Error: a must be bigger than a. \n Value a: " + a + "\n Value b: " + b, exception.getMessage());
        }

        @Test
        @DisplayName("Throws exception because b > a")
        void InvalidEuclideanRecursive() {
            Throwable exception = Assertions.assertThrows(EuclideanException.class, () -> {
                Euclid.calcAlgo(new Euclid.EuclideanRecursive(), a, b);
            });
            Assertions.assertEquals("Error: a must be bigger than a. \n Value a: " + a + "\n Value b: " + b, exception.getMessage());
        }
    }
}
