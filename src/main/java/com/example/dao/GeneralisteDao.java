package com.example.dao;

import com.example.models.Generaliste;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

/**
 * GeneralisteDao
 */
public class GeneralisteDao {
  private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("eDiagnose");

  public void createGeneraliste(Generaliste generaliste) {
    try (EntityManager em = emf.createEntityManager()) {
      EntityTransaction tr = em.getTransaction();
      tr.begin();
      em.persist(generaliste);
      tr.commit();
    }
  }

  public Generaliste findById(int id) {
    try (EntityManager em = emf.createEntityManager()) {
      return em.find(Generaliste.class, id);
    }
  }

  public Generaliste findByEmail(String email) {
    try (EntityManager em = emf.createEntityManager()) {
      return em.createQuery("select g from Generaliste g where g.email = :email", Generaliste.class)
          .setParameter("email", email)
          .getResultStream()
          .findFirst()
          .orElse(null);
    }
  }

  public List<Generaliste> findAll() {
    try (EntityManager em = emf.createEntityManager()) {
      return em.createQuery("select g from Generaliste g", Generaliste.class).getResultList();
    }
  }

  public void updateGeneraliste(Generaliste generaliste) {
    try (EntityManager em = emf.createEntityManager()) {
      EntityTransaction tr = em.getTransaction();
      tr.begin();
      em.merge(generaliste);
      tr.commit();
    }
  }

  public void deleteGeneraliste(int id) {
    try (EntityManager em = emf.createEntityManager()) {
      Generaliste found = em.find(Generaliste.class, id);
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