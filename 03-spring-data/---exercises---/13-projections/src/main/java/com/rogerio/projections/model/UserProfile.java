package com.rogerio.projections.model;

import jakarta.persistence.*;

@Entity
public class UserProfile {

  @Id
  @GeneratedValue(generator = "gen", strategy = GenerationType.SEQUENCE)
  @SequenceGenerator(name = "gen", sequenceName = "seq", allocationSize = 1)
  Long id;

  String userName;
  String email;
  String heavyBio;
  String heavyAvatar;

  public UserProfile() {
  }

  public UserProfile(String userName, String email) {
    this.userName = userName;
    this.email = email;
  }
}
