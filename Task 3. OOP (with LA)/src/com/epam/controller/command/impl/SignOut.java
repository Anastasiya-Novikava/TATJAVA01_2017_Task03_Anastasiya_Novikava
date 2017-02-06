package com.epam.controller.command.impl;

import com.epam.controller.command.Command;
import com.epam.service.ClientService;
import com.epam.service.exeption.ServiceException;
import com.epam.service.factory.ServiceFactory;

public class SignOut implements Command {

	@Override
	public String execute(String request) {
		String login = null;
		String response = null;

		try{
		login = request.split(" ")[1];
		} catch(ArrayIndexOutOfBoundsException e){
			response = "Parameters are input wrong";
			return response;
		}
		
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		ClientService clientService = serviceFactory.getClientService();

		try {
			if(clientService.signOut(login)){
			response = "Client signed out successfully";
			}
			else response = "No such user";
		} catch (ServiceException e) {
			response = "Error during sign out procedure";
		}
		return response;
	}
}