package mwallet.commands;

import java.util.List;

import mwallet.entities.User;
import mwallet.services.IUserService;

public class AddMoneyCommand implements ICommand{
    private final IUserService userService;

    public AddMoneyCommand(IUserService userService) {
        this.userService = userService;
    }
    @Override
    public void execute(List<String> tokens) {
        String userId = tokens.get(1);
        Double amount = Double.parseDouble(tokens.get(2));

        User user = userService.findUser(userId);
        Double balance = userService.addMoney(user, amount);
        System.out.println("Account balance : " + balance);
        
        
    }
    
}

