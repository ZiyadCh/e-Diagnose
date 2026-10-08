package com.example.service;

import java.util.List;

import com.example.dao.PatientDao;
import com.example.dao.SpecialisteDao;
import com.example.models.Patient;
import com.example.models.Specialiste;
import com.example.models.Status;

/**
 * GeneralisteService
 */
public class GeneralisteService {
  private static final PatientDao patientDao = new PatientDao();
  private static final SpecialisteDao specialisteDao = new SpecialisteDao();

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

  public List<Specialiste> searchSpecialiste() {
    return specialisteDao.findAll();
  }
}
