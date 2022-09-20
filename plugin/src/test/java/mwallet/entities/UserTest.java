package mwallet.entities;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("User Test")
public class UserTest {

    static User user;

@BeforeEach
public void setup() {
    List<History> transactionList = new ArrayList<History>() {
        {
            add(new History("Debited : " + 1000.0));
        }
    };
    user = new User("1", "Zuber", new Wallet(1000.0), transactionList);
}


@Test
@DisplayName("Checking if wallet is created successfully")
public void userWalletCreationTest() {
    Wallet expected = new Wallet(1000.0);
    Wallet actual = user.getWallet();

    Assertions.assertEquals(expected, actual);

}


@Test
@DisplayName("Checking if transaction history is recorded")
public void transactionHistoryTest() {
    List<History> expectedList = new ArrayList<History>() {
        {
            add(new History("Debited : " + 1000.0));
        }
    };
    List<History> actualList = user.getHistory();

    Assertions.assertEquals(expectedList, actualList);
}

}
