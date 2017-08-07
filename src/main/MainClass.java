package main;

import main.control.EncryptionController;
import main.control.InputController;

public class MainClass {

    public static void main(String args[]) {
        EncryptionController encryptionController = new EncryptionController();
        encryptionController.initialize();

        InputController inputController = new InputController(encryptionController);
        inputController.initialize();
        inputController.getInput();
        inputController.close();
    }
}
