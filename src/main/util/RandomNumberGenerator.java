package main.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RandomNumberGenerator {

    /**
     * Convenience method for getting a single, random prime number from a defined range of numbers.
     * @param limitTop max value of generated numbers.
     * @return a random prime number
     */
    public static int getSinglePrimeSieve(int limitTop) {
        Random rand = new Random();
        List<Integer> primeList = getPrimesSieve(limitTop);
        return primeList.get(rand.nextInt((primeList.size() - 1) + 1));
    }

    /**
     * Uses Sieve algorithm for creating a list of prime numbers.
     *
     * @param limitTop max value of generated numbers.
     * @return list of primes
     */
    public static List<Integer> getPrimesSieve(int limitTop) {
        List<Integer> numberList = generateRandomNumbers(limitTop, 10000);
        numberList.removeIf(x -> x == 0 || x == 1 || x == 2);
        for (Iterator<Integer> it = numberList.iterator(); it.hasNext(); ) {
            int x = it.next();
            for (int i = 2; i <= Math.sqrt(x); i++) {
                if (x % i == 0) {
                    it.remove();
                    break;
                }
            }
        }
        return numberList;
    }

    /**
     * Get list of first 10,000 primes from a txt file.
     *
     * @return list of first 10,000 primes
     */
    public static List<Integer> getPrimesFromList() {
        List<Integer> numberList = new ArrayList<>();
        try {
            // TODO: Make path relative
            FileReader fileReader = new FileReader("C:\\Users\\Thilo\\IdeaProjects\\RSA\\src\\test\\files\\primes.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            bufferedReader.readLine();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                numberList.add(Integer.parseInt(line));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return numberList;
    }

    /**
     * Conveniance method for getting a single random number from within a defined number range.
     * @param limitTop limits the max possible number.
     * @return a random number.
     */
    public static int getSingleRandomNumber(int limitTop) {
        Random rand = new Random(65498);
        List<Integer> numberList = generateRandomNumbers(limitTop, 1000);
        return numberList.get(rand.nextInt(rand.nextInt((numberList.size() - 1) + 1) + 1));

    }

    private static List<Integer> generateRandomNumbers(int limitTop, int count) {
        return Stream.generate(Math::random)
                .limit(count)
                .map(x -> x * limitTop)
                .map(Double::intValue)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

}
