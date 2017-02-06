package com.epam.service.impl;

import com.epam.dao.UserDAO;
import com.epam.dao.exception.DAOException;
import com.epam.dao.factory.DAOFactory;
import com.epam.service.ClientService;
import com.epam.service.exeption.ServiceException;

public class ClientServiceImpl implements ClientService {

	@Override
	public void initUsers() throws ServiceException {
		try {
			DAOFactory daoObjectFactory = DAOFactory.getInstance();
			UserDAO userDAO = daoObjectFactory.getUserDAO();
			userDAO.initUsers();
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}
	
	@Override
	public void logAllUsers() throws ServiceException {
		try {
			DAOFactory daoObjectFactory = DAOFactory.getInstance();
			UserDAO userDAO = daoObjectFactory.getUserDAO();
			userDAO.logAllUsers();
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
	}
	
	@Override
	public boolean registration(String login, String password) throws ServiceException {
		boolean result = false;

		if (login == null || login.trim().isEmpty()) {
			throw new ServiceException("Incorrect login");
		}

		if (password == null || password.trim().isEmpty()) {
			throw new ServiceException("Incorrect password");
		}

		try {
			DAOFactory daoObjectFactory = DAOFactory.getInstance();
			UserDAO userDAO = daoObjectFactory.getUserDAO();
			result = userDAO.registration(login, password);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return result;
	}

	
	@Override
	public boolean signIn(String login, String password) throws ServiceException {
		boolean result = false;

		if (login == null || login.trim().isEmpty()) {
			throw new ServiceException("Incorrect login");
		}

		if (password == null || password.trim().isEmpty()) {
			throw new ServiceException("Incorrect password");
		}

		try {
			DAOFactory daoObjectFactory = DAOFactory.getInstance();
			UserDAO userDAO = daoObjectFactory.getUserDAO();
			result = userDAO.signIn(login, password);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return result;
	}

	@Override
	public boolean signOut(String login) throws ServiceException {
		boolean result = false;

		if (login == null || login.trim().isEmpty()) {
			throw new ServiceException("Incorrect login");
		}

		try {
			DAOFactory daoObjectFactory = DAOFactory.getInstance();
			UserDAO userDAO = daoObjectFactory.getUserDAO();
			result = userDAO.signOut(login);
		} catch (DAOException e) {
			throw new ServiceException(e);
		}
		return result;
	}
}
