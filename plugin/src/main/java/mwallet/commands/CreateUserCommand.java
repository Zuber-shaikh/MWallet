package mwallet.commands;

import java.util.List;

import mwallet.entities.User;
import mwallet.entities.Wallet;
import mwallet.services.IUserService;
import mwallet.services.IWalletService;

public class CreateUserCommand implements ICommand{
    private final IUserService userService;

    private final IWalletService walletService;

    public CreateUserCommand(IUserService userService, IWalletService walletService) {
        this.userService = userService;
        this.walletService = walletService;
    }

    @Override
    public void execute(List<String> tokens) {
        String userName  = tokens.get(1);
        Double amount = 0.0;
        if(tokens.size() == 3) {
            amount = Double.parseDouble(tokens.get(2));
        }
        Wallet wallet = walletService.createWallet(amount);
        User user = userService.createUser(userName, wallet);
        System.out.println(user);
    }
}