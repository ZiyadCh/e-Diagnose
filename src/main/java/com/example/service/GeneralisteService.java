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

  public List<Patient> getPatientsEnAttente() {
    return patientDao.findByStatus(Status.ATTENTE);
  }

  public Patient getPatient(int patientId) {
    return patientDao.findById(patientId);
  }

  public void diagnoePatient(Patient patient, String diagnostic) {
    patient.setDiagnostic(diagnostic);
    patientDao.updatePatient(patient);
  }

}
