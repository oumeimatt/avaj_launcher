package src.ro.academyplus.avaj.simulator;

public class MyException extends Exception {
    public MyException(String message, Throwable th){
        super(message, th);
    }
    public MyException(String message){
        super(message);
    }
}