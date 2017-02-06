package com.epam.dao.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;

import com.epam.bean.Catalog;
import com.epam.bean.News;
import com.epam.dao.NewsDAO;
import com.epam.dao.exception.DAOException;
import com.epam.dao.factory.DAOFactory;

public class NewsDAOImpl implements NewsDAO {

	@Override
	public void initCatalog() throws DAOException {
		ArrayList<News> catalog = new ArrayList<>();
		String[] lines;

		try {
			lines = readCatalog("catalog.txt").split("\r\n");
		} catch (IOException e) {
			throw new DAOException("Error read file", e);
		}

		String[] titles = new String[lines.length];
		String[] categories = new String[lines.length];
		String[] contents = new String[lines.length];

		try {
			for (int i = 0; i < lines.length; ++i) {
				titles[i] = lines[i].split(" ")[0];
				categories[i] = lines[i].split(" ")[1];
				contents[i] = lines[i].split(" ")[2];

				catalog.add(new News(titles[i], categories[i], contents[i]));
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			throw new DAOException("Data in file in wrong format", e);
		} finally {
			DAOFactory.getInstance().getCatalog().addAll(catalog);
		}
	}

	@Override
	public void logAllNews() throws DAOException {
		String result = "";

		Catalog catalog = DAOFactory.getInstance().getCatalog();

		for (News item : catalog) {
			result += item.toString();
		}
		try {
			PrintWriter writer = new PrintWriter("log_news.txt", "UTF-8");
			writer.write(result);
			writer.close();

		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			throw new DAOException("Error write file", e);
		}
	}

	@Override
	public boolean addNews(News news) throws DAOException {
		boolean result = true;

		if (news.getTitle() == null || news.getTitle().trim().isEmpty()) {
			throw new DAOException("Incorrect title");
		}
		if (news.getCategory() == null || news.getCategory().trim().isEmpty()) {
			throw new DAOException("Incorrect category");
		}
		if (news.getContent() == null || news.getContent().trim().isEmpty()) {
			throw new DAOException("Incorrect content");
		}

		Iterator<News> iterator = DAOFactory.getInstance().getCatalog().iterator();
		while (iterator.hasNext()) {
			News item = iterator.next();
			if ((item.getTitle().equals(news.getTitle())) && (item.getCategory().equals(news.getCategory()))
					&& (item.getContent().equals(news.getContent()))) {
				result = false;
			}
		}
		if (result == true) {
			DAOFactory.getInstance().getCatalog().add(new News(news.getTitle(), news.getCategory(), news.getContent()));
		}
		return result;
	}

	@Override
	public News findByTitle(String title) throws DAOException {
		if (title == null || title.trim().isEmpty()) {
			throw new DAOException("Incorrect title");
		}

		News result = new News();
		Iterator<News> iterator = DAOFactory.getInstance().getCatalog().iterator();

		while (iterator.hasNext()) {
			News news = iterator.next();
			if (news.getTitle().equals(title)) {
				result = new News(news.getTitle(), news.getCategory(), news.getContent());
			}
		}
		return result;
	}

	@Override
	public ArrayList<News> findByCategory(String category) throws DAOException {
		if (category == null || category.trim().isEmpty()) {
			throw new DAOException("Incorrect category");
		}

		ArrayList<News> result = new ArrayList<>();
		Iterator<News> iterator = DAOFactory.getInstance().getCatalog().iterator();

		while (iterator.hasNext()) {
			News news = iterator.next();
			if (news.getCategory().equals(category)) {
				result.add(news);
			}
		}
		return result;
	}

	public static String readCatalog(String name) throws IOException {
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
