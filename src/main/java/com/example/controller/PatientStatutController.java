package com.example.controller;

import java.io.IOException;

import com.example.models.Status;
import com.example.service.InfirmierService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * PatientStatutController
 */
@WebServlet("/patient/statut")
public class PatientStatutController extends HttpServlet {

  private static final InfirmierService infirmierService = new InfirmierService();

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    try {
      int id = Integer.parseInt(req.getParameter("id"));
      Status status = Status.valueOf(req.getParameter("statut"));
      boolean updated = infirmierService.changeStatus(id, status);
      resp.sendRedirect(req.getContextPath() + (updated ? "/patient?statut=1" : "/patient?error=1"));
    } catch (IllegalArgumentException e) {
      resp.sendRedirect(req.getContextPath() + "/patient?error=1");
    }
  }

}
