package mwallet.services;

import java.util.ArrayList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import mwallet.entities.History;
import mwallet.entities.User;
import mwallet.entities.Wallet;
import mwallet.repositories.IUserRepo;
import mwallet.repositories.UserRepo;

@DisplayName("UserWallet service Tests")
public class UserWalletServiceTest {


// @BeforeEach
// void setup() {
//     List<History> transactionList = new ArrayList<History>() {
//         {
//             add(new History("Debited : " + 1000.0));
//         }
//     };

//     // final Map<String, User> userMap = new HashMap<>() {
//     //     {
//     //         put("1", new User("1", "Zuber", new Wallet(1000.0), transactionList));
//     //         put("2", new User("2", "Luffy", new Wallet(1000.0), transactionList));
//     //         put("3", new User("3", "Ace", new Wallet(1000.0), transactionList));
//     //     }
//     // };
//     userService = new UserService(userRepo);
//     userService.createUser("Zuber", new Wallet(1000.0));
// }


@DisplayName("Save method should save an User")
@Test
public void saveMethodCheck() {
    final IUserService userService;
    final IUserRepo userRepo = new UserRepo();
    userService = new UserService(userRepo);
    
    User expected = new User("1", "Sabo", new Wallet(0.0), new ArrayList<History>());

    User actual = userService.createUser("Sabo", new Wallet(0.0));

    Assertions.assertEquals(expected, actual);
}


@DisplayName("Credit money check")
@Test
public void addMoneyMethodCheck() {
    final IUserService userService;
    final IUserRepo userRepo = new UserRepo();
    userService = new UserService(userRepo);
    User user = userService.createUser("Sabo", new Wallet(0.0));
    Double expected = 1000.0;

    Double actual = userService.addMoney(user, 1000.0);

    Assertions.assertEquals(expected, actual);
}

@DisplayName("Debit money check")
@Test
public void WithDrawMoneyMethodCheck() {
    final IUserService userService;
    final IUserRepo userRepo = new UserRepo();
    userService = new UserService(userRepo);
    User user = userService.createUser("Sabo", new Wallet(1000.0));
    Double expected = 800.0;

    Double actual = userService.withDraw(user, 200.0);

    Assertions.assertEquals(expected, actual);
}
}
