package exception;

public class BizRuntimeException extends RuntimeException{
    private String message;

    public BizRuntimeException(String message) {
        super(message);
    }

}
