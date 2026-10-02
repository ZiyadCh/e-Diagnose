package com.example.service;

import org.mindrot.jbcrypt.BCrypt;

import com.example.dao.UserDao;
import com.example.models.User;

/**
 * AuthService
 */
public class AuthService {
  private static UserDao userDao = new UserDao();

  public boolean loginCheck(String email, String password) {
    User foundUser = userDao.findByEmail(email);
    if (foundUser != null) {
      if (BCrypt.checkpw(password, foundUser.getPassword())) {
        return true;
      }
    }
    return false;

  }

}
