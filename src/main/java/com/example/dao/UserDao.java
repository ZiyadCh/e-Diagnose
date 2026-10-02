package com.example.dao;

import com.example.models.User;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

/**
 * UserDao
 */
public class UserDao {
  private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("eDiagnose");

  public void createUser(User user) {
    try (EntityManager em = emf.createEntityManager()) {
      EntityTransaction tr = em.getTransaction();
      tr.begin();
      em.persist(user);
      tr.commit();
    }
  }

  public User findById(int id) {
    try (EntityManager em = emf.createEntityManager()) {
      return em.find(User.class, id);
    }
  }

  public User findByEmail(String email) {
    try (EntityManager em = emf.createEntityManager()) {
      return em.createQuery("select u from User u where u.email = :email", User.class)
          .setParameter("email", email)
          .getResultStream()
          .findFirst()
          .orElse(null);
    }
  }

  public List<User> findAll() {
    try (EntityManager em = emf.createEntityManager()) {
      return em.createQuery("select u from User u", User.class).getResultList();
    }
  }

  public void updateUser(User user) {
    try (EntityManager em = emf.createEntityManager()) {
      EntityTransaction tr = em.getTransaction();
      tr.begin();
      em.merge(user);
      tr.commit();
    }
  }

  public void deleteUser(int id) {
    try (EntityManager em = emf.createEntityManager()) {
      User found = em.find(User.class, id);
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