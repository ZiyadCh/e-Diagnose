package com.example.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

/**
 * Patient
 */
@Entity
@Table(name = "patient")
public class Patient {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  protected int id;

  @Column(name = "nom", nullable = false)
  protected String nom;

  @Column(name = "coordonnees")
  protected String coordonnees;

  @Column(name = "ssn", nullable = false, unique = true)
  protected String ssn;

  @Enumerated(EnumType.STRING)
  @JdbcTypeCode(SqlTypes.NAMED_ENUM)
  @Column(name = "status", nullable = false)
  protected Status status;

  @Column(name = "diagnostic")
  protected String diagnostic;

  @Column(name = "specialiste_id")
  protected Integer specialisteId;

  public Patient() {
  }

  public Patient(String nom, String coordonnees, String ssn) {
    this.nom = nom;
    this.coordonnees = coordonnees;
    this.ssn = ssn;
    this.status = Status.ENREGISTRER;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getCoordonnees() {
    return coordonnees;
  }

  public void setCoordonnees(String coordonnees) {
    this.coordonnees = coordonnees;
  }

  public String getSsn() {
    return ssn;
  }

  public void setSsn(String ssn) {
    this.ssn = ssn;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public String getDiagnostic() {
    return diagnostic;
  }

  public void setDiagnostic(String diagnostic) {
    this.diagnostic = diagnostic;
  }

  public Integer getSpecialisteId() {
    return specialisteId;
  }

  public void setSpecialisteId(Integer specialisteId) {
    this.specialisteId = specialisteId;
  }

}
