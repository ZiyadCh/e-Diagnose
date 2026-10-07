package com.example.dao;

import com.example.models.Patient;
import com.example.models.Status;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

/**
 * PatientDao
 */
public class PatientDao {
  private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("eDiagnose");

  public void createPatient(Patient patient) {
    try (EntityManager em = emf.createEntityManager()) {
      EntityTransaction tr = em.getTransaction();
      tr.begin();
      em.persist(patient);
      tr.commit();
    }
  }

  public Patient findById(int id) {
    try (EntityManager em = emf.createEntityManager()) {
      return em.find(Patient.class, id);
    }
  }

  public List<Patient> findAll() {
    try (EntityManager em = emf.createEntityManager()) {
      return em.createQuery("select p from Patient p", Patient.class).getResultList();
    }
  }

  public List<Patient> findByStatus(Status status) {
    try (EntityManager em = emf.createEntityManager()) {
      return em.createQuery("select p from Patient p where p.status = :status", Patient.class)
          .setParameter("status", status)
          .getResultList();
    }
  }

  public void updatePatient(Patient patient) {
    try (EntityManager em = emf.createEntityManager()) {
      EntityTransaction tr = em.getTransaction();
      tr.begin();
      em.merge(patient);
      tr.commit();
    }
  }

  public void deletePatient(int id) {
    try (EntityManager em = emf.createEntityManager()) {
      Patient found = em.find(Patient.class, id);
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
