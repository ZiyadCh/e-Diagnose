package com.example;

import com.example.dao.InfirmierDao;
import com.example.models.Infirmier;
import com.example.models.Role;

/**
 * App
 */
public class App {
  public static void main(String[] args) {
    InfirmierDao infirmierDao = new InfirmierDao();
    infirmierDao.createInfirmier(new Infirmier("ziyad", "ch@", "1234", Role.INFIRMIER));
  }
}
