<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>eDiagnose - Connexion</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
</head>
<body>

<div class="box">
  <h1>eDiagnose</h1>
  <p class="sub">Connectez-vous à votre compte</p>

  <% if (request.getParameter("error") != null) { %>
    <p class="error">Email ou mot de passe incorrect.</p>
  <% } %>

  <form action="${pageContext.request.contextPath}/login" method="post">
    <label for="email">Email</label>
    <input type="text" id="email" name="email" required>

    <label for="password">Mot de passe</label>
    <input type="password" id="password" name="password" required>

    <input type="submit" value="Se connecter">
  </form>

  <p class="foot"><a href="#">Mot de passe oublié ?</a></p>
</div>

</body>
</html>
