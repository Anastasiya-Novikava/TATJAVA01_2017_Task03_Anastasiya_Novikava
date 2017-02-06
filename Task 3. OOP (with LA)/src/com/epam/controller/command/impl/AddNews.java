package com.epam.controller.command.impl;

import com.epam.bean.News;
import com.epam.controller.command.Command;
import com.epam.service.CatalogService;
import com.epam.service.exeption.ServiceException;
import com.epam.service.factory.ServiceFactory;

public class AddNews implements Command {

	@Override
	public String execute(String request) {
		String response = null;

		News news = new News();
		
		try{
		news.setTitle(request.split(" ")[1]);
		news.setCategory(request.split(" ")[2]);
		news.setContent(request.split(" ")[3]);
		} catch(ArrayIndexOutOfBoundsException e){
			response = "Parameters are input wrong";
			return response;
		}

		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		CatalogService catalogService = serviceFactory.getCatalogService();

		try {
			if(catalogService.addNews(news)){
				response = "News added successfully";
			}
			else {
				response = "Such news is already exist";
			}
		} catch (ServiceException e) {
			response = "Error during add procedure";
		}
		return response;
	}
}