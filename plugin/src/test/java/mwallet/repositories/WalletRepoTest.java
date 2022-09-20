package mwallet.repositories;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import mwallet.entities.Wallet;

@DisplayName("Wallet Test")
public class WalletRepoTest {
private WalletRepo walletRepo;
@BeforeEach
void setup() {
    final Map<String, Wallet> walletMap = new HashMap<>(){
        {
            put("1", new Wallet("1", 1000.0));
            put("2", new Wallet("2", 2000.0));

        }
    };
    walletRepo = new WalletRepo(walletMap);

}

@Test
@DisplayName("Save method should create new Wallet")
public void saveWallet() {
    final Wallet wallet3 = new Wallet(3000.0);
    Wallet expected = new Wallet("3", 3000.0);

    Wallet actual = walletRepo.save(wallet3);

    Assertions.assertEquals(expected, actual);

}
}
