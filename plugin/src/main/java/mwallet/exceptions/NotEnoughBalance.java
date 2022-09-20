package mwallet.exceptions;

public class NotEnoughBalance extends RuntimeException{
    
    public NotEnoughBalance() {
        super();
    }

    public NotEnoughBalance(String msg) {
        super(msg);
    }
}