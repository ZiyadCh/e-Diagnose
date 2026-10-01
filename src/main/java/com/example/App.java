package com.example;

import com.example.dao.UserDao;
import com.example.models.Role;
import com.example.models.User;

/**
 * App
 */
public class App {
  public static void main(String[] args) {
    UserDao userDao = new UserDao();
    userDao.createUser(new User("ziyad", "ch@amil", "1234", Role.GENERALISTE));
  }
}
