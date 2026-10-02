package com.example.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 * Generaliste
 */
@Entity
@Table(name = "generaliste")
public class Generaliste extends User {

  protected Generaliste() {
  }

  public Generaliste(String nom, String email, String password, Role role) {
    super(nom, email, password, role);
  }

}