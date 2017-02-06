package com.epam.controller;

import java.util.HashMap;
import java.util.Map;

import com.epam.controller.command.Command;
import com.epam.controller.command.CommandName;
import com.epam.controller.command.impl.AddNews;
import com.epam.controller.command.impl.FindByCategory;
import com.epam.controller.command.impl.FindByTitle;
import com.epam.controller.command.impl.InitCatalog;
import com.epam.controller.command.impl.InitUsers;
import com.epam.controller.command.impl.LogAllNews;
import com.epam.controller.command.impl.LogAllUsers;
import com.epam.controller.command.impl.Registration;
import com.epam.controller.command.impl.SignIn;
import com.epam.controller.command.impl.SignOut;
import com.epam.controller.command.impl.WrongRequest;

final class CommandProvider {
    private final Map<CommandName, Command> repository = new HashMap<>();


    CommandProvider(){
    	repository.put(CommandName.INIT_USERS, new InitUsers());
    	repository.put(CommandName.INIT_CATALOG, new InitCatalog());
    	repository.put(CommandName.LOG_ALL_NEWS, new LogAllNews());
    	repository.put(CommandName.LOG_ALL_USERS, new LogAllUsers());
    	repository.put(CommandName.REGISTRATION, new Registration());
    	repository.put(CommandName.SIGN_IN, new SignIn());
    	repository.put(CommandName.SIGN_OUT, new SignOut());
        repository.put(CommandName.ADD_NEWS, new AddNews());
        repository.put(CommandName.FIND_BY_TITLE, new FindByTitle());
        repository.put(CommandName.FIND_BY_CATEGORY, new FindByCategory());
        repository.put(CommandName.WRONG_REQUEST, new WrongRequest());

    }
    Command getCommand(String name){
        CommandName commandName = null;
        Command command = null;

        try {
            commandName = CommandName.valueOf((name.toUpperCase()));
            command = repository.get(commandName);
        } catch (IllegalArgumentException | NullPointerException e){
            command = repository.get(CommandName.WRONG_REQUEST);
        }
        return command;
    }
}
