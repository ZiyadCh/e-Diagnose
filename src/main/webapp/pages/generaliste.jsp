<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>eDiagnose - Espace généraliste</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/infirmier.css">
</head>
<body>

<header class="topbar">
  <span class="brand">eDiagnose</span>
  <div class="user">
    <span>${sessionScope.user.nom} (Généraliste)</span>
    <a href="${pageContext.request.contextPath}/logout">Se déconnecter</a>
  </div>
</header>

<main class="page">

  <section class="box">
    <h1>Patients en liste d'attente</h1>
    <p class="sub">Patients en attente de prise en charge.</p>

    <c:choose>
      <c:when test="${not empty attente}">
        <div class="table-wrap">
          <table>
            <thead>
              <tr>
                <th>Nom</th>
                <th>Coordonnées</th>
                <th>Numéro de sécurité sociale</th>
              </tr>
            </thead>
            <tbody>
              <c:forEach var="p" items="${attente}">
                <tr>
                  <td>${p.nom}</td>
                  <td>${p.coordonnees}</td>
                  <td>${p.ssn}</td>
                </tr>
              </c:forEach>
            </tbody>
          </table>
        </div>
      </c:when>
      <c:otherwise>
        <p class="empty">Aucun patient en liste d'attente.</p>
      </c:otherwise>
    </c:choose>
  </section>

</main>

</body>
</html>
