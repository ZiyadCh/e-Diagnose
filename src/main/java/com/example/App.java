package com.example;

import com.example.dao.InfirmierDao;
import com.example.models.Infirmier;

/**
 * App
 */
public class App {
  public static void main(String[] args) {
    InfirmierDao dao = new InfirmierDao();

    int testId = 1;

    // 1. Fetch the existing entity
    Infirmier infirmier = dao.findById(testId);

    if (infirmier != null) {
      System.out.println("***************************************");
      System.out.println("***************************************");
      System.out.println("Before Update: " + infirmier.getNom());

      dao.deleteInfirmier(1);

    } else {
      System.out.println("Infirmier with ID " + testId + " was not found!");
    }
  }
}
