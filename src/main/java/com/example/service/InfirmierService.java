package com.example.service;

import com.example.dao.PatientDao;
import com.example.models.Patient;

/**
 * InfirmierService
 */
public class InfirmierService {
  private static final PatientDao patientDao = new PatientDao();

  public void writePatient(Patient patient) {
    patientDao.createPatient(patient);
  }
}
