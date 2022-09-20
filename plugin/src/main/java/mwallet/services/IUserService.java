package mwallet.services;

import java.util.List;

import mwallet.entities.History;
import mwallet.entities.User;
import mwallet.entities.Wallet;

public interface IUserService {
    public User createUser(String name, Wallet wallet);
    public User findUser(String id);
    public Double addMoney(User user, Double amount);
    public Double withDraw(User user, Double amount);
    public Double checkBalance(User user);
    public List<History> transactions(User user);
}
