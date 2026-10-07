package com.example.service;

import com.example.dao.PatientDao;
import com.example.models.Patient;
import com.example.models.Status;
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

  public List<Patient> getPatients(Status status) {
    return patientDao.findByStatus(status);
  }

  public boolean changeStatus(int patientId, Status status) {
    Patient patient = patientDao.findById(patientId);
    if (patient == null) {
      return false;
    }
    patient.setStatus(status);
    patientDao.updatePatient(patient);
    return true;
  }
}
