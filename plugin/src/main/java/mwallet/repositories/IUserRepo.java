package mwallet.repositories;

import java.util.Optional;
import mwallet.entities.User;

public interface IUserRepo extends CRUDOperations<User, String>{
    
    public Optional<User> findById(String id);
    // public User addTransaction(User user, String transaction);
}
