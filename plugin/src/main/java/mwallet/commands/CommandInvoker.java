package mwallet.commands;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mwallet.exceptions.NoSuchCommandException;

public class CommandInvoker {
    private static final Map<String, ICommand> commandMap = new HashMap<>();
    
    public void registerCommand(String commandName, ICommand command) {
        commandMap.put(commandName, command);
    }

    private ICommand getCommand(String name) {
        return commandMap.get(name);
    }

    public void executeCommand(String commandName, List<String> tokens) throws NoSuchCommandException {
        ICommand command = getCommand(commandName);

        if(command == null) {
            throw new NoSuchCommandException();
        }

        command.execute(tokens);
    }
}

