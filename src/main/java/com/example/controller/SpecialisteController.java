package com.example.controller;

import java.io.IOException;

import com.example.models.User;
import com.example.service.SpecialisteService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * SpecialisteController
 */
@WebServlet("/specialiste")
public class SpecialisteController extends HttpServlet {

  private static final SpecialisteService specialisteService = new SpecialisteService();

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    User user = (User) req.getSession().getAttribute("user");
    if (user == null) {
      resp.sendRedirect(req.getContextPath() + "/login");
      return;
    }
    req.setAttribute("mesPatients", specialisteService.getMesPatients(user.getId()));
    req.getRequestDispatcher("/pages/mes-patients.jsp").forward(req, resp);
  }

}