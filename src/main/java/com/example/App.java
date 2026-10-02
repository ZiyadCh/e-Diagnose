package com.example;

import com.example.dao.InfirmierDao;
import com.example.models.Infirmier;

/**
 * App
 */
public class App {
  public static void main(String[] args) {
    InfirmierDao infirmierDao = new InfirmierDao();
    Infirmier infirmier = infirmierDao.findById(1);
    System.out.println(infirmier.getId() + " " + infirmier.getNom() + " " + infirmier.getRole());

  }
}
