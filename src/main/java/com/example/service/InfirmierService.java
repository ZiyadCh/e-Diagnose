package com.example.service;

import com.example.dao.PatientDao;
import com.example.models.Patient;
import java.util.List;

/**
 * InfirmierService
 */
public class InfirmierService {
  private static final PatientDao patientDao = new PatientDao();

  public void writePatient(Patient patient) {
    patientDao.createPatient(patient);
  }

  public List<Patient> getPatients() {
    return patientDao.findAll();
  }
}
