package mwallet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import mwallet.appconfig.AppConfig;
import mwallet.commands.CommandInvoker;

public class App {
    static String currentId = "";
    public static void main(String[] args) throws NumberFormatException, IOException {
        AppConfig appConfig = new AppConfig();
        CommandInvoker commandInvoker = appConfig.getCommandInvoker();
        System.out.println("WELCOME TO MWallet!!");
        

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        boolean flag = true;
        
        do {
            System.out.println("Select an option to perform");
            System.out.println("1. Create an User" + "\n" + "2. Already an User, provide login-id \n" + "3. AddMoney \n"
                           + "4. WithDraw money \n" + "5. Check Balance \n6. Get account transaction history\n7. Exit");
            int choice1 = Integer.parseInt(input.readLine());
            switch(choice1) {
                case  1:
                        System.out.println("Provide an UserName");
                        String name = input.readLine();
                        List<String> listOFTokens = new ArrayList<String>() {
                            {
                                add("Create-User");
                                add(name);
                                
                            }
                        };
                        commandInvoker.executeCommand("Create-User", listOFTokens);
                        break;
                case 2:
                        System.out.println("Enter your Login Id");
                        currentId = input.readLine();
                        
                        List<String> loginTokens = new ArrayList<String>() {
                            {
                                add("Login-User");
                                add(currentId);
                                
                            }
                        };
                        commandInvoker.executeCommand("Login-User", loginTokens);
                        break;
                
                case 3:
                        System.out.println("Enter the amount of money to add in your wallet");
                        String amount = input.readLine();
                        List<String> addingTokens = new ArrayList<String>() {
                            {
                                add("AddMoney");
                                add(currentId);
                                add(amount);
                                
                            }
                        };
                        commandInvoker.executeCommand("AddMoney", addingTokens);
                        break;
                case 4:
                        System.out.println("Enter the amount to withdraw from your wallet");
                        String withdrawAmount = input.readLine();
                        List<String> withDrawTokens = new ArrayList<String>() {
                            {
                                add("WithDraw");
                                add(currentId);
                                add(withdrawAmount);
                            }
                        };
                        commandInvoker.executeCommand("WithDraw", withDrawTokens);
                        break;
                case 5:
                        List<String> balanceCheckTokens = new ArrayList<String>() {
                            {
                                add("CheckBalance");
                                add(currentId);
                            }
                        };
                        commandInvoker.executeCommand("CheckBalance", balanceCheckTokens);
                        break;
                case 6:
                        List<String> checkHistoryTokens = new ArrayList<String>() {
                            {
                                add("Transaction-History");
                                add(currentId);
                            }
                        };
                        commandInvoker.executeCommand("Transaction-History", checkHistoryTokens);
                        break;
                case 7: 
                        System.out.println("Exiting MWallet...");
                        flag = false;
                        break;
            }
        } while(flag);

    }
}
