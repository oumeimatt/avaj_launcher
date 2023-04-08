package exceptions;

public class InvalidInputException extends Exception {
    public InvalidInputException(String message, Throwable th){
        super(message, th);
    }
    public InvalidInputException(String message){
        super(message);
    }
}