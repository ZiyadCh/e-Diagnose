package com.example.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * User
 */

@Entity
@Table(name = "users")
public abstract class User {

  protected User() {
  }

  public User(int id, String nom, String email, String password, Role role) {
    this.id = id;
    this.nom = nom;
    this.email = email;
    this.password = password;
    this.role = role;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  protected int id;

  @Column(name = "nom", nullable = false)
  protected String nom;

  @Column(name = "email", nullable = false, unique = true)
  protected String email;

  @Column(name = "password", nullable = false)
  protected String password;

  @Enumerated(EnumType.STRING)
  @Column(name = "role", nullable = false)
  protected Role role;

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

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Role getRole() {
    return role;
  }

  public void setRole(Role role) {
    this.role = role;
  }

}
