package mwallet.exceptions;

public class NoUserFoundException extends RuntimeException{
    public NoUserFoundException() {
        super();
    }

    public NoUserFoundException(String msg) {
        super(msg);
    }
    
}