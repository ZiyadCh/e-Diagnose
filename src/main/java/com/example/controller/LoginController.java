package com.example.controller;

import java.io.IOException;

import com.example.service.AuthService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
  private static final AuthService authService = new AuthService();

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.setContentType("text/plain;charset=UTF-8");
  }

}
