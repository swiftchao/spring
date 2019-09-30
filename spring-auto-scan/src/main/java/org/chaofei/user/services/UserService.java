package org.chaofei.user.services;

import org.chaofei.user.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;

public class UserService {
    @Autowired
    UserDAO userDAO;

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public String toString() {
        return "UserService [userDAO=" + userDAO + "]";
    }
}
