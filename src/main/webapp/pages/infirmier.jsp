<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>eDiagnose - Espace infirmier</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/infirmier.css">
</head>
<body>

<header class="topbar">
  <span class="brand">eDiagnose</span>
  <div class="user">
    <span>${sessionScope.user.nom} (Infirmier)</span>
    <a href="${pageContext.request.contextPath}/logout">Se déconnecter</a>
  </div>
</header>

<main class="page">

  <section class="box">
    <h1>Accueil du patient</h1>
    <p class="sub">Recherchez le patient par numéro de sécurité sociale avant de l'enregistrer.</p>

    <c:if test="${param.success != null}">
      <p class="success">Patient ajouté à la file d'attente.</p>
    </c:if>
    <c:if test="${param.error != null}">
      <p class="error">L'enregistrement a échoué. Vérifiez les champs et réessayez.</p>
    </c:if>

    <form class="search" action="${pageContext.request.contextPath}/patient" method="get">
      <div class="field">
        <label for="ssn">Numéro de sécurité sociale</label>
        <input type="text" id="ssn" name="ssn" value="${param.ssn}" required>
      </div>
      <button type="submit">Rechercher</button>
    </form>

    <c:if test="${param.ssn == null || empty patients}">
      <h2>Nouveau patient</h2>
      <p class="sub">Renseignez les informations du patient pour l'enregistrer.</p>

      <form action="${pageContext.request.contextPath}/patient" method="post">
        <div class="grid">
          <div>
            <label for="nom">Nom</label>
            <input type="text" id="nom" name="nom" required>
          </div>
          <div>
            <label for="ssnPatient">Numéro de sécurité sociale</label>
            <input type="text" id="ssnPatient" name="ssn" value="${param.ssn}" required>
          </div>
          <div>
            <label for="coordonnees">Coordonnées (téléphone)</label>
            <input type="tel" id="coordonnees" name="coordonnees" required>
          </div>
        </div>

        <div class="actions">
          <input type="submit" value="Ajouter à la file d'attente">
        </div>
      </form>
    </c:if>

    <c:if test="${param.ssn != null && not empty patients}">
      <h2>Patient trouvé</h2>
      <dl class="patient">
        <div><dt>Nom</dt><dd>${patients[0].nom}</dd></div>
        <div><dt>Coordonnées</dt><dd>${patients[0].coordonnees}</dd></div>
        <div><dt>Numéro de sécurité sociale</dt><dd>${patients[0].ssn}</dd></div>
      </dl>
    </c:if>

    <h2>Patients enregistrés</h2>
    <c:choose>
      <c:when test="${not empty patients}">
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
              <c:forEach var="p" items="${patients}">
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
        <p class="empty">Aucun patient trouvé.</p>
      </c:otherwise>
    </c:choose>
  </section>

</main>

</body>
</html>
