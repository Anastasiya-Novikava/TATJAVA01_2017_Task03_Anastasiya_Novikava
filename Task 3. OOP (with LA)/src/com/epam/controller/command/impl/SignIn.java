package com.epam.controller.command.impl;

import com.epam.controller.command.Command;
import com.epam.service.ClientService;
import com.epam.service.exeption.ServiceException;
import com.epam.service.factory.ServiceFactory;

public class SignIn implements Command {

	@Override
	public String execute(String request) {
		String login = null;
		String password = null;
		String response = null;

		try{
		login = request.split(" ")[1];
		password = request.split(" ")[2];
		} catch(ArrayIndexOutOfBoundsException e){
			response = "Parameters are input wrong";
			return response;
		}

		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		ClientService clientService = serviceFactory.getClientService();

		try {
			if(clientService.signIn(login, password)){
			response = "Client signed in successfully";
			}
			else response = "No such user";
		} catch (ServiceException e) {
			response = "Error during sign in procedure";
		}
		return response;
	}
}