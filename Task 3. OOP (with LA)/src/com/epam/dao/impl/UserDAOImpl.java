package com.epam.dao.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;

import com.epam.bean.User;
import com.epam.bean.Users;
import com.epam.dao.UserDAO;
import com.epam.dao.exception.DAOException;
import com.epam.dao.factory.DAOFactory;

public class UserDAOImpl implements UserDAO {

	@Override
	public void initUsers() throws DAOException {
		ArrayList<User> users = new ArrayList<>();
		String[] lines;

		try {
			lines = readUsers("users.txt").split("\r\n");
		} catch (IOException e) {
			throw new DAOException("Error read file", e);
		}

		String[] logins = new String[lines.length];
		String[] passwords = new String[lines.length];

		try {
			for (int i = 0; i < lines.length; ++i) {
				logins[i] = lines[i].split(" ")[0];
				passwords[i] = lines[i].split(" ")[1];
				users.add(new User(logins[i], passwords[i]));
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new DAOException("Data in file are wrong in wrong format", e);
		} finally {
			DAOFactory.getInstance().getUsers().addAll(users);
		}
	}

	@Override
	public void logAllUsers() throws DAOException {
		String result = "";

		Users users = DAOFactory.getInstance().getUsers();

		for (User item : users) {
			result += item.toString();
		}
		try {
			PrintWriter writer = new PrintWriter("log_users.txt", "UTF-8");
			writer.write(result);
			writer.close();

		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			throw new DAOException("Error write file", e);
		}
	}

	@Override
	public boolean registration(String login, String password) throws DAOException {
		boolean result = true;

		if (login == null || login.trim().isEmpty()) {
			throw new DAOException("Incorrect login");
		}

		if (password == null || password.trim().isEmpty()) {
			throw new DAOException("Incorrect password");
		}

		Iterator<User> iterator = DAOFactory.getInstance().getUsers().iterator();
		while (iterator.hasNext()) {
			User user = iterator.next();
			if ((user.getLogin().equals(login))) {
				result = false;
			}
		}
		if (result == true) {
			DAOFactory.getInstance().getUsers().add(new User(login, password));
		}
		return result;
	}

	@Override
	public boolean signIn(String login, String password) throws DAOException {
		if (login == null || login.trim().isEmpty()) {
			throw new DAOException("Incorrect login");
		}

		if (password == null || password.trim().isEmpty()) {
			throw new DAOException("Incorrect password");
		}

		Iterator<User> iterator = DAOFactory.getInstance().getUsers().iterator();
		while (iterator.hasNext()) {
			User user = iterator.next();
			if ((user.getLogin().equals(login)) && (user.getPassword().equals(password))) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean signOut(String login) throws DAOException {
		boolean result = false;
		String password = null;

		if (login == null || login.trim().isEmpty()) {
			throw new DAOException("Incorrect password");
		}

		Iterator<User> iterator = DAOFactory.getInstance().getUsers().iterator();
		while (iterator.hasNext()) {
			User user = iterator.next();
			if (user.getLogin().equals(login)) {
				result = true;
				password = user.getPassword();
			}
		}
		if (result == true) {
			DAOFactory.getInstance().getUsers().remove(new User(login, password));
		}
		return result;
	}

	public static String readUsers(String name) throws IOException {
		FileInputStream inputStream = null;
		try {
			inputStream = new FileInputStream(name);
			byte[] str = new byte[inputStream.available()];
			inputStream.read(str);
			String everything = new String(str);
			return everything;
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
			System.exit(0);
			return e.toString();
		} finally {
			inputStream.close();
		}
	}

}
