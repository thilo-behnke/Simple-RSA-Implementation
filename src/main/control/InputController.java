package main.control;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Controller class for managing user input.
 */
public class InputController {

    private Scanner scanner;
    private EncryptionController encryptionController;

    public InputController(EncryptionController encryptionController) {
        this.encryptionController = encryptionController;
    }

    public void initialize() {
        scanner = new Scanner(System.in);
    }

    public void getInput() {
        // Encrypt message
        System.out.println("Input message that needs to be encrypted:");
        int message = 0;
        while(message == 0){
            try {
                message = scanner.nextInt();
            } catch (InputMismatchException ex){
                System.out.println("Wrong input format - expected numeric value!");
                ex.printStackTrace();
            }
        }
        System.out.println("Input message: " + message);
        int encryptedMessage = encryptionController.encrypt(message);
        System.out.println("Encrypted message: " + encryptedMessage);
        int decryptedMessage = encryptionController.decrypt(encryptedMessage);
        System.out.println("Decrypted message: " + decryptedMessage);
    }

    public void close() {
        scanner.close();
    }
}
