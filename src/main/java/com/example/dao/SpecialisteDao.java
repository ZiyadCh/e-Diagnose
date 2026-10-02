package com.example.dao;

import com.example.models.Specialiste;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

/**
 * SpecialisteDao
 */
public class SpecialisteDao {
  private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("eDiagnose");

  public void createSpecialiste(Specialiste specialiste) {
    try (EntityManager em = emf.createEntityManager()) {
      EntityTransaction tr = em.getTransaction();
      tr.begin();
      em.persist(specialiste);
      tr.commit();
    }
  }

  public Specialiste findById(int id) {
    try (EntityManager em = emf.createEntityManager()) {
      return em.find(Specialiste.class, id);
    }
  }

  public List<Specialiste> findAll() {
    try (EntityManager em = emf.createEntityManager()) {
      return em.createQuery("select s from Specialiste s", Specialiste.class).getResultList();
    }
  }

  public void updateSpecialiste(Specialiste specialiste) {
    try (EntityManager em = emf.createEntityManager()) {
      EntityTransaction tr = em.getTransaction();
      tr.begin();
      em.merge(specialiste);
      tr.commit();
    }
  }

  public void deleteSpecialiste(int id) {
    try (EntityManager em = emf.createEntityManager()) {
      Specialiste found = em.find(Specialiste.class, id);
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