package mwallet.services;

import java.util.List;

import mwallet.entities.History;
import mwallet.entities.User;
import mwallet.entities.Wallet;
import mwallet.exceptions.NoTransactionsYetException;
import mwallet.exceptions.NoUserFoundException;
import mwallet.repositories.IUserRepo;

public class UserService implements IUserService {
    private final IUserRepo userRepo;
    
    public UserService(IUserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User createUser(String name, Wallet wallet) {
        User user = userRepo.save(new User(name, wallet));
        return user;
    }

    @Override
    public User findUser(String id) {
        User user = userRepo.findById(id).orElseThrow(() -> new NoUserFoundException("User with ID" + id +" not found!"));
        return user;
    }

    @Override
    public Double addMoney(User user, Double amount) {
       Wallet wallet = user.getWallet();
       Double balance = wallet.addMoney(amount);
       user.addTransaction("Credit : " + amount + " Balance : " + balance);
       userRepo.save(user);
       return balance;

    }

    @Override
    public Double withDraw(User user, Double amount) {
       Wallet wallet = user.getWallet();
       Double balance = wallet.withDraw(amount);
       user.addTransaction("Debit : " + amount + " Balance : " + balance);
       userRepo.save(user);
       return balance;
    }

    @Override
    public Double checkBalance(User user) {
        Wallet wallet = user.getWallet();
        Double balance = wallet.getBalance();
        return balance;
    }

    @Override
    public List<History> transactions(User user) throws NoTransactionsYetException{
        List<History> transactions = user.getHistory();
        if(transactions.size() == 0)
        throw new NoTransactionsYetException("There are no transaction yet!!!");
        return transactions;
    }


    
}
