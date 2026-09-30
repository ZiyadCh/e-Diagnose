package com.example.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/**
 * Specialiste
 */
@Entity
@Table(name = "specialiste")
public class Specialiste {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  protected int id;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id", nullable = false)
  protected User user;

  @Enumerated(EnumType.STRING)
  @Column(name = "specialite", nullable = false)
  protected Specialites specialite;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Specialites getSpecialite() {
    return specialite;
  }

  public void setSpecialite(Specialites specialite) {
    this.specialite = specialite;
  }

}
