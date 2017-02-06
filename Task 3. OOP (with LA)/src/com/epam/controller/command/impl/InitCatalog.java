package com.epam.controller.command.impl;

import com.epam.controller.command.Command;
import com.epam.service.CatalogService;
import com.epam.service.exeption.ServiceException;
import com.epam.service.factory.ServiceFactory;

public class InitCatalog implements Command {

	@Override
	public String execute(String request) {
		String response = null;

		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		CatalogService catalogService = serviceFactory.getCatalogService();

		try {
			catalogService.initCatalog();
			response = "Catalog are initialized successfully";
		} catch (ServiceException e) {
			response = "Error during catalog initialization procedure";
		}
		return response;
	}
}