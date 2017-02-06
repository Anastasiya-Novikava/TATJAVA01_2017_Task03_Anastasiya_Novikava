package com.epam.service.impl;

import java.util.ArrayList;
import com.epam.bean.News;

import com.epam.dao.NewsDAO;
import com.epam.dao.exception.DAOException;
import com.epam.dao.factory.DAOFactory;
import com.epam.service.CatalogService;
import com.epam.service.exeption.ServiceException;

public class CatalogServiceImpl implements CatalogService{

	@Override
	public void initCatalog() throws ServiceException {
		try {
			DAOFactory daoObjectFactory = DAOFactory.getInstance();
			NewsDAO newsDAO = daoObjectFactory.getNewsDAO();
			newsDAO.initCatalog();
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}
	
	@Override
	public void logAllNews() throws ServiceException {
		try {
			DAOFactory daoObjectFactory = DAOFactory.getInstance();
			NewsDAO newsDAO = daoObjectFactory.getNewsDAO();
			newsDAO.logAllNews();
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}
	
	@Override
	public boolean addNews(News news) throws ServiceException {
		boolean result = false;
		
		if(news.getTitle() == null || news.getTitle().trim().isEmpty()){
			 throw new ServiceException("Incorrect title");
		}
		if(news.getCategory() == null || news.getCategory().trim().isEmpty()){
			 throw new ServiceException("Incorrect category");
		}
		if(news.getContent() == null || news.getContent().trim().isEmpty()){
			 throw new ServiceException("Incorrect content");
		}
		try{
			DAOFactory daoObjectFactory = DAOFactory.getInstance();
			NewsDAO newsDAO = daoObjectFactory.getNewsDAO();
			result = newsDAO.addNews(news);
		} catch(DAOException e){
			throw new ServiceException(e);
		}
		return result;
	}

	
	@Override
	public News findByTitle(String title) throws ServiceException {
		News news = new News();
		if (title == null || title.trim().isEmpty()){
            throw new ServiceException("Incorrect title");
        }
		try{
			DAOFactory daoObjectFactory = DAOFactory.getInstance();
			NewsDAO newsDAO = daoObjectFactory.getNewsDAO();
			news =  newsDAO.findByTitle(title);
		} catch(DAOException e){
			throw new ServiceException(e);
		}
		return news;
	}

	@Override
	public ArrayList<News> findByCategory(String category) throws ServiceException {
		ArrayList<News> newsList= new ArrayList<>();
		if (category == null || category.trim().isEmpty()){
            throw new ServiceException("Incorrect category");
        }
		try{
			DAOFactory daoObjectFactory = DAOFactory.getInstance();
			NewsDAO newsDAO = daoObjectFactory.getNewsDAO();
			newsList =  newsDAO.findByCategory(category);
		} catch(DAOException e){
			throw new ServiceException(e);
		}
		return newsList;
	}

}
