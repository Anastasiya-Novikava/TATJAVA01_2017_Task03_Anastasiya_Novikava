package com.epam.dao.factory;

import com.epam.bean.Catalog;
import com.epam.bean.Users;
import com.epam.dao.NewsDAO;
import com.epam.dao.UserDAO;
import com.epam.dao.impl.NewsDAOImpl;
import com.epam.dao.impl.UserDAOImpl;

public final class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();

    private final NewsDAO newsImpl = new NewsDAOImpl();
    private final UserDAO userImpl = new UserDAOImpl();
    private final Catalog catalog = new Catalog();
    private final Users users = new Users();

    private DAOFactory(){}

    public static DAOFactory getInstance(){
        return instance;
    }

    public NewsDAO getNewsDAO(){
        return newsImpl;
    }
    
    public UserDAO getUserDAO(){
        return userImpl;
    }
    
    public Catalog getCatalog() {
        return catalog;
    }
    
    public Users getUsers() {
        return users;
    }
}