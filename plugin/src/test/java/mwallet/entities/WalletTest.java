package mwallet.entities;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Wallet Test")
public class WalletTest {

    static User user;
    
@BeforeEach
public void setup() {
    List<History> transactionList = new ArrayList<History>();
    user = new User("1", "Zuber", new Wallet(1000.0), transactionList);
}


@Test
@DisplayName("Checking crediting money function")
public void creditTest() {
    Double expected = 2000.0;

    Double actual = user.getWallet().addMoney(1000.0);
    Assertions.assertEquals(expected, actual);
}


@Test
@DisplayName("Checking debit function")
public void debitTest() {
    Double expected = 0.0;

    Double actual = user.getWallet().withDraw(1000.0);
    Assertions.assertEquals(expected, actual);
}
}
