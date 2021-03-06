package com.epam.controller.command.impl;

import com.epam.bean.News;
import com.epam.controller.command.Command;
import com.epam.service.CatalogService;
import com.epam.service.exeption.ServiceException;
import com.epam.service.factory.ServiceFactory;

public class FindByTitle implements Command {

	@Override
	public String execute(String request) {
		String title = null;
		String response = null;

		try{
		title = request.split(" ")[1];
		} catch(ArrayIndexOutOfBoundsException e){
			response = "Parameters are input wrong";
			return response;
		}
		
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
        CatalogService catalogService = serviceFactory.getCatalogService();
        try {
        	News news = catalogService.findByTitle(title);
			if ((news.getTitle() != null) && (news.getCategory() != null) && (news.getContent() != null)) {
				response = "News found successfully";
			} else {
				response = "News are not found";
			}
        } catch (ServiceException e){
            response = "Error during find by title procedure";
        }
        return response;
	}
}