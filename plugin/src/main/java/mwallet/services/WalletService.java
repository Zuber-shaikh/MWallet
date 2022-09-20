package mwallet.services;

import mwallet.entities.Wallet;
import mwallet.repositories.IWalletRepo;

public class WalletService implements IWalletService{

    private final IWalletRepo walletRepo;

    public WalletService(IWalletRepo walletRepo) {
        this.walletRepo = walletRepo;
    }

    @Override
    public Wallet createWallet() {
       Wallet wallet = walletRepo.save(new Wallet(0.0));
       return wallet;
    }

    @Override
    public Wallet createWallet(Double amount) {
        Wallet wallet = walletRepo.save(new Wallet(amount));
       return wallet;
    }

    @Override
    public Double addMoney(String id, Double amount) {
        Wallet wallet = walletRepo.getById(id).get();
        Double balance = wallet.addMoney(amount);
        walletRepo.save(wallet);
        return balance;
    }

    @Override
    public Double withDraw(String id, Double amount) {
        Wallet wallet = walletRepo.getById(id).get();
        Double balance = wallet.withDraw(amount);
        walletRepo.save(wallet);
        return balance;
    }

   
    
}
