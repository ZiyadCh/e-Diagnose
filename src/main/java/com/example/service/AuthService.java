package com.example.service;

import com.example.dao.UserDao;
import com.example.models.User;

/**
 * AuthService
 */
public class AuthService {
  private static UserDao userDao = new UserDao();

  public boolean login(User user, String password) {
    User foundUser = userDao.findById(user.getId());
    if (foundUser != null) {
      if (foundUser.getPassword().equals(password)) {
        return true;
      }
    }
    return false;

  }
}
