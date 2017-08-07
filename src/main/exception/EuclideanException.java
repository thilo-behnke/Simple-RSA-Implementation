package main.exception;

/**
 * Custom exception for the case that b is bigger than a in Euclidean Algorithm.
 */
public class EuclideanException extends Exception {

    private String message;

    public EuclideanException(int a, int b){
        message = "Error: a must be bigger than a. \n Value a: " + a + "\n Value b: " + b;
    }

    @Override
    public String toString() {
        return "EuclideanException{" +
                "message='" + message + '\'' +
                '}';
    }

    @Override
    public String getMessage() {
        return message;
    }
}
