package com.example.service;

import com.example.dao.PatientDao;
import com.example.models.Patient;
import com.example.models.Status;
import java.util.List;

/**
 * GeneralisteService
 */
public class GeneralisteService {
  private static final PatientDao patientDao = new PatientDao();

  /**
   * Retourne les patients en attente de prise en charge (liste d'attente).
   */
  public List<Patient> getPatientsEnAttente() {
    return patientDao.findByStatus(Status.ATTENTE);
  }

}
