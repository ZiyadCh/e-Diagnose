package com.example.controller;

import java.io.IOException;

import com.example.service.GeneralisteService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * GeneralisteController
 */
@WebServlet("/generaliste")
public class GeneralisteController extends HttpServlet {

  private static final GeneralisteService generalisteService = new GeneralisteService();

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.setAttribute("attente", generalisteService.getPatientsEnAttente());
    req.getRequestDispatcher("/pages/generaliste.jsp").forward(req, resp);
  }

}
