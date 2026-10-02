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

  public Infirmier findById(int id) {
    try (EntityManager em = emf.createEntityManager()) {
      return em.find(Infirmier.class, id);
    }
  }

  public void updateInfirmier(Infirmier infirmier) {
    try (EntityManager em = emf.createEntityManager()) {
      EntityTransaction tr = em.getTransaction();
      tr.begin();
      em.merge(infirmier);
      tr.commit();
      em.close();
    }
  }
}
