package com.example.dao;

import com.example.models.Infirmier;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

/**
 * InfirmierDao
 */
public class InfirmierDao {
  private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("eDiagnose");

  public void createInfirmier(Infirmier infirmier) {
    try (EntityManager em = emf.createEntityManager()) {
      EntityTransaction tr = em.getTransaction();
      tr.begin();
      em.persist(infirmier);
      tr.commit();
    }
  }

  public void getInfirmier(Infirmier infirmier) {
    try (EntityManager em = emf.createEntityManager()) {
      EntityTransaction tr = em.getTransaction();
      tr.begin();
      em.find(infirmier.getClass(), infirmier);
      tr.commit();
    }
  }
}
