package mwallet.appconfig;

import mwallet.commands.AddMoneyCommand;
import mwallet.commands.CheckBalanceCommand;
import mwallet.commands.CommandInvoker;
import mwallet.commands.CreateUserCommand;
import mwallet.commands.GetTransactionsCommand;
import mwallet.commands.LoginUserCommand;
import mwallet.commands.WithDrawMoneyCommand;
import mwallet.repositories.IUserRepo;
import mwallet.repositories.IWalletRepo;
import mwallet.repositories.UserRepo;
import mwallet.repositories.WalletRepo;
import mwallet.services.IUserService;
import mwallet.services.IWalletService;
import mwallet.services.UserService;
import mwallet.services.WalletService;

public class AppConfig {
    private final IUserRepo userRepo = new UserRepo();
    private final IWalletRepo walletRepo = new WalletRepo();

    private final IUserService userService = new UserService(userRepo);
    private final IWalletService walletService = new WalletService(walletRepo);

    private final CreateUserCommand createUser = new CreateUserCommand(userService, walletService);
    private final AddMoneyCommand addMoney = new AddMoneyCommand(userService);
    private final WithDrawMoneyCommand withDrawMoney = new WithDrawMoneyCommand(userService);
    private final LoginUserCommand loginUser = new LoginUserCommand(userService);
    private final CheckBalanceCommand balanceCheck = new CheckBalanceCommand(userService);
    private final GetTransactionsCommand getTransactions = new GetTransactionsCommand(userService);

    private final CommandInvoker commandInvoker = new CommandInvoker();

    public CommandInvoker getCommandInvoker() {
        commandInvoker.registerCommand("Create-User", createUser);
        commandInvoker.registerCommand("Login-User", loginUser);
        commandInvoker.registerCommand("AddMoney", addMoney);
        commandInvoker.registerCommand("WithDraw", withDrawMoney);
        commandInvoker.registerCommand("CheckBalance", balanceCheck);
        commandInvoker.registerCommand("Transaction-History", getTransactions);

        return commandInvoker;
    }
    
}
