package test.algorithmTesting;

import main.control.EncryptionController;
import main.util.RandomNumberGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RsaTest {

    @Test
    @DisplayName("Test the implementation of the RSA Algorithm with varying numbers.")
    void RsaTest100Times() {
        EncryptionController encryptionController = new EncryptionController();
        for(int i = 0; i < 100; i++) {
            encryptionController.initialize();
            int message = RandomNumberGenerator.getSingleRandomNumber(encryptionController.getN() - 1);
            System.out.println("Generated message: " + message);
            int encryptedMessage = encryptionController.encrypt(message);
            System.out.println("Encrypted message: " + encryptedMessage);
            int decryptedMessage = encryptionController.decrypt(encryptedMessage);
            System.out.println("Decrypted message: " + decryptedMessage);
            Assertions.assertEquals(message, decryptedMessage);
        }
    }

}
