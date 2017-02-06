package com.epam.service;

import com.epam.service.exeption.ServiceException;

public interface ClientService {
	void initUsers() throws ServiceException;
	void logAllUsers() throws ServiceException;
	boolean registration(String login, String password) throws ServiceException;
	boolean signIn(String login, String password) throws ServiceException;
	boolean signOut(String login) throws ServiceException;
}
