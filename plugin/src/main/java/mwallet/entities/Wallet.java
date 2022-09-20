package mwallet.entities;

import mwallet.exceptions.NotEnoughBalance;

public class Wallet extends BaseEntity{
    private Double balance;

    public Wallet(Double balance) {
        this.balance = balance;
    }   

    public Wallet(String id, Double balance) {
        this.id = id;
        this.balance = balance;
    }

    public Double getBalance() {
        return balance;
    }
    
    public String getId() {
        return id;
    }

    public Double withDraw(Double amount) throws NotEnoughBalance{
        if(amount > balance)
        throw new NotEnoughBalance();

        balance -= amount;
        return balance;
    }


    public Double addMoney(Double amount) {
        balance += amount;
        return balance;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null)
            return false;
        if(getClass() != obj.getClass())
            return false;
        Wallet other = (Wallet) obj;
        if(id == null) {
            if(other.id != null)
                return false;
        } else if(!id.equals(other.id))
            return false;
        return true;

    }
}
