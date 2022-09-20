package mwallet.commands;

import java.util.List;

import mwallet.entities.User;
import mwallet.services.IUserService;

public class LoginUserCommand implements ICommand{
    private final IUserService userService;

    public LoginUserCommand(IUserService userService) {
        this.userService = userService;
    }

    @Override
    public void execute(List<String> tokens) {
        String id = tokens.get(1);
        try {
        User user = userService.findUser(id);
        System.out.println("Login Successfull!" + user.getName());
        } catch(RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
    
}
