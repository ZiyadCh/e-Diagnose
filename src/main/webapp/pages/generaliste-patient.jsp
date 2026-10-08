<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page import="com.example.models.Patient" %>
<%@ page import="com.example.models.Status" %>
<%@ page import="com.example.service.GeneralisteService" %>
<%@ page import="com.example.service.InfirmierService" %>
<%
  String cloturer = request.getParameter("cloturer");
  if (cloturer != null && !cloturer.isEmpty()) {
    try {
      InfirmierService infirmierService = new InfirmierService();
      infirmierService.changeStatus(Integer.parseInt(cloturer), Status.ENREGISTRER);
    } catch (NumberFormatException e) {
    }
    response.sendRedirect(request.getContextPath() + "/generaliste");
    return;
  }

  String patientID = request.getParameter("patientID");
  Patient patient = null;
  if (patientID != null && !patientID.isEmpty()) {
    try {
      GeneralisteService generalisteService = new GeneralisteService();
      patient = generalisteService.getPatient(Integer.parseInt(patientID));
    } catch (NumberFormatException e) {
      patient = null;
    }
  }
  request.setAttribute("patient", patient);
%>
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

    <c:if test="${empty patient}">
      <p class="error">Patient introuvable.</p>
      <p class="sub"><a href="${pageContext.request.contextPath}/generaliste">← Retour à la liste d'attente</a></p>
    </c:if>

    <c:if test="${not empty patient}">
      <dl class="patient">
        <div><dt>Nom</dt><dd><c:out value="${patient.nom}"/></dd></div>
        <div><dt>Coordonnées</dt><dd><c:out value="${patient.coordonnees}"/></dd></div>
        <div><dt>Numéro de sécurité sociale</dt><dd><c:out value="${patient.ssn}"/></dd></div>
        <div><dt>Statut</dt><dd><c:out value="${patient.status}"/></dd></div>
        <div><dt>Diagnostic</dt><dd><c:out value="${patient.diagnostic}" default="—"/></dd></div>
      </dl>

      <h2>Diagnostic</h2>
      <form action="${pageContext.request.contextPath}/generaliste" method="POST">
        <input type="hidden" name="patientID" value="${patient.id}">
        <label for="diagnostic">Diagnostic</label>
        <textarea id="diagnostic" name="diagnostic" rows="4"><c:out value="${patient.diagnostic}"/></textarea>

        <div class="actions-row">
          <input type="submit" value="Ajouter diagnostic">
          <button type="button">Consulter un spécialiste</button>
        </div>
      </form>

      <form action="${pageContext.request.contextPath}/pages/generaliste-patient.jsp" method="POST" class="actions-row">
        <input type="hidden" name="patientID" value="${patient.id}">
        <input type="hidden" name="cloturer" value="${patient.id}">
        <input type="submit" value="Clôturer">
      </form>

      <p class="sub">
        <a href="${pageContext.request.contextPath}/generaliste">← Retour à la liste d'attente</a>
      </p>
    </c:if>
  </section>

</main>

</body>
</html>
