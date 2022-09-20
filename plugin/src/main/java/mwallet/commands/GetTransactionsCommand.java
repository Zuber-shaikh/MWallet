package mwallet.commands;

import java.util.List;

import mwallet.entities.History;
import mwallet.entities.User;
import mwallet.services.IUserService;

public class GetTransactionsCommand implements ICommand{
    private final IUserService userService;

    public GetTransactionsCommand(IUserService userService) {
        this.userService = userService;
    }

    @Override
    public void execute(List<String> tokens) {
        String userId = tokens.get(1);
        User user = userService.findUser(userId);
        try{
        List<History> transactionList = userService.transactions(user);
        transactionList.stream().forEach(System.out::println);
        } catch(RuntimeException e) {
            System.out.println(e.getMessage());
        }
        
    }
    
}
