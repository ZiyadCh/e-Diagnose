package com.example.controller;

import java.io.IOException;

import com.example.service.SpecialisteService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * PatientSpecialisteController
 */
@WebServlet("/patient/specialiste")
public class PatientSpecialisteController extends HttpServlet {

  private static final SpecialisteService specialisteService = new SpecialisteService();

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    try {
      int patientId = Integer.parseInt(req.getParameter("patientID"));
      int specialisteId = Integer.parseInt(req.getParameter("specialisteID"));
      boolean sent = specialisteService.sendPatient(patientId, specialisteId);
      resp.sendRedirect(req.getContextPath() + (sent ? "/generaliste?envoye=1" : "/generaliste?error=1"));
    } catch (NumberFormatException e) {
      resp.sendRedirect(req.getContextPath() + "/generaliste?error=1");
    }
  }

}