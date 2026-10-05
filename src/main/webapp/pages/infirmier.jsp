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
    <span>${sessionScope.user.prenom} ${sessionScope.user.nom} (Infirmier)</span>
    <a href="${pageContext.request.contextPath}/logout">Se déconnecter</a>
  </div>
</header>

<main class="page">

  <!-- ===== US1 : Accueil du patient ===== -->
  <section class="box">
    <h1>Accueil du patient</h1>
    <p class="sub">Recherchez le patient par numéro de sécurité sociale avant de l'enregistrer.</p>

    <c:if test="${param.success != null}">
      <p class="success">Patient ajouté à la file d'attente.</p>
    </c:if>
    <c:if test="${param.error != null}">
      <p class="error">L'enregistrement a échoué. Vérifiez les champs et réessayez.</p>
    </c:if>

    <form class="search" action="${pageContext.request.contextPath}/infirmier/accueil" method="get">
      <div class="field">
        <label for="nss">Numéro de sécurité sociale</label>
        <input type="text" id="nss" name="nss" value="${param.nss}" required>
      </div>
      <button type="submit">Rechercher</button>
    </form>

    <%-- Accès direct au formulaire de création, sans recherche préalable --%>
    <c:if test="${param.nss == null && param.mode == null}">
      <h2>Ajouter un patient</h2>
      <p class="sub">Saisissez son numéro de sécurité sociale pour l'enregistrer directement.</p>

      <form class="search" action="${pageContext.request.contextPath}/infirmier/accueil" method="get">
        <input type="hidden" name="mode" value="add">
        <div class="field">
          <label for="nssAdd">Numéro de sécurité sociale</label>
          <input type="text" id="nssAdd" name="nss" required>
        </div>
        <button type="submit">Ajouter un patient</button>
      </form>
    </c:if>

    <c:if test="${param.nss != null || param.mode != null}">
      <c:choose>

        <%-- Patient existant : nouveaux signes vitaux uniquement --%>
        <c:when test="${patient != null && param.mode == null}">
          <h2>Patient trouvé</h2>
          <dl class="patient">
            <div><dt>Nom</dt><dd>${patient.nom}</dd></div>
            <div><dt>Prénom</dt><dd>${patient.prenom}</dd></div>
            <div><dt>Date de naissance</dt><dd>${patient.dateNaissance}</dd></div>
            <div><dt>Téléphone</dt><dd>${patient.telephone}</dd></div>
          </dl>

          <form action="${pageContext.request.contextPath}/infirmier/accueil" method="post">
            <input type="hidden" name="csrfToken" value="${sessionScope.csrfToken}">
            <input type="hidden" name="patientId" value="${patient.id}">

            <h2>Signes vitaux</h2>
            <div class="grid">
              <div>
                <label for="tension">Tension artérielle (ex : 12/8)</label>
                <input type="text" id="tension" name="tension" required>
              </div>
              <div>
                <label for="frequenceCardiaque">Fréquence cardiaque (bpm)</label>
                <input type="number" id="frequenceCardiaque" name="frequenceCardiaque" min="0" required>
              </div>
              <div>
                <label for="temperature">Température (°C)</label>
                <input type="number" id="temperature" name="temperature" step="0.1" min="0" required>
              </div>
              <div>
                <label for="frequenceRespiratoire">Fréquence respiratoire (/min)</label>
                <input type="number" id="frequenceRespiratoire" name="frequenceRespiratoire" min="0" required>
              </div>
              <div>
                <label for="poids">Poids (kg)</label>
                <input type="number" id="poids" name="poids" step="0.1" min="0">
              </div>
              <div>
                <label for="taille">Taille (cm)</label>
                <input type="number" id="taille" name="taille" min="0">
              </div>
            </div>

            <div class="actions">
              <input type="submit" value="Ajouter à la file d'attente">
            </div>
          </form>
        </c:when>

        <%-- Nouveau patient --%>
        <c:otherwise>
          <h2>Nouveau patient</h2>
          <form action="${pageContext.request.contextPath}/infirmier/accueil" method="post">
            <input type="hidden" name="csrfToken" value="${sessionScope.csrfToken}">

            <div class="grid">
              <div>
                <label for="nom">Nom</label>
                <input type="text" id="nom" name="nom" required>
              </div>
              <div>
                <label for="prenom">Prénom</label>
                <input type="text" id="prenom" name="prenom" required>
              </div>
              <div>
                <label for="dateNaissance">Date de naissance</label>
                <input type="date" id="dateNaissance" name="dateNaissance" required>
              </div>
              <div>
                <label for="numSecu">Numéro de sécurité sociale</label>
                <input type="text" id="numSecu" name="numSecu" value="${param.nss}" required>
              </div>
              <div>
                <label for="telephone">Téléphone (optionnel)</label>
                <input type="tel" id="telephone" name="telephone">
              </div>
              <div>
                <label for="mutuelle">Mutuelle</label>
                <input type="text" id="mutuelle" name="mutuelle">
              </div>
              <div class="span-all">
                <label for="adresse">Adresse (optionnel)</label>
                <input type="text" id="adresse" name="adresse">
              </div>
              <div class="span-all">
                <label for="antecedents">Antécédents</label>
                <textarea id="antecedents" name="antecedents"></textarea>
              </div>
              <div>
                <label for="allergies">Allergies</label>
                <textarea id="allergies" name="allergies"></textarea>
              </div>
              <div>
                <label for="traitements">Traitements en cours</label>
                <textarea id="traitements" name="traitements"></textarea>
              </div>
            </div>

            <h2>Signes vitaux</h2>
            <div class="grid">
              <div>
                <label for="tension2">Tension artérielle (ex : 12/8)</label>
                <input type="text" id="tension2" name="tension" required>
              </div>
              <div>
                <label for="frequenceCardiaque2">Fréquence cardiaque (bpm)</label>
                <input type="number" id="frequenceCardiaque2" name="frequenceCardiaque" min="0" required>
              </div>
              <div>
                <label for="temperature2">Température (°C)</label>
                <input type="number" id="temperature2" name="temperature" step="0.1" min="0" required>
              </div>
              <div>
                <label for="frequenceRespiratoire2">Fréquence respiratoire (/min)</label>
                <input type="number" id="frequenceRespiratoire2" name="frequenceRespiratoire" min="0" required>
              </div>
              <div>
                <label for="poids2">Poids (kg)</label>
                <input type="number" id="poids2" name="poids" step="0.1" min="0">
              </div>
              <div>
                <label for="taille2">Taille (cm)</label>
                <input type="number" id="taille2" name="taille" min="0">
              </div>
            </div>

            <div class="actions">
              <input type="submit" value="Ajouter à la file d'attente">
            </div>
          </form>
        </c:otherwise>
      </c:choose>
    </c:if>
  </section>

</main>

</body>
</html>
