package mwallet.repositories;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import mwallet.entities.Wallet;

public class WalletRepo implements IWalletRepo{
    private final Map<String, Wallet> walletMap;
    private Integer autoIncrement = 0;
    public WalletRepo() {
        walletMap = new HashMap<String, Wallet>();
    }

    public WalletRepo(Map<String, Wallet> walletMap) {
        this.walletMap = walletMap;
        autoIncrement = walletMap.size();
    }

    
    @Override
    public Wallet save(Wallet entity) {
        if(entity.getId() == null) {
            autoIncrement++;
            Wallet w = new Wallet(autoIncrement.toString(), entity.getBalance());
            walletMap.put(w.getId(), w);
            return w;
        }
        walletMap.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public List<Wallet> getAll() {
        List<Wallet> walletList = walletMap.entrySet().stream()
                                    .map(Map.Entry::getValue).collect(Collectors.toList());
        return walletList;
    }

    @Override
    public void delete(Wallet entity) {
        
    }

    @Override
    public Optional<Wallet> getById(String id) {
        Optional<Wallet> wallet = walletMap.entrySet().stream()
                                    .filter(w -> w.getKey().equals(id))
                                    .map(Map.Entry::getValue).findFirst();
        return wallet;
    }
    
}

