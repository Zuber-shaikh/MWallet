package mwallet.repositories;

import java.util.Optional;

import mwallet.entities.Wallet;

public interface IWalletRepo extends CRUDOperations<Wallet, String>{
    public Optional<Wallet> getById(String id);
}

