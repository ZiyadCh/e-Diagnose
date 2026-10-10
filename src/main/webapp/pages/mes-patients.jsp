<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>eDiagnose - Espace spécialiste</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/infirmier.css">
</head>
<body>

<header class="topbar">
  <span class="brand">eDiagnose</span>
  <div class="user">
    <span>${sessionScope.user.nom} (Spécialiste)</span>
    <a href="${pageContext.request.contextPath}/logout">Se déconnecter</a>
  </div>
</header>

<main class="page">

  <section class="box">
    <h1>Patients à diagnostiquer</h1>
    <p class="sub">Patients envoyés par le généraliste.</p>

    <c:choose>
      <c:when test="${not empty mesPatients}">
        <form action="${pageContext.request.contextPath}/pages/generaliste-patient.jsp" method="GET">
          <div class="table-wrap">
            <table>
              <thead>
                <tr>
                  <th>ID</th>
                  <th>Nom</th>
                  <th>Coordonnées</th>
                  <th>Numéro de sécurité sociale</th>
                  <th>Action</th>
                </tr>
              </thead>
              <tbody>
                <c:forEach var="p" items="${mesPatients}">
                  <tr>
                    <td>${p.id}</td>
                    <td>${p.nom}</td>
                    <td>${p.coordonnees}</td>
                    <td>${p.ssn}</td>
                    <td><button type="submit" name="patientID" value="${p.id}">Diagnostique</button></td>
                  </tr>
                </c:forEach>
              </tbody>
            </table>
          </div>
        </form>
      </c:when>
      <c:otherwise>
        <p class="empty">Aucun patient à diagnostiquer.</p>
      </c:otherwise>
    </c:choose>
  </section>

</main>

</body>
</html>