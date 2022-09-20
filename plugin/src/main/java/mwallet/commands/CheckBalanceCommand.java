package mwallet.commands;

import java.util.List;

import mwallet.entities.User;
import mwallet.services.IUserService;

public class CheckBalanceCommand implements ICommand{
    private final IUserService userService;

    public CheckBalanceCommand(IUserService userService) {
        this.userService = userService;
    }

    @Override
    public void execute(List<String> tokens) {
       String userId = tokens.get(1);

       User user = userService.findUser(userId);
       Double balance = userService.checkBalance(user);
       System.out.println("Account balance is : " + balance);
        
    }
    
}
