package exceptions;

public class invalidInputException extends Exception {
    invalidInputException(String message, Throwable th){
        super(message, th);
    }
}