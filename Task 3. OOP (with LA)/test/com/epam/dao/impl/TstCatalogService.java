package com.epam.dao.impl;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.epam.bean.News;
import com.epam.dao.NewsDAO;
import com.epam.dao.exception.DAOException;
import com.epam.dao.factory.DAOFactory;

public class TstCatalogService {
	@BeforeClass
	public void beforeClass() throws DAOException{
		 DAOFactory daoObjectFactory = DAOFactory.getInstance();
	     NewsDAO newsDAO = daoObjectFactory.getNewsDAO();
	     newsDAO.initCatalog();
	}
	
	@DataProvider(name = "simpleDataProvider")
	public Object[][] createSomeData() {
		return new Object[][] {
				{ new News("The_best_actress", "Film", "text_of_news") },
				{ new News("Top_chart", "Disk", "text_of_news") },
				{ new News("The_most_interesting_Novel", "Book", "text_of_news") },
				};
	}
	
	@Test(dataProvider = "simpleDataProvider")
    public void tstAddNews(News news) throws DAOException{
        DAOFactory daoObjectFactory = DAOFactory.getInstance();
        NewsDAO newsDAO = daoObjectFactory.getNewsDAO();
        Assert.assertTrue(newsDAO.addNews(news));
    }
	
	@Test(dataProvider = "simpleDataProvider")
    public void tstFindByTitle(News news) throws DAOException{
        DAOFactory daoObjectFactory = DAOFactory.getInstance();
        NewsDAO newsDAO = daoObjectFactory.getNewsDAO();
        Assert.assertEquals(newsDAO.findByTitle(news.getTitle()), news);
    }
	
}
