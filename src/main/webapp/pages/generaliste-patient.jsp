<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>eDiagnose - Fiche patient</title>
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
    <h1>Fiche patient</h1>
    <p class="sub">Informations du patient sélectionné.</p>

    <c:if test="${param.saved != null}">
      <p class="success">Diagnostic enregistré.</p>
    </c:if>
    <c:if test="${param.error != null}">
      <p class="error">L'enregistrement du diagnostic a échoué. Vérifiez le champ et réessayez.</p>
    </c:if>

    <dl class="patient">
      <div><dt>Nom</dt><dd>${patient.nom}</dd></div>
      <div><dt>Coordonnées</dt><dd>${patient.coordonnees}</dd></div>
      <div><dt>Numéro de sécurité sociale</dt><dd>${patient.ssn}</dd></div>
      <div><dt>Statut</dt><dd>${patient.status}</dd></div>
      <div><dt>Diagnostic</dt><dd>${empty patient.diagnostic ? '—' : fn:escapeXml(patient.diagnostic)}</dd></div>
    </dl>

    <h2>Diagnostic</h2>
    <form action="${pageContext.request.contextPath}/generaliste" method="post">
      <input type="hidden" name="patientID" value="${patient.id}">
      <label for="diagnostic">Diagnostic</label>
      <textarea id="diagnostic" name="diagnostic" rows="4">${fn:escapeXml(patient.diagnostic)}</textarea>

      <div class="actions-row">
        <input type="submit" value="Ajouter diagnostic">
        <button type="button">Consulter un spécialiste</button>
      </div>
    </form>

    <p class="sub">
      <a href="${pageContext.request.contextPath}/generaliste">← Retour à la liste d'attente</a>
    </p>
  </section>

</main>

</body>
</html>