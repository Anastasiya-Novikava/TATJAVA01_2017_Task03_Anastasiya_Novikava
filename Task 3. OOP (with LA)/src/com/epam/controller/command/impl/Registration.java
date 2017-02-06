package com.epam.controller.command.impl;

import com.epam.controller.command.Command;
import com.epam.service.ClientService;
import com.epam.service.exeption.ServiceException;
import com.epam.service.factory.ServiceFactory;

public class Registration implements Command {

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
			if(clientService.registration(login, password)){
			response = "Client registered successfully";
			}
			else response = "Such user is already exist";
		} catch (ServiceException e) {
			response = "Error during registration procedure";
		}
		return response;
	}
}