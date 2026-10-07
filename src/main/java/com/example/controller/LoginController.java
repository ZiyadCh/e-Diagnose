package com.example.controller;

import java.io.IOException;

import com.example.models.Role;
import com.example.models.User;
import com.example.service.AuthService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * LoginController
 *
 * GET /login -> show the login page
 * POST /login -> check the credentials and open the session
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {

  private static final AuthService authService = new AuthService();

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.getRequestDispatcher("/auth/login.jsp").forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String email = request.getParameter("email");
    String password = request.getParameter("password");

    User user = authService.login(email, password);

    if (user == null) {
      response.sendRedirect(request.getContextPath() + "/login?error=1");
      return;
    }

    HttpSession session = request.getSession();
    session.setAttribute("user", user);

    String page = switch (user.getRole()) {
      case INFIRMIER -> "/patient";
      case GENERALISTE -> "/pages/generaliste.jsp";
      case SPECIALISTE -> "/pages/specialiste.jsp";
    };
    response.sendRedirect(request.getContextPath() + page);

  }

}
