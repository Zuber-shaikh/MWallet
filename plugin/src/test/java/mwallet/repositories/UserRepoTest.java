package mwallet.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import mwallet.entities.History;
import mwallet.entities.User;
import mwallet.entities.Wallet;

@DisplayName("UserRepo Test")
public class UserRepoTest {

private UserRepo userRepo;

@BeforeEach
void setup() {
    List<History> transactionList = new ArrayList<History>() {
        {
            add(new History("Debited : " + 1000.0));
        }
    };

    final Map<String, User> userMap = new HashMap<>() {
        {
            put("1", new User("1", "Zuber", new Wallet(1000.0), transactionList));
            put("2", new User("2", "Luffy", new Wallet(1000.0), transactionList));
            put("3", new User("3", "Ace", new Wallet(1000.0), transactionList));
        }
    };

    userRepo = new UserRepo(userMap);
} 


@Test
@DisplayName("Saving User")
public void saveUser() {
    final User user4 = new User("Sabo", new Wallet(0.0));
    User expectedUser = new User("4", "Sabo", new Wallet(0.0), new ArrayList<History>());

    User actualUser = userRepo.save(user4);
    Assertions.assertEquals(expectedUser, actualUser);
}


@Test
@DisplayName("Finding all users")
public void findAllUser() {
    int expectedCount = 3;

    List<User> actual = userRepo.getAll();

    Assertions.assertEquals(expectedCount, actual.size());
}

@Test
@DisplayName("Finding User by Id")
public void findBy_Id() {
    String expected = "3";
    Optional<User> actual = userRepo.findById(expected);

    Assertions.assertEquals(expected, actual.get().getId());
}

@Test
@DisplayName("FindId method should return null if no user is found")
public void findBy_Id_CheckIfNull() {
    Optional<User> expected = Optional.empty();
    Optional<User> actual = userRepo.findById("4");

    Assertions.assertEquals(expected, actual);
}

}
