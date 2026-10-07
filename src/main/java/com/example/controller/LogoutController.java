package com.example.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * LogoutController
 *
 * GET /logout -> destroy the session and go back to the login page
 */
@WebServlet("/logout")
public class LogoutController extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    req.getSession().invalidate();
    resp.sendRedirect(req.getContextPath() + "/login");
  }

}
