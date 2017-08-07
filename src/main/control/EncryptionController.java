package main.control;

import main.exception.EuclideanException;
import main.model.EncryptionData;
import main.util.Euclid;

import java.math.BigInteger;

import static main.util.RandomNumberGenerator.getSinglePrimeSieve;

/**
 * Controller class for encrypting and decrypting messages using rsa algorithm.
 */
public class EncryptionController {

    private EncryptionData encryptionData;

    public EncryptionController() {
        encryptionData = new EncryptionData();
    }

    public void initialize() {
        // Set p and q
        int p = 0;
        int q = 0;
        while (p == q) {
            p = getSinglePrimeSieve(1000);
            q = getSinglePrimeSieve(1000);
        }
        encryptionData.setP(p);
        encryptionData.setQ(q);
        System.out.println("Generated p: " + p);
        System.out.println("Generated q: " + q);

        // Set n
        int n = p * q;
        encryptionData.setN(n);
        System.out.println("Generated n: " + n);

        // Set e
        int e = 0;
        int gcd = 0;
        while (gcd != 1) {
            do {
                e = getSinglePrimeSieve(1000);
            } while (e > encryptionData.getPhiN());
            try {
                gcd = Euclid.calcAlgo(new Euclid.EuclideanRecursive(), encryptionData.getPhiN(), e);
            } catch (EuclideanException ex){
                ex.printStackTrace();
            }
        }
        encryptionData.setE(e);
        System.out.println("Generated e: " + e);

        // Set d
        int d = Euclid.calcEuclideanExtendedIterative(encryptionData.getPhiN(), encryptionData.getE()).getT();
        encryptionData.setD(d);
        System.out.println("Generated d: " + d);
    }

    /**
     * Calculate m^e mod n.
     *
     * @param message that needs to be encrypted.
     * @return encrypted message.
     */
    public int encrypt(int message) {
        return BigInteger.valueOf(message).modPow(BigInteger.valueOf(encryptionData.getE()), BigInteger.valueOf(encryptionData.getN())).intValue();
    }

    /**
     * Calculate c^d mod n.
     *
     * @param encryptedMessage that needs to be decrypted.
     * @return decrypted message.
     */
    public int decrypt(int encryptedMessage) {
        // TODO: Fails from time to be time due to ArithmeticException: BigInteger not invertible
        return BigInteger.valueOf(encryptedMessage).modPow(BigInteger.valueOf(encryptionData.getD()), BigInteger.valueOf(encryptionData.getN())).intValue();
    }

    /**
     * Method returns value of n to check for validity of message length.
     *
     * @return integer value of n.
     */
    public int getN() {
        return encryptionData.getN();
    }
}
