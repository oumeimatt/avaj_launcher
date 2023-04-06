package exceptions;

public class FileException extends Exception {
    public FileException(String message, Throwable th) {
        super(message, th);
    }
}