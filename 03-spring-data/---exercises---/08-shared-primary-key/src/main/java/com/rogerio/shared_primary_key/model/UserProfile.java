package com.rogerio.shared_primary_key.model;

import jakarta.persistence.*;

@Entity
public class UserProfile {

  @Id
  @Column(name = "user_id")
  private Long id;

  private String bio;

  @OneToOne
  @MapsId
  @JoinColumn(name = "user_id", unique = true, nullable = false)
  private User user;

  public UserProfile() {}

  public UserProfile(String bio, User user) {
    this.bio = bio;
    this.user = user;
  }
}
