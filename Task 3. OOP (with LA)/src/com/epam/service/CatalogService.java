package com.epam.service;

import java.util.ArrayList;

import com.epam.bean.News;
import com.epam.service.exeption.ServiceException;

public interface CatalogService {
	void initCatalog() throws ServiceException;
	void logAllNews() throws ServiceException;
	boolean addNews(News news) throws ServiceException;
    News findByTitle(String title) throws ServiceException;
    ArrayList<News> findByCategory(String catalog) throws ServiceException;
}
