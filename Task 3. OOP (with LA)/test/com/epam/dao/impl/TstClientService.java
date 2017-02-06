package com.epam.dao.impl;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.epam.bean.User;
import com.epam.dao.UserDAO;
import com.epam.dao.exception.DAOException;
import com.epam.dao.factory.DAOFactory;
import com.epam.service.ClientService;
import com.epam.service.exeption.ServiceException;
import com.epam.service.factory.ServiceFactory;

public class TstClientService {
	@BeforeClass
	public void beforeClass() throws DAOException{
		 DAOFactory daoObjectFactory = DAOFactory.getInstance();
		 UserDAO userDAO = daoObjectFactory.getUserDAO();
		 userDAO.initUsers();
	}
	
	@DataProvider(name = "simpleDataProviderOne")
	public Object[][] createSomeDataOne() {
		return new Object[][] {
				{ new User("user", "123456") },
				{ new User("hello", "world") },
				{ new User("angel", "123") },
				};
	}
	
	@DataProvider(name = "simpleDataProviderTwo")
	public Object[][] createSomeDataTwo() {
		return new Object[][] {
				{ new User("admin", "admin") },
				{ new User("name", "1234") },
				{ new User("login", "password") },
				};
	}
	
	@DataProvider(name = "simpleDataProviderThree")
	public Object[][] createSomeDataThree() {
		return new Object[][] {
				{ new User("1", "1") },
				{ new User("2", "2") },
				{ new User("day", "night") },
				};
	}
	
	@Test(dataProvider = "simpleDataProviderOne")
    public void tstRegistrationPositive(User user) throws ServiceException{
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        ClientService client = serviceFactory.getClientService();
        Assert.assertTrue(client.registration(user.getLogin(), user.getPassword()));
    }
	
	@Test(dataProvider = "simpleDataProviderTwo")
    public void tstSignInPositive(User user)  throws ServiceException{
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
        ClientService client = serviceFactory.getClientService();
        Assert.assertTrue(client.signIn(user.getLogin(), user.getPassword()));
    }
	
	@Test(dataProvider = "simpleDataProviderTwo")
    public void tstSignOutPositive(User user)  throws ServiceException{
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
        ClientService client = serviceFactory.getClientService();
        Assert.assertTrue(client.signOut(user.getLogin()));
    }
	
	@Test(dataProvider = "simpleDataProviderTwo")
    public void tstRegistrationNegative(User user) throws ServiceException{
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
        ClientService client = serviceFactory.getClientService();
        Assert.assertFalse(client.registration(user.getLogin(), user.getPassword()));
    }
	
	@Test(dataProvider = "simpleDataProviderThree")
    public void tstSignInNegative(User user)  throws ServiceException{
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
        ClientService client = serviceFactory.getClientService();
        Assert.assertFalse(client.signIn(user.getLogin(), user.getPassword()));
    }
	
	@Test(dataProvider = "simpleDataProviderThree")
    public void tstSignOutNegative(User user)  throws ServiceException{
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
        ClientService client = serviceFactory.getClientService();
        Assert.assertFalse(client.signIn(user.getLogin(), user.getPassword()));
    }
}
