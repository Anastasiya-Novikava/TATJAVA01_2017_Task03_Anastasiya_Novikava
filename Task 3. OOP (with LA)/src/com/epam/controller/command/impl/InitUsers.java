package com.epam.controller.command.impl;

import com.epam.controller.command.Command;
import com.epam.service.ClientService;
import com.epam.service.exeption.ServiceException;
import com.epam.service.factory.ServiceFactory;

public class InitUsers implements Command {

	@Override
	public String execute(String request) {
		String response = null;

		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		ClientService clientService = serviceFactory.getClientService();

		try {
			clientService.initUsers();
			response = "Users are initialized successfully";
		} catch (ServiceException e) {
			response = "Error during users initialization procedure";
		}
		return response;
	}
}