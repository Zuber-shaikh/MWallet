package mwallet.exceptions;

public class NoTransactionsYetException extends RuntimeException{
    public NoTransactionsYetException() {
        super();
    }

    public NoTransactionsYetException(String msg) {
        super(msg);
    }
}
