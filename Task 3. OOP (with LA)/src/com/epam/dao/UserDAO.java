package com.epam.dao;

import com.epam.dao.exception.DAOException;

public interface UserDAO {
	void initUsers() throws DAOException;
	void logAllUsers() throws DAOException;
	boolean registration(String login, String password) throws DAOException;
	boolean signIn(String login, String password) throws DAOException;
	boolean signOut(String password) throws DAOException;
}
