package test.algorithmTesting;

import main.util.RandomNumberGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thilo on 07.08.2017.
 */
@DisplayName("Primenumber generator testing")
class PrimeNumberGeneratorTest {

    private List<Integer> numberList;
    private List<Integer> referenceList;

    @BeforeEach
    void resetData() {
        numberList = new ArrayList<>();
        referenceList = RandomNumberGenerator.getPrimesFromList();
    }

    @Test
    @DisplayName("Generate prime number list using Sieve")
    void generatePrimesSieve() {
        for (int i = 0; i < 100; i++) {
            numberList = RandomNumberGenerator.getPrimesSieve(1000);
            for (int number : numberList) {
                Assertions.assertTrue(referenceList.contains(number), String.valueOf(number));
            }
        }
    }

    @Test
    @DisplayName("Get a single prime number")
    void generateSinglePrime() {
        int prime = RandomNumberGenerator.getSinglePrimeSieve(1000);
        Assertions.assertTrue(referenceList.contains(prime), String.valueOf(prime));
    }
}
