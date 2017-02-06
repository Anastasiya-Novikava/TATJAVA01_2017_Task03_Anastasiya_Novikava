package com.epam.controller.command.impl;

import com.epam.controller.command.Command;
import com.epam.service.CatalogService;
import com.epam.service.exeption.ServiceException;
import com.epam.service.factory.ServiceFactory;

public class FindByCategory implements Command {

	@Override
	public String execute(String request) {
		String category = null;
		String response = null;

		try{
		category = request.split(" ")[1];
		} catch(ArrayIndexOutOfBoundsException e){
			response = "Parameters are input wrong";
			return response;
		}
		
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        CatalogService catalogService = serviceFactory.getCatalogService();
        try {
            if(!catalogService.findByCategory(category).isEmpty()){
            response = "News found successfully";
            }
            else  {
            	response = "News are not found";
            }
        } catch (ServiceException e){
            response = "Error during find by category procedure";
        }
        return response;
	}
}
