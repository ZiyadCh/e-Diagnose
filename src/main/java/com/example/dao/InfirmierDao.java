package com.example.dao;

import com.example.models.Infirmier;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

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

  public List<Infirmier> findAll() {
    try (EntityManager em = emf.createEntityManager()) {
      return em.createQuery("select i from Infirmier i", Infirmier.class).getResultList();
    }
  }

  public void updateInfirmier(Infirmier infirmier) {
    try (EntityManager em = emf.createEntityManager()) {
      EntityTransaction tr = em.getTransaction();
      tr.begin();
      em.merge(infirmier);
      tr.commit();
    }
  }

  public void deleteInfirmier(int id) {
    try (EntityManager em = emf.createEntityManager()) {
      Infirmier found = em.find(Infirmier.class, id);
      if (found == null) {
        return;
      }
      EntityTransaction tr = em.getTransaction();
      tr.begin();
      em.remove(found);
      tr.commit();
    }
  }
}