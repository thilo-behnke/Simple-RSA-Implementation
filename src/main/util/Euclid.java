package main.util;

import main.exception.EuclideanException;
import main.model.EuclideanData;

public class Euclid {

    /**
     * Method for calling a specific implementation of the euclidean algorithm.
     *
     * @param algo Implementation to be called.
     * @param a
     * @param b
     * @return greatest common denominator for a and b.
     */
    public static int calcAlgo(EuclideanAlgo algo, int a, int b) throws EuclideanException {
        if(a < b) throw new EuclideanException(a, b);
        return algo.accept(a, b);
    }

    /**
     * Interface for insertion of euclidean implementation.
     */
    public interface EuclideanAlgo {
        int accept(int a, int b);
    }

    public static class EuclideanRecursive implements EuclideanAlgo {
        public int accept(int a, int b) {
            return calcEuclidRecursive(a, b);
        }
    }

    public static class EuclideanIterative implements EuclideanAlgo {
        public int accept(int a, int b) {
            return calcEuclidIterative(a, b);
        }
    }

    /**
     * Recursive implementation of euclidean algorithm.
     */
    public static int calcEuclidRecursive(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return calcEuclidRecursive(b, a % b);
        }
    }

    /**
     * Iterative implementation of euclidean algorithm
     */
    public static int calcEuclidIterative(int a, int b) {
        while (b != 0) {
            int c = a % b;
            a = b;
            b = c;
        }
        return a;
    }

    /**
     * Iterative implementation of extended Euclidean Algorithm.
     * @param a
     * @param b
     * @return EuclideanData package
     */
    public static EuclideanData calcEuclideanExtendedIterative(int a, int b)  {
        int x = 0, y = 1, s = 1, t = 0;
        while (b != 0) {
            int q = a / b;
            int r = a % b;

            a = b;
            b = r;

            int temp = x;
            x = s - q * x;
            s = temp;

            temp = y;
            y = t - q * y;
            t = temp;
        }
        return new EuclideanData(a, b, s, t);
    }
}
