package mwallet.services;

import mwallet.entities.Wallet;

public interface IWalletService {
    public Wallet createWallet();
    public Wallet createWallet(Double amount);
    public Double addMoney(String id, Double amount);
    public Double withDraw(String id, Double amount);
}
