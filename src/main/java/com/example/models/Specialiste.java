package com.example.models;

import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

/**
 * Specialiste
 */
@Entity
@Table(name = "specialiste")
public class Specialiste extends User {

  @Enumerated(EnumType.STRING)
  @JdbcTypeCode(SqlTypes.NAMED_ENUM)
  @Column(name = "specialite")
  protected Specialites specialite;

  protected Specialiste() {
  }

  public Specialiste(String nom, String email, String password, Role role, Specialites specialite) {
    super(nom, email, password, role);
    this.specialite = specialite;
  }

  public Specialites getSpecialite() {
    return specialite;
  }

  public void setSpecialite(Specialites specialite) {
    this.specialite = specialite;
  }

}