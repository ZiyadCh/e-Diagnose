<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page import="com.example.models.Specialiste" %>
<%@ page import="com.example.models.Specialites" %>
<%@ page import="com.example.service.GeneralisteService" %>
<%@ page import="java.util.List" %>
<%
  GeneralisteService generalisteService = new GeneralisteService();
  List<Specialiste> specialistes = generalisteService.searchSpecialiste();

  String filtre = request.getParameter("specialite");
  if (filtre != null && !filtre.isEmpty()) {
    List<Specialiste> filtres = new java.util.ArrayList<Specialiste>();
    for (Specialiste s : specialistes) {
      if (s.getSpecialite() != null && s.getSpecialite().name().equals(filtre)) {
        filtres.add(s);
      }
    }
    specialistes = filtres;
  }
  request.setAttribute("specialistes", specialistes);

  String patientID = request.getParameter("patientID");
%>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>eDiagnose - Spécialistes</title>
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
    <h1>Liste des spécialistes</h1>
    <p class="sub">Spécialistes disponibles, filtrables par spécialité.</p>

    <form action="${pageContext.request.contextPath}/pages/specialiste.jsp" method="GET" class="filter-row">
      <% if (patientID != null && !patientID.isEmpty()) { %>
        <input type="hidden" name="patientID" value="<%= patientID %>">
      <% } %>
      <label for="specialite">Spécialité</label>
      <select id="specialite" name="specialite">
        <option value="">Toutes</option>
        <% for (Specialites sp : Specialites.values()) { %>
          <option value="<%= sp.name() %>" <%= sp.name().equals(filtre) ? "selected" : "" %>><%= sp.name() %></option>
        <% } %>
      </select>
      <input type="submit" value="Filtrer">
    </form>

    <c:choose>
      <c:when test="${not empty specialistes}">
        <div class="table-wrap">
          <table>
            <thead>
              <tr>
                <th>ID</th>
                <th>Nom</th>
                <th>Email</th>
                <th>Spécialité</th>
                <c:if test="${not empty param.patientID}"><th>Action</th></c:if>
              </tr>
            </thead>
            <tbody>
              <c:forEach var="s" items="${specialistes}">
                <tr>
                  <td>${s.id}</td>
                  <td><c:out value="${s.nom}"/></td>
                  <td><c:out value="${s.email}"/></td>
                  <td><c:out value="${s.specialite}"/></td>
                  <c:if test="${not empty param.patientID}">
                    <td>
                      <form action="${pageContext.request.contextPath}/patient/specialiste" method="POST">
                        <input type="hidden" name="patientID" value="${param.patientID}">
                        <button type="submit" name="specialisteID" value="${s.id}">Envoyer</button>
                      </form>
                    </td>
                  </c:if>
                </tr>
              </c:forEach>
            </tbody>
          </table>
        </div>
      </c:when>
      <c:otherwise>
        <p class="empty">Aucun spécialiste trouvé.</p>
      </c:otherwise>
    </c:choose>

    <p class="sub">
      <% if (patientID != null && !patientID.isEmpty()) { %>
        <a href="${pageContext.request.contextPath}/pages/generaliste-patient.jsp?patientID=<%= patientID %>">← Retour à la fiche du patient</a>
      <% } else { %>
        <a href="${pageContext.request.contextPath}/generaliste">← Retour à la liste d'attente</a>
      <% } %>
    </p>
  </section>

</main>

</body>
</html>
