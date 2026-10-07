package com.example.controller;

import java.io.IOException;
import java.util.List;

import com.example.models.Patient;
import com.example.service.InfirmierService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * PatientController
 *
 * POST /patient -> create a new patient
 */
@WebServlet("/patient")
public class PatientController extends HttpServlet {
  private static final InfirmierService infirmierService = new InfirmierService();

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String nom = req.getParameter("nom");
    String coordonnes = req.getParameter("coordonnees");
    String ssn = req.getParameter("ssn");
    infirmierService.writePatient(new Patient(nom, coordonnes, ssn));
    resp.sendRedirect(req.getContextPath() + "/patient?success=1");
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    List<Patient> patients = infirmierService.getPatients();

    String ssn = req.getParameter("ssn");
    if (ssn != null && !ssn.isBlank()) {
      patients = patients.stream().filter(p -> ssn.equals(p.getSsn())).toList();
    }

    req.setAttribute("patients", patients);
    req.getRequestDispatcher("/pages/infirmier.jsp").forward(req, resp);
  }
}
