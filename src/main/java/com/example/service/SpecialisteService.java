package com.example.service;

import java.util.List;

import com.example.dao.PatientDao;
import com.example.models.Patient;
import com.example.models.Status;

/**
 * SpecialisteService
 */
public class SpecialisteService {
  private static final PatientDao patientDao = new PatientDao();

  public boolean sendPatient(int patientId, int specialisteId) {
    Patient patient = patientDao.findById(patientId);
    if (patient == null) {
      return false;
    }
    patient.setSpecialisteId(specialisteId);
    patient.setStatus(Status.SPECIALISTE);
    patientDao.updatePatient(patient);
    return true;
  }

  public List<Patient> getMesPatients(int specialisteId) {
    return patientDao.findBySpecialiste(specialisteId);
  }
}
