package com.example.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 * Infirmier
 */
@Entity
@Table(name = "infirmier")
public class Infirmier extends User {

  protected Infirmier() {
  }

  public Infirmier(String nom, String email, String password, Role role) {
    super(nom, email, password, role);
  }

}