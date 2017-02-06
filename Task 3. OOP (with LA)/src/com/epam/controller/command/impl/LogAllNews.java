package com.epam.controller.command.impl;

import com.epam.controller.command.Command;
import com.epam.service.CatalogService;
import com.epam.service.exeption.ServiceException;
import com.epam.service.factory.ServiceFactory;

public class LogAllNews implements Command {

	@Override
	public String execute(String request) {
		String response = null;

		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		CatalogService catalogService = serviceFactory.getCatalogService();

		try {
			catalogService.logAllNews();
			response = "News are loged successfully";
		} catch (ServiceException e) {
			response = "Error during log news procedure";
		}
		return response;
	}
}