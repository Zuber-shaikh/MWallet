package mwallet.entities;

import java.util.ArrayList;
import java.util.List;

public class User extends BaseEntity{
    private String userName;
    private Wallet userWallet;
    private List<History> accountHistory;
    public User(String name, Wallet wallet) {
        this.userName = name;
        this.userWallet = wallet;
        this.accountHistory = new ArrayList<History>();
    }

    public User(String id, String name, Wallet wallet, List<History> accountHistory) {
        this.id = id;
        this.userName = name;
        this.userWallet = wallet;
        this.accountHistory = accountHistory;
    }

    public String getName() {
        return userName;
    }

    public Wallet getWallet() {
        return userWallet;
    }

    public List<History> getHistory() {
        return accountHistory;
    }
    private Integer transId = 0;
    public void addTransaction(String transaction){
        transId++;
        History trans = new History(Integer.toString(transId), transaction);
        accountHistory.add(trans);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        if(getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if(id == null) {
            if(other.id != null)
                return false;
        } else if(!id.equals(other.id))
            return false;
        return true;

    }

    @Override
    public String toString() {
        return "UserId : " + id + " Username : " + userName + " WalletBalance : " + userWallet.getBalance();
    }    
}
