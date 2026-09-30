package com.example.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * User
 */

@Entity
@Table(name = "users")
abstract public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  protected int id;

  @Column(name = "nom", length = 255)
  protected String nom;

  @Column(name = "email", unique = true, length = 255)
  protected String email;

  @Column(name = "password")
  protected String password;

  @Column(name = "role")
  protected Role role;

}
