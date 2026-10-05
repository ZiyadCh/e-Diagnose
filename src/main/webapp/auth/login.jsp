<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>eDiagnose - Connexion</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
</head>
<body>

<div class="login-card">
  <div class="brand">
    <span class="brand-logo">eD</span>
    <h1>eDiagnose</h1>
    <p class="subtitle">Espace de connexion</p>
  </div>

  <c:if test="${not empty param.error}">
    <div class="alert">Email ou mot de passe incorrect.</div>
  </c:if>

  <form action="${pageContext.request.contextPath}/login" method="post" novalidate>
    <div class="field">
      <label for="email">Adresse email</label>
      <input type="email" id="email" name="email" placeholder="exemple@ediagnose.com"
             autocomplete="email" required autofocus>
    </div>

    <div class="field">
      <label for="password">Mot de passe</label>
      <input type="password" id="password" name="password" placeholder="••••••••"
             autocomplete="current-password" required>
    </div>

    <div class="row">
      <label class="checkbox">
        <input type="checkbox" name="remember"> Se souvenir de moi
      </label>
      <a href="#" class="link">Mot de passe oublié ?</a>
    </div>

    <button type="submit" class="btn">Se connecter</button>
  </form>

  <p class="footer-text">
    Pas encore de compte ? <a href="#" class="link">Créer un compte</a>
  </p>
</div>

</body>
</html>
