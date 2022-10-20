package itv.assignment.exception;

public class InvalidProductCodeException extends Exception {

    public InvalidProductCodeException() {
        super("One or more products have invalid codes!");
    }
}
