package mwallet.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import mwallet.entities.User;

public class UserRepo implements IUserRepo{
    private final Map<String, User> userMap;
    private Integer autoIncrement = 0;

    public UserRepo() {
       userMap = new HashMap<String, User>();
    }

    public UserRepo(Map<String, User> userMap) {
        this.userMap = userMap;
        this.autoIncrement = userMap.size();
    }

    @Override
    public User save(User entity) {
        if(entity.getId() == null) {
            autoIncrement++;
            User u = new User(autoIncrement.toString(), entity.getName(), entity.getWallet(), entity.getHistory());
            userMap.put(u.getId(), u);
            return u;
        }

        userMap.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public List<User> getAll() {
        List<User> userList = userMap.entrySet().stream()
                                    .map(Map.Entry::getValue).collect(Collectors.toList());
        return userList;
    }

    @Override
    public void delete(User entity) {
        
    }

    @Override
    public Optional<User> findById(String id) {
        Optional<User> user = userMap.entrySet().stream()
                                .filter(m -> m.getKey().equals(id))
                                .map(Map.Entry::getValue).findFirst();
        return user;
    }

    // @Override
    // public User addTransaction(User user, String transaction) {
    //     user.addTransaction(transaction);
    //     return user;
    // }

}
