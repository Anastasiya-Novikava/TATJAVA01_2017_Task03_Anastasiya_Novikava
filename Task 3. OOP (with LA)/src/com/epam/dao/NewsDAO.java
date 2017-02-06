package com.epam.dao;

import java.util.ArrayList;

import com.epam.bean.News;
import com.epam.dao.exception.DAOException;

public interface NewsDAO {
	void initCatalog() throws DAOException;
	void logAllNews() throws DAOException;
	boolean addNews(News news) throws DAOException;
    News findByTitle(String title) throws DAOException;
    ArrayList<News> findByCategory(String category) throws DAOException;
}